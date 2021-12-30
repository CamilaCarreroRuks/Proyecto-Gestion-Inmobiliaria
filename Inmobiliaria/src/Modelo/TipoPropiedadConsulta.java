package Modelo;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Camila Carrero
 */
public class TipoPropiedadConsulta {
    public boolean registrar(TipoPropiedad tp) {
        boolean respuesta = true;
        String sql = "INSERT INTO tipoPropiedad (nombreTipoPropiedad) VALUES ('" + tp.getNombreTipoPropiedad() + "')";
        try {
            Consulta consulta = new Consulta();
            respuesta = consulta.InsercionBase(sql);
            JOptionPane.showMessageDialog(null, "Registro exitoso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de registro \n" + e);
        }
        return respuesta;
    }

    public boolean eliminar(TipoPropiedad tp) {
        boolean respuesta = true;
        String sql = "DELETE FROM tipoPropiedad WHERE idTipoPropiedad='" + tp.getIdTipoPropiedad() + "'";
        try {
            Consulta consulta = new Consulta();
            respuesta = consulta.EliminacionBase(sql);
            JOptionPane.showMessageDialog(null, "Eliminación exitosa");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la eliminación \n" + e);
        }
        return respuesta;
    }

    public boolean modificar(TipoPropiedad tp) {
        String sql = "UPDATE tipoPropiedad SET nombreTipoPropiedad='" + tp.getNombreTipoPropiedad() + "' WHERE idTipoPropiedad='" + tp.getIdTipoPropiedad() + "'";
        boolean respuesta = true;
        try {
            Consulta consulta = new Consulta();
            respuesta = consulta.ActualizacionBase(sql);
            JOptionPane.showMessageDialog(null, "Modificación exitosa");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de modificación \n" + e);
        }
        return respuesta;
    }
    
    public boolean tipoUsuarioExiste(TipoPropiedad tp) {
        ResultSet resultado = null;
        boolean respuesta = false;
        String sql = "SELECT * FROM tipoPropiedad WHERE nombreTipoPropiedad='" + tp.getNombreTipoPropiedad() + "'";
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

    public int obtenerId(String tipo){
        ResultSet resultado = null;
        int id = 0;
        String sql = "SELECT idTipoPropiedad FROM tipoPropiedad WHERE nombreTipoPropiedad='" + tipo + "'";
        try {
            Consulta consulta = new Consulta();
            resultado = consulta.ConsultaBase(sql);
            if (resultado.next()) {
                id = resultado.getInt(1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }
        return id;
    }
    
    public static ArrayList<String> listaTipoPropiedad() {
        ArrayList<String> lista = new ArrayList<String>();
        ResultSet resultado = null;
        String sql = "SELECT nombreTipoPropiedad FROM tipoPropiedad ORDER BY nombreTipoPropiedad";
        try {
            Consulta consulta = new Consulta();
            resultado = consulta.ConsultaBase(sql);
            ResultSetMetaData columna = resultado.getMetaData();
            int cantColumnas = columna.getColumnCount();
            while (resultado.next()) {
                Object[] filas = new Object[cantColumnas];
                for (int i = 0; i < cantColumnas; i++) {
                    filas[i] = resultado.getObject(i + 1);
                    lista.add(filas[i].toString());
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }
        return lista;
    }
}
