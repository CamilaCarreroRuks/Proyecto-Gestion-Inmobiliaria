package Modelo;

import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Camila Carrero
 */
public class OperacionConsulta {
    public boolean registrar(Operacion op) {
        boolean respuesta = true;
        String sql = "INSERT INTO operacion (nombreOperacion) VALUES ('" + op.getNombreOperacion() + "')";
        try {
            Consulta consulta = new Consulta();
            respuesta = consulta.InsercionBase(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de registro \n" + e);
        }
        return respuesta;
    }

    public boolean eliminar(Operacion op) {
        boolean respuesta = true;
        String sql = "DELETE FROM operacion WHERE idOperacion='" + op.getIdOperacion() + "'";
        try {
            Consulta consulta = new Consulta();
            respuesta = consulta.EliminacionBase(sql);
            JOptionPane.showMessageDialog(null, "Eliminación exitosa");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la eliminación \n" + e);
        }
        return respuesta;
    }

    public boolean modificar(Operacion op) {
        String sql = "UPDATE operacion SET nombreOperacion='" + op.getNombreOperacion() + "' WHERE idOperacion='" + op.getIdOperacion() + "'";
        boolean respuesta = true;
        try {
            Consulta consulta = new Consulta();
            respuesta = consulta.ActualizacionBase(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de modificación \n" + e);
        }
        return respuesta;
    }
    
    public boolean tipoUsuarioExiste(Operacion op) {
        ResultSet resultado = null;
        boolean respuesta = false;
        String sql = "SELECT * FROM operacion WHERE nombreOperacion='" + op.getNombreOperacion() + "'";
        try {
            Consulta consulta = new Consulta();
            resultado = consulta.ConsultaBase(sql);
            if (resultado.next()) {
                respuesta = true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }
        return respuesta;
    }

}
