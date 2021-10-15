package controlador;

import vista.SuperAdm;


public class SuperAdmC {
    
    static SuperAdm superAdm = new SuperAdm();
    
    public static void SAVisible(){
        superAdm.setVisible(true);
        superAdm.setLocationRelativeTo(null);   
    }
    
    public static void desplegarInfo(int pestaña) {
        switch (pestaña) {
            case 0 -> {if(ComunasC.consultasRealizadas != 0) ComunasC.buscar("1");}
            case 1 -> bancosC.buscar("1");
            case 2 -> RedesC.buscar("1");
            case 3 -> ArticulosC.buscar("1");
            case 4 -> CatArtC.buscar("1");
            case 5 -> ProveedoresC.buscar();
            case 6 -> SAUsuariosC.RellenarUsuario();
            case 7 -> SAClientesC.RellenarCliente();
            case 9 -> EstadosVentaC.buscar("1");
            default -> {}
        }
    }
}