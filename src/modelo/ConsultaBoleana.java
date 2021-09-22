package modelo;

import java.sql.SQLException;


public class ConsultaBoleana {
    
    private final Conexion cc = new Conexion("jdbc:mysql://50.62.141.188/dg?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","deamgifttest","rooot");
    private final java.sql.Connection   conexionSQL   = cc.connect();
    
    public ConsultaBoleana(){}
    
    public boolean consultas(String SQL){
        
        boolean validacion = false;
        
     try{
            
            var st = conexionSQL.createStatement();
            var rs = st.executeQuery(SQL);
            validacion = rs.next();
            if(rs.next()){System.out.println("consulta confirmada");}
            
            
        }catch(SQLException e){
            System.out.println("error: "+ e);
        
        }
        
    return validacion;
    }
        
    }