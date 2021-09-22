package modelo;
import java.sql.*;

public class Conexion {
    
    //variables requeridas para conectar con mysql
    final String url, user, password;
    Connection com = null;
    //"jdbc:mysql://localhost/"nombrebase"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"

    
    //constructor
    public Conexion(String url,String user, String password){
    
        this.url = url;
        this.user = user;
        this.password = password;        
    }
    
    
    public java.sql.Connection connect(){
       
            try{
                
                com = (java.sql.Connection) DriverManager.getConnection(url,user,password);
                //if(com != null){System.out.println("conexion lograda con exito " + com);}
                
                
            }
            catch(SQLException e){
            System.out.println("Error: " + e.getLocalizedMessage());
            }

           return com;
        }

    
    
   }

