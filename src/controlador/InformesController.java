/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import vista.Informes;

/**
 *
 * @author Mauro
 */
public class InformesController {
    public static Informes pestanaInformes = new Informes(); 
    
    public static void InformesController(){}
    
    public static void informesVisible() {
        System.out.println("Infomres abierto InformesController");
        pestanaInformes.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pestanaInformes.setVisible(true);
        pestanaInformes.setLocationRelativeTo(null);
    }
    
    public static void activarTabla(int index) {
        if(index == 0)
            InformesVentasC.buscarTodos();
        else if(index == 1)
            InformeInventarioC.buscarTodo();
    }
}
