package Modelo;

import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import Vista.PanelTipoCliente;

/**
 *
 * @author Camila Carrero
 */
public class TipoClienteConsulta {

    public boolean registrar(TipoCliente tcli) {
        boolean respuesta = true;
        String sql = "INSERT INTO tipoCliente (nombreTipoCliente) VALUES ('" + tcli.getNombreTipoCliente() + "')";
        try {
            Consulta consulta = new Consulta();
            respuesta = consulta.InsercionBase(sql);
            JOptionPane.showMessageDialog(null, "Registro exitoso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de registro \n" + e);
        }
        return respuesta;
    }

    public boolean eliminar(TipoCliente tcli) {
        boolean respuesta = true;
        String sql = "DELETE FROM tipoCliente WHERE nombreTipoCliente='" + tcli.getNombreTipoCliente() + "'";
        try {
            Consulta consulta = new Consulta();
            respuesta = consulta.EliminacionBase(sql);          
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la eliminación \n");
        }
        return respuesta;
    }

    public boolean modificar(TipoCliente tcli) {
        String sql = "UPDATE tipoCliente SET nombreTipoCliente='" + tcli.getNombreTipoCliente() + "' WHERE idTipoCliente = '" + tcli.getIdTipoCliente() + "' ";
        boolean respuesta = true;
        try {
            Consulta consulta = new Consulta();
            respuesta = consulta.ActualizacionBase(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de modificación \n" + e);
        }
        return respuesta;
    }

    public static ArrayList<String> listaTipoCliente() {
        ArrayList<String> lista = new ArrayList<String>();
        ResultSet resultado = null;
        String sql = "SELECT nombreTipoCliente FROM tipoCliente";
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

    public boolean tipoClienteExiste(TipoCliente tc) {
        boolean respuesta = false;
        String sql = "SELECT * FROM tipoCliente WHERE nombreTipoCliente='" + tc.getNombreTipoCliente() + "'";
        ResultSet resultado = null;
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

    public int obtenerId(String ntc) {
        String sql = "SELECT idTipoCliente FROM tipoCliente WHERE nombreTipoCliente='" + ntc + "'";
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
    
    public TableModel buscarTipoCliente() {
        DefaultTableModel modelo = new DefaultTableModel() {
            public boolean isCellEditable(int columnas, int filas) {
                return false;
            }
        };
        String sql = "";
        if (PanelTipoCliente.filtro.getSelectedItem() == "Nombre de Tipo de Usuario") {
            sql = "SELECT idTipoCliente,nombreTipoCliente FROM tipoCliente  WHERE nombreTipoCliente LIKE '%" + PanelTipoCliente.tBuscar.getText() + "%'";
        }  else {
                if (PanelTipoCliente.filtro.getSelectedItem() == "Todos") {
                    sql = "SELECT idTipoCliente,nombreTipoCliente FROM tipoCliente";
                }
            }       
        try {
            Consulta consulta = new Consulta();
            ResultSet resultado = consulta.ConsultaBase(sql);
            ResultSetMetaData columna = resultado.getMetaData();
            int cantColumnas = columna.getColumnCount();
            modelo.addColumn("Id");
            modelo.addColumn("Nombre");           
            while (resultado.next()) {
                Object[] filas = new Object[cantColumnas];
                for (int i = 0; i < cantColumnas; i++) {
                    filas[i] = resultado.getObject(i + 1);
                }
                modelo.addRow(filas);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en buscar tipo de cliente \n" + e);
        }
        return modelo;
    }       
}
