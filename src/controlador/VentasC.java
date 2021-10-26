/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import vista.venta;

/**
 *
 * @author Mauro
 */
public class VentasC {
    public static venta pestanaVenta = new venta(); 
    
    public static void ventaVisible() {
        pestanaVenta.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pestanaVenta.setVisible(true);
        pestanaVenta.setLocationRelativeTo(null);
    }
    
    public static void desplegarInfo(int pestana) {
        switch(pestana) {
            case 1 -> ConsultaVentaC.buscarTodos();
            case 2 -> EstadoDespachoC.buscarTodos();
            case 3 -> EstadoDespachoC.buscarTodos();
        }
    }
}
