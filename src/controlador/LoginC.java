package controlador;
import javax.swing.JOptionPane;
import modelo.ConsultaBoleana;
import vista.Login;
/*------------*/

public  class LoginC {
    
    public static Login login = new Login();
    public static ConsultaBoleana consulta = new ConsultaBoleana();
    
    
    public static void LoginVisible(){
        login.setVisible(true);
    }
    public static void LoginNoVisible(){
        login.setVisible(false);
    }
    
    
    public static void ConsultarUsuario(){
    
        String usuario = login.getLoginUsuario().getText();
        String password = login.getLoginPassword().getText();
        var SQL = "SELECT usuario_nombre, usuario_clave from usuarios where(usuario_nombre='"+usuario+"' && usuario_clave='"+password+"')";
        
        if(consulta.consultas(SQL)){JOptionPane.showMessageDialog(null, "Bienvenido "+usuario);
                                    login.dispose();
                                    DreamGiftC dreamgift = new DreamGiftC();
                                    dreamgift.DreamGiftVisible();}
        else{JOptionPane.showMessageDialog(null, "La contraseña que ingresaste es incorrecta");}
        
       login.setLoginUsuarioSetText("Ingresar Usuario");
       login.setLoginPasswordSetText("IngresarContraseña");
        
        
    
    }
}

