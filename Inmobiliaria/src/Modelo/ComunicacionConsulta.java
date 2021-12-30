package Modelo;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import Vista.PanelComunicacion;

/**
 *
 * @author Camila Carrero
 */
public class ComunicacionConsulta {

    public boolean registrar(Comunicacion c) {
        boolean respuesta = true;      
        String sql = "INSERT INTO comunicacion (fecha, idCliente, observaciones, idInconveniente) VALUES ('" + c.getFecha() + "', '" + c.getIdCliente() + "', '" + c.getObservaciones() + "', null)";  
        try {
            Consulta consulta = new Consulta();
            respuesta = consulta.InsercionBase(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de registro \n" + e);
        }
        return respuesta;
    }

    public boolean modificar(Comunicacion c) {
        String sql = "UPDATE comunicacion SET fecha= '" + c.getFecha() + "', idCliente= '" + c.getIdCliente() + "', observaciones= '" + c.getObservaciones() + "', idInconveniente= null WHERE idComunicacion = '" + c.getIdComunicacion() + "';";
        boolean respuesta = true;
        try {
            Consulta consulta = new Consulta();
            respuesta = consulta.ActualizacionBase(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de modificación \n" + e);
        }
        return respuesta;
    }

    public boolean eliminar(Comunicacion c) {
        boolean respuesta = true;
        String sql = "DELETE FROM comunicacion WHERE idComunicacion='" + c.getIdComunicacion() + "'";
        try {
            Consulta consulta = new Consulta();
            respuesta = consulta.EliminacionBase(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la eliminación \n" + e);
        }
        return respuesta;
    }

    public TableModel buscarComunicacion() {
        DefaultTableModel modelo = new DefaultTableModel() {
            public boolean isCellEditable(int columnas, int filas) {
                return false;
            }
        };
        String sql = "";
        if (PanelComunicacion.filtro.getSelectedItem() == "Cliente") {
            sql = "SELECT com.idComunicacion, (SELECT GROUP_CONCAT(CONCAT_WS(', ',(CONCAT_WS(' ', n.primerApellido, n.segundoApellido)),(CONCAT_WS(' ', n.primerNombre, n.segundoNombre)))) nombre FROM nombre n WHERE n.idNombre = cli.idNombre), com.fecha, com.observaciones\n"
                    + "FROM comunicacion com, cliente cli, nombre n WHERE com.idCliente = cli.idCliente AND n.idNombre = cli.idNombre "
                    + "AND (n.primerNombre LIKE '%" + PanelComunicacion.tfBuscar.getText() + "%' OR n.segundoNombre LIKE '%" + PanelComunicacion.tfBuscar.getText() + "%' OR n.primerApellido LIKE '%" + PanelComunicacion.tfBuscar.getText() + "%' OR n.segundoApellido LIKE '%" + PanelComunicacion.tfBuscar.getText() + "%') ORDER BY com.idComunicacion";
        } else if (PanelComunicacion.filtro.getSelectedItem() == "Fecha") {
            sql = "SELECT com.idComunicacion, (SELECT GROUP_CONCAT(CONCAT_WS(', ',(CONCAT_WS(' ', n.primerApellido, n.segundoApellido)),(CONCAT_WS(' ', n.primerNombre, n.segundoNombre)))) nombre FROM nombre n WHERE n.idNombre = cli.idNombre), com.fecha, com.observaciones\n"
                    + "FROM comunicacion com, cliente cli, nombre n WHERE com.idCliente = cli.idCliente AND n.idNombre = cli.idNombre"
                    + " AND com.fecha LIKE '%" + PanelComunicacion.tfBuscar.getText() + "%' ORDER BY com.idComunicacion;";
        } else if (PanelComunicacion.filtro.getSelectedItem() == "Todos") {
            sql = "SELECT com.idComunicacion, (SELECT GROUP_CONCAT(CONCAT_WS(', ',(CONCAT_WS(' ', n.primerApellido, n.segundoApellido)),(CONCAT_WS(' ', n.primerNombre, n.segundoNombre)))) nombre FROM nombre n WHERE n.idNombre = cli.idNombre), com.fecha, com.observaciones\n"
                    + "FROM comunicacion com, cliente cli, nombre n WHERE com.idCliente = cli.idCliente AND n.idNombre = cli.idNombre ORDER BY com.idComunicacion;";
        }
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
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en buscar contabilidad \n" + e);
        }
        return modelo;
    }
    
    public int obtenerIdCliente(int idc){
        ResultSet resultado = null;
        int id = 0;
        String sql = "SELECT idCliente FROM comunicacion WHERE idComunicacion = '" + idc + "';";
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
