package controlador;

import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Consultas;
import vista.ModificarPack;



public class SAPackC {
    
    static Consultas consultaSQL = new Consultas();
    private static final DefaultListModel modelArt = new DefaultListModel();

    public static void SAPackC(){}
    
    
    public static void rellenarArt(){
    
           try{
          //  consultaSQL.Connectar();
            modelArt.removeAllElements();
            var artLista = consultaSQL.doQueryGet("select articulo_descripcion from articulos");
            while(artLista.next()){
                modelArt.addElement(artLista.getString("articulo_descripcion"));
            }
            
            SuperAdmC.superAdm.packArtListado.setModel(modelArt);}
        
           
        catch (SQLException e) {
            System.out.println("error: " + e);
        }
       
    }
    
    public static void añadirArt(){
        
        String datos[] = new String[2];
        DefaultTableModel modelArt2 = (DefaultTableModel) SuperAdmC.superAdm.packCreaListado.getModel();
        datos[0] = SuperAdmC.superAdm.packArtListado.getSelectedValue();
        if(Integer.parseInt(SuperAdmC.superAdm.packCantAdd.getText())>0){
            
                datos[1] = SuperAdmC.superAdm.packCantAdd.getText();
                modelArt2.addRow(datos);
                SuperAdmC.superAdm.packCantAdd.setText("");
           }
        else{JOptionPane.showMessageDialog(null, "cantidad invalida");}
     
    }
    
    public static void eleminarArt(){
        if(SuperAdmC.superAdm.packCreaListado.getSelectedRow() != -1){
        
            DefaultTableModel modelArt2 = (DefaultTableModel) SuperAdmC.superAdm.packCreaListado.getModel();
            modelArt2.removeRow(SuperAdmC.superAdm.packCreaListado.getSelectedRow());
        }

    }
    
