/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Consultas;
import vista.modificarEstadoDespacho;

/**
 *
 * @author Mauro
 */
public class EstadoDespachoC {
    static Consultas queries = new Consultas();
    
    public static String[] estados = EstadoDespachoC.obtenerLista("SELECT `estados_descripcion` FROM `estados_venta` ORDER BY `estados_id`", "estados_descripcion");
    
    public static void EstadoDespachoC(){}
    
    public static void buscar(Date busqueda) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        String fecha = formatter.format(busqueda);
        
        String Query = "SELECT * FROM `ventas` WHERE `venta_fechaentrega` = '" + fecha + "' OR `venta_fechaventa` = '" + fecha + "'";
        var response = EstadoDespachoC.extraerDatos(Query);
        
        if(response != null)
            EstadoDespachoC.insertarDatosTabla(response);
        else
            JOptionPane.showMessageDialog(null, "No se hallaron resultados en tu busqueda");
        
    }
    
    public static void modificar() {
        String[] parametros = EstadoDespachoC.selectedRowInfo();
        var editWindow = new modificarEstadoDespacho();
        editWindow.setVisible(true);
        editWindow.setLocationRelativeTo(SuperAdmC.superAdm);
        
        
        EstadoDespachoC.datosModificar(editWindow, parametros);
        
    }
    
     public static String[] selectedRowInfo() {
        var table = VentasC.pestanaVenta.getEstDespTabla();
        int row = table.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        String info;
        
        info = model.getValueAt(row, 0).toString() + ","
                + model.getValueAt(row, 17).toString();
        
        var result = info.split(",");
        
        
        return result;
    }
     
     private static void datosModificar(modificarEstadoDespacho window, String[] parametros) {
        window.getVentaStatusCB().setSelectedItem(parametros[1]);
        window.getIdLabel().setText(parametros[0]);
    }
    
    public static void buscarTodos() {
        String Query = "SELECT * FROM `ventas`";
        var data = extraerDatos(Query);
        insertarDatosTabla(data);
    }
    
    public static boolean modificarEstadoDespacho(String id, String estado){
        String idEstado = getIdOf("SELECT `estados_id` FROM `estados_venta` WHERE `estados_descripcion` = '" + estado + "'", "estados_id");
        
        String Query = "UPDATE `ventas` SET `id_estadoventa` = '" + idEstado +
                "' WHERE `venta_id` = '" + id + "'";
                
         var result = queries.doQueryPost(Query);
         return result;
    }
    
     private static ArrayList<String> extraerDatos(String SQL) {
        ArrayList<String> resultado = new ArrayList<>();
        ResultSet response = queries.doQueryGet(SQL);

        try {
            for (boolean hayMasDatos = response.next(); hayMasDatos; hayMasDatos = response.next()) {
                resultado.add(response.getString("venta_id")); //0
                resultado.add(response.getString("venta_total")); //1
                resultado.add(response.getString("venta_fechaventa")); //2
                resultado.add(response.getString("venta_fechatransferencia"));//3
                resultado.add(response.getString("venta_codigotransferencia")); //4
                resultado.add(response.getString("venta_nombredestinatario")); //5
                resultado.add(response.getString("venta_direcciondestinatario")); //6
                resultado.add(response.getString("venta_telefono"));//7
                resultado.add(response.getString("venta_email")); //8
                resultado.add(response.getString("venta_fechaentrega")); //9
                resultado.add(response.getString("venta_horaentrega_inicial")); //10
                resultado.add(response.getString("venta_horaentrega_final")); //11
                resultado.add(response.getString("venta_saludo")); //12
                resultado.add(response.getString("id_redsocial"));//13
                resultado.add(response.getString("id_comuna"));//14
                resultado.add(response.getString("id_banco"));//15
                resultado.add(response.getString("rut_cliente"));//16
                resultado.add(response.getString("id_estadoventa"));//17
                resultado.add(response.getString("id_pack"));//18
            }

            return resultado;
        } catch (SQLException e) {
            System.out.println("consultarBanco Error: " + e.getLocalizedMessage());
        }
        
        return null;
    }
     
     private static void insertarDatosTabla(ArrayList<String> datos) {
         var table = VentasC.pestanaVenta.getEstDespTabla();
        var model = (DefaultTableModel) table.getModel();
        int n;
        String estado;
        
        //Se limpia la tabla.
        model.setRowCount(0);
        
        //Si existen elementos en el  Array, se agregan a la tabla
        if (datos != null ){
            for(int i =0; (i * 19) < datos.size() ; i++){
                n = i * 19;
                estado = getIdOf("SELECT `estados_descripcion` FROM `estados_venta` WHERE `estados_id` = '" + datos.get( n + 17 ) + "'", "estados_descripcion"); 
                
                model.addRow(new Object[] { datos.get( n ), datos.get( n + 1 ), datos.get( n + 2 ), datos.get( n + 3 ), datos.get( n + 4 ), datos.get( n + 5 ), datos.get( n + 6 ), datos.get( n + 7 ), datos.get( n + 8 ), datos.get( n + 9 ), datos.get( n + 10 ), datos.get( n + 11 ),
                datos.get( n + 12 ), datos.get( n + 13 ), datos.get( n + 14 ), datos.get( n + 15 ), datos.get( n + 16 ), estado, datos.get( n + 18 )} );
            }
           //Si el Array está vacío
        } else {
            JOptionPane.showMessageDialog(null, "No se hallaron resultados :(");
        }
     }
     
     public static String getIdOf(String Query, String dataRequired) {
         var response = IngresoVentaC.queries.doQueryGet(Query);
        try {
            if(response.next())
                return response.getString(dataRequired);
        } catch (SQLException ex) {
            Logger.getLogger(ArticulosC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
     }
     
     public static String[] obtenerLista(String Query, String dataRequired) {
        ResultSet response = EstadoDespachoC.queries.doQueryGet(Query);
        String categorias = "";
        try {
            if(response.next()){
                for(boolean hayMasDatos = true; hayMasDatos; hayMasDatos = response.next()){
                    categorias = categorias + response.getString(dataRequired) + ",";
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArticulosC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String[] resultado = categorias.split(",");
        return resultado;
    }
}
