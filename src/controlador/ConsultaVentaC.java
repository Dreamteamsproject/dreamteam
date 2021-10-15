/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import static controlador.SAClientesC.consultaSQL;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.Consultas;

/**
 *
 * @author Mauro
 */
public class ConsultaVentaC {
    static Consultas queries = new Consultas();
    
    public static String[] bancos = obtenerLista("SELECT `banco_descripcion` FROM `bancos` ORDER BY `banco_id`", "banco_descripcion");
    
    public static void buscar(String Pedido) {
        var response = ConsultaVentaC.buscarPedido(Pedido);
        if( !response )
            JOptionPane.showMessageDialog(null, "No se hallaron resultados en la busqueda:(");
    }
    
    private static void setDatosCliente(String nombreCliente, String rutCliente, String numeroPedido) {
        VentasC.pestanaVenta.getcVentaRut().setText(rutCliente);
        VentasC.pestanaVenta.getcVentaNombre().setText(nombreCliente);
        VentasC.pestanaVenta.getcVentaNPedido().setText(numeroPedido);
        //Reinicia parámetros
        VentasC.pestanaVenta.getcVentaCodigo().setText("");
         VentasC.pestanaVenta.cVentaFechaPago.setDate(new Date());
         VentasC.pestanaVenta.getcVentaBancoVanilla().setSelectedIndex(0);
    }
    
    public static void setDatosCliente(String codigoTransferencia, Date fechaTransferencia, String idBanco){
        String nombreBanco = getIdOf("SELECT `banco_descripcion` FROM `bancos` WHERE `banco_id` = '" + idBanco +"'", "banco_descripcion");
        
        VentasC.pestanaVenta.cVentaFechaPago.setDate(fechaTransferencia);
        VentasC.pestanaVenta.getcVentaCodigo().setText(codigoTransferencia);
        VentasC.pestanaVenta.getcVentaBancoVanilla().setSelectedItem(nombreBanco);
    }
    
    public static boolean buscarPedido(String pedido) {
        String Query = "SELECT * FROM `ventas` WHERE `venta_id` = '" + pedido + "'";
        String rutCliente = null;
        String nombreCliente;
        
        try{
            var response = queries.doQueryGet(Query);
            var datos = extraerDato(response, new String[] {"rut_cliente", "venta_codigotransferencia", "venta_fechatransferencia", "id_banco"});
            rutCliente = datos.get(0);

            if(rutCliente != null){
                response = queries.doQueryGet("SELECT `cliente_nombre`, `cliente_apellido` FROM `clientes` WHERE `RUT` = '" + rutCliente + "'");
                ArrayList<String> partesDelNombre = extraerDato(response, new String[] {"cliente_nombre", "cliente_apellido"});
                nombreCliente = partesDelNombre.get(0) + " " + partesDelNombre.get(1);

                setDatosCliente(nombreCliente, rutCliente, pedido);

                if(datos.get(1) != null){
                    String codigoTransferencia = datos.get(1);
                    Date fechaTransferencia = new Date( datos.get(2).replace("-", "/") );
                    String idBanco = datos.get(3);

                    setDatosCliente(codigoTransferencia, fechaTransferencia, idBanco);
                    VentasC.pestanaVenta.getcVentaIngresarBtn().setEnabled(false);
                } else {
                    System.out.println("Entro aqui");
                    VentasC.pestanaVenta.getcVentaIngresarBtn().setEnabled(true);
                }

                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return false;
            
    }
    
     public static String[] obtenerLista(String Query, String dataRequired) {
        ResultSet response = ConsultaVentaC.queries.doQueryGet(Query);
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
    
    
    
    private static ArrayList<String> extraerDato(ResultSet response, String[] dataRequired) {
        ArrayList<String> resultado = new ArrayList<>();
        try {
            if( response.next() ){
                for(int i = 0; i < dataRequired.length; i++){
                    resultado.add(response.getString(dataRequired[i]));
                }
                
                return resultado;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaVentaC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
     public static String getIdOf(String Query, String dataRequired) {
         var response = ConsultaVentaC.queries.doQueryGet(Query);
        try {
            if(response.next())
                return response.getString(dataRequired);
        } catch (SQLException ex) {
            Logger.getLogger(ArticulosC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
     }
    
    public static void agregarPago() {
        String numeroPedido = VentasC.pestanaVenta.getcVentaNPedido().getText();
        String fechaPago = VentasC.pestanaVenta.getcVentaFechaPago();
        String codigoPago = VentasC.pestanaVenta.getcVentaCodigo().getText();
        String idBanco = getIdOf("SELECT `banco_id` FROM `bancos` WHERE `banco_descripcion` = '" + VentasC.pestanaVenta.getcVentaBanco() + "'", "banco_id");
        
        String Query = 
                "UPDATE `ventas` SET `venta_codigotransferencia` = '" + codigoPago + "'," +
                "`venta_fechatransferencia` = '" + fechaPago + "'," +
                "`id_banco` = '" + idBanco + "' WHERE `venta_id` = '" + numeroPedido + "'";
        
        var response = queries.doQueryPost(Query);
        if(response)
            JOptionPane.showMessageDialog(null, "Pago Ingresado");
        else
            JOptionPane.showMessageDialog(null, "No se pudo ingresar el pago");
    }
    
    //Extrae los datos de una petición GET
//    private static ArrayList<String> extraerDatos(String SQL) {
//        ArrayList<String> resultado = new ArrayList<>();
//        var response = queries.doQueryGet(SQL);
//
//        try {
////            extraerRutCliente();
//
//            return resultado;
//        } catch (SQLException e) {
//            System.out.println("extraerDatos Clientes Error: " + e.getLocalizedMessage());
//        }
//        
//        return null;
//    }
}
