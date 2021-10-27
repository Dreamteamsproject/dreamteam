
package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Consultas;



public class comparAController {
     static Consultas consultaSQL = new Consultas();
    
    
    public static void RellenarTab(){
        
        try{
          //  consultaSQL.Connectar();
            DefaultListModel modelo = new DefaultListModel();
            var artLista = consultaSQL.doQueryGet("select articulo_descripcion from articulos");
            while(artLista.next()){
                modelo.addElement(artLista.getString("articulo_descripcion"));
                System.out.println(artLista.getString("articulo_descripcion"));
            }
            
            ComprasController.pestanaCompras.packArtListado.setModel(modelo);}
        
           
        catch (SQLException e) {
            
            System.out.println("error: " + e);
        }
    
        RellenarPed();
    }
    
     public static void RellenarPed(){
     
             DefaultTableModel model = (DefaultTableModel) ComprasController.pestanaCompras.infTable.getModel();
             String completa[] = new String[4];
             String SQL = "select * from orden_compra";
             int suma = 0;
             model.setRowCount(0);
         try {
             
             var rs = consultaSQL.doQueryGet(SQL);
             ResultSet rs2;
             while(rs.next()){
                 
                 completa[0] = rs.getString("orden_id");
                 completa[1] = rs.getString("orden_fecha");
                 SQL = "select detalle_cantidad from detalle_ordencompra where id_orden="+completa[0];
                 System.out.println(SQL);
                 rs2 = consultaSQL.doQueryGet(SQL);
                 
                 while(rs2.next()){
                     suma += rs2.getInt("detalle_cantidad");
                 }
                 
                 completa[2] = String.valueOf(suma);
                 completa[3] = "????";
                 model.addRow(completa);
                 rs2.close();
             }
             rs.close();
             
         } catch (SQLException ex) {
             Logger.getLogger(comparAController.class.getName()).log(Level.SEVERE, null, ex);
         }
     
     }
    
     public static void filtrar(String filtro){
     
             DefaultTableModel model = (DefaultTableModel) ComprasController.pestanaCompras.infTable.getModel();
             String completa[] = new String[4];
             String SQL = "select * from orden_compra where orden_id="+filtro;
             int suma = 0;
             model.setRowCount(0);
         try {
             
             var rs = consultaSQL.doQueryGet(SQL);
             ResultSet rs2;
             while(rs.next()){
                 
                 completa[0] = rs.getString("orden_id");
                 completa[1] = rs.getString("orden_fecha");
                 SQL = "select detalle_cantidad from detalle_ordencompra where id_orden="+completa[0];
                 System.out.println(SQL);
                 rs2 = consultaSQL.doQueryGet(SQL);
                 
                 while(rs2.next()){
                     suma += rs2.getInt("detalle_cantidad");
                 }
                 
                 completa[2] = String.valueOf(suma);
                 completa[3] = "????";
                 model.addRow(completa);
                 rs2.close();
             }
             rs.close();
             
         } catch (SQLException ex) {
             Logger.getLogger(comparAController.class.getName()).log(Level.SEVERE, null, ex);
         }
     
     }
     
     public static void filtrarVacio(String a){
         if(a.equals("")){RellenarPed();}
     
     }
     
    public static void añadirArt(){
        
        String datos[] = new String[2];
        DefaultTableModel modelArt = (DefaultTableModel) ComprasController.pestanaCompras.packCreaListado.getModel();
        datos[1] = ComprasController.pestanaCompras.packArtListado.getSelectedValue();
        if(Integer.parseInt(ComprasController.pestanaCompras.packCantAdd.getText())>0){
            
                datos[0] = ComprasController.pestanaCompras.packCantAdd.getText();
                modelArt.addRow(datos);
                ComprasController.pestanaCompras.packCantAdd.setText("");
           }
        else{JOptionPane.showMessageDialog(null, "cantidad invalida");}
     
    }
      
    public static void eleminarArt(){
        if(ComprasController.pestanaCompras.packCreaListado.getSelectedRow() != -1){
        
            DefaultTableModel modelArt2 = (DefaultTableModel) ComprasController.pestanaCompras.packCreaListado.getModel();
            modelArt2.removeRow(ComprasController.pestanaCompras.packCreaListado.getSelectedRow());
        }

    }
    
    public static void CreaOrden(){
        
         try {
             String id = "";
             String SQL = "INSERT INTO orden_compra (orden_fecha) VALUES ('"+ExtraerFecha(ComprasController.pestanaCompras.infBuscFech.getDate().toString())+"')";
             System.out.println(consultaSQL.doQueryPost(SQL));
             SQL ="SELECT * FROM orden_compra WHERE orden_id = (SELECT MAX(orden_id) FROM orden_compra)";
             var rs = consultaSQL.doQueryGet(SQL);
             if(rs.next()){
                id = rs.getString("orden_id");
             }
             rs.close();
             DetalleOrden(id);
             
         } catch (SQLException ex) {
             Logger.getLogger(comparAController.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }
    
    public static void DetalleOrden(String id) {
        String SQL;
        
        try {
              
                int j = ComprasController.pestanaCompras.packCreaListado.getRowCount();
                String guarda[][] = new String[j][2];

                
                //obtiene id de productos y cantidad
                for (int i = 0; i < j; i++) {
                    for (int k = 0; k < 2; k++) {
                        guarda[i][k] = (String) ComprasController.pestanaCompras.packCreaListado.getValueAt(i,k);
                    }
                    SQL = "select articulo_id from articulos where articulo_descripcion='"+guarda[i][1]+"'";
                    var rs = consultaSQL.doQueryGet(SQL);
                    if(rs.next()){
                        guarda[i][1] = rs.getString("articulo_id");
                        rs.close();
                    }
                }
                
                SQL = "insert into detalle_ordencompra (detalle_cantidad,id_articulo,id_orden,detalle_valor) VALUES ";
                
                //inserta llaves foraneas a tabla conectora
                for(int i = 0; i < j;i++){
                    SQL += "("+guarda[i][0]+","+guarda[i][1]+","+id+",1000) ";
                    if(i<(j-1)){
                        SQL += ",";
                        
                    }
                    System.out.print(guarda[i][0]+ "----");
                    System.out.println(guarda[i][1]+ "");
                }
                System.out.println(SQL);
                if(consultaSQL.doQueryPost(SQL)){
                    JOptionPane.showMessageDialog(null, "Orden creada exitosamente ");
                    
                }
            }catch(Exception e){System.out.println("error " + e);}
    }
    
    private static String ExtraerFecha(String fecha){
        
        System.out.println(fecha);
        
        String dia,mes,año,date;
    
        dia = fecha.substring(8, 10);
        mes = ConvertirMes(fecha.substring(4, 7));
        año = fecha.substring(25, 29);
        
        date = año+"-"+mes+"-"+ dia;
        
        System.out.println(date);
        
        return date;
    }
    
    private static String ConvertirMes(String mes){
        String mesNum = "error";
        switch(mes){
        
            case"Jan" -> mesNum = "01";
            case"Feb" -> mesNum = "02";
            case"Mar" -> mesNum = "03";
            case"Apr" -> mesNum = "04";
            case"May" -> mesNum = "05";
            case"Jun" -> mesNum = "06";
            case"Jul" -> mesNum = "07";
            case"Aug" -> mesNum = "08";
            case"Sep" -> mesNum = "09";
            case"Oct" -> mesNum = "10";
            case"Nov" -> mesNum = "11";
            case"Dec" -> mesNum = "12";
        
        
        } 
        return mesNum;
    }
}

