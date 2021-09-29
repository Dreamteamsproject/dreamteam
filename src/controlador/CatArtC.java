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
import vista.modificarCatArt;
import vista.modificarRedes;

/**
 *
 * @author Mauro
 */
public class CatArtC {
    static Consultas queries = new Consultas();
    
    public static void CatArtC() {
    }
    
    public static boolean insertarCatArt(String nombreCat) {
        boolean response = true;
        
        if("".equals(nombreCat))
            return false;
        
        try {
            String Query = 
                    "INSERT INTO `categorias_articulo` (`categoria_id`, `categoria_descripcion`, `categoria_estado`) VALUES (NULL,'"
                    + nombreCat  +  "','1' )";
            response = CatArtC.queries.doQueryPost(Query);
        
        } catch(Exception e) {
            System.out.println("insertarCategoriaArticulo Error: " +  e.getMessage());
        }
        
        return response;
    }
    
    public static ArrayList<String> consultarCatArt(String busqueda) {
        ArrayList<String> resultado;
        String Query = "SELECT * FROM `categorias_articulo` WHERE `categoria_id` = '" + busqueda + "' OR `categoria_descripcion` like '%" + busqueda +  "%' OR `categoria_estado` = '" + busqueda + "'";
        
        resultado = CatArtC.extraerDatos(Query);
        return resultado;
    }
    
    public static boolean modificarCatArt(String id, String catName, int catStatus) {
        boolean response = false;
        
        if("".equals(catName))
            return false;
        
         try {
            String Query = 
                    "UPDATE `categorias_articulo` SET `categoria_descripcion` = '" + catName +
                    "', `categoria_estado` = '" + catStatus + "' WHERE `categoria_id` = '" + id + "'"; 
            response = CatArtC.queries.doQueryPost(Query);
        
        } catch(Exception e) {
            System.out.println("ModificarCategoriaArticulo Error: " +  e.getMessage());
        }
        
        return response;
    }
    
    private static ArrayList<String> extraerDatos(String SQL) {
        ArrayList<String> resultado = new ArrayList<>();
        ResultSet response = queries.doQueryGet(SQL);

        try {
            for (boolean hayMasDatos = response.next(); hayMasDatos; hayMasDatos = response.next()) {
                resultado.add(response.getString("categoria_id"));
                resultado.add(response.getString("categoria_descripcion"));
                resultado.add(response.getString("categoria_estado"));
            }

            return resultado;
        } catch (SQLException e) {
            System.out.println("extraerDatos CategoriaArticulo Error: " + e.getLocalizedMessage());
        }
        
        return null;
    }
    
    public static void buscar(String busqueda) {
        var response = CatArtC.consultarCatArt(busqueda);
        CatArtC.mostrarResultados(response);
    }
    
    public static void ingresar(String nombre) {
        var response = CatArtC.insertarCatArt(nombre);
        if (response)
            JOptionPane.showMessageDialog(null, "Categoria ingresada con éxito");
        else
            JOptionPane.showMessageDialog(null, "No fue posible ingresar la Categoria");
    }
    
    public static void modificar() {
        String[] parametros = CatArtC.selectedRowInfo();
        var editWindow = new modificarCatArt();
        editWindow.setVisible(true);
        editWindow.setLocationRelativeTo(SuperAdmC.superAdm);
        
        
        CatArtC.datosModificar(editWindow, parametros);
        
    }
    
    private static void datosModificar(modificarCatArt window, String[] parametros) {
        window.getCatArtNameTF().setText(parametros[1]);
        window.getCatArtStatusCB().setSelectedIndex(Integer.parseInt(parametros[2]));
        
        window.getIdLabel().setText(parametros[0]);
    }
    
    public static void mostrarResultados(ArrayList<String> resultados) {
        var table = SuperAdmC.superAdm.getCatArtTabla();
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
        var table = SuperAdmC.superAdm.getCatArtTabla();
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
