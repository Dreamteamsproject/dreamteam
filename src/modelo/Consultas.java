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
            if(rs.next())
                System.out.println("consulta confirmada");
            
            
        } catch(SQLException e) {
            System.out.println("error: "+ e);
        
        }
        
        return validacion;
    }
    
    // Select Queries
    public ResultSet doQueryGet(String SQL) {
        try {
            var st = conexionSQL.createStatement(); // Statement Object
            var rs = st.executeQuery(SQL); // ResultSet Object
            
            return rs;
            
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
        }
        
        return true;
    }
        
}