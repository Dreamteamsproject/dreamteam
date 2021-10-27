package controlador;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import modelo.Consultas;
import vista.Login;
/*------------*/

public  class LoginC {
    
    public static Login login = new Login();
    public static Consultas consulta = new Consultas();
    
    
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
        
        if(consulta.consultaBooleana(SQL)){
            JOptionPane.showMessageDialog(null, "Bienvenido "+usuario);
            login.dispose();
            
            if("admin".equals(usuario))
                SuperAdmC.SAVisible();
            else
                MainPageController.setVisible();
            
        } else {
            JOptionPane.showMessageDialog(null, "La contraseña que ingresaste es incorrecta");
            login.setLoginUsuarioSetText("Ingresar Usuario");
            login.setLoginUsuarioSetTextSetColor(Color.gray);
            login.setLoginPasswordSetText("IngresarContraseña");
            login.setLoginPasswordSetTextSetColor(Color.gray);
        }
        
    }
    
    
    public static void IngresarAdm(String clave){
        
        var SQL = "SELECT usuario_nombre, usuario_clave from usuarios where(usuario_nombre='admin' && usuario_clave='"+clave+"')";
        
         if(consulta.consultaBooleana(SQL)){
             SuperAdmC.SAVisible();
             MainPageController.pass.dispose();
         }
         else{JOptionPane.showMessageDialog(null, "contraseña invalida");}
    
    }
    
    
    public static void CheckKeyPress(java.awt.event.KeyEvent evt){
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){ConsultarUsuario();}
    }
    
    
    
    public static void CheckPasswordText(){
    
        if(login.getLoginPassword().getText().equals("IngresarContraseña")){login.setLoginPasswordSetText("");login.setLoginPasswordSetTextSetColor(Color.black);}
        
    }
   
    
    
     public static void CheckPasswordTextVacio(){
    
        if(login.getLoginPassword().getText().equals("")){login.setLoginPasswordSetText("IngresarContraseña");login.setLoginPasswordSetTextSetColor(Color.gray);}
        
    }
    
     
     
    public static void CheckUserText(){
    
        if(login.getLoginUsuario().getText().equals("Ingresar Usuario")){login.setLoginUsuarioSetText("");login.setLoginUsuarioSetTextSetColor(Color.black);}
        
    }
    
    
    
    public static void CheckUserTextVacio(){
    
        if(login.getLoginUsuario().getText().equals("")){login.setLoginUsuarioSetText("Ingresar Usuario");login.setLoginUsuarioSetTextSetColor(Color.gray);}
    }
    
    
    
    public static void Salir(){
        System.exit(0);
    }
    
   
}

