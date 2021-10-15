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
import vista.modificarEstados;

/**
 *
 * @author Mauro
 */
public class EstadosVentaC {
    static Consultas queries = new Consultas();
    
    public static void EstadosVentaC() {
    }
    
    public static boolean insertarEstado(String nombreEstado) {
        boolean response = true;
        
        if("".equals(nombreEstado))
            return false;
        
        try {
            String Query = 
                    "INSERT INTO `estados_venta` (`estados_id`, `estados_descripcion`, `estados_estado`) VALUES (NULL,'"
                    + nombreEstado  +  "','1' )";
            response = EstadosVentaC.queries.doQueryPost(Query);
        
        } catch(Exception e) {
            System.out.println("insertarEstado Error: " +  e.getMessage());
        }
        
        return response;
    }
    
    public static ArrayList<String> consultarEstado(String busqueda) {
        ArrayList<String> resultado;
        String Query = "SELECT * FROM `estados_venta` WHERE `estados_id` = '" + busqueda + "' OR `estados_descripcion` like '%" + busqueda +  "%' OR `estados_estado` = '" + busqueda + "'";
        
        resultado = EstadosVentaC.extraerDatos(Query);
        return resultado;
    }
    
    public static boolean modificarEstado(String id, String name, int status) {
        boolean response = false;
        
        if("".equals(name))
            return false;
        
         try {
            String Query = 
                    "UPDATE `estados_venta` SET `estados_descripcion` = '" + name +
                    "', `estados_estado` = '" + status + "' WHERE `estados_id` = '" + id + "'"; 
            response = EstadosVentaC.queries.doQueryPost(Query);
        
        } catch(Exception e) {
            System.out.println("modificarEstado Error: " +  e.getMessage());
        }
        
        return response;
    }
    
    private static ArrayList<String> extraerDatos(String SQL) {
        ArrayList<String> resultado = new ArrayList<>();
        ResultSet response = queries.doQueryGet(SQL);

        try {
            for (boolean hayMasDatos = response.next(); hayMasDatos; hayMasDatos = response.next()) {
                resultado.add(response.getString("estados_id"));
                resultado.add(response.getString("estados_descripcion"));
                resultado.add(response.getString("estados_estado"));
            }

            return resultado;
        } catch (SQLException e) {
            System.out.println("extraerDatos EstadosVenta Error: " + e.getLocalizedMessage());
        }
        
        return null;
    }
    
    public static void buscar(String busqueda) {
        var response = EstadosVentaC.consultarEstado(busqueda);
        EstadosVentaC.mostrarResultados(response);
    }
    
    public static void ingresar(String nombre) {
        var response = EstadosVentaC.insertarEstado(nombre);
        if (response)
            JOptionPane.showMessageDialog(null, "Estado de venta ingresado con éxito");
        else
            JOptionPane.showMessageDialog(null, "No fue posible ingresar el estado de venta");
    }
    
    public static void modificar() {
        String[] parametros = EstadosVentaC.selectedRowInfo();
        var editWindow = new modificarEstados();
        editWindow.setVisible(true);
        editWindow.setLocationRelativeTo(SuperAdmC.superAdm);
        
        
        EstadosVentaC.datosModificar(editWindow, parametros);
        
    }
    
    private static void datosModificar(modificarEstados window, String[] parametros) {
        window.getEstadoNameTF().setText(parametros[1]);
        window.getEstadoStatusCB().setSelectedIndex(Integer.parseInt(parametros[2]));
        
        window.getIdLabel().setText(parametros[0]);
    }
    
    public static void mostrarResultados(ArrayList<String> resultados) {
        var table = SuperAdmC.superAdm.getEstadosTabla();
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
        var table = SuperAdmC.superAdm.getEstadosTabla();
        int row = table.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        String info;
        
        info = model.getValueAt(row, 0).toString() + ","
                + model.getValueAt(row, 1).toString() + ",";
        
        if( model.getValueAt(row, 2) == "Activo")
            info = info + "1";
        else
            info = info + "0";
        
        var result = info.split(",");
        
        
        return result;
    }
}
