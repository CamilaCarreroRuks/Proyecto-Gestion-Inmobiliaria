package Modelo;

import Vista.FormReportes;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import Vista.PanelUsuario;

/**
 *
 * @author Camila Carrero
 */
public class UsuarioConsulta {

    public boolean registrar(Usuario usu) {
        boolean respuesta = true;
        String sql = "INSERT INTO usuario (nombreUsuario,contraseña,idTipoUsuario) VALUES ('" + usu.getNombreUsuario() + "','" + usu.getContraseña() + "','" + usu.getIdTipoUsuario() + "')";
        try {
            Consulta consulta = new Consulta();
            respuesta = consulta.InsercionBase(sql);
            JOptionPane.showMessageDialog(null, "Registro exitoso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de registro \n" + e);
        }
        return respuesta;
    }

    public boolean login(Usuario usu) {
        boolean respuesta = false;
        String sql = "SELECT * FROM usuario WHERE nombreUsuario= '" + usu.getNombreUsuario() + "' AND contraseña= '" + usu.getContraseña() + "'";
        try {
            Consulta consulta = new Consulta();
            ResultSet resultado = consulta.ConsultaBase(sql);
            if (resultado.next()) {
                respuesta = true;
            } else if (usuarioExiste(usu)) {
                JOptionPane.showMessageDialog(null, "Error de acceso.\nContraseña incorrecta");
            } else {
                JOptionPane.showMessageDialog(null, "Error de acceso.\nUsuario no registrado");
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
            respuesta = false;
        }
        return respuesta;
    }

    public boolean usuarioExiste(Usuario usu) {
        ResultSet resultado = null;
        boolean respuesta = false;
        String sql = "SELECT * FROM usuario WHERE nombreUsuario='" + usu.getNombreUsuario() + "'";
        try {
            Consulta consulta = new Consulta();
            resultado = consulta.ConsultaBase(sql);
            if (resultado.next()) {
                respuesta = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }
        return respuesta;
    }

    public boolean eliminar(Usuario usu) {
        boolean respuesta = false;
        String sql = "DELETE FROM usuario WHERE nombreUsuario='" + usu.getNombreUsuario() + "'";
        try {
            Consulta consulta = new Consulta();
            consulta.EliminacionBase(sql);
            respuesta = true;
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error en la eliminación \n" + e);
            respuesta = false;
        }
        return respuesta;
    }

    public boolean modificar(Usuario usu) {
        String sql = "UPDATE usuario SET nombreUsuario='" + usu.getNombreUsuario() + "',contraseña ='" + usu.getContraseña() + "',idTipoUsuario='" + usu.getIdTipoUsuario() + "' WHERE idUsuario='" + usu.getIdUsuario() + "'";
        boolean respuesta = true;
        try {
            Consulta consulta = new Consulta();
            respuesta = consulta.ActualizacionBase(sql);
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error de modificación \n" + e);
        }
        return respuesta;
    }

    public TableModel buscarUsuario() {
        DefaultTableModel modelo = new DefaultTableModel() {
            public boolean isCellEditable(int columnas, int filas) {
                return false;
            }
        };
        String sql = "";
        if (PanelUsuario.filtro.getSelectedItem() == "Nombre de Usuario") {
            sql = "SELECT u.idUsuario,u.nombreUsuario,u.contraseña,tu.nombreTipoUsuario FROM usuario u, tipoUsuario tu WHERE u.idTipoUsuario = tu.idTipoUsuario and u.nombreUsuario LIKE '%" + PanelUsuario.tbuscar.getText() + "%'";
        } else {
            if (PanelUsuario.filtro.getSelectedItem() == "Tipo de Usuario") {
                sql = "SELECT u.idUsuario,u.nombreUsuario,u.contraseña,tu.nombreTipoUsuario FROM usuario u, tipoUsuario tu WHERE u.idTipoUsuario = tu.idTipoUsuario and tu.nombreTipoUsuario LIKE '%" + PanelUsuario.tbuscar.getText() + "%'";
            } else {
                if (PanelUsuario.filtro.getSelectedItem() == "Todos") {
                    sql = "SELECT u.idUsuario,u.nombreUsuario,u.contraseña,tu.nombreTipoUsuario FROM usuario u, tipoUsuario tu WHERE u.idTipoUsuario = tu.idTipoUsuario";
                }
            }
        }
        try {
            Consulta consulta = new Consulta();
            ResultSet resultado = consulta.ConsultaBase(sql);
            ResultSetMetaData columna = resultado.getMetaData();
            int cantColumnas = columna.getColumnCount();
            modelo.addColumn("Id");
            modelo.addColumn("Nombre");
            modelo.addColumn("Contraseña");
            modelo.addColumn("Tipo");
            while (resultado.next()) {
                Object[] filas = new Object[cantColumnas];
                for (int i = 0; i < cantColumnas; i++) {
                    filas[i] = resultado.getObject(i + 1);
                }
                modelo.addRow(filas);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en buscar usuario \n" + e);
        }
        return modelo;
    }

    public static TableModel imprimir() {
        DefaultTableModel modelo = new DefaultTableModel() {
            public boolean isCellEditable(int columnas, int filas) {
                return false;
            }
        };
        //String sql = "SELECT u.idUsuario,u.nombreUsuario,tu.nombreTipoUsuario FROM usuario u, tipoUsuario tu WHERE u.idTipoUsuario = tu.idTipoUsuario";
        String sql = "";
        if (FormReportes.filtro.getSelectedItem() == "Nombre de Usuario") {
            sql = "SELECT u.idUsuario,u.nombreUsuario,tu.nombreTipoUsuario FROM usuario u, tipoUsuario tu WHERE u.idTipoUsuario = tu.idTipoUsuario and u.nombreUsuario LIKE '%" + FormReportes.tFiltro.getText() + "%'";
        } else {
            if (FormReportes.filtro.getSelectedItem() == "Tipo de Usuario") {
                sql = "SELECT u.idUsuario,u.nombreUsuario,tu.nombreTipoUsuario FROM usuario u, tipoUsuario tu WHERE u.idTipoUsuario = tu.idTipoUsuario and tu.nombreTipoUsuario LIKE '%" + FormReportes.tFiltro.getText() + "%'";
            } else {
                if (FormReportes.filtro.getSelectedItem() == "Todos") {
                    sql = "SELECT u.idUsuario,u.nombreUsuario,tu.nombreTipoUsuario FROM usuario u, tipoUsuario tu WHERE u.idTipoUsuario = tu.idTipoUsuario";
                }
            }
        }
        if (FormReportes.ordenar.getSelectedIndex() != 0) {
            if (FormReportes.ordenar.getSelectedItem() == "Tipo de Usuario") {
                sql = sql + " ORDER BY tu.nombreTipoUsuario";
            }
        }
        try {
            Consulta consulta = new Consulta();
            ResultSet resultado = consulta.ConsultaBase(sql);
            ResultSetMetaData columna = resultado.getMetaData();
            int cantColumnas = columna.getColumnCount();
            modelo.addColumn("Id");
            modelo.addColumn("Nombre");
            modelo.addColumn("Tipo");
            while (resultado.next()) {
                Object[] filas = new Object[cantColumnas];
                for (int i = 0; i < cantColumnas; i++) {
                    filas[i] = resultado.getObject(i + 1);
                }
                modelo.addRow(filas);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en buscar usuario \n" + e);
        }
        return modelo;
    }

    public int obtenerTipoUsuario(Usuario u) {
        ResultSet resultado = null;
        int id = 0;
        String sql = "SELECT tu.idTipoUsuario FROM tipoUsuario tu, usuario u WHERE tu.idTipoUsuario = u.idTipoUsuario AND nombreUsuario= '" + u.getNombreUsuario() + "'";
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
}
