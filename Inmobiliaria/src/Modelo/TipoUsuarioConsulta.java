package Modelo;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import Vista.PanelTipoUsuario;

/**
 *
 * @author Camila Carrero
 */
public class TipoUsuarioConsulta {

    public boolean registrar(TipoUsuario tu) {
        boolean respuesta = true;
        String sql = "INSERT INTO tipoUsuario (nombreTipoUsuario) VALUES ('" + tu.getNombreTipoUsuario() + "')";
        try {
            Consulta consulta = new Consulta();
            respuesta = consulta.InsercionBase(sql);
            JOptionPane.showMessageDialog(null, "Registro exitoso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de registro \n" + e);
        }
        return respuesta;
    }

    public boolean eliminar(TipoUsuario tu) {
        boolean respuesta = true;
        String sql = "DELETE FROM tipoUsuario WHERE idTipoUsuario='" + tu.getIdTipoUsuario() + "'";
        try {
            Consulta consulta = new Consulta();
            respuesta = consulta.EliminacionBase(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la eliminación \n" + e);
        }
        return respuesta;
    }

    public boolean modificar(TipoUsuario tu) {
        String sql = "UPDATE tipoUsuario SET nombreTipoUsuario='" + tu.getNombreTipoUsuario() + "' WHERE idTipoUsuario='" + tu.getIdTipoUsuario() + "'";
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
    
    public boolean tipoUsuarioExiste(TipoUsuario tu) {
        ResultSet resultado = null;
        boolean respuesta = false;
        String sql = "SELECT * FROM tipoUsuario WHERE nombreTipoUsuario='" + tu.getNombreTipoUsuario() + "'";
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
        String sql = "SELECT idTipoUsuario FROM tipoUsuario WHERE nombreTipoUsuario='" + tipo + "'";
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
    
    public TableModel buscarTipoUsuario() {
        DefaultTableModel modelo = new DefaultTableModel() {
            public boolean isCellEditable(int columnas, int filas) {
                return false;
            }
        };
        String sql = "";
        if (PanelTipoUsuario.filtro.getSelectedItem() == "Nombre de Tipo de Usuario") {
            sql = "SELECT idTipoUsuario,nombreTipoUsuario FROM tipoUsuario  WHERE nombreTipoUsuario LIKE '%" + PanelTipoUsuario.tBuscar.getText() + "%'";
        }  else {
                if (PanelTipoUsuario.filtro.getSelectedItem() == "Todos") {
                    sql = "SELECT idTipoUsuario,nombreTipoUsuario FROM tipoUsuario";
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
            JOptionPane.showMessageDialog(null, "Error en buscar tipo de usuario \n" + e);
        }
        return modelo;
    }
    
    
    public static ArrayList<String> listaTipoUsuario() {
        ArrayList<String> lista = new ArrayList<String>();
        ResultSet resultado = null;
        String sql = "SELECT nombreTipoUsuario FROM tipoUsuario";
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
