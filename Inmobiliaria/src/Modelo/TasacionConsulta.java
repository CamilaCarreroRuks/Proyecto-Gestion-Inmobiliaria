package Modelo;

import Vista.FormReportes;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import Vista.PanelTasacion;

/**
 *
 * @author Camila Carrero
 */
public class TasacionConsulta {

    public boolean registrar(Tasacion t) {
        String sql = "INSERT INTO tasacion (fecha, idCliente, idDireccion, idTipoPropiedad, idCategoria, idDatos, idConstantes) "
                + "VALUES ('" + t.getFecha() + "', '" + t.getIdCliente() + "', '" + t.getIdDireccion() + "', '" + t.getIdTipoPropiedad() + "', "
                + "'" + t.getIdCategoria() + "', '" + t.getIdDatos() + "', '" + t.getIdConstantes() + "');";
        boolean respuesta = true;
        try {
            Consulta consulta = new Consulta();
            respuesta = consulta.InsercionBase(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de registro \n" + e);
        }
        return respuesta;
    }

    public boolean registrarDatos(Tasacion t) {
        String sql = "INSERT INTO datosTasacion (años, estado, m2Construccion, m2Terreno) VALUES ('" + t.getAños() + "', "
                + "'" + t.getEstado() + "', '" + t.getM2Construccion() + "', '" + t.getM2Terreno() + "')";
        boolean respuesta = true;
        try {
            Consulta consulta = new Consulta();
            respuesta = consulta.InsercionBase(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de registro \n" + e);
        }
        return respuesta;
    }

    public boolean registrarValor(Tasacion t) {
        String sql = "INSERT INTO valoresTasacion (valorConstruccion, valorTerreno, valorTotal) "
                + "VALUES ('" + t.getValorConstruccion() + "', '" + t.getValorTerreno() + "', '" + t.getValorTotal() + "')";
        boolean respuesta = true;
        try {
            Consulta consulta = new Consulta();
            respuesta = consulta.InsercionBase(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de registro \n" + e);
        }
        return respuesta;
    }

    public boolean registrarConstantes(Tasacion t) {
        String sql = "INSERT INTO ConstantesTasacion (valorBolsa, valorM2Terreno, valorResidual) "
                + "VALUES ('" + t.getValorBolsa() + "', '" + t.getValorM2Terreno() + "', '" + t.getValorResidual() + "')";
        boolean respuesta = true;
        try {
            Consulta consulta = new Consulta();
            respuesta = consulta.InsercionBase(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de registro \n" + e);
        }
        return respuesta;
    }

    public boolean eliminar(Tasacion t) {
        String sql = "DELETE FROM tasacion WHERE idTasacion='" + t.getIdTasacion() + "'";
        boolean respuesta = true;
        try {
            Consulta consulta = new Consulta();
            respuesta = consulta.EliminacionBase(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la eliminación \n");
        }
        return respuesta;
    }

    public boolean modificar(Tasacion t) {
        String sql = "UPDATE tasacion SET fecha= '" + t.getFecha() + "', idCliente= '" + t.getIdCliente() + "', "
                + "idDireccion= '" + t.getIdDireccion() + "', idTipoPropiedad= '" + t.getIdTipoPropiedad() + "', "
                + "idCategoria= '" + t.getIdCategoria() + "' WHERE idTasacion= '" + t.getIdTasacion() + "';";
        boolean respuesta = true;
        try {
            Consulta consulta = new Consulta();
            respuesta = consulta.ActualizacionBase(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de modificación \n" + e);
        }
        return respuesta;
    }

    public void modificarIdValores(Tasacion t) {
        String sql = "UPDATE tasacion SET  idValores= '" + t.getIdValores() + "' WHERE idTasacion= '" + t.getIdTasacion() + "';";
        boolean respuesta = true;
        try {
            Consulta consulta = new Consulta();
            respuesta = consulta.ActualizacionBase(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de modificación \n" + e);
        }
    }

    public boolean modificarDatos(Tasacion t) {
        String sql = "UPDATE datosTasacion SET años= '" + t.getAños() + "', estado= '" + t.getEstado() + "', "
                + "m2Construccion= '" + t.getM2Construccion() + "', m2Terreno= '" + t.getM2Terreno() + "' WHERE idDatos= '" + t.getIdDatos() + "'";
        boolean respuesta = true;
        try {
            Consulta consulta = new Consulta();
            respuesta = consulta.ActualizacionBase(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de modificación \n" + e);
        }
        return respuesta;
    }

    public boolean modificarValores(Tasacion t) {
        String sql = "UPDATE valoresTasacion SET valorConstruccion= '" + t.getValorConstruccion() + "', "
                + "valorTerreno= '" + t.getValorTerreno() + "', valorTotal= '" + t.getValorTotal() + "' WHERE idValores= '" + t.getIdValores() + "'";
        boolean respuesta = true;
        try {
            Consulta consulta = new Consulta();
            respuesta = consulta.ActualizacionBase(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de modificación \n" + e);
        }
        return respuesta;
    }

    public boolean modificarConstantes(Tasacion t) {
        String sql = "UPDATE constantesTasacion SET valorBolsa= '" + t.getValorBolsa() + "', valorM2Terreno= '" + t.getValorM2Terreno() + "', "
                + "valorResidual= '" + t.getValorResidual() + "' WHERE idConstantes = '" + t.getIdConstantes() + "'";
        boolean respuesta = true;
        try {
            Consulta consulta = new Consulta();
            respuesta = consulta.ActualizacionBase(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de modificación \n" + e);
        }
        return respuesta;
    }

    public TableModel buscarTasacion() {
        DefaultTableModel modelo = new DefaultTableModel() {
            public boolean isCellEditable(int columnas, int filas) {
                return false;
            }
        };
        String sql = "";
        if (PanelTasacion.filtro.getSelectedItem() == "Todos") {
            sql = "SELECT t.idTasacion, t.fecha, (SELECT GROUP_CONCAT(CONCAT_WS(', ',(CONCAT_WS(' ', n.primerApellido, n.segundoApellido)),"
                    + "(CONCAT_WS(' ', n.primerNombre, n.segundoNombre)))) nombre FROM nombre n, "
                    + "cliente c WHERE n.idNombre = c.idNombre AND c.idCliente = t.idCliente), "
                    + "(SELECT GROUP_CONCAT(CONCAT_WS(' ', d.calle, d.numero, d.depto)) direccion FROM direccion d WHERE d.idDireccion = t.idDireccion), "
                    + "l.nombreLocalidad, tp.nombreTipoPropiedad, v.valorConstruccion, v.valorTerreno, v.valorTotal "
                    + "FROM tasacion t, cliente c, nombre n, direccion d, localidad l, tipoPropiedad tp, valoresTasacion v "
                    + "WHERE n.idNombre = c.idNombre AND c.idCliente = t.idCliente AND d.idDireccion = t.idDireccion "
                    + "AND l.idLocalidad = d.idLocalidad AND t.idTipoPropiedad = tp.idTipoPropiedad AND t.idValores = v.idValores ORDER BY t.idTasacion;";
        } else {
            if (PanelTasacion.filtro.getSelectedItem() == "Fecha") {
                sql = "SELECT t.idTasacion, t.fecha, (SELECT GROUP_CONCAT(CONCAT_WS(', ',(CONCAT_WS(' ', n.primerApellido, n.segundoApellido)),"
                        + "(CONCAT_WS(' ', n.primerNombre, n.segundoNombre)))) nombre FROM nombre n, "
                        + "cliente c WHERE n.idNombre = c.idNombre AND c.idCliente = t.idCliente), "
                        + "(SELECT GROUP_CONCAT(CONCAT_WS(' ', d.calle, d.numero, d.depto)) direccion FROM direccion d WHERE d.idDireccion = t.idDireccion), "
                        + "l.nombreLocalidad, tp.nombreTipoPropiedad, v.valorConstruccion, v.valorTerreno, v.valorTotal "
                        + "FROM tasacion t, cliente c, nombre n, direccion d, localidad l, tipoPropiedad tp, valoresTasacion v "
                        + "WHERE n.idNombre = c.idNombre AND c.idCliente = t.idCliente AND d.idDireccion = t.idDireccion "
                        + "AND l.idLocalidad = d.idLocalidad AND t.idTipoPropiedad = tp.idTipoPropiedad AND t.idValores = v.idValores "
                        + "AND t.fecha LIKE '%" + PanelTasacion.tfBuscar.getText() + "%' ORDER BY t.idTasacion;";

            } else {
                if (PanelTasacion.filtro.getSelectedItem() == "Cliente") {
                    sql = "SELECT t.idTasacion, t.fecha, (SELECT GROUP_CONCAT(CONCAT_WS(', ',(CONCAT_WS(' ', n.primerApellido, n.segundoApellido)),"
                            + "(CONCAT_WS(' ', n.primerNombre, n.segundoNombre)))) nombre FROM nombre n, "
                            + "cliente c WHERE n.idNombre = c.idNombre AND c.idCliente = t.idCliente), "
                            + "(SELECT GROUP_CONCAT(CONCAT_WS(' ', d.calle, d.numero, d.depto)) direccion FROM direccion d "
                            + "WHERE d.idDireccion = t.idDireccion), l.nombreLocalidad, tp.nombreTipoPropiedad, v.valorConstruccion, v.valorTerreno, v.valorTotal "
                            + "FROM tasacion t, cliente c, nombre n, direccion d, localidad l, tipoPropiedad tp, valoresTasacion v "
                            + "WHERE n.idNombre = c.idNombre AND c.idCliente = t.idCliente AND d.idDireccion = t.idDireccion AND l.idLocalidad = d.idLocalidad "
                            + "AND t.idTipoPropiedad = tp.idTipoPropiedad AND t.idValores = v.idValores "
                            + "AND (n.primerNombre LIKE '%" + PanelTasacion.tfBuscar.getText() + "%' OR n.segundoNombre "
                            + "LIKE '%" + PanelTasacion.tfBuscar.getText() + "%' OR n.primerApellido LIKE '%" + PanelTasacion.tfBuscar.getText() + "%' "
                            + "OR n.segundoApellido LIKE '%" + PanelTasacion.tfBuscar.getText() + "%') ORDER BY t.idTasacion;";
                } else {
                    if (PanelTasacion.filtro.getSelectedItem() == "Dirección") {
                        sql = "SELECT t.idTasacion, t.fecha, (SELECT GROUP_CONCAT(CONCAT_WS(', ',(CONCAT_WS(' ', n.primerApellido, n.segundoApellido)),"
                                + "(CONCAT_WS(' ', n.primerNombre, n.segundoNombre)))) nombre FROM nombre n, "
                                + "cliente c WHERE n.idNombre = c.idNombre AND c.idCliente = t.idCliente), "
                                + "(SELECT GROUP_CONCAT(CONCAT_WS(' ', d.calle, d.numero, d.depto)) direccion FROM direccion d WHERE d.idDireccion = t.idDireccion), "
                                + "l.nombreLocalidad, tp.nombreTipoPropiedad, v.valorConstruccion, v.valorTerreno, v.valorTotal "
                                + "FROM tasacion t, cliente c, nombre n, direccion d, localidad l, tipoPropiedad tp, valoresTasacion v "
                                + "WHERE n.idNombre = c.idNombre AND c.idCliente = t.idCliente AND d.idDireccion = t.idDireccion AND l.idLocalidad = d.idLocalidad "
                                + "AND t.idTipoPropiedad = tp.idTipoPropiedad AND t.idValores = v.idValores "
                                + "AND d.calle LIKE '%" + PanelTasacion.tfBuscar.getText() + "%' ORDER BY t.idTasacion;";
                    } else {
                        if (PanelTasacion.filtro.getSelectedItem() == "Localidad") {
                            sql = "SELECT t.idTasacion, t.fecha, (SELECT GROUP_CONCAT(CONCAT_WS(', ',(CONCAT_WS(' ', n.primerApellido, n.segundoApellido)),"
                                    + "(CONCAT_WS(' ', n.primerNombre, n.segundoNombre)))) nombre FROM nombre n, "
                                    + "cliente c WHERE n.idNombre = c.idNombre AND c.idCliente = t.idCliente), "
                                    + "(SELECT GROUP_CONCAT(CONCAT_WS(' ', d.calle, d.numero, d.depto)) direccion FROM direccion d WHERE d.idDireccion = t.idDireccion), "
                                    + "l.nombreLocalidad, tp.nombreTipoPropiedad, v.valorConstruccion, v.valorTerreno, v.valorTotal "
                                    + "FROM tasacion t, cliente c, nombre n, direccion d, localidad l, tipoPropiedad tp, valoresTasacion v "
                                    + "WHERE n.idNombre = c.idNombre AND c.idCliente = t.idCliente AND d.idDireccion = t.idDireccion AND l.idLocalidad = d.idLocalidad "
                                    + "AND t.idTipoPropiedad = tp.idTipoPropiedad AND t.idValores = v.idValores "
                                    + "AND l.nombreLocalidad LIKE '%" + PanelTasacion.tfBuscar.getText() + "%' ORDER BY t.idTasacion;";
                        } else {
                            if (PanelTasacion.filtro.getSelectedItem() == "Tipo de Propiedad") {
                                sql = "SELECT t.idTasacion, t.fecha, (SELECT GROUP_CONCAT(CONCAT_WS(', ',(CONCAT_WS(' ', n.primerApellido, n.segundoApellido)),"
                                        + "(CONCAT_WS(' ', n.primerNombre, n.segundoNombre)))) nombre FROM nombre n, "
                                        + "cliente c WHERE n.idNombre = c.idNombre AND c.idCliente = t.idCliente), "
                                        + "(SELECT GROUP_CONCAT(CONCAT_WS(' ', d.calle, d.numero, d.depto)) direccion FROM direccion d WHERE d.idDireccion = t.idDireccion), "
                                        + "l.nombreLocalidad, tp.nombreTipoPropiedad, v.valorConstruccion, v.valorTerreno, v.valorTotal "
                                        + "FROM tasacion t, cliente c, nombre n, direccion d, localidad l, tipoPropiedad tp, valoresTasacion v WHERE n.idNombre = c.idNombre "
                                        + "AND c.idCliente = t.idCliente AND d.idDireccion = t.idDireccion AND l.idLocalidad = d.idLocalidad "
                                        + "AND t.idTipoPropiedad = tp.idTipoPropiedad AND t.idValores = v.idValores "
                                        + "AND tp.nombreTipoPropiedad LIKE '%" + PanelTasacion.tfBuscar.getText() + "%' ORDER BY t.idTasacion;";
                            } else {

                            }
                        }
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
            modelo.addColumn("Cliente");
            modelo.addColumn("Dirección");
            modelo.addColumn("Localidad");
            modelo.addColumn("Tipo de Propiedad");
            modelo.addColumn("Valor Construcción");
            modelo.addColumn("Valor Terreno");
            modelo.addColumn("Valor Total");
            int cantColumnas = Columnas.getColumnCount();
            while (resultado.next()) {
                Object[] fila = new Object[cantColumnas];
                for (int i = 0; i < cantColumnas; i++) {
                    if (i == 6 || i == 7 || i == 8) {
                        DecimalFormat df = new DecimalFormat("###,###.##");
                        fila[i] = df.format(resultado.getObject(i + 1));
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

    public Double obtenerCoef(String estado, String años) {
        String est = estado.replace(".", "");
        Double coef = null;
        String sql = null;
        if (Integer.parseInt(años) > 100) {
            int cen = Integer.parseInt(años) / 100;
            int mod = Integer.parseInt(años) % 100;
            coef = (obtenerCoef(estado, "100") * cen) + obtenerCoef(estado, Integer.toString(mod));
        } else {
            int a = Integer.parseInt(años) + 1;
            sql = "SELECT " + "c" + est + " FROM tablaTasacion WHERE idTablaTasacion = " + a + "";

            try {
                Consulta consulta = new Consulta();
                ResultSet resultado = consulta.ConsultaBase(sql);
                if (resultado.next()) {
                    coef = (resultado.getDouble(1));
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error " + e);
            }
        }
        coef = coef / 100;
        return coef;
    }

    public TableModel tasacionXId(int id) {
        DefaultTableModel modelo = new DefaultTableModel();
        String sql = "SELECT t.fecha, c.dni, tp.nombreTipoPropiedad, d.calle, d.numero, d.depto, l.nombreLocalidad, cons.valorBolsa, "
                + "cons.valorM2Terreno, cons.valorResidual, da.años, da.estado, da.m2Construccion, da.m2Terreno "
                + "FROM tasacion t, cliente c, tipoPropiedad tp, direccion d, localidad l, constantesTasacion cons, datosTasacion da "
                + "WHERE t.idCliente = c.idCliente AND t.idTipoPropiedad = tp.idTipoPropiedad AND t.idDireccion = d.idDireccion "
                + "AND d.idLocalidad = l.idLocalidad AND t.idConstantes = cons.idConstantes AND t.idDatos = da.idDatos "
                + "AND t.idTasacion = '" + id + "';";
        try {
            Consulta consulta = new Consulta();
            ResultSet resultado = consulta.ConsultaBase(sql);
            ResultSetMetaData Columnas = resultado.getMetaData();
            modelo.addColumn("Fecha");
            modelo.addColumn("Cliente");
            modelo.addColumn("Tipo de Propiedad");
            modelo.addColumn("Calle");
            modelo.addColumn("Número");
            modelo.addColumn("Departamento");
            modelo.addColumn("Localidad");
            modelo.addColumn("Valor bolsa");
            modelo.addColumn("Valor M2 terreno");
            modelo.addColumn("Valor residual");
            modelo.addColumn("Años");
            modelo.addColumn("Estado");
            modelo.addColumn("M2 construcción");
            modelo.addColumn("M2 terreno");
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

    public int obtenerIdDirec(String i) {
        int id = 0;
        String sql = "SELECT idDireccion FROM tasacion WHERE idTasacion = '" + i + "';";
        try {
            Consulta consulta = new Consulta();
            ResultSet resultado = consulta.ConsultaBase(sql);
            if (resultado.next()) {
                id = resultado.getInt(1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }
        return id;
    }

    public boolean existeConstantes(Tasacion t) {
        boolean respuesta = false;
        String sql = "SELECT * FROM constantesTasacion WHERE valorBolsa= '" + t.getValorBolsa() + "' "
                + "AND valorM2Terreno= '" + t.getValorM2Terreno() + "' AND valorResidual= '" + t.getValorResidual() + "'";
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

    public boolean existeDatos(Tasacion t) {
        boolean respuesta = false;
        String sql = "SELECT * FROM datosTasacion WHERE años= '" + t.getAños() + "' "
                + "AND estado= '" + t.getEstado() + "' AND m2Construccion= '" + t.getM2Construccion() + "' "
                + "AND m2Terreno= '" + t.getM2Terreno() + "';";
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

    public int obtenerIdConstantes(Tasacion t) {
        int id = 0;
        String sql = "SELECT idConstantes FROM constantesTasacion WHERE valorBolsa= '" + t.getValorBolsa() + "' "
                + "AND valorM2Terreno= '" + t.getValorM2Terreno() + "' AND valorResidual= '" + t.getValorResidual() + "'";
        try {
            Consulta consulta = new Consulta();
            ResultSet resultado = consulta.ConsultaBase(sql);
            if (resultado.next()) {
                id = resultado.getInt(1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }
        return id;
    }

    public int obtenerIdDatos(Tasacion t) {
        int id = 0;
        String sql = "SELECT idDatos FROM datosTasacion WHERE años= '" + t.getAños() + "' "
                + "AND estado= '" + t.getEstado() + "' AND m2Construccion= '" + t.getM2Construccion() + "' "
                + "AND m2Terreno= '" + t.getM2Terreno() + "'";
        try {
            Consulta consulta = new Consulta();
            ResultSet resultado = consulta.ConsultaBase(sql);
            if (resultado.next()) {
                id = resultado.getInt(1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }
        return id;
    }

    public int obtenerIdValores(Tasacion t) {
        int id = 0;
        String sql = "SELECT idValores FROM valoresTasacion WHERE valorConstruccion = '" + t.getValorConstruccion() + "' "
                + "AND valorTerreno = '" + t.getValorTerreno() + "' AND valorTotal = '" + t.getValorTotal() + "';";
        try {
            Consulta consulta = new Consulta();
            ResultSet resultado = consulta.ConsultaBase(sql);
            if (resultado.next()) {
                id = resultado.getInt(1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }
        return id;
    }

    public int obtenerIdTasacion(Tasacion t) {
        int id = 0;
        String sql = "SELECT idTasacion FROM tasacion WHERE fecha= '" + t.getFecha() + "' AND idCliente= '" + t.getIdCliente() + "' "
                + "AND idDireccion= '" + t.getIdDireccion() + "' AND idTipoPropiedad= '" + t.getIdTipoPropiedad() + "' "
                + "AND idCategoria= '" + t.getIdCategoria() + "';";
        try {
            Consulta consulta = new Consulta();
            ResultSet resultado = consulta.ConsultaBase(sql);
            if (resultado.next()) {
                id = resultado.getInt(1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }
        return id;
    }

    public TableModel imprimir() {
        DefaultTableModel modelo = new DefaultTableModel() {
            public boolean isCellEditable(int columnas, int filas) {
                return false;
            }
        };
        String sql = "";
        if (FormReportes.filtro.getSelectedItem() == "Todos") {
            sql = "SELECT t.idTasacion, t.fecha, (SELECT GROUP_CONCAT(CONCAT_WS(', ',(CONCAT_WS(' ', n.primerApellido, n.segundoApellido)),"
                    + "(CONCAT_WS(' ', n.primerNombre, n.segundoNombre)))) nombre FROM nombre n, "
                    + "cliente c WHERE n.idNombre = c.idNombre AND c.idCliente = t.idCliente), "
                    + "(SELECT GROUP_CONCAT(CONCAT_WS(' ', d.calle, d.numero, d.depto)) direccion FROM direccion d WHERE d.idDireccion = t.idDireccion), "
                    + "l.nombreLocalidad, tp.nombreTipoPropiedad, v.valorConstruccion, v.valorTerreno, v.valorTotal "
                    + "FROM tasacion t, cliente c, nombre n, direccion d, localidad l, tipoPropiedad tp, valoresTasacion v "
                    + "WHERE n.idNombre = c.idNombre AND c.idCliente = t.idCliente AND d.idDireccion = t.idDireccion AND l.idLocalidad = d.idLocalidad "
                    + "AND t.idTipoPropiedad = tp.idTipoPropiedad AND t.idValores = v.idValores";
        } else {
            if (FormReportes.filtro.getSelectedItem() == "Fecha") {
                sql = "SELECT t.idTasacion, t.fecha, (SELECT GROUP_CONCAT(CONCAT_WS(', ',(CONCAT_WS(' ', n.primerApellido, n.segundoApellido)),"
                        + "(CONCAT_WS(' ', n.primerNombre, n.segundoNombre)))) nombre FROM nombre n, "
                        + "cliente c WHERE n.idNombre = c.idNombre AND c.idCliente = t.idCliente), "
                        + "(SELECT GROUP_CONCAT(CONCAT_WS(' ', d.calle, d.numero, d.depto)) direccion FROM direccion d WHERE d.idDireccion = t.idDireccion),"
                        + "l.nombreLocalidad, tp.nombreTipoPropiedad, v.valorConstruccion, v.valorTerreno, v.valorTotal "
                        + "FROM tasacion t, cliente c, nombre n, direccion d, localidad l, tipoPropiedad tp, valoresTasacion v "
                        + "WHERE n.idNombre = c.idNombre AND c.idCliente = t.idCliente AND d.idDireccion = t.idDireccion AND l.idLocalidad = d.idLocalidad "
                        + "AND t.idTipoPropiedad = tp.idTipoPropiedad AND t.idValores = v.idValores "
                        + "AND t.fecha LIKE '%" + FormReportes.tFiltro.getText() + "%'";

            } else {
                if (FormReportes.filtro.getSelectedItem() == "Cliente") {
                    sql = "SELECT t.idTasacion, t.fecha, (SELECT GROUP_CONCAT(CONCAT_WS(', ',(CONCAT_WS(' ', n.primerApellido, n.segundoApellido)),"
                            + "(CONCAT_WS(' ', n.primerNombre, n.segundoNombre)))) nombre FROM nombre n, "
                            + "cliente c WHERE n.idNombre = c.idNombre AND c.idCliente = t.idCliente), "
                            + "(SELECT GROUP_CONCAT(CONCAT_WS(' ', d.calle, d.numero, d.depto)) direccion FROM direccion d WHERE d.idDireccion = t.idDireccion), "
                            + "l.nombreLocalidad, tp.nombreTipoPropiedad, v.valorConstruccion, v.valorTerreno, v.valorTotal "
                            + "FROM tasacion t, cliente c, nombre n, direccion d, localidad l, tipoPropiedad tp, valoresTasacion v "
                            + "WHERE n.idNombre = c.idNombre AND c.idCliente = t.idCliente AND d.idDireccion = t.idDireccion AND l.idLocalidad = d.idLocalidad "
                            + "AND t.idTipoPropiedad = tp.idTipoPropiedad AND t.idValores = v.idValores "
                            + "AND (n.primerNombre LIKE '%" + FormReportes.tFiltro.getText() + "%' OR n.segundoNombre LIKE '%" + FormReportes.tFiltro.getText() + "%' "
                            + "OR n.primerApellido LIKE '%" + FormReportes.tFiltro.getText() + "%' OR n.segundoApellido LIKE '%" + FormReportes.tFiltro.getText() + "%')";
                } else {
                    if (FormReportes.filtro.getSelectedItem() == "Localidad") {
                        sql = "SELECT t.idTasacion, t.fecha, (SELECT GROUP_CONCAT(CONCAT_WS(', ',(CONCAT_WS(' ', n.primerApellido, n.segundoApellido)),"
                                + "(CONCAT_WS(' ', n.primerNombre, n.segundoNombre)))) nombre FROM nombre n, "
                                + "cliente c WHERE n.idNombre = c.idNombre AND c.idCliente = t.idCliente), "
                                + "(SELECT GROUP_CONCAT(CONCAT_WS(' ', d.calle, d.numero, d.depto)) direccion FROM direccion d WHERE d.idDireccion = t.idDireccion), "
                                + "l.nombreLocalidad, tp.nombreTipoPropiedad, v.valorConstruccion, v.valorTerreno, v.valorTotal "
                                + "FROM tasacion t, cliente c, nombre n, direccion d, localidad l, tipoPropiedad tp, valoresTasacion v "
                                + "WHERE n.idNombre = c.idNombre AND c.idCliente = t.idCliente AND d.idDireccion = t.idDireccion AND l.idLocalidad = d.idLocalidad "
                                + "AND t.idTipoPropiedad = tp.idTipoPropiedad AND t.idValores = v.idValores "
                                + "AND l.nombreLocalidad LIKE '%" + FormReportes.tFiltro.getText() + "%'";
                    } else {
                        if (FormReportes.filtro.getSelectedItem() == "Tipo de Propiedad") {
                            sql = "SELECT t.idTasacion, t.fecha, (SELECT GROUP_CONCAT(CONCAT_WS(', ',(CONCAT_WS(' ', n.primerApellido, n.segundoApellido)),"
                                    + "(CONCAT_WS(' ', n.primerNombre, n.segundoNombre)))) nombre FROM nombre n, "
                                    + "cliente c WHERE n.idNombre = c.idNombre AND c.idCliente = t.idCliente), "
                                    + "(SELECT GROUP_CONCAT(CONCAT_WS(' ', d.calle, d.numero, d.depto)) direccion FROM direccion d WHERE d.idDireccion = t.idDireccion), "
                                    + "l.nombreLocalidad, tp.nombreTipoPropiedad, v.valorConstruccion, v.valorTerreno, v.valorTotal "
                                    + "FROM tasacion t, cliente c, nombre n, direccion d, localidad l, tipoPropiedad tp, valoresTasacion v "
                                    + "WHERE n.idNombre = c.idNombre AND c.idCliente = t.idCliente AND d.idDireccion = t.idDireccion AND l.idLocalidad = d.idLocalidad "
                                    + "AND t.idTipoPropiedad = tp.idTipoPropiedad AND t.idValores = v.idValores "
                                    + "AND tp.nombreTipoPropiedad LIKE '%" + FormReportes.tFiltro.getText() + "%'";
                        } else {

                        }
                    }
                }
            }
        }

        if (FormReportes.ordenar.getSelectedIndex() == 0) {
            sql = sql + " ORDER BY t.idTasacion";
        } else if (FormReportes.ordenar.getSelectedItem() == "Fecha") {
            sql = sql + " ORDER BY t.fecha";
        } else if (FormReportes.ordenar.getSelectedItem() == "Cliente") {
            sql = sql + " ORDER BY c.idCliente";
        } else if (FormReportes.ordenar.getSelectedItem() == "Localidad") {
            sql = sql + " ORDER BY l.nombreLocalidad";
        } else if (FormReportes.ordenar.getSelectedItem() == "Tipo de Propiedad") {
            sql = sql + " ORDER BY tp.nombreTipoPropiedad";
        }
        try {
            Consulta consulta = new Consulta();
            ResultSet resultado = consulta.ConsultaBase(sql);
            ResultSetMetaData Columnas = resultado.getMetaData();
            modelo.addColumn("Id");
            modelo.addColumn("Fecha");
            modelo.addColumn("Cliente");
            modelo.addColumn("Dirección");
            modelo.addColumn("Localidad");
            modelo.addColumn("Tipo de Propiedad");
            modelo.addColumn("Valor Construcción");
            modelo.addColumn("Valor Terreno");
            modelo.addColumn("Valor Total");
            int cantColumnas = Columnas.getColumnCount();
            while (resultado.next()) {
                Object[] fila = new Object[cantColumnas];
                for (int i = 0; i < cantColumnas; i++) {
                    if (i == 6 || i == 7 || i == 8) {
                        DecimalFormat df = new DecimalFormat("###,###");
                        fila[i] = "$ " + df.format(resultado.getObject(i + 1));
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
