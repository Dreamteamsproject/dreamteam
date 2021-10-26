/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import vista.mainPage;

/**
 *
 * @author Mauro
 */
public class MainPageController {
    public static mainPage paginaPrincipal = new mainPage();
    
    public static void setVisible() {
        paginaPrincipal.setVisible(true);
        paginaPrincipal.setLocationRelativeTo(null);
    }
    
    public static void abrirVentas() {
        VentasC.ventaVisible();
    }
    
    public static void abrirCompras() {
        ComprasController.compraVisible();
    }
    
    public static void abrirInformes() {
        InformesController.informesVisible();
    }
}
