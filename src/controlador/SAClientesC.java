
package controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import modelo.Consultas;
import javax.swing.JOptionPane;

/**
 *
 * @author marce
 */
public class SAClientesC {
    
    static Consultas consultaSQL = new Consultas();
    static DefaultListModel modelClient = new DefaultListModel();
    
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
            modelClient.removeAllElements();
            var clienteLista = consultaSQL.doQueryGet("select cliente_nombre,cliente_apellido from clientes where cliente_nombre like '%%'");
            try {
                while(clienteLista.next()){
                    String cliente = clienteLista.getString("cliente_nombre")+ "  " + clienteLista.getString("cliente_apellido");
                    System.out.println(cliente);
                    modelClient.addElement(cliente);
                }
                SuperAdmC.superAdm.clienteListado.setModel(modelClient);
            } catch (SQLException ex) {
                Logger.getLogger(SAClientesC.class.getName()).log(Level.SEVERE, null, ex);
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
    
}
