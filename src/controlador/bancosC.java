package controlador;

import modelo.*;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Mauro
 */

//Text field campos de banco:
//bcoDescripcion1
//bcoCodigo

//Boton agregar banco
//bcoAgregarBcoBtn

public class bancosC {
    Consultas queries = new Consultas();
    
    public boolean insertarBanco(String nombreBanco, String codigoBanco) {
        boolean response = true;
        
        try {
            String Query = 
                    "INSERT INTO `bancos` (`banco_id`, `banco_descripcion`, `banco_codigo`, `banco_estado`) VALUES (NULL,'"
                    + nombreBanco  + "','" + codigoBanco + "','1' )";
            response = this.queries.doQueryPost(Query);
        
        } catch(Exception e) {
            System.out.println("insertarBanco Error: " +  e.getMessage());
        }
        
        return response;
    }
    
    public ArrayList<String> consultarBanco(String busqueda) {
        ArrayList<String> resultado;
        String Query = "SELECT * FROM `bancos` WHERE `banco_id` = '" + busqueda + "' OR `banco_descripcion` like '%" + busqueda + "%' OR `banco_codigo` like '%" + busqueda + "%' OR `banco_estado` = '" + busqueda + "'";
        
        resultado = this.extraerDatos(Query);
        return resultado;
    }
    
    public boolean modificarBanco(String id, String bankName, String bankCode, String bankStatus) {
        boolean response = true;
        
         try {
            String Query = 
                    "UPDATE `bancos` SET `banco_descripcion` = '" + bankName +
                    "',banco_codigo = '" + bankCode +
                    "',banco_estado = '" + bankStatus + "' WHERE `banco_id` = '" + id + "'"; 
            response = this.queries.doQueryPost(Query);
        
        } catch(Exception e) {
            System.out.println("bankInsert Error: " +  e.getMessage());
        }
        
        return response;
    }
    
    private ArrayList<String> extraerDatos(String SQL) {
        ArrayList<String> resultado = new ArrayList<>();
        ResultSet response = queries.doQueryGet(SQL);

        try {
            for (boolean hayMasDatos = response.next(); hayMasDatos; hayMasDatos = response.next()) {
                resultado.add(response.getString("banco_id"));
                resultado.add(response.getString("banco_descripcion"));
                resultado.add(response.getString("banco_codigo"));
                resultado.add(response.getString("banco_estado"));
            }

            return resultado;
        } catch (SQLException e) {
            System.out.println("consultarBanco Error: " + e.getLocalizedMessage());
        }
        
        return null;
    }
}
