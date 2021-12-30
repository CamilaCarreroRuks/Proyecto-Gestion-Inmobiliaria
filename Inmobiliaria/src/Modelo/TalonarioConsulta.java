package Modelo;

import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Camila Carrero
 */
public class TalonarioConsulta {

    public boolean registrar(Talonario t) {
        boolean respuesta = true;
        String sql = "INSERT INTO talonario (nombreTAlonario, idTipoComprobante, vigente, nComprobanteActual, nComprobanteTotal) VALUES ('" + t.getNombreTalonario() + "', '" + t.getIdTipoComprobante() + "', '" + t.getVigente() + "', '" + t.getnComprobanteActual() + "', '" + t.getnComprobanteTotal() + "')";
        try {
            Consulta consulta = new Consulta();
            respuesta = consulta.InsercionBase(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de registro \n" + e);
        }
        return respuesta;
    }

    public boolean modificar(Talonario t) {
        String sql = "UPDATE talonario SET nombreTalonario= '" + t.getNombreTalonario() + "', idTipoComprobante= '" + t.getIdTipoComprobante() + "', vigente= '" + t.getVigente() + "', nComprobanteActual= '" + t.getnComprobanteActual() + "', nComprobanteTotal= '" + t.getnComprobanteTotal() + "' WHERE idTalonario= '" + t.getIdTalonario() + "'";
        boolean respuesta = true;
        try {
            Consulta consulta = new Consulta();
            respuesta = consulta.ActualizacionBase(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de modificación \n" + e);
        }
        return respuesta;
    }

    public boolean modificarNComprobanteActual(Talonario t) {
        String sql = "UPDATE talonario SET nComprobanteActual= '" + t.getnComprobanteActual() + "' WHERE idTalonario= '" + t.getIdTalonario() + "'";
        boolean respuesta = true;
        try {
            Consulta consulta = new Consulta();
            respuesta = consulta.ActualizacionBase(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de modificación \n" + e);
        }
        return respuesta;
    }

    public boolean eliminar(Talonario t) {
        boolean respuesta = true;
        String sql = "DELETE FROM talonario WHERE idtalonario='" + t.getIdTalonario() + "'";
        try {
            Consulta consulta = new Consulta();
            respuesta = consulta.EliminacionBase(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la eliminación \n" + e);
        }
        return respuesta;
    }

    public int obtenerId(Talonario t) {
        String sql = "SELECT idTalonario FROM talonario WHERE idTipoComprobante= '" + t.getIdTipoComprobante() + "' AND vigente= '" + 1 + "'";
        ResultSet resultado = null;
        int u = 0;
        try {
            Consulta consulta = new Consulta();
            resultado = consulta.ConsultaBase(sql);
            while (resultado.next()) {
                u = resultado.getInt(1);
            }
            return u;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }
        return u;
    }

    public int obtenerNComprbanteActual(Talonario t) {
        String sql = "SELECT nComprobanteActual FROM talonario WHERE idTalonario= '" + t.getIdTalonario() + "' AND vigente= '" + 1 + "'";
        ResultSet resultado = null;
        int u = 0;
        try {
            Consulta consulta = new Consulta();
            resultado = consulta.ConsultaBase(sql);
            while (resultado.next()) {
                u = resultado.getInt(1);
            }
            return u;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }
        return u;
    }
}
