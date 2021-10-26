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
import modelo.Consultas;

/**
 *
 * @author Mauro
 */
public class IngresoVentaC {
    
    public static void IngresoVentaC(){
    };
    
    static Consultas queries = new Consultas();
    
    public static String[] horarios = new String[] {
        "9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00"
    };
    
    public static String[] redesSociales = IngresoVentaC.obtenerLista("SELECT `rs_nombre` FROM rrss ORDER BY `rs_id`", "rs_nombre");
    public static String[] comunas = IngresoVentaC.obtenerLista("SELECT `comuna_nombre` FROM comunas ORDER BY `comuna_id`", "comuna_nombre");
    public static String[] packs = IngresoVentaC.obtenerLista("SELECT `pack_nombre` FROM packs ORDER BY `pack_id`", "pack_nombre");
    public static String[] precios = IngresoVentaC.obtenerLista("SELECT `pack_costo` FROM packs ORDER BY `pack_id`", "pack_costo");
    
    public static void buscar(String RUT) {
        var response = SAClientesC.consultarCliente(RUT);
        if(response != null)
            setDatosCliente(response);
        else
            JOptionPane.showMessageDialog(null, "No se hallaron resultados en la busqueda:(");
    }
    
    
    public static void ingresarVenta() {
        boolean respuesta = false;
        try{
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
            
            String ventaTotal = VentasC.pestanaVenta.getiVentaTotal().getText();
            String fechaVenta = formatter.format(new Date());
            String nombreDestinatario = VentasC.pestanaVenta.iVentaDestinat.getText();
            String direccionDestino = VentasC.pestanaVenta.iVentaDireccion.getText();
            String telefonoDestinatario = VentasC.pestanaVenta.iVentaTelefono.getText();
            String mailDestinatario = VentasC.pestanaVenta.iVentaCorreo.getText();
            String fechaEntrega = formatter.format( VentasC.pestanaVenta.iVentaFechaEnt.getDate() );
            String horaEntregaIni = VentasC.pestanaVenta.getiVentaHoraInicial();
            String horaEntregaFin = VentasC.pestanaVenta.getiVentaHoraFinal();
            String saludo = VentasC.pestanaVenta.iVentaSaludo.getText();
            String idRedSocial = getIdOf("SELECT `rs_id` FROM `rrss` WHERE `rs_nombre` = '" + VentasC.pestanaVenta.getiVentaRedSocial() + "'", "rs_id");
            String idComuna = getIdOf("SELECT `comuna_id` FROM `comunas` WHERE `comuna_nombre` = '" + VentasC.pestanaVenta.getiVentaComuna() + "'", "comuna_id");
            String rutCliente = VentasC.pestanaVenta.iVentaRut.getText();
            String idPack = getIdOf("SELECT `pack_id` FROM `packs` WHERE `pack_nombre` = '" + VentasC.pestanaVenta.getiVentaPacks() + "'", "pack_id");
            
            String Query = "INSERT INTO `ventas` (`venta_total`, `venta_fechaventa`, `venta_nombredestinatario`, `venta_direcciondestinatario`, `venta_telefono`, `venta_email`, `venta_fechaentrega`, `venta_horaentrega_inicial`, `venta_horaentrega_final`, `venta_saludo`, `id_redsocial`, `id_comuna`, `rut_cliente`, `id_pack`) VALUES"
                    + "( '" + ventaTotal + "','" + fechaVenta + "','" + nombreDestinatario +"','"+ direccionDestino + "','" + telefonoDestinatario + "','" + mailDestinatario + "','" + fechaEntrega + "','" + horaEntregaIni + "','" + horaEntregaFin + "','"  + saludo + "','" + idRedSocial + "','" + idComuna + "','" + rutCliente + "','" + idPack + "')";
            
            respuesta = queries.doQueryPost(Query);
            
            if(respuesta)
                JOptionPane.showMessageDialog(null, "Venta Ingresada");
            else
                JOptionPane.showMessageDialog(null, "No fue posible ingresar la venta");
            
        } catch (Error e) {
            System.out.println("Error IngresarVenta: " + e);
        }
        
        
    }
    
    private static void setDatosCliente(ArrayList<String> datos) {
        VentasC.pestanaVenta.iVentaRut.setText(datos.get(0));
        VentasC.pestanaVenta.iVentaNombre.setText(datos.get(1) + " " + datos.get(2));
        VentasC.pestanaVenta.iVentaMail.setText(datos.get(3));
        
    }
    
    // "SELECT `categoria_descripcion` FROM categorias_articulo ORDER BY `categoria_id`"
    public static String[] obtenerLista(String Query, String dataRequired) {
        ResultSet response = IngresoVentaC.queries.doQueryGet(Query);
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
    
    public static void setTotalCost(int index) {
        VentasC.pestanaVenta.getiVentaTotal().setText(precios[index]);
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
     
}
