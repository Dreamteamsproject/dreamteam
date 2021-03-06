package modelo;

import java.sql.*;


public class Consultas {
    
    private final Conexion cc = new Conexion("jdbc:mysql://50.62.141.188/dg?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&autoReconnect=true","deamgifttest","rooot");
    private final java.sql.Connection   conexionSQL   = cc.connect();
    
    
    
    
    public Consultas(){}
    
    
    
    
    
    
    public boolean consultaBooleana(String SQL){
        boolean validacion = false;
        
        try{
            var st = conexionSQL.createStatement();
            var rs = st.executeQuery(SQL);
            validacion = rs.next();
            if(validacion){
                System.out.println("consulta confirmada");
                return true;
            }
            
        } catch(SQLException e) {
            System.out.println("error: "+ e);
        
        }
        
        return false;
    }
    
    
    
    
    
    
    // Select Queries
    public ResultSet doQueryGet(String SQL) {
        try {
            var st = conexionSQL.createStatement(); // Statement Object
            var rs = st.executeQuery(SQL); // ResultSet Object
            
            return rs;
            
        } catch (SQLException e) {
            System.out.println("Error consultas.doQueryGet: " +  e.getLocalizedMessage());
        }
        
        return null;
    }
    
    
    
    
    
    //Insert & Update Queries
    public boolean doQueryPost(String SQL) {
        try {
            var st = conexionSQL.createStatement();
                st.executeUpdate(SQL);
                
            } catch (SQLException e) {
                System.out.println("Error consultas.doQueryPost: " +  e.getLocalizedMessage());
                return false;
            }
        
        return true;
    }
    
    public ResultSet traerTodos(String tabla){
        String Query = "SELECT * FROM " + tabla;
        
        try{
            var st = conexionSQL.createStatement();
            var rs = st.executeQuery(Query);
           
            return rs;
            
        } catch (SQLException e) {
            System.out.println("Error Consultas.traerTodos: " + e.getLocalizedMessage());
        }
        
        return null;
    }
        
}