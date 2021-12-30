package Modelo;

import Vista.FormReportes;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import Vista.PanelComprobante;
import java.text.DecimalFormat;

/**
 *
 * @author Camila Carrero
 */
public class ComprobanteConsulta {

    public boolean registrar(Comprobante c) {
        boolean respuesta = true;
        String sql = "INSERT INTO comprobante (idContabilidad, fecha, monto, idTipoComprobante, idComprobanteTalonario, vigente) VALUES ('" + c.getIdContabilidad() + "', '" + c.getFecha() + "', '" + c.getMonto() + "', '" + c.getIdTipoComprobante() + "', '" + c.getIdComprobanteTalonario() + "', '" + 1 + "')";
        try {
            Consulta consulta = new Consulta();
            respuesta = consulta.InsercionBase(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de registro \n" + e);
        }
        return respuesta;
    }

    public boolean registrarComprobanteTalonario(Comprobante c) {
        boolean respuesta = true;
        String sql = "INSERT INTO comprobanteTalonario (idTalonario, numeroComprobante) VALUES ('" + c.getIdTalonario() + "', '" + c.getNumeroComprobante() + "')";
        try {
            Consulta consulta = new Consulta();
            respuesta = consulta.InsercionBase(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de registro \n" + e);
        }
        return respuesta;
    }

    public boolean anularComprobante(Comprobante c) {
        String sql = "UPDATE comprobante SET vigente= '" + 0 + "' WHERE idComprobante = '" + c.getIdComprobante() + "'";
        boolean respuesta = true;
        try {
            Consulta consulta = new Consulta();
            respuesta = consulta.ActualizacionBase(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de modificación \n" + e);
        }
        return respuesta;
    }

    public void aumentarNComprobante(int id) {
        String sql = "UPDATE talonario SET nComprobanteActual= nComprobanteActual + 1 WHERE idTalonario = '" + id + "'";
        boolean respuesta = true;
        try {
            Consulta consulta = new Consulta();
            respuesta = consulta.ActualizacionBase(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de modificación \n" + e);
        }
    }

    public TableModel buscarComprobante() {
        DefaultTableModel modelo = new DefaultTableModel() {
            public boolean isCellEditable(int columnas, int filas) {
                return false;
            }
        };
        String sql = "";
        if (PanelComprobante.filtro.getSelectedItem() == "Todos") {
            sql = "SELECT c.idComprobante, c.fecha, c.monto, tc.nombreTipoComprobante, c.vigente FROM comprobante c, tipoComprobante tc "
                    + "WHERE c.idTipoComprobante = tc.idTipoComprobante ORDER BY c.idComprobante";
        } else if (PanelComprobante.filtro.getSelectedItem() == "Fecha") {
            sql = "SELECT c.idComprobante, c.fecha, c.monto, tc.nombreTipoComprobante, c.vigente FROM comprobante c, tipoComprobante tc "
                    + "WHERE c.idTipoComprobante = tc.idTipoComprobante AND c.fecha LIKE '%" + PanelComprobante.tfBuscar.getText() + "%' ORDER BY c.idComprobante";
        } else if (PanelComprobante.filtro.getSelectedItem() == "Tipo de Comprobante") {
            sql = "SELECT c.idComprobante, c.fecha, c.monto, tc.nombreTipoComprobante, c.vigente FROM comprobante c, tipoComprobante tc "
                    + "WHERE c.idTipoComprobante = tc.idTipoComprobante AND tc.nombreTipoComprobante LIKE '%" + PanelComprobante.tfBuscar.getText() + "%' ORDER BY c.idComprobante";
        }
        try {
            Consulta consulta = new Consulta();
            ResultSet resultado = consulta.ConsultaBase(sql);
            ResultSetMetaData Columnas = resultado.getMetaData();
            modelo.addColumn("Id");
            modelo.addColumn("Fecha");
            modelo.addColumn("Monto");
            modelo.addColumn("Tipo de Comprobante");
            modelo.addColumn("Vigente");
            int cantColumnas = Columnas.getColumnCount();
            while (resultado.next()) {
                Object[] fila = new Object[cantColumnas];
                for (int i = 0; i < cantColumnas; i++) {
                    if (i == 2) {
                        fila[i] = resultado.getDouble(i + 1);
                        DecimalFormat df = new DecimalFormat("###,###.##");
                        fila[i] = df.format(Double.valueOf(fila[i].toString()));
                    } else {
                        fila[i] = resultado.getObject(i + 1);
                    }
                    if (i == 4) {
                        if (fila[i].equals(1)) {
                            fila[i] = true;
                        } else if (fila[i].equals(0)) {
                            fila[i] = false;
                        }
                    }
                }
                modelo.addRow(fila);
            }
            return modelo;
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return modelo;
    }

    public int obtenerId(Comprobante c) {
        String sql = "SELECT idComprobante FROM comprobante WHERE idContabilidad= '" + c.getIdContabilidad() + "' AND fecha= '" + c.getFecha() + "' AND monto= '" + c.getMonto() + "' and idTipoComprobante= '" + c.getIdTipoComprobante() + "' AND idComprobanteTalonario= '" + c.getIdComprobanteTalonario() + "' AND vigente= '" + c.getVigente() + "';";
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
            System.out.println(e);
        }
        return u;
    }

    public TableModel obtenerDatos(int id) {
        DefaultTableModel modelo = new DefaultTableModel();
        String sql = "SELECT ct.numeroComprobante, (SELECT GROUP_CONCAT(CONCAT_WS(', ',(CONCAT_WS(' ', n.primerApellido, n.segundoApellido)),(CONCAT_WS(' ', n.primerNombre, n.segundoNombre)))) nombre FROM nombre n WHERE n.idNombre = c.idNombre), com.monto, con.concepto, com.fecha FROM comprobante com, comprobanteTalonario ct, talonario t, contabilidad con, cliente c, nombre n WHERE com.idContabilidad = con.idContabilidad AND com.idComprobanteTalonario = ct.idComprobanteTalonario AND ct.idTalonario = t.idTalonario AND con.idCliente = c.idCliente AND n.idNombre = c.idNombre AND com.idComprobante = '" + id + "';";
        try {
            Consulta consulta = new Consulta();
            ResultSet resultado = consulta.ConsultaBase(sql);
            ResultSetMetaData Columnas = resultado.getMetaData();
            modelo.addColumn("Número Comprobante");
            modelo.addColumn("Cliente");
            modelo.addColumn("Monto");
            modelo.addColumn("Concepto");
            modelo.addColumn("Fecha");
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
            JOptionPane.showMessageDialog(null, "Error " + e);
        }
        return modelo;
    }

    public int obtenerIdComprobanteTalonario(Comprobante c) {
        String sql = "SELECT idComprobanteTalonario FROM comprobanteTalonario WHERE idTalonario= '" + c.getIdTalonario() + "' AND numeroComprobante = '" + c.getNumeroComprobante() + "' ;";
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

    public Double obtenerMontoContabilidad(int id) {
        String sql = "SELECT monto FROM contabilidad WHERE idContabilidad = '" + id + "';";
        Double monto = 0.0;
        ResultSet resultado = null;
        try {
            Consulta consulta = new Consulta();
            resultado = consulta.ConsultaBase(sql);
            while (resultado.next()) {
                monto = resultado.getDouble(1);
            }
            return monto;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }
        return monto;
    }

    public Double montoUsado(int id) {
        String sql = "SELECT com.monto FROM comprobante com, contabilidad con WHERE com.idContabilidad = con.idContabilidad AND con.idContabilidad = '" + id + "' AND com.vigente = 1;";
        Double monto = 0.0;
        ResultSet resultado = null;
        try {
            Consulta consulta = new Consulta();
            resultado = consulta.ConsultaBase(sql);
            while (resultado.next()) {
                Double m = resultado.getDouble(1);
                monto = monto + m;
            }
            return monto;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }
        return monto;
    }

    public TableModel imprimir() {
        DefaultTableModel modelo = new DefaultTableModel() {
            public boolean isCellEditable(int columnas, int filas) {
                return false;
            }
        };
        String sql = "";
        if (FormReportes.filtro.getSelectedItem() == "Todos") {
            sql = "SELECT c.idComprobante, c.fecha,(SELECT GROUP_CONCAT(CONCAT_WS(', ',(CONCAT_WS(' ', n.primerApellido, n.segundoApellido)),"
                    + "(CONCAT_WS(' ', n.primerNombre, n.segundoNombre)))) nombre FROM nombre n WHERE n.idNombre = cl.idNombre ), "
                    + "con.concepto ,c.monto, tc.nombreTipoComprobante FROM comprobante c, tipoComprobante tc, cliente cl, nombre n, contabilidad con "
                    + "WHERE c.idTipoComprobante = tc.idTipoComprobante AND con.idContabilidad = c.idContabilidad AND con.idCliente = cl.idCliente "
                    + "AND cl.idNombre = n.idNombre AND c.vigente = 1";
        } else if (FormReportes.filtro.getSelectedItem() == "Fecha") {
            sql = "SELECT c.idComprobante, c.fecha,(SELECT GROUP_CONCAT(CONCAT_WS(', ',(CONCAT_WS(' ', n.primerApellido, n.segundoApellido)),"
                    + "(CONCAT_WS(' ', n.primerNombre, n.segundoNombre)))) nombre FROM nombre n WHERE n.idNombre = cl.idNombre ), "
                    + "con.concepto ,c.monto, tc.nombreTipoComprobante FROM comprobante c, tipoComprobante tc, cliente cl, nombre n, contabilidad con "
                    + "WHERE c.idTipoComprobante = tc.idTipoComprobante AND con.idContabilidad = c.idContabilidad AND con.idCliente = cl.idCliente "
                    + "AND cl.idNombre = n.idNombre AND c.vigente = 1 AND c.fecha LIKE '%" + FormReportes.tFiltro.getText() + "%'";
        } else if (FormReportes.filtro.getSelectedItem() == "Tipo de Comprobante") {
            sql = "SELECT c.idComprobante, c.fecha,(SELECT GROUP_CONCAT(CONCAT_WS(', ',(CONCAT_WS(' ', n.primerApellido, n.segundoApellido)),"
                    + "(CONCAT_WS(' ', n.primerNombre, n.segundoNombre)))) nombre FROM nombre n WHERE n.idNombre = cl.idNombre ), "
                    + "con.concepto ,c.monto, tc.nombreTipoComprobante FROM comprobante c, tipoComprobante tc, cliente cl, nombre n, contabilidad con "
                    + "WHERE c.idTipoComprobante = tc.idTipoComprobante AND con.idContabilidad = c.idContabilidad AND con.idCliente = cl.idCliente "
                    + "AND cl.idNombre = n.idNombre AND c.vigente = 1 AND tc.nombreTipoComprobante LIKE '%" + FormReportes.tFiltro.getText() + "%'";
        }
        if (FormReportes.ordenar.getSelectedIndex() == 0) {
            sql = sql + " ORDER BY c.idComprobante";
        } else if (FormReportes.ordenar.getSelectedItem() == "Fecha") {
            sql = sql + " ORDER BY c.fecha";
        } else if (FormReportes.ordenar.getSelectedItem() == "Tipo de Comprobante") {
            sql = sql + " ORDER BY tc.nombreTipoComprobante";
        }
        try {
            Consulta consulta = new Consulta();
            ResultSet resultado = consulta.ConsultaBase(sql);
            ResultSetMetaData Columnas = resultado.getMetaData();
            modelo.addColumn("Id");
            modelo.addColumn("Fecha");
            modelo.addColumn("Cliente");
            modelo.addColumn("Concepto");
            modelo.addColumn("Monto");
            modelo.addColumn("Tipo de Comprobante");
            int cantColumnas = Columnas.getColumnCount();
            while (resultado.next()) {
                Object[] fila = new Object[cantColumnas];
                for (int i = 0; i < cantColumnas; i++) {
                    if (i == 4) {
                        fila[i] = resultado.getDouble(i + 1);
                        DecimalFormat df = new DecimalFormat("###,###.##");
                        fila[i] = df.format(Double.valueOf(fila[i].toString()));
                    } else {
                        fila[i] = resultado.getObject(i + 1);
                    }
                }
                modelo.addRow(fila);
            }
            return modelo;
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return modelo;
    }
}
