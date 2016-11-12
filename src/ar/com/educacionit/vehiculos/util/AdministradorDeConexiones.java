/*
 * AdministradorDeConexiones.java
 *
 *
 */

package ar.com.educacionit.vehiculos.util;

import java.sql.Connection;
import java.sql.DriverManager;


public abstract class AdministradorDeConexiones {
    
    /**
     * Creates a new instance of AdministradorDeConexiones
     */
    public AdministradorDeConexiones() {
    }

    public static Connection getConnection() throws Exception
    {

        // Establece el nombre del driver a utilizar
        String dbDriver = "org.hsqldb.jdbc.JDBCDriver";
        
        // Establece la conexion a utilizar contra la base de datos
        String dbConnString = "jdbc:hsqldb:hsql://localhost/eit";
        
        // Establece el usuario de la base de datos
        String dbUser = "SA";
        
        // Establece la contrase�a de la base de datos
        String dbPassword = "";
        
        // Establece el driver de conexion
        Class.forName(dbDriver).newInstance();
        
        // Retorna la conexion
        return DriverManager.getConnection(dbConnString, dbUser, dbPassword);
    }    
    
}
