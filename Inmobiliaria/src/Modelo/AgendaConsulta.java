package Modelo;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import Vista.PanelAgenda;

/**
 *
 * @author Camila Carrero
 */
public class AgendaConsulta {

    public boolean registrar(Agenda a) {
        boolean respuesta = false;
        String sql = "INSERT INTO agenda (fecha, lugar, hora, idCliente, observaciones) VALUES ('" + a.getFecha() + "', '" + a.getLugar() + "', '" + a.getHora() + "', '" + a.getIdCliente() + "', '" + a.getObservaciones() + "')";
        try {
            Consulta consulta = new Consulta();
            consulta.InsercionBase(sql);
            respuesta = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de registro \n" + e);
        }
        return respuesta;
    }

    public boolean modificar(Agenda a) {
        String sql = "UPDATE agenda SET fecha='" + a.getFecha() + "', lugar='" + a.getLugar() + "', hora='" + a.getHora() + "', idCliente='" + a.getIdCliente() + "', observaciones='" + a.getObservaciones() + "' WHERE idAgenda = '" + a.getIdAgenda() + "'";
        boolean respuesta = false;
        try {
            Consulta consulta = new Consulta();
            consulta.ActualizacionBase(sql);
            respuesta = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de modificación \n" + e);
        }
        return respuesta;
    }

    public boolean eliminar(Agenda a) {
        boolean respuesta = false;
        String sql = "DELETE FROM agenda WHERE idAgenda='" + a.getIdAgenda() + "'";
        try {
            Consulta consulta = new Consulta();
            consulta.EliminacionBase(sql);
            respuesta = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la eliminación \n" + e);
        }
        return respuesta;
    }

    public TableModel buscarAgenda() {
        DefaultTableModel modelo = new DefaultTableModel(){
            public boolean isCellEditable(int columnas, int filas) {
                return false;
            }
        };
        String sql = "";
        if (PanelAgenda.filtro.getSelectedItem() == "Todos") {
            sql = "SELECT a.idAgenda, a.fecha, a.lugar, a.hora, (SELECT GROUP_CONCAT(CONCAT_WS(', ',(CONCAT_WS(' ', n.primerApellido, n.segundoApellido)),(CONCAT_WS(' ', n.primerNombre, n.segundoNombre)))) nombre FROM nombre n, cliente c WHERE n.idNombre = c.idNombre AND c.idCliente = a.idCliente), a.observaciones FROM agenda a";
        } else {
            if (PanelAgenda.filtro.getSelectedItem() == "Fecha") {
                sql = "SELECT a.idAgenda, a.fecha, a.lugar, a.hora, (SELECT GROUP_CONCAT(CONCAT_WS(', ',(CONCAT_WS(' ', n.primerApellido, n.segundoApellido)),(CONCAT_WS(' ', n.primerNombre, n.segundoNombre)))) nombre FROM nombre n, cliente c WHERE n.idNombre = c.idNombre AND c.idCliente = a.idCliente), a.observaciones FROM agenda a WHERE fecha LIKE '%" + PanelAgenda.tfBuscar.getText() + "%'";
            } else {
                if (PanelAgenda.filtro.getSelectedItem() == "Cliente") {
                    sql = "SELECT a.idAgenda, a.fecha, a.lugar, a.hora, (SELECT GROUP_CONCAT(CONCAT_WS(', ',(CONCAT_WS(' ', n.primerApellido, n.segundoApellido)),(CONCAT_WS(' ', n.primerNombre, n.segundoNombre)))) nombre FROM nombre n, cliente c WHERE n.idNombre = c.idNombre AND c.idCliente = a.idCliente), a.observaciones FROM agenda a, cliente c, nombre n WHERE n.idNombre = c.idNombre AND c.idCliente = a.idCliente AND (n.primerNombre LIKE '%" + PanelAgenda.tfBuscar.getText() + "%' OR n.segundoNombre LIKE '%" + PanelAgenda.tfBuscar.getText() + "%' OR n.primerApellido LIKE '%" + PanelAgenda.tfBuscar.getText() + "%' OR n.segundoApellido LIKE '%" + PanelAgenda.tfBuscar.getText() + "%')";
                } else {
                    if (PanelAgenda.filtro.getSelectedItem() == "Lugar") {
                        sql = "SELECT a.idAgenda, a.fecha, a.lugar, a.hora, (SELECT GROUP_CONCAT(CONCAT_WS(', ',(CONCAT_WS(' ', n.primerApellido, n.segundoApellido)),(CONCAT_WS(' ', n.primerNombre, n.segundoNombre)))) nombre FROM nombre n, cliente c WHERE n.idNombre = c.idNombre AND c.idCliente = a.idCliente), a.observaciones FROM agenda a WHERE lugar LIKE '%" + PanelAgenda.tfBuscar.getText() + "%'";
                    }
                }
            }
        }
        try {
            Consulta consulta = new Consulta();
            ResultSet resultado = consulta.ConsultaBase(sql);
            ResultSetMetaData Columnas = resultado.getMetaData();
            modelo.addColumn("Id");
            modelo.addColumn("Fecha");
            modelo.addColumn("Lugar");
            modelo.addColumn("Hora");
            modelo.addColumn("Cliente");
            modelo.addColumn("Observaciones");
            int cantColumnas = Columnas.getColumnCount();
            while (resultado.next()) {
                Object[] fila = new Object[cantColumnas];
                for (int i = 0; i < cantColumnas; i++) {
                    fila[i] = resultado.getObject(i + 1);
                }
                modelo.addRow(fila);
            }
            return modelo;
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return modelo;
    }
    
    public int obtenerIdCliente(int ida){
        ResultSet resultado = null;
        int id = 0;
        String sql = "SELECT idCliente FROM agenda WHERE idAgenda = '" + ida + "';";
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
