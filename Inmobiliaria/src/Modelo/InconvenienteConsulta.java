package Modelo;

import Vista.BuscarInconveniente;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 *
 * @author Camila Carrero
 */
public class InconvenienteConsulta {

    public boolean registrar(Inconveniente i) {
        boolean respuesta = true;
        String sql = "INSERT INTO inconveniente (nombreInconveniente, idPropiedad, estado) VALUES ('" + i.getNombreInconveniente() + "', '" + i.getIdPropiedad() + "', '" + i.getEstado() + "')";
        try {
            Consulta consulta = new Consulta();
            respuesta = consulta.InsercionBase(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de registro \n" + e);
        }
        return respuesta;
    }

    public boolean eliminar(Inconveniente i) {
        boolean respuesta = true;
        String sql = "DELETE FROM inconveniente WHERE idInconveniente='" + i.getIdIncoveniente() + "'";
        try {
            Consulta consulta = new Consulta();
            respuesta = consulta.EliminacionBase(sql);
            JOptionPane.showMessageDialog(null, "Eliminación exitosa");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la eliminación \n" + e);
        }
        return respuesta;
    }

    public boolean modificar(Inconveniente i) {
        String sql = "UPDATE inconveniente SET nombreInconveniente='" + i.getNombreInconveniente() + "', idPropiedad= '" + i.getIdPropiedad() + "', estado= '" + i.getEstado() + "' WHERE idInconveniente='" + i.getIdIncoveniente() + "'";
        boolean respuesta = true;
        try {
            Consulta consulta = new Consulta();
            respuesta = consulta.ActualizacionBase(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de modificación \n" + e);
        }
        return respuesta;
    }

    public TableModel buscarInconveniente() {
        DefaultTableModel modelo = new DefaultTableModel() {
            public boolean isCellEditable(int columnas, int filas) {
                return false;
            }
        };
        String sql = "";
        if (BuscarInconveniente.filtro.getSelectedItem() == "Nombre") {
            sql = "SELECT i.idInconveniente, i.nombreInconveniente, "
                    + "(SELECT GROUP_CONCAT(CONCAT_WS(' ', d.calle, d.numero, d.depto)) direccion FROM direccion d WHERE d.idDireccion = p.idDireccion), "
                    + "l.nombreLocalidad, tp.nombreTipoPropiedad FROM inconveniente i, direccion d, localidad l, propiedad p, tipoPropiedad tp "
                    + "WHERE d.idDireccion = p.idDireccion AND d.idLocalidad = l.idLocalidad AND p.idTipoPropiedad = tp.idTipoPropiedad "
                    + "AND i.nombreInconveniente LIKE '%" + BuscarInconveniente.tBuscar.getText() + "%'";
        } else if (BuscarInconveniente.filtro.getSelectedItem() == "Tipo de Propiedad") {
            sql = "SELECT i.idInconveniente, i.nombreInconveniente, "
                    + "(SELECT GROUP_CONCAT(CONCAT_WS(' ', d.calle, d.numero, d.depto)) direccion FROM direccion d WHERE d.idDireccion = p.idDireccion), "
                    + "l.nombreLocalidad, tp.nombreTipoPropiedad FROM inconveniente i, direccion d, localidad l, propiedad p, tipoPropiedad tp "
                    + "WHERE d.idDireccion = p.idDireccion AND d.idLocalidad = l.idLocalidad AND p.idTipoPropiedad = tp.idTipoPropiedad "
                    + "AND tp.nombreTipoPropiedad LIKE '%" + BuscarInconveniente.tBuscar.getText() + "%'";
        } else if (BuscarInconveniente.filtro.getSelectedItem() == "Todos") {
            sql = "SELECT i.idInconveniente, i.nombreInconveniente, "
                    + "(SELECT GROUP_CONCAT(CONCAT_WS(' ', d.calle, d.numero, d.depto)) direccion FROM direccion d WHERE d.idDireccion = p.idDireccion), "
                    + "l.nombreLocalidad, tp.nombreTipoPropiedad FROM inconveniente i, direccion d, localidad l, propiedad p, tipoPropiedad tp "
                    + "WHERE d.idDireccion = p.idDireccion AND d.idLocalidad = l.idLocalidad AND p.idTipoPropiedad = tp.idTipoPropiedad";
        } else if (BuscarInconveniente.filtro.getSelectedItem() == "Localidad") {
            sql = "SELECT i.idInconveniente, i.nombreInconveniente, "
                    + "(SELECT GROUP_CONCAT(CONCAT_WS(' ', d.calle, d.numero, d.depto)) direccion FROM direccion d WHERE d.idDireccion = p.idDireccion), "
                    + "l.nombreLocalidad, tp.nombreTipoPropiedad FROM inconveniente i, direccion d, localidad l, propiedad p, tipoPropiedad tp "
                    + "WHERE d.idDireccion = p.idDireccion AND d.idLocalidad = l.idLocalidad AND p.idTipoPropiedad = tp.idTipoPropiedad "
                    + "AND l.nombreLocalidad LIKE '%" + BuscarInconveniente.tBuscar.getText() + "%'";
        }
        try {
            Consulta consulta = new Consulta();
            ResultSet resultado = consulta.ConsultaBase(sql);
            ResultSetMetaData columna = resultado.getMetaData();
            int cantColumnas = columna.getColumnCount();
            modelo.addColumn("Id");
            modelo.addColumn("Nombre");
            modelo.addColumn("Dirección");
            modelo.addColumn("Localidad");
            modelo.addColumn("Tipo de Propiedad");
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

    public TableModel cargarComunicacion(int id) {
        DefaultTableModel modelo = new DefaultTableModel() {
            public boolean isCellEditable(int columnas, int filas) {
                return false;
            }
        };
        String sql = "SELECT com.idComunicacion, (SELECT GROUP_CONCAT(CONCAT_WS(', ',(CONCAT_WS(' ', n.primerApellido, n.segundoApellido)),"
                + "(CONCAT_WS(' ', n.primerNombre, n.segundoNombre)))) nombre FROM nombre n WHERE n.idNombre = cli.idNombre), com.fecha, com.observaciones\n"
                + "FROM comunicacion com, cliente cli, nombre n WHERE com.idCliente = cli.idCliente AND n.idNombre = cli.idNombre"
                + " AND com.idInconveniente = '" + id + "' ORDER BY com.idComunicacion asc;";
        try {
            Consulta consulta = new Consulta();
            ResultSet resultado = consulta.ConsultaBase(sql);
            ResultSetMetaData columna = resultado.getMetaData();
            int cantColumnas = columna.getColumnCount();
            modelo.addColumn("Id");
            modelo.addColumn("Cliente");
            modelo.addColumn("Fecha");
            modelo.addColumn("Observaciones");
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

}
