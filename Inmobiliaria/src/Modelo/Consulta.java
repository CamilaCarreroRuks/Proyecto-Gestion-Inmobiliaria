package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Camila Carrero
 */
public class Consulta {

    Conexion con = new Conexion();
    Connection co = con.conexion();
    PreparedStatement pst;
    Statement st;
    ResultSet rs;

    public ResultSet ConsultaBase(String sql) {
        ResultSet resultado = null;
        try {
            st = co.createStatement();
            resultado = st.executeQuery(sql);
            return resultado;
           
        } catch (SQLException ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR EN CLASE SQLOPERACIONES");       
        }
        return resultado;
    }

    public boolean InsercionBase(String sql) {
        boolean respuesta = false;
        int UNIQUE_CONSTRAINT_VIOLATED = 1062;
        try {
            st = co.createStatement();
            st.execute(sql);
            respuesta = true;
        } catch (SQLIntegrityConstraintViolationException ex) {
            if (UNIQUE_CONSTRAINT_VIOLATED == ex.getErrorCode()) {
                String msg = "El registro ya se encuentra en la base de datos";
                JOptionPane.showMessageDialog(null, msg);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (co != null) {
                    co.close();
                }
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
        return respuesta;
    }

    public boolean ActualizacionBase(String sql) {
        boolean respuesta = false;
        try {
            pst = co.prepareStatement(sql);
            pst.executeUpdate();
            respuesta = true;
        } catch (SQLException ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (co != null) {
                    co.close();
                }
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
        return respuesta;
    }

    public boolean EliminacionBase(String sql) {
        boolean respuesta = false;
        try {
            st = co.createStatement();
            st.execute(sql);
            respuesta = true;
             } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "No puede eliminarse.\nEl mismo está siendo utilizado.");
        } catch (SQLException ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (co != null) {
                    co.close();
                }
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
        return respuesta;
    }
}
