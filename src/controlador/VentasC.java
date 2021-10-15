/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import vista.venta;

/**
 *
 * @author Mauro
 */
public class VentasC {
    public static venta pestanaVenta = new venta(); 
    
    public static void ventaVisible() {
        pestanaVenta.setVisible(true);
        pestanaVenta.setLocationRelativeTo(null);
    }
}
