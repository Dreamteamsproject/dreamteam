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
public class InformesVentasC {
    private static Consultas queries = new Consultas();
    
    
    public static void buscar() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        
        String fechaInicial = formatter.format(InformesController.pestanaInformes.getInfVenFechaI().getDate());
        String fechaFinal = formatter.format(InformesController.pestanaInformes.getInfVenFechaF().getDate());
        String RUT = InformesController.pestanaInformes.getInfVenRUT().getText();
        System.out.println("Está vacio RUT: " + RUT);
        
        String Query = "SELECT * FROM `ventas` WHERE ((`venta_fechaventa` >=  '" + fechaInicial + "' AND `venta_fechaventa` <= '"+ fechaFinal + "') OR (`venta_fechaentrega` >=  '" + fechaInicial + "' AND `venta_fechaentrega` <= '" + fechaFinal + "'))";
            
        if(!"".equals(RUT))
            Query = Query + " AND `rut_cliente` = '" + RUT + "'";
        
        System.out.println(Query);
        
        var data = extraerDatos(Query);
        insertarDatosTabla(data);
    }
    
    public static void buscarTodos() {
        String Query = "SELECT * FROM `ventas`";
        var data = extraerDatos(Query);
        insertarDatosTabla(data);
    }
    
    private static ArrayList<String> extraerDatos(String SQL) {
        ArrayList<String> resultado = new ArrayList<>();
        ResultSet response = queries.doQueryGet(SQL);
        int numeroDeResultados = 0;

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
                numeroDeResultados++;
            }
            System.out.println(numeroDeResultados);
            
            return resultado;
        } catch (SQLException e) {
            System.out.println("ConsultaVentas InformesVentas Error: " + e.getLocalizedMessage());
        }
        
        return null;
    }
    
     private static void insertarDatosTabla(ArrayList<String> datos) {
         var table = InformesController.pestanaInformes.getInformesVentasTabla();
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
                String redSocial = getIdOf("SELECT `rs_nombre` FROM `rrss` WHERE `rs_id` = '" + datos.get( n + 13) + "'", "rs_nombre");
                String comuna = getIdOf("SELECT `comuna_nombre` FROM `comunas` WHERE `comuna_id` = '" + datos.get( n + 14) + "'", "comuna_nombre");
                String banco = getIdOf("SELECT `banco_descripcion` FROM `bancos` WHERE `banco_id` = '" + datos.get( n + 15) + "'", "banco_descripcion");
                String pack = getIdOf("SELECT `pack_nombre` FROM `packs` WHERE `pack_id` = '" + datos.get( n + 18) + "'", "pack_nombre");
                
                model.addRow(new Object[] { datos.get( n ), datos.get( n + 1 ), datos.get( n + 2 ), datos.get( n + 3 ), datos.get( n + 4 ), datos.get( n + 5 ), datos.get( n + 6 ), datos.get( n + 7 ), datos.get( n + 8 ), datos.get( n + 9 ), datos.get( n + 10 ), datos.get( n + 11 ),
                datos.get( n + 12 ), redSocial, comuna, banco, datos.get( n + 16 ), estado, pack} );
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
}
