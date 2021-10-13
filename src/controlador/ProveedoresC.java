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

public class ProveedoresC {
    static Consultas queries = new Consultas();
    
    public static void ProveedoresC(){
    }
    
    public static boolean insertarProveedor(String RUT, String nombre, String telefono, String correo, String direccion) {
        boolean response = true;
        
        if(voidParams(RUT, nombre, telefono, correo, direccion)) //Existen paramétros vacíos
            return false;
        
        try {
            String Query = 
                    "INSERT INTO `proveedores` (`proveedor_rut`, `proveedor_nombre`, `proveedor_telefono`, `proveedor_correo`, `proveedor_direccion`, `proveedor_estado`) VALUES ('"
                    + RUT + "', '" + nombre + "', '" + telefono + "', '" + correo + "', '" + direccion +"', '1')" ;
            
            response = ProveedoresC.queries.doQueryPost(Query);
        
        } catch(Exception e) {
            System.out.println("insertarProveedor Error: " +  e.getMessage());
        }
        
        return response;
    }
    
    public static ArrayList<String> consultarProveedor(String busqueda) {
        ArrayList<String> resultado;
        String Query = "SELECT * FROM `proveedores` WHERE `proveedor_rut` = '" + busqueda + "'";
        
        resultado = ProveedoresC.extraerDatos(Query);
        return resultado;
    }
    
    public static ArrayList<String> todosProveedores() {
        ArrayList<String> resultado;
        String Query = "SELECT * FROM `proveedores`";
        
        resultado = ProveedoresC.extraerDatos(Query);
        return resultado;
    }
    
    public static boolean modificarProveedor(String RUT, String nombre, String telefono, String correo, String direccion, int estado) {
        boolean response = false;
        
        if(voidParams(RUT, nombre, telefono, correo, direccion))
            return false;
        
         try {
            String Query = 
                    "UPDATE `proveedores` SET `proveedor_nombre` = '" + nombre +
                    "',proveedor_telefono = '" + telefono +
                    "',proveedor_correo = '" + correo + 
                    "',proveedor_direccion = '" + direccion +
                    "',proveedor_estado = '"+ estado + "' WHERE `proveedor_rut` = '" + RUT + "'"; 
            
            response = ProveedoresC.queries.doQueryPost(Query);
        
        } catch(Exception e) {
            System.out.println("ModificarProveedor Error: " +  e.getMessage());
        }
        
        return response;
    }
    
    private static ArrayList<String> extraerDatos(String SQL) {
        ArrayList<String> resultado = new ArrayList<>();
        ResultSet response = queries.doQueryGet(SQL);

        try {
            for (boolean hayMasDatos = response.next(); hayMasDatos; hayMasDatos = response.next()) {
                resultado.add(response.getString("proveedor_rut"));
                resultado.add(response.getString("proveedor_nombre"));
                resultado.add(response.getString("proveedor_telefono"));
                resultado.add(response.getString("proveedor_correo"));
                resultado.add(response.getString("proveedor_direccion"));
                resultado.add(response.getString("proveedor_estado"));
            }

            return resultado;
        } catch (SQLException e) {
            System.out.println("extraerDatos Proveedores Error: " + e.getLocalizedMessage());
        }
        
        return null;
    }
    
    public static void buscar(String busqueda) {
        if(busqueda == "")
            ProveedoresC.buscar();
        else {
            var response = ProveedoresC.consultarProveedor(busqueda);
            ProveedoresC.mostrarResultados(response);
        }
    }
    
    public static void buscar() {
        var response = ProveedoresC.mostrarTodos();
        ProveedoresC.mostrarResultados(response);
    }
    
    public static ArrayList<String> mostrarTodos() {
        ArrayList<String> resultado = new ArrayList<>();
        ResultSet response = queries.traerTodos("proveedores");

        try {
            for (boolean hayMasDatos = response.next(); hayMasDatos; hayMasDatos = response.next()) {
                resultado.add(response.getString("proveedor_rut"));
                resultado.add(response.getString("proveedor_nombre"));
                resultado.add(response.getString("proveedor_telefono"));
                resultado.add(response.getString("proveedor_correo"));
                resultado.add(response.getString("proveedor_direccion"));
                resultado.add(response.getString("proveedor_estado"));
            }

            return resultado;
        } catch (SQLException e) {
            System.out.println("extraerDatos Proveedores Error: " + e.getLocalizedMessage());
        }
        
        return null;
    }
    
    
    public static void ingresar(String RUT, String nombre, String telefono, String correo, String direccion) {
        var response = ProveedoresC.insertarProveedor(RUT, nombre, telefono, correo, direccion);
        if (response){
            JOptionPane.showMessageDialog(null, "Proveedor ingresado con éxito");
            queries.traerTodos("proveedores");
        } else
            JOptionPane.showMessageDialog(null, "No fue posible ingresar el proveedor");
    }
    
    public static void modificar() {
        String[] parametros = ProveedoresC.selectedRowInfo();
        var editWindow = new ModificarProveedor();
        editWindow.setVisible(true);
        editWindow.setLocationRelativeTo(SuperAdmC.superAdm);
        
        
        ProveedoresC.datosModificar(editWindow, parametros);
        
    }
    
    private static void datosModificar(ModificarProveedor window, String[] parametros) {
        window.getNombreTF().setText(parametros[1]);
        window.getTelefonoTF().setText(parametros[2]);
        window.getCorreoTF().setText(parametros[3]);
        window.getDireccionTF().setText(parametros[4]);
        window.getEstadoCB().setSelectedIndex(Integer.parseInt(parametros[5]));
        
        window.getRutLabel().setText(parametros[0]);
    }
    
    public static void mostrarResultados(ArrayList<String> resultados) {
        var table = SuperAdmC.superAdm.getProveedorTabla();
        var model = (DefaultTableModel) table.getModel();
        int n;
        String estado;
        
        //Se limpia la tabla.
        model.setRowCount(0);
        
        //Si existen elementos en el  Array, se agregan a la tabla
        if (resultados != null ){
            for(int i =0; (i * 6) < resultados.size() ; i++){
                n = i * 6;
                if(Integer.parseInt(resultados.get( n+5 )) == 1)
                    estado = "Activo";
                else
                    estado = "Inactivo";
                
                model.addRow(new Object[] { resultados.get( n ), resultados.get( n + 1 ), resultados.get( n + 2 ), resultados.get( n + 3 ), resultados.get( n + 4 ), estado } );
            }
           //Si el Array está vacío
        } else {
            JOptionPane.showMessageDialog(null, "No se hallaron resultados :(");
        }
    }
    
    public static String[] selectedRowInfo() {
        var table = SuperAdmC.superAdm.getProveedorTabla();
        int row = table.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        String info;
        
        info = model.getValueAt(row, 0).toString() + ","
                + model.getValueAt(row, 1).toString() + ","
                + model.getValueAt(row, 2).toString() + ","
                + model.getValueAt(row, 3).toString() + ","
                + model.getValueAt(row, 4).toString() + ",";
        
        if( model.getValueAt(row, 5)  == "Activo")
            info = info + "1";
        else
            info = info + "0";
        
        var result = info.split(",");
        
        
        return result;
    }
    
    private static boolean voidParams(String RUT, String nombre, String telefono, String correo, String direccion) {
        if("".equals(RUT) || "".equals(nombre) || "".equals(telefono) || "".equals(correo) || "".equals(direccion))
            return true;
        else
            return false;
    }
}
