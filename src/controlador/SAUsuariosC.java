package controlador;

import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import modelo.Consultas;
import vista.SuperAdm;


public class SAUsuariosC {
   
    static Consultas consultaSQL = new Consultas();
    static DefaultListModel modelUser = new DefaultListModel();
    
    
    public static void IniciarClase(){}
    
    public static void AgregarUsuario(){
        
        
        if(!SuperAdmC.superAdm.getSAUsuarioNuevoGetText().equals("Añadir un usuario") && !SuperAdmC.superAdm.getSAContraseñaNuevaGetText().equals("Añadirunpass")){
        var usuario     = SuperAdmC.superAdm.getSAUsuarioNuevoGetText();
        var contraseña  = SuperAdmC.superAdm.getSAContraseñaNuevaGetText();
        String SQL = "insert into usuarios (usuario_nombre,usuario_clave)VALUES('"+usuario+"','"+contraseña+"');";
        //insert into usuarios (usuario_nombre,usuario_clave) VALUES('asdad','asdasd')
        if(consultaSQL.doQueryPost(SQL)){JOptionPane.showMessageDialog(null, "Usuario "+usuario+ " añadido a la base de datos");}
                                         SuperAdmC.superAdm.setSAUsuarioNuevosSetText("Añadir un usuario");
                                         SuperAdmC.superAdm.setSAContraseñaNuevaSetText("Añadirunpass");
                                         SuperAdmC.superAdm.setSAUsuarioNuevosSetColor(Color.gray);
                                         SuperAdmC.superAdm.setSAContraseñaNuevaSetColor(Color.gray);
        
                }
        else{
            SuperAdmC.superAdm.setSAUsuarioNuevosSetText("Añadir un usuario");
            SuperAdmC.superAdm.setSAContraseñaNuevaSetText("Añadirunpass");
            SuperAdmC.superAdm.setSAUsuarioNuevosSetColor(Color.gray);
            SuperAdmC.superAdm.setSAContraseñaNuevaSetColor(Color.gray);
            JOptionPane.showMessageDialog(null, "Ingresa un usuario y contraseña validos");
        }
    }
    
    public static void RellenarUsuario(){
        
        
        if(SuperAdmC.superAdm.usuarioBuscarUser.getText().equals("")){
        try{
            modelUser.removeAllElements();
            var usuariosLista = consultaSQL.doQueryGet("select usuario_nombre from usuarios where usuario_nombre  like '%%'");
            while(usuariosLista.next()){
            modelUser.addElement(usuariosLista.getString("usuario_nombre"));
            }
            SuperAdmC.superAdm.usuarioLista.setModel(modelUser);}
        catch (SQLException ex) {
            Logger.getLogger(SuperAdm.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
    
    public static void FiltrarUsuarios(){
        
            
            try{
            
                modelUser.removeAllElements();
                var usuariosLista = consultaSQL.doQueryGet("select usuario_nombre from usuarios where usuario_nombre  like '%"+SuperAdmC.superAdm.usuarioBuscarUser.getText()+"%'");
                while(usuariosLista.next()){
                modelUser.addElement(usuariosLista.getString("usuario_nombre"));
                }
                SuperAdmC.superAdm.usuarioLista.setModel(modelUser);}
            catch (SQLException ex) {
            Logger.getLogger(SuperAdm.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    
    }
    
     public static void CheckUserText(){
    
        if(SuperAdmC.superAdm.getSAUsuarioNuevoGetText().equals("Añadir un usuario")){SuperAdmC.superAdm.setSAUsuarioNuevosSetText("");SuperAdmC.superAdm.setSAUsuarioNuevosSetColor(Color.black);}
        
    }
     
    public static void CheckUserTextVacio(){
    
        if(SuperAdmC.superAdm.getSAUsuarioNuevoGetText().equals("")){SuperAdmC.superAdm.setSAUsuarioNuevosSetText("Añadir un usuario");SuperAdmC.superAdm.setSAUsuarioNuevosSetColor(Color.gray);}
        
    }
    
     public static void CheckpassText(){
    
        if(SuperAdmC.superAdm.getSAContraseñaNuevaGetText().equals("Añadirunpass")){SuperAdmC.superAdm.setSAContraseñaNuevaSetText("");SuperAdmC.superAdm.setSAContraseñaNuevaSetColor(Color.black);}
        
    }
     
    public static void CheckpassTextVacio(){
    
        if(SuperAdmC.superAdm.getSAContraseñaNuevaGetText().equals("")){SuperAdmC.superAdm.setSAContraseñaNuevaSetText("Añadirunpass");SuperAdmC.superAdm.setSAContraseñaNuevaSetColor(Color.gray);}
        
    }
}
