package modelo;

import java.sql.*;


public class Consultas {
    
    private final Conexion cc = new Conexion("jdbc:mysql://50.62.141.188/dg?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","deamgifttest","rooot");
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
            var statement = conexionSQL.createStatement(); // Statement Object
            var response = statement.executeQuery(SQL); // ResultSet Object
            
            return response;
            
        } catch (SQLException e) {
            System.out.println("Error: " +  e.getLocalizedMessage());
        }
        
        return null;
    }
    
    
    //Insert & Update Queries
    public boolean doQueryPost(String SQL) {
        try {
            var statement = conexionSQL.createStatement();
            statement.executeUpdate(SQL);
                
            } catch (SQLException e) {
                System.out.println("Error: " +  e.getLocalizedMessage());
                return false;
            }
     
        return true;
    }
        
}