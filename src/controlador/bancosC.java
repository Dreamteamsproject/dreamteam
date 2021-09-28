package controlador;

import modelo.*;
import vista.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mauro
 */

//Text field campos de banco:
//bcoDescripcion1
//bcoCodigo

//Boton agregar banco
//bcoAgregarBcoBtn

public class bancosC {
    static Consultas queries = new Consultas();
    
    public static void bancosC(){
    }
    
    public static boolean insertarBanco(String nombreBanco, String codigoBanco) {
        boolean response = true;
        
        try {
            String Query = 
                    "INSERT INTO `bancos` (`banco_id`, `banco_descripcion`, `banco_codigo`, `banco_estado`) VALUES (NULL,'"
                    + nombreBanco  + "','" + codigoBanco + "','1' )";
            response = bancosC.queries.doQueryPost(Query);
        
        } catch(Exception e) {
            System.out.println("insertarBanco Error: " +  e.getMessage());
        }
        
        return response;
    }
    
    public static ArrayList<String> consultarBanco(String busqueda) {
        ArrayList<String> resultado;
        String Query = "SELECT * FROM `bancos` WHERE `banco_id` = '" + busqueda + "' OR `banco_descripcion` like '%" + busqueda + "%' OR `banco_codigo` like '%" + busqueda + "%' OR `banco_estado` = '" + busqueda + "'";
        
        resultado = bancosC.extraerDatos(Query);
        return resultado;
    }
    
    public static boolean modificarBanco(String id, String bankName, String bankCode, int bankStatus) {
        boolean response = false;
        
         try {
            String Query = 
                    "UPDATE `bancos` SET `banco_descripcion` = '" + bankName +
                    "',banco_codigo = '" + bankCode +
                    "',banco_estado = '" + bankStatus + "' WHERE `banco_id` = '" + id + "'"; 
            
             System.out.println(Query);
            response = bancosC.queries.doQueryPost(Query);
        
        } catch(Exception e) {
            System.out.println("bankInsert Error: " +  e.getMessage());
        }
        
        return response;
    }
    
    private static ArrayList<String> extraerDatos(String SQL) {
        ArrayList<String> resultado = new ArrayList<>();
        ResultSet response = queries.doQueryGet(SQL);

        try {
            for (boolean hayMasDatos = response.next(); hayMasDatos; hayMasDatos = response.next()) {
                resultado.add(response.getString("banco_id"));
                resultado.add(response.getString("banco_descripcion"));
                resultado.add(response.getString("banco_codigo"));
                resultado.add(response.getString("banco_estado"));
            }

            return resultado;
        } catch (SQLException e) {
            System.out.println("consultarBanco Error: " + e.getLocalizedMessage());
        }
        
        return null;
    }
    
    public static void buscar(String busqueda) {
        var response = bancosC.consultarBanco(busqueda);
        bancosC.mostrarResultados(response);
    }
    
    public static void ingresar(String nombre, String codigo) {
        var response = bancosC.insertarBanco(nombre, codigo);
        if (response)
            JOptionPane.showMessageDialog(null, "Banco ingresado con éxito");
        else
            JOptionPane.showMessageDialog(null, "No fue posible ingresar el banco");
    }
    
    public static void modificar() {
        String[] parametros = bancosC.selectedRowInfo();
        var editWindow = new modificarBanco();
        editWindow.setVisible(true);
        
        bancosC.datosModificar(editWindow, parametros);
        
    }
    
    private static void datosModificar(modificarBanco window, String[] parametros) {
        window.getBankNameTF().setText(parametros[1]);
        window.getBankCodeTF().setText(parametros[2]);
        window.getBankStatusCB().setSelectedIndex(Integer.parseInt(parametros[3]));
        
        window.getIdLabel().setText(parametros[0]);
    }
    
    public static void mostrarResultados(ArrayList<String> resultados) {
        var table = SuperAdmC.superAdm.getBcoTabla();
        var model = (DefaultTableModel) table.getModel();
        int n;
        String estado;
        
        //Se limpia la tabla.
        model.setRowCount(0);
        
        //Si existen elementos en el  Array, se agregan a la tabla
        if (resultados != null ){
            for(int i =0; (i * 4) < resultados.size() ; i++){
                n = i * 4;
                if(Integer.parseInt(resultados.get( n+3 )) == 1)
                    estado = "Activo";
                else
                    estado = "Inactivo";
                
                model.addRow(new Object[] { resultados.get( n ), resultados.get( n + 1 ), resultados.get( n + 2 ), estado } );
            }
           //Si el Array está vacío
        } else {
            JOptionPane.showMessageDialog(null, "No se hallaron resultados :(");
        }
    }
    
    public static String[] selectedRowInfo() {
        var table = SuperAdmC.superAdm.getBcoTabla();
        int row = table.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        String info;
        
        info = model.getValueAt(row, 0).toString() + ","
                + model.getValueAt(row, 1).toString() + ","
                + model.getValueAt(row, 2).toString() + ",";
        
        if( model.getValueAt(row, 3)  == "Activo")
            info = info + "1";
        else
            info = info + "0";
        
        var result = info.split(",");
        
        
        return result;
    }
}
