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

public class ComunasC {
    static Consultas queries = new Consultas();
    public static int consultasRealizadas = 0;
    
    public static void ComunasC(){}
    
    public static boolean insertarComuna(String nombreComuna, String codigoComuna) {
        boolean response = true;
        
        try {
            String Query = 
                    "INSERT INTO `comunas` (`comuna_id`, `comuna_nombre`, `comuna_codigo`, `comuna_estado`) VALUES (NULL,'"
                    + nombreComuna  + "','" + codigoComuna + "','1' )";
            response = ComunasC.queries.doQueryPost(Query);
        
        } catch(Exception e) {
            System.out.println("insertarComuna Error: " +  e.getMessage());
        }
        
        return response;
    }
    
    public static ArrayList<String> consultarComuna(String busqueda) {
        ArrayList<String> resultado;
        String Query = "SELECT * FROM `comunas` WHERE `comuna_id` = '" + busqueda + "' OR `comuna_nombre` like '%" + busqueda + "%' OR `comuna_codigo` like '%" + busqueda + "%' OR `comuna_estado` = '" + busqueda + "'";
        
        resultado = ComunasC.extraerDatos(Query);
        return resultado;
    }
    
    public static boolean modificarComuna(String id, String comunaName, String comunaCode, int comunaStatus) {
        boolean response = false;
        
         try {
            String Query = 
                    "UPDATE `comunas` SET `comuna_nombre` = '" + comunaName +
                    "',comuna_codigo = '" + comunaCode +
                    "',comuna_estado = '" + comunaStatus + "' WHERE `comuna_id` = '" + id + "'"; 
            
            response = ComunasC.queries.doQueryPost(Query);
        
        } catch(Exception e) {
            System.out.println("comunaModificar Error: " +  e.getMessage());
        }
        
        return response;
    }
    
    private static ArrayList<String> extraerDatos(String SQL) {
        ArrayList<String> resultado = new ArrayList<>();
        ResultSet response = queries.doQueryGet(SQL);

        try {
            for (boolean hayMasDatos = response.next(); hayMasDatos; hayMasDatos = response.next()) {
                resultado.add(response.getString("comuna_id"));
                resultado.add(response.getString("comuna_nombre"));
                resultado.add(response.getString("comuna_codigo"));
                resultado.add(response.getString("comuna_estado"));
            }

            return resultado;
        } catch (SQLException e) {
            System.out.println("ExtraerDatosComuna Error: " + e.getLocalizedMessage());
        }
        
        return null;
    }
    
    public static void buscar(String busqueda) {
        var response = ComunasC.consultarComuna(busqueda);
        ComunasC.mostrarResultados(response);
        
        ComunasC.consultasRealizadas++;
    }
    
    public static void ingresar(String nombre, String codigo) {
        var response = ComunasC.insertarComuna(nombre, codigo);
        if (response)
            JOptionPane.showMessageDialog(null, "Comuna ingresada con éxito");
        else
            JOptionPane.showMessageDialog(null, "No fue posible ingresar la comuna");
    }
    
    public static void modificar() {
        String[] parametros = ComunasC.selectedRowInfo();
        var editWindow = new modificarComuna();
        editWindow.setVisible(true);
        editWindow.setLocationRelativeTo(SuperAdmC.superAdm);
        
        
        ComunasC.datosModificar(editWindow, parametros);
        
    }
    
    private static void datosModificar(modificarComuna window, String[] parametros) {
        window.getComunaNameTF().setText(parametros[1]);
        window.getComunaCodeTF().setText(parametros[2]);
        window.getComunaStatusCB().setSelectedIndex(Integer.parseInt(parametros[3]));
        
        window.getIdLabel().setText(parametros[0]);
    }
    
    public static void mostrarResultados(ArrayList<String> resultados) {
        var table = SuperAdmC.superAdm.getComunasTabla();
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
        var table = SuperAdmC.superAdm.getComunasTabla();
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
