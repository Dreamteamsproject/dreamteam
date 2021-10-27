/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import modelo.Consultas;
import java.sql.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;

/**
 *
 * @author Mauro
 */
public class InformeInventarioC {
    private static Consultas queries = new Consultas();
    
    public static String[] listaCategorias = obtenerListaCategorias();
    
    public static void buscar() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        String Query = "SELECT * FROM `articulos` WHERE ";
        int filtros = 0;
        
        if(InformesController.pestanaInformes.getInformesDateCheckbox()){
            String fechaInicial = formatter.format(InformesController.pestanaInformes.getInfInvFechaI().getDate());
            String fechaFinal = formatter.format(InformesController.pestanaInformes.getInfInvFechaF().getDate());
            Query = Query + "(`articulo_fechavencimiento` >= '" + fechaInicial +"' AND `articulo_fechavencimiento` <= '" + fechaFinal + "')";
            filtros++;
        }
        if(InformesController.pestanaInformes.getInformesCategoriaCheckbox()){
            String categoria = InformesController.pestanaInformes.getInfVentCategoria();
            categoria = getIdOf("SELECT `categoria_id` FROM `categorias_articulo` WHERE `categoria_descripcion` = '" + categoria + "'", "categoria_id");
            if(filtros > 0)
                Query = Query + " AND ";
            Query = Query + "(`id_categoria` = '" + categoria + "')";
            filtros++;
        }
        if(filtros == 0)
            Query = Query + " '1'";
        
        Query = Query + " ORDER BY `articulo_stock`";
        
        System.out.println(Query);
        
        var data = extraerDatos(Query);
        insertarDatosTabla(data);
    }
    
    public static void buscarTodo() {
        String Query = "SELECT * FROM `articulos` ORDER BY `articulo_stock`";
        var data = extraerDatos(Query);
        insertarDatosTabla(data);
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
            System.out.println("ExtraerDatos InformesInventario Error: " + e.getLocalizedMessage());
        }
        
        return null;
    }
    
    public static void insertarDatosTabla(ArrayList<String> resultados) {
        var table = InformesController.pestanaInformes.getInfInvTabla();
        var model = (DefaultTableModel) table.getModel();
        int n;
        String estado;
        String categoria;
        
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
                
                categoria = getIdOf("SELECT `categoria_descripcion` FROM `categorias_articulo` WHERE `categoria_id` = '" + resultados.get( n + 4 ) + "'", "categoria_descripcion");

                model.addRow(new Object[] { resultados.get( n ), resultados.get( n + 1 ), resultados.get( n + 2 ), resultados.get( n + 3 ), categoria, estado } );
            }
           //Si el Array está vacío
        } else {
            JOptionPane.showMessageDialog(null, "No se hallaron resultados :(");
        }
    }
    
     public static String getIdOf(String Query, String dataRequired) {
         var response = queries.doQueryGet(Query);
        try {
            if(response.next())
                return response.getString(dataRequired);
        } catch (SQLException ex) {
            Logger.getLogger(ArticulosC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
     }
     
     private static String[] obtenerListaCategorias() {
        String Query = "SELECT `categoria_descripcion` FROM categorias_articulo ORDER BY `categoria_id`";
        ResultSet response = queries.doQueryGet(Query);
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
}