    public static void crearPack() {
        
        try {
            
            //crea pack
            String SQL = "select categoria_id from categoria_pack where categoria_descripcion='" + SuperAdmC.superAdm.categoriaPack.getSelectedItem()+"'";
            var rs = consultaSQL.doQueryGet(SQL);
            String categoriaId = "";
            if(rs.next()){
                categoriaId = rs.getString("categoria_id");
            }
            SQL = "insert into packs (pack_nombre,pack_costo,pack_stock,id_categoria) VALUES('" + SuperAdmC.superAdm.packNombrePack.getText() + "'," + SuperAdmC.superAdm.packValor.getText() + ",0,"+categoriaId+")";
            consultaSQL.doQueryPost(SQL);
            
            //obtiene id pack creado
            rs = consultaSQL.doQueryGet("select pack_id from packs where pack_nombre = '" + SuperAdmC.superAdm.packNombrePack.getText()+"'");
            
            if (rs.next()) {
                
                String packId = rs.getString("pack_id");
                int j = SuperAdmC.superAdm.packCreaListado.getRowCount();
                String guarda[][] = new String[j][2];

                
                //obtiene id de productos y cantidad
                for (int i = 0; i < j; i++) {
                    for (int k = 0; k < 2; k++) {
                        guarda[i][k] = (String) SuperAdmC.superAdm.packCreaListado.getValueAt(i, k);
                    }
                    SQL = "select articulo_id from articulos where articulo_descripcion='"+guarda[i][0]+"'";
                    rs = consultaSQL.doQueryGet(SQL);
                    if(rs.next()){
                        guarda[i][0] = rs.getString("articulo_id");
                        rs.close();
                    }
                }
                
                SQL = "insert into articulo_del_pack (adp_cantidad,id_articulo,id_pack) VALUES ";
                
                //inserta llaves foraneas a tabla conectora
                for(int i = 0; i < j;i++){
                    SQL += "("+guarda[i][1]+","+guarda[i][0]+","+packId+") ";
                    if(i<(j-1)){
                        SQL += ",";
                    }
                }
                System.out.println(SQL);
                if(consultaSQL.doQueryPost(SQL)){
                    JOptionPane.showMessageDialog(null, "pack creado exitosamente ");
                    rs.close();
                }
            }
            
        } catch (SQLException ex) {
            System.out.println("error: " + ex);
        }
        rellenarPacks();

    }
    
    
    public static void añadirCat(){
    
        SuperAdmC.superAdm.categoriaPack.removeAll();
        String SQL = "SELECT categoria_descripcion from categoria_pack";     
        try {
            var rs = consultaSQL.doQueryGet(SQL);
            while(rs.next()){
                SuperAdmC.superAdm.categoriaPack.addItem(rs.getString("categoria_descripcion")); 
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("error: " + ex);
        }
    
    }
    
    
    public static void rellenarPacks(){
    
        String datos[] = new String[5];
        DefaultTableModel modelPack = new DefaultTableModel(); 
        modelPack = (DefaultTableModel) SuperAdmC.superAdm.packTabla.getModel();
        modelPack.setRowCount(0);
        
        try {
            
            String SQL = "select * from packs";
            var rs = consultaSQL.doQueryGet(SQL);
            while(rs.next()){
                
                datos[0] = rs.getString("pack_id");
                datos[1] = rs.getString("pack_nombre");
                datos[2] = rs.getString("pack_stock");
                var rs2 = consultaSQL.doQueryGet("select categoria_descripcion from categoria_pack where categoria_id="+rs.getString("id_categoria"));
                    if(rs2.next()){
                    datos[3] = rs2.getString("categoria_descripcion");
                    }
                datos[4] = rs.getString("pack_costo");
                
                rs2.close();
                modelPack.addRow(datos);    
                
            }
            rs.close();
        } catch (SQLException ex) {
            
        }
            

    }
    
    
    public static void BuscarPack(){
    
        String datos[] = new String[5];
        DefaultTableModel modelPack = (DefaultTableModel) SuperAdmC.superAdm.packTabla.getModel();
        modelPack.setRowCount(0);
        
        
        try {
            
            String SQL = "select * from packs where pack_nombre like '%"+SuperAdmC.superAdm.PackBuscar.getText()+"%'";
            var rs = consultaSQL.doQueryGet(SQL);
            while(rs.next()){
                
                datos[0] = rs.getString("pack_id");
                datos[1] = rs.getString("pack_nombre");
                datos[2] = rs.getString("pack_stock");
                datos[4] = rs.getString("pack_costo");
                
                var rs2 = consultaSQL.doQueryGet("select categoria_descripcion from categoria_pack where categoria_id="+rs.getString("id_categoria"));
                if(rs2.next()){
                    datos[3] = rs2.getString("categoria_descripcion");
                }
                rs2.close();
                modelPack.addRow(datos);    
                
            }
            SuperAdmC.superAdm.packTabla.setModel(modelPack);
            rs.close();
        } catch (SQLException ex) {
            
        }
        
    
    }
    
    
    
    
    public static void ModificarBoton() {
        
        
        String id = (String) SuperAdmC.superAdm.packTabla.getValueAt(SuperAdmC.superAdm.packTabla.getSelectedRow(), 0);
        String nombre  = (String) SuperAdmC.superAdm.packTabla.getValueAt(SuperAdmC.superAdm.packTabla.getSelectedRow(), 1);
        String stock   = (String) SuperAdmC.superAdm.packTabla.getValueAt(SuperAdmC.superAdm.packTabla.getSelectedRow(), 2);
        String categoria = (String) SuperAdmC.superAdm.packTabla.getValueAt(SuperAdmC.superAdm.packTabla.getSelectedRow(), 3);
        String costo = (String) SuperAdmC.superAdm.packTabla.getValueAt(SuperAdmC.superAdm.packTabla.getSelectedRow(), 4);
     
        var modificar = new ModificarPack(id,nombre,costo,stock,SuperAdmC.superAdm.categoriaPack.getModel());
        modificar.categoriaBox.setSelectedItem(categoria);
        modificar.setVisible(true);
        
    }
    
    public static void ModificarGuardar(String nombre, String costo,String stock, String categoria, String id){
    
        
        try {
            String SQL = "select categoria_id from categoria_pack where categoria_descripcion='"+categoria+"'";
            var rs = consultaSQL.doQueryGet(SQL);
            if(rs.next()){
                categoria = rs.getString("categoria_id");
            }
            rs.close();
            
            SQL = "update packs SET pack_nombre='"+nombre+"',pack_costo='"+costo+"',pack_stock='"+stock+"',id_categoria='"+categoria+"' where pack_id='"+id+"'";
            if(consultaSQL.doQueryPost(SQL)){JOptionPane.showMessageDialog(null, "actualizacion terminada");}
            else{JOptionPane.showMessageDialog(null, "error de actualizacion");}
            
        } catch (SQLException ex) {
            System.out.println("error " + ex);
        }
        
        rellenarPacks();
    }
    
    public static void LimpiarCampos(){
        
       DefaultTableModel model = (DefaultTableModel) SuperAdmC.superAdm.packCreaListado.getModel();
       model.setRowCount(0);
       SuperAdmC.superAdm.packCreaListado.setModel(model);
       SuperAdmC.superAdm.packNombrePack.setText("");
       SuperAdmC.superAdm.packValor.setText("");
       SuperAdmC.superAdm.categoriaPack.setSelectedIndex(0);
       
    }
            
}
