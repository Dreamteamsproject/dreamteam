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
        String SQL;
        String consultaInicio = "SELECT banco_id, banco_descripcion, banco_codigo, banco_estado FROM bancos ";

        String[] posiblesRespuestas = { "WHERE banco_descripcion = " + busqueda, "WHERE banco_codigo = " + busqueda,
                "WHERE banco_estado = " + busqueda, "WHERE banco_id = " + busqueda };

        for (int i = 0; i < 4; i++) {
            SQL = consultaInicio + posiblesRespuestas[i];
            boolean existeDato = queries.consultaBooleana(SQL);

            if (existeDato) {
                resultado = this.extraerDatos(SQL);
                return resultado;
            }
        }

        return null;
    }
    
    public boolean modificarBanco(int id, String descripcion, String codigo, int estado) {
        String SQL = 
                "UPDATE bancos SET banco_descripcion = " + descripcion + ", banco_codigo = " + codigo
                        + ", banco_estado = " + estado;

        
        return true;
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
