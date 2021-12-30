package Modelo;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Camila Carrero
 */
public class TipoContabilidadConsulta {
    public boolean registrar(TipoContabilidad tc) {
        boolean respuesta = true;
        String sql = "INSERT INTO tipoContabilidad (nombreTipoContabilidad) VALUES ('" + tc.getNombreTipoContabilidad() + "')";
        try {
            Consulta consulta = new Consulta();
            respuesta = consulta.InsercionBase(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de registro \n" + e);
        }
        return respuesta;
    }

    public boolean eliminar(TipoContabilidad tc) {
        boolean respuesta = true;
        String sql = "DELETE FROM tipoContabilidad WHERE nombreTipoContabilidad='" + tc.getNombreTipoContabilidad() + "'";
        try {
            Consulta consulta = new Consulta();
            respuesta = consulta.EliminacionBase(sql);       
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la eliminación \n");
        }
        return respuesta;
    }

    public boolean modificar(TipoContabilidad tc) {
        String sql = "UPDATE tipoContabilidad SET nombreTipoContabilidad='" + tc.getNombreTipoContabilidad() + "' WHERE idTipoContabilidad = '" + tc.getIdTipoContabilidad() + "' ";
        boolean respuesta = true;
        try {
            Consulta consulta = new Consulta();
            respuesta = consulta.ActualizacionBase(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de modificación \n" + e);
        }
        return respuesta;
    }
    
    public int obtenerId(String ntc) {
        String sql = "SELECT idTipoContabilidad FROM tipoContabilidad WHERE nombreTipoContabilidad='" + ntc + "'";
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
    
    public static ArrayList<String> listaTipoContabilidad() {
        ArrayList<String> lista = new ArrayList<String>();
        ResultSet resultado = null;
        String sql = "SELECT nombreTipoContabilidad FROM tipoContabilidad";
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
