package controlador;

import modelo.*;
import vista.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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

public class ArticulosC {
    static Consultas queries = new Consultas();
    public static String[] listaCategorias = ArticulosC.obtenerListaCategorias();
    
    public static void ArticulosC(){
    }
    
    public static boolean insertarArticulo(String nombre, String stock, String fechaVencimiento, String categoria) {
        boolean response = true;
        
        try {
            String Query = 
                "INSERT INTO `articulos` (`articulo_descripcion`, `articulo_stock`, `articulo_fechavencimiento`, `id_categoria`, `articulo_estado`) VALUES"
                + "('"+nombre+"', '"+stock+"', '"+ fechaVencimiento + "', '"+categoria+"', '1' )";
            response = ArticulosC.queries.doQueryPost(Query);
        
        } catch(Exception e) {
            System.out.println("insertarArticulo Error: " +  e.getMessage());
        }
        
        return response;
    }
    
    public static ArrayList<String> consultarArticulo(String busqueda) {
        ArrayList<String> resultado;
        String Query = "SELECT * FROM `articulos` WHERE `articulo_id` = '" + busqueda + "' OR `articulo_descripcion` like '%" + busqueda + "%' OR `articulo_stock` = '" + busqueda + "' OR `articulo_fechavencimiento` like '%" + busqueda + "%' OR `id_categoria` = '" + busqueda + "' OR `articulo_estado` = '" + busqueda + "'";
        
        resultado = ArticulosC.extraerDatos(Query);
        return resultado;
    }
    
    public static boolean modificarArticulo(String id, String nombre, String stock, String fechaVencimiento, String categoria, String estado) {
        boolean response = false;
        
         try {
            String Query = 
                    "UPDATE `articulos` SET `articulo_descripcion` = '" + nombre +
                    "',articulo_stock = '" + stock +
                    "',articulo_fechavencimiento = '" + fechaVencimiento + 
                    "',id_categoria = '" + categoria +
                    "', articulo_estado = '" + estado +
                    "' WHERE `articulo_id` = '" + id + "'"; 
            
            response = ArticulosC.queries.doQueryPost(Query);
        
        } catch(Exception e) {
            System.out.println("ModificarArticulo Error: " +  e.getMessage());
        }
        
        return response;
    }
    
    private static ArrayList<String> extraerDatos(String SQL) {
        ArrayList<String> resultado = new ArrayList<>();
        ResultSet response = queries.doQueryGet(SQL);

        try {
            for (boolean hayMasDatos = response.next(); hayMasDatos; hayMasDatos = response.next()) {
                resultado.add(response.getString("articulo_id"));
                resultado.add(response.getString("articulo_descripcion"));
                resultado.add(response.getString("articulo_stock"));
                resultado.add(response.getString("articulo_fechavencimiento"));
                resultado.add(response.getString("id_categoria"));
                resultado.add(response.getString("articulo_estado"));
            }

            return resultado;
        } catch (SQLException e) {
            System.out.println("ExtraerDatos Articulos Error: " + e.getLocalizedMessage());
        }
        
        return null;
    }
    
    public static void buscar(String busqueda) {
        var response = ArticulosC.consultarArticulo(busqueda);
        ArticulosC.mostrarResultados(response);
    }
    
    public static void ingresar(String nombre, String stock, String dia, String mes, String anio, String categoria) {
        String fechaVencimiento = ArticulosC.toDate(Integer.parseInt(dia), Integer.parseInt(mes), Integer.parseInt(anio));
        String id = ArticulosC.getIdOf(categoria);
        
        var response = ArticulosC.insertarArticulo(nombre, stock, fechaVencimiento, id);
        if (response)
            JOptionPane.showMessageDialog(null, "Articulo ingresado con éxito");
        else
            JOptionPane.showMessageDialog(null, "No fue posible ingresar el articulo");
    }
    
    public static void modificar() {
        String[] parametros = ArticulosC.selectedRowInfo();
//        for(int i = 0; i < parametros.length; i++){
//            System.out.println(parametros[i]);
//        }
        var editWindow = new ModificarArticulo();
        editWindow.setVisible(true);
        editWindow.setLocationRelativeTo(SuperAdmC.superAdm);
        
        
        ArticulosC.datosModificar(editWindow, parametros);
        
    }
    
    private static void datosModificar(ModificarArticulo window, String[] parametros) {
        String description = ArticulosC.getNameOf(parametros[4]);
        String[] fechaVencimiento = parametros[3].split("-");
        
        window.getArtName().setText(parametros[1]);
        window.getArtStock().setText(parametros[2]);
        
        window.getArtDiaFV().setText(fechaVencimiento[2]);
        window.getArtMesFV().setText(fechaVencimiento[1]);
        window.getArtAnioFV().setText(fechaVencimiento[0]);
        
        window.getArtCategoria().setSelectedItem(description);
        window.getArtEstado().setSelectedIndex(Integer.parseInt(parametros[5]));
        
        window.getIdLabel().setText(parametros[0]);
    }
    
    public static void mostrarResultados(ArrayList<String> resultados) {
        var table = SuperAdmC.superAdm.getArtTabla();
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
        var table = SuperAdmC.superAdm.getArtTabla();
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
    
     public static String toDate(int dia, int mes, int anio) {
        String sDia = "" + dia;
        String sMes = "" + mes;
        String sAnio = "" + anio;
        
        if(dia < 10)
            sDia = "0" + sDia;
        if(mes < 10)
            sMes = "0" + mes;
        
        return sAnio + "-" + sMes + "-" + sDia;
    } 
     
     public static String getIdOf(String name) {
         String Query = "SELECT `categoria_id` FROM `categorias_articulo` WHERE `categoria_descripcion` = '" + name + "'";
         var response = ArticulosC.queries.doQueryGet(Query);
        try {
            if(response.next())
                return response.getString("categoria_id");
        } catch (SQLException ex) {
            Logger.getLogger(ArticulosC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
     }
     
     private static String getNameOf(String id) {
         String Query = "SELECT `categoria_descripcion` FROM `categorias_articulo` WHERE `categoria_id` = '" + id + "'";
         var response = ArticulosC.queries.doQueryGet(Query);
        try {
            if(response.next())
                return response.getString("categoria_descripcion");
        } catch (SQLException ex) {
            Logger.getLogger(ArticulosC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
     }
     
      public static String[] obtenerListaCategorias() {
        String Query = "SELECT `categoria_descripcion` FROM categorias_articulo ORDER BY `categoria_id`";
        ResultSet response = ArticulosC.queries.doQueryGet(Query);
        String categorias = "";
        try {
            if(response.next()){
                for(boolean hayMasDatos = true; hayMasDatos; hayMasDatos = response.next()){
                    categorias = categorias + response.getString("categoria_descripcion") + ",";
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArticulosC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String[] resultado = categorias.split(",");
        return resultado;
    }
      
      public static void actualizarListaCategorias() {
          ArticulosC.listaCategorias = ArticulosC.obtenerListaCategorias();
          SuperAdmC.superAdm.getArticuloCatCB().setModel(new javax.swing.DefaultComboBoxModel<>(ArticulosC.listaCategorias));
      }
}
