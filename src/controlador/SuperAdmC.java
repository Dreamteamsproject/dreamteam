package controlador;

import vista.SuperAdm;


public class SuperAdmC {
    
    static SuperAdm superAdm = new SuperAdm();
    
    public static void SAVisible(){
        superAdm.setVisible(true);
    }
    
    public static void desplegarInfo(int pestaña) {
//        if( pestaña == 0 )
//            ComunasC.buscar("1");
        if( pestaña == 1 )
            bancosC.buscar("1");
        else if( pestaña == 2 )
            RedesC.buscar("1");
    }
}
