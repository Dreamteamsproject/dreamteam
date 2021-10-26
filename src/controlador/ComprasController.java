/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import vista.compras;

/**
 *
 * @author Mauro
 */
public class ComprasController {
    public static compras pestanaCompras = new compras(); 
    
    public static void compraVisible() {
        pestanaCompras.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pestanaCompras.setVisible(true);
        pestanaCompras.setLocationRelativeTo(null);
    }
}
