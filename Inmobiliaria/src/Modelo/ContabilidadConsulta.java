package Modelo;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import Vista.PanelContabilidad;
import java.text.DecimalFormat;

/**
 *
 * @author Camila Carrero
 */
public class ContabilidadConsulta {

    public boolean registrar(Contabilidad c) {
        boolean respuesta = true;
        String sql = "INSERT INTO contabilidad (idCliente, fecha, monto, concepto, idTipoContabilidad) VALUES ('" + c.getIdCliente() + "', '" + c.getFecha() + "', '" + c.getMonto() + "', '" + c.getConcepto() + "', '" + c.getIdTipoContabilidad() + "');";
        try {
            Consulta consulta = new Consulta();
            respuesta = consulta.InsercionBase(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de registro \n" + e);
        }
        return respuesta;
    }

    public boolean modificar(Contabilidad c) {
        String sql = "UPDATE contabilidad SET idCliente = '" + c.getIdCliente() + "', fecha= '" + c.getFecha() + "', monto= '" + c.getMonto() + "', concepto= '" + c.getConcepto() + "', idTipoContabilidad= '" + c.getIdTipoContabilidad() + "' WHERE idContabilidad = '" + c.getIdContabilidad() + "'";
        boolean respuesta = true;
        try {
            Consulta consulta = new Consulta();
            respuesta = consulta.ActualizacionBase(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de modificación \n" + e);
        }
        return respuesta;
    }

    public boolean eliminar(Contabilidad c) {
        boolean respuesta = true;
        String sql = "DELETE FROM contabilidad WHERE idContabilidad='" + c.getIdContabilidad() + "'";
        try {
            Consulta consulta = new Consulta();
            respuesta = consulta.EliminacionBase(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la eliminación \n" + e);
        }
        return respuesta;
    }

    public TableModel buscarContabilidad() {
        DefaultTableModel modelo = new DefaultTableModel() {
            public boolean isCellEditable(int columnas, int filas) {
                return false;
            }
        };
        String sql = "";
        if (PanelContabilidad.filtro.getSelectedItem() == "Cliente") {
            sql = "SELECT c.idContabilidad,(SELECT GROUP_CONCAT(CONCAT_WS(', ',(CONCAT_WS(' ', n.primerApellido, n.segundoApellido)),(CONCAT_WS(' ', n.primerNombre, n.segundoNombre)))) nombre FROM nombre n WHERE n.idNombre = cli.idNombre),"
                    + "c.fecha,c.monto, c.concepto, tc.nombreTipoContabilidad, (c.monto - (SELECT SIFNULL(SUM(com.monto),0) FROM comprobante com WHERE c.idContabilidad = com.idContabilidad AND com.vigente = 1))"
                    + " FROM contabilidad c, cliente cli, nombre n, tipoContabilidad tc, comprobante com"
                    + " WHERE c.idCliente = cli.idCliente AND cli.idNombre = n.idNombre AND c.idTipoContabilidad = tc.idTipoContabilidad "
                    + "AND (n.primerNombre LIKE '%" + PanelContabilidad.tfBuscar.getText() + "%' OR n.segundoNombre LIKE '%" + PanelContabilidad.tfBuscar.getText() + "%' OR n.primerApellido LIKE '%"
                    + PanelContabilidad.tfBuscar.getText() + "%' OR n.segundoApellido LIKE '%" + PanelContabilidad.tfBuscar.getText() + "%') GROUP BY c.idContabilidad ORDER BY c.idContabilidad";
        } else if (PanelContabilidad.filtro.getSelectedItem() == "Concepto") {
            sql = "SELECT c.idContabilidad,(SELECT GROUP_CONCAT(CONCAT_WS(', ',(CONCAT_WS(' ', n.primerApellido, n.segundoApellido)),(CONCAT_WS(' ', n.primerNombre, n.segundoNombre)))) nombre FROM nombre n WHERE n.idNombre = cli.idNombre),"
                    + "c.fecha,c.monto, c.concepto, tc.nombreTipoContabilidad, (c.monto - (SELECT IFNULL(SUM(com.monto),0) FROM comprobante com WHERE c.idContabilidad = com.idContabilidad AND com.vigente = 1))"
                    + " FROM contabilidad c, cliente cli, nombre n, tipoContabilidad tc, comprobante com"
                    + " WHERE c.idCliente = cli.idCliente AND cli.idNombre = n.idNombre AND c.idTipoContabilidad = tc.idTipoContabilidad "
                    + "AND c.concepto LIKE '%" + PanelContabilidad.tfBuscar.getText() + "%' GROUP BY c.idContabilidad ORDER BY c.idContabilidad";
        } else if (PanelContabilidad.filtro.getSelectedItem() == "Tipo de Contabilidad") {
            sql = "SELECT c.idContabilidad,(SELECT GROUP_CONCAT(CONCAT_WS(', ',(CONCAT_WS(' ', n.primerApellido, n.segundoApellido)),(CONCAT_WS(' ', n.primerNombre, n.segundoNombre)))) nombre FROM nombre n WHERE n.idNombre = cli.idNombre),"
                    + "c.fecha,c.monto, c.concepto, tc.nombreTipoContabilidad, (c.monto - (SELECT IFNULL(SUM(com.monto),0) FROM comprobante com WHERE c.idContabilidad = com.idContabilidad AND com.vigente = 1))"
                    + " FROM contabilidad c, cliente cli, nombre n, tipoContabilidad tc, comprobante com"
                    + " WHERE c.idCliente = cli.idCliente AND cli.idNombre = n.idNombre AND c.idTipoContabilidad = tc.idTipoContabilidad "
                    + "AND tc.nombreTipoContabilidad LIKE '%" + PanelContabilidad.tfBuscar.getText() + "%' GROUP BY c.idContabilidad ORDER BY c.idContabilidad";
        } else if (PanelContabilidad.filtro.getSelectedItem() == "Todos") {
            sql = "SELECT c.idContabilidad,(SELECT GROUP_CONCAT(CONCAT_WS(', ',(CONCAT_WS(' ', n.primerApellido, n.segundoApellido)),(CONCAT_WS(' ', n.primerNombre, n.segundoNombre)))) nombre FROM nombre n WHERE n.idNombre = cli.idNombre),"
                    + "c.fecha,c.monto, c.concepto, tc.nombreTipoContabilidad, (c.monto - (SELECT IFNULL(SUM(com.monto),0) FROM comprobante com WHERE c.idContabilidad = com.idContabilidad AND com.vigente = 1))"
                    + " FROM contabilidad c, cliente cli, nombre n, tipoContabilidad tc, comprobante com"
                    + " WHERE c.idCliente = cli.idCliente AND cli.idNombre = n.idNombre AND c.idTipoContabilidad = tc.idTipoContabilidad GROUP BY c.idContabilidad ORDER BY c.idContabilidad";
        }
        try {
            Consulta consulta = new Consulta();
            ResultSet resultado = consulta.ConsultaBase(sql);
            ResultSetMetaData columna = resultado.getMetaData();
            int cantColumnas = columna.getColumnCount();
            modelo.addColumn("Id");
            modelo.addColumn("Cliente");
            modelo.addColumn("Fecha");
            modelo.addColumn("Monto");
            modelo.addColumn("Concepto");
            modelo.addColumn("Tipo de Colntabilidad");;
            modelo.addColumn("Saldo");
            while (resultado.next()) {
                Object[] filas = new Object[cantColumnas];
                for (int i = 0; i < cantColumnas; i++) {
                    if (i == 3 || i == 6) {
                        filas[i] = resultado.getDouble(i + 1);
                        DecimalFormat df = new DecimalFormat("###,###.##");
                        filas[i] = df.format(Double.valueOf(filas[i].toString()));
                    } else {
                        filas[i] = resultado.getObject(i + 1);
                    }
                }
                modelo.addRow(filas);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en buscar contabilidad \n" + e);
        }
        return modelo;
    }

    public int obtenerIdCliente(int idc) {
        ResultSet resultado = null;
        int id = 0;
        String sql = "SELECT idCliente FROM contabilidad WHERE idContabilidad = '" + idc + "';";
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
