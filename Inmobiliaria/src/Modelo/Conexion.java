package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Camila Carrero
 */
public class Conexion {

    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3305/inmobiliaria?serverTimezone=UTC";
    private String user = "root";
    private String password = "admin";
    public Connection con = null;

    public Connection conexion() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            if (con != null) {
                System.out.println("Conexión establecida.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: no se pudo conectar a la base de datos: " + e);
        }
        return con;
    }
}
