package controlador;

import vista.SuperAdm;


public class SuperAdmC {
    
    static SuperAdm superAdm = new SuperAdm();
    
    public static void SAVisible(){
        superAdm.setVisible(true);
    }
    
    public static void desplegarInfo(int pestaña) {
        if( pestaña == 1 )
            bancosC.buscar("1");
        else if( pestaña == 2 )
            RedesC.buscar("1");
        else if( pestaña == 4 )
            CatArtC.buscar("1");
        else if(pestaña == 7)
            SAUsuariosC.RellenarUsuario();
        else if(pestaña == 3)
            ArticulosC.buscar("1");
        else if(pestaña == 0){
            if(ComunasC.consultasRealizadas != 0)
                ComunasC.buscar("1");
        }
    }
}
