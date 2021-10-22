
package controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import modelo.Consultas;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vista.ModificarCliente;

/**
 *
 * @author marce
 */
public class SAClientesC {
    
    static Consultas consultaSQL = new Consultas();
    
    
    public static void AgregarCliente(){
        
        if(!SuperAdmC.superAdm.clientesNombre.getText().equals("") ||
           !SuperAdmC.superAdm.clientesRut.getText().equals("")    ||
           !SuperAdmC.superAdm.clientesMail.getText().equals("") ||
           !SuperAdmC.superAdm.clientesApellido.getText().equals("") ||   
           !SuperAdmC.superAdm.clientesTelefono.getText().equals("") ||
           !SuperAdmC.superAdm.clientesCelular.getText().equals("")  )
                {
                    
                   String SQL = "INSERT INTO clientes values('"+SuperAdmC.superAdm.clientesRut.getText()+"','"
                                                              +SuperAdmC.superAdm.clientesNombre.getText()+"','"
                                                              +SuperAdmC.superAdm.clientesApellido.getText()+"','"
                                                              +SuperAdmC.superAdm.clientesTelefono.getText()+"','"
                                                              +SuperAdmC.superAdm.clientesMail.getText()+"','"
                                                              +ExtraerFecha(SuperAdmC.superAdm.fechaCliente.getDate().toString())+"','"
                                                              +ObtenerEstado(SuperAdmC.superAdm.clientesEstado.getSelectedItem().toString())+"')";
                                                              
                    System.out.println(SQL);
                        if(consultaSQL.doQueryPost(SQL)){JOptionPane.showMessageDialog(null, "Usuario añadido con exito");}
                    
        
                 }
        else{JOptionPane.showMessageDialog(null, "Porfavor rellene todos los campos, de requerir un campo nulo complete con N/A");}
        
    }
    
    
    private static int ObtenerEstado(String pan){
        
        if("activo".equals(pan)){return 1;}
        else if("desactivado".equals(pan)){return 0;}
        return 0;
    }
    
    
    public static void RellenarCliente() {
        
       
          //  consultaSQL.Connectar();
            String datos[] = new String[2];
            var tabla = (DefaultTableModel) SuperAdmC.superAdm.clienteListado.getModel();
            tabla.setRowCount(0);
            var rs = consultaSQL.doQueryGet("select cliente_nombre,cliente_apellido,RUT from clientes where cliente_nombre like '%%'");
            try {
                while(rs.next()){
                    datos[0] = rs.getString("RUT");
                    datos[1] = rs.getString("cliente_nombre")+ "  " + rs.getString("cliente_apellido");
                    System.out.println(datos[0] +"  "+  datos[1]);
                    tabla.addRow(datos);
                }
                SuperAdmC.superAdm.clienteListado.setModel(tabla);
            } catch (SQLException ex) {
                System.out.println("error " + ex);
            }
            
       
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
    
    public static ArrayList<String> consultarCliente(String busqueda) {
        ArrayList<String> resultado;
        String Query = "SELECT * FROM `clientes` WHERE `RUT` = '" + busqueda + "'";
        
        resultado = SAClientesC.extraerDatos(Query);
        return resultado;
    }
    
    private static ArrayList<String> extraerDatos(String SQL) {
        ArrayList<String> resultado = new ArrayList<>();
        var response = consultaSQL.doQueryGet(SQL);

        try {
            for (boolean hayMasDatos = response.next(); hayMasDatos; hayMasDatos = response.next()) {
                resultado.add(response.getString("RUT"));
                resultado.add(response.getString("cliente_nombre"));
                resultado.add(response.getString("cliente_apellido"));
                resultado.add(response.getString("cliente_email"));
            }

            return resultado;
        } catch (SQLException e) {
            System.out.println("extraerDatos Clientes Error: " + e.getLocalizedMessage());
        }
        
        return null;
    }
    
     public static void ModificarCliente(){
   
        try {
            String rut = (String) SuperAdmC.superAdm.clienteListado.getValueAt(SuperAdmC.superAdm.clienteListado.getSelectedRow(), 0);
            String SQL = "select * from clientes where RUT='"+rut+"'";
            var rs = consultaSQL.doQueryGet(SQL);
           
                if(rs.next()){
                    //String rut, String nombre, String apellido, String telefono, String mail,String estado
                    var modificar = new ModificarCliente(rs.getString("RUT"),rs.getString("cliente_nombre"),rs.getString("cliente_apellido"),rs.getString("cliente_telefono"),rs.getString("cliente_email"),rs.getString("cliente_estado"));
                    modificar.setVisible(true);
                } 
        }catch (SQLException ex) {
            Logger.getLogger(SAClientesC.class.getName()).log(Level.SEVERE, null, ex);
        }
      
   
   }
    
     public static void BuscarCliente(){
       
       var tabla = (DefaultTableModel) SuperAdmC.superAdm.clienteListado.getModel();
            String datos[] = new String[2];
            tabla.setRowCount(0);
            var clienteLista = consultaSQL.doQueryGet("select cliente_nombre,cliente_apellido,RUT from clientes where RUT like '%"+SuperAdmC.superAdm.clientesBuscarBtn.getText()+"%'");
            try {
                
                while(clienteLista.next()){
                    
                    datos[1] = clienteLista.getString("cliente_nombre")+ "  " + clienteLista.getString("cliente_apellido");
                    datos[0] = clienteLista.getString("RUT");
                    tabla.addRow(datos);
  
                }

            } catch (SQLException ex) {
                Logger.getLogger(SAClientesC.class.getName()).log(Level.SEVERE, null, ex);
            }

  }
     
      public static void GuardarModificar(String rut, String nombre, String apellido, String telefono, String mail,int estado){

       String SQL = "update clientes SET cliente_nombre='"+nombre+"',cliente_apellido='"+apellido+"', cliente_telefono='"+telefono+"',cliente_email='"+mail+"',cliente_estado="+estado+" where RUT='"+rut+"'";
       if(consultaSQL.doQueryPost(SQL)){JOptionPane.showMessageDialog(null, "cliente Actualizado");}
       else{JOptionPane.showMessageDialog(null, "error en la actualizacion");}
       RellenarCliente();
}
    
}
