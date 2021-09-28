/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Consultas;
import vista.modificarBanco;
import vista.modificarRedes;

/**
 *
 * @author Mauro
 */
public class RedesC {
    static Consultas queries = new Consultas();
    
    public static void RedesC() {
    }
    
    public static boolean insertarRed(String nombreRed) {
        boolean response = true;
        
        try {
            String Query = 
                    "INSERT INTO `rrss` (`rs_id`, `rs_nombre`, `rs_estado`) VALUES (NULL,'"
                    + nombreRed  +  "','1' )";
            response = RedesC.queries.doQueryPost(Query);
        
        } catch(Exception e) {
            System.out.println("insertarRed Error: " +  e.getMessage());
        }
        
        return response;
    }
    
    public static ArrayList<String> consultarRed(String busqueda) {
        ArrayList<String> resultado;
        String Query = "SELECT * FROM `rrss` WHERE `rs_id` = '" + busqueda + "' OR `rs_nombre` like '%" + busqueda +  "%' OR `rs_estado` = '" + busqueda + "'";
        
        resultado = RedesC.extraerDatos(Query);
        return resultado;
    }
    
    public static boolean modificarRed(String id, String rsName, int rsStatus) {
        boolean response = false;
        
         try {
            String Query = 
                    "UPDATE `rrss` SET `rs_nombre` = '" + rsName +
                    "', `rs_estado` = '" + rsStatus + "' WHERE `rs_id` = '" + id + "'"; 
            response = RedesC.queries.doQueryPost(Query);
        
        } catch(Exception e) {
            System.out.println("modificarRed Error: " +  e.getMessage());
        }
        
        return response;
    }
    
    private static ArrayList<String> extraerDatos(String SQL) {
        ArrayList<String> resultado = new ArrayList<>();
        ResultSet response = queries.doQueryGet(SQL);

        try {
            for (boolean hayMasDatos = response.next(); hayMasDatos; hayMasDatos = response.next()) {
                resultado.add(response.getString("rs_id"));
                resultado.add(response.getString("rs_nombre"));
                resultado.add(response.getString("rs_estado"));
            }

            return resultado;
        } catch (SQLException e) {
            System.out.println("extraerDatos Red Error: " + e.getLocalizedMessage());
        }
        
        return null;
    }
    
    public static void buscar(String busqueda) {
        var response = RedesC.consultarRed(busqueda);
        RedesC.mostrarResultados(response);
    }
    
    public static void ingresar(String nombre) {
        var response = RedesC.insertarRed(nombre);
        if (response)
            JOptionPane.showMessageDialog(null, "Red ingresada con éxito");
        else
            JOptionPane.showMessageDialog(null, "No fue posible ingresar la red");
    }
    
    public static void modificar() {
        String[] parametros = RedesC.selectedRowInfo();
        var editWindow = new modificarRedes();
        editWindow.setVisible(true);
        
        RedesC.datosModificar(editWindow, parametros);
        
    }
    
    private static void datosModificar(modificarRedes window, String[] parametros) {
        window.getRedNameTF().setText(parametros[1]);
        window.getRedStatusCB().setSelectedIndex(Integer.parseInt(parametros[2]));
        
        window.getIdLabel().setText(parametros[0]);
    }
    
    public static void mostrarResultados(ArrayList<String> resultados) {
        var table = SuperAdmC.superAdm.getRrssTabla();
        var model = (DefaultTableModel) table.getModel();
        int n;
        String estado;
        
        //Se limpia la tabla.
        model.setRowCount(0);
        
        //Si existen elementos en el  Array, se agregan a la tabla
        if (resultados != null ){
            for(int i =0; (i * 3) < resultados.size() ; i++){
                n = i * 3;
                if(Integer.parseInt(resultados.get(n+2)) == 1)
                    estado = "Activo";
                else
                    estado = "Inactivo";
                model.addRow(new Object[] { resultados.get( n ), resultados.get( n + 1 ), estado } );
            }
           //Si el Array está vacío
        } else {
            JOptionPane.showMessageDialog(null, "No se hallaron resultados :(");
        }
    }
    
    public static String[] selectedRowInfo() {
        var table = SuperAdmC.superAdm.getRrssTabla();
        int row = table.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        String info;
        
        info = model.getValueAt(row, 0).toString() + ","
                + model.getValueAt(row, 1).toString() + ",";
        
        if( model.getValueAt(row, 2) == "Activo")
            info = info + "1";
        else
            info = info + "0";
        
        System.out.println("Info: " + info);
        
        var result = info.split(",");
        
        
        return result;
    }
}
