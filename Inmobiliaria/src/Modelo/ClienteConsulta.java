package Modelo;

import javax.swing.JOptionPane;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import Vista.PanelCliente;
import java.sql.ResultSetMetaData;
import Vista.BuscarCliente;
import Vista.FormReportes;

/**
 *
 * @author Camila Carrero
 */
public class ClienteConsulta {

    public boolean registrar(Cliente cli) {
        registrarNombre(cli);
        registrarTelefono(cli);
        String sql = "INSERT INTO cliente (idNombre, dni, idTelefono, idDireccion, correo, idTipoCliente) "
                + "VALUES ((SELECT idNombre FROM nombre WHERE primerNombre = '" + cli.getPrimerNombre() + "' "
                + "AND segundoNombre= '" + cli.getSegundoNombre() + "' AND primerApellido = '" + cli.getPrimerApellido() + "' "
                + "AND segundoApellido = '" + cli.getSegundoApellido() + "'), "
                + "'" + cli.getDni() + "', (SELECT idTelefono FROM telefono WHERE telefonoPrincipal = '" + cli.getTelefonoPrincipal() + "'), "
                + "'" + cli.getIdDireccion() + "', '" + cli.getCorreo() + "', '" + cli.getIdTipoCliente() + "')";
        boolean respuesta = true;
        try {
            Consulta consulta = new Consulta();
            respuesta = consulta.InsercionBase(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de registro \n" + e);
        }
        return respuesta;
    }

    public boolean registrarNombre(Cliente cli) {
        String sql = "INSERT INTO nombre(primerNombre, segundoNombre, primerApellido, segundoApellido) "
                + "VALUES ('" + cli.getPrimerNombre() + "', '" + cli.getSegundoNombre() + "', '" + cli.getPrimerApellido() + "', "
                + "'" + cli.getSegundoApellido() + "');";
        boolean respuesta = true;
        try {
            Consulta consulta = new Consulta();
            respuesta = consulta.InsercionBase(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de registro \n" + e);
        }
        return respuesta;
    }

    public boolean registrarTelefono(Cliente cli) {
        String sql = "";
        if (cli.getTelefonoSecundario() == 0 || cli.getTelefonoSecundario() == '0') {
            sql = "INSERT INTO telefono(telefonoPrincipal) VALUES ('" + cli.getTelefonoPrincipal() + "');";
        } else {
            sql = "INSERT INTO telefono(telefonoPrincipal,telefonoSecundario) VALUES ('" + cli.getTelefonoPrincipal() + "', " + cli.getTelefonoSecundario() + ");";
        }
        boolean respuesta = true;
        try {
            Consulta consulta = new Consulta();
            respuesta = consulta.InsercionBase(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de registro \n" + e);
        }
        return respuesta;
    }

    public boolean clienteExiste(Cliente cli) {
        boolean respuesta = false;
        String sql = "SELECT dni FROM cliente WHERE dni='" + cli.getDni() + "'";
        ResultSet resultado = null;
        try {
            Consulta consulta = new Consulta();
            resultado = consulta.ConsultaBase(sql);
            while (resultado.next()) {
                respuesta = true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }
        return respuesta;
    }

    public boolean eliminar(Cliente cli) {
        String sql = "DELETE FROM cliente WHERE dni='" + cli.getDni() + "'";
        boolean respuesta = true;
        try {
            Consulta consulta = new Consulta();
            respuesta = consulta.EliminacionBase(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la eliminación \n" + e);

        }
        return respuesta;
    }

    public boolean modificar(Cliente cli) {
        modificarNombre(cli);
        modificarTelefono(cli);
        String sql = "UPDATE cliente SET dni= '" + cli.getDni() + "', correo = '" + cli.getCorreo() + "', idTipoCliente = '" + cli.getIdTipoCliente() + "' "
                + "where idCliente= '" + cli.getIdCliente() + "';";
        boolean respuesta = true;
        try {
            Consulta consulta = new Consulta();
            respuesta = consulta.ActualizacionBase(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de modificación \n" + e);
        }
        return respuesta;
    }

    public boolean modificarNombre(Cliente cli) {
        String sql = "UPDATE nombre SET primerNombre = '" + cli.getPrimerNombre() + "', segundoNombre= '" + cli.getSegundoNombre() + "', "
                + "primerApellido = '" + cli.getPrimerApellido() + "', segundoApellido = '" + cli.getSegundoApellido() + "' "
                + "WHERE idNombre= (SELECT idNombre FROM cliente where idCliente= '" + cli.getIdCliente() + "');";
        boolean respuesta = true;
        try {
            Consulta consulta = new Consulta();
            respuesta = consulta.ActualizacionBase(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de modificación \n" + e);
        }
        return respuesta;
    }

    public boolean modificarTelefono(Cliente cli) {
        String sql = "";
        if (cli.getTelefonoSecundario() == 0 || cli.getTelefonoSecundario() == '0') {
            sql = "UPDATE telefono SET telefonoPrincipal= '" + cli.getTelefonoPrincipal() + "' "
                    + "WHERE idTelefono= (SELECT idTelefono FROM cliente WHERE idCliente= '" + cli.getIdCliente() + "');";
        } else {
            sql = "UPDATE telefono SET telefonoPrincipal= '" + cli.getTelefonoPrincipal() + "', telefonoSecundario = '" + cli.getTelefonoSecundario() + "' "
                    + "WHERE idTelefono= (SELECT idTelefono FROM cliente WHERE idCliente= '" + cli.getIdCliente() + "');";
        }
        boolean respuesta = true;
        try {
            Consulta consulta = new Consulta();
            respuesta = consulta.ActualizacionBase(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de modificación \n" + e);
        }
        return respuesta;
    }

    public TableModel buscarClientePanel() {
        DefaultTableModel modelo = new DefaultTableModel() {
            public boolean isCellEditable(int columnas, int filas) {
                return false;
            }
        };
        String sql = "";
        if (PanelCliente.filtro.getSelectedItem() == "Todos") {
            sql = " SELECT c.idcliente, tc.nombreTipoCliente, (SELECT GROUP_CONCAT(CONCAT_WS(', ',(CONCAT_WS(' ', n.primerApellido, n.segundoApellido)),"
                    + "(CONCAT_WS(' ', n.primerNombre, n.segundoNombre)))) nombre FROM nombre n WHERE n.idNombre = c.idNombre  ), c.dni,"
                    + "(SELECT GROUP_CONCAT(CONCAT_WS(' ', d.calle, d.numero, d.depto)) direccion FROM direccion d WHERE d.idDireccion = c.idDireccion), "
                    + "l.nombreLocalidad, t.telefonoPrincipal, t.telefonoSecundario, c.correo\n"
                    + "FROM cliente c, nombre n, telefono t, direccion d, localidad l, tipoCliente tc WHERE d.idLocalidad = l.idLocalidad "
                    + "AND c.idNombre = n.idNombre AND c.idTelefono = t.idTelefono AND c.idDireccion = d.idDireccion "
                    + "AND c.idTipoCliente = tc.idTipoCliente ORDER BY c.idCliente;";
        } else {
            if (PanelCliente.filtro.getSelectedItem() == "Nombre") {
                sql = "SELECT c.idcliente, tc.nombreTipoCliente, (SELECT GROUP_CONCAT(CONCAT_WS(', ',(CONCAT_WS(' ', n.primerApellido, n.segundoApellido)),"
                        + "(CONCAT_WS(' ', n.primerNombre, n.segundoNombre)))) nombre FROM nombre n WHERE n.idNombre = c.idNombre  ) , c.dni, "
                        + "(SELECT GROUP_CONCAT(CONCAT_WS(' ', d.calle, d.numero, d.depto)) direccion FROM direccion d WHERE d.idDireccion = c.idDireccion) , "
                        + "l.nombreLocalidad, t.telefonoPrincipal, t.telefonoSecundario, c.correo\n"
                        + "FROM cliente c, nombre n, telefono t, direccion d, localidad l, tipoCliente tc WHERE d.idLocalidad = l.idLocalidad "
                        + "AND c.idNombre = n.idNombre AND c.idTelefono = t.idTelefono AND c.idDireccion = d.idDireccion AND c.idTipoCliente = tc.idTipoCliente \n"
                        + " AND (n.primerNombre LIKE '%" + PanelCliente.tfBuscar.getText() + "%' OR n.segundoNombre LIKE '%" + PanelCliente.tfBuscar.getText() + "%' "
                        + "OR n.primerApellido LIKE '%" + PanelCliente.tfBuscar.getText() + "%' OR n.segundoApellido "
                        + "LIKE '%" + PanelCliente.tfBuscar.getText() + "%') ORDER BY c.idCliente";
            } else {
                if (PanelCliente.filtro.getSelectedItem() == "Dni") {
                    sql = "SELECT c.idcliente, tc.nombreTipoCliente, (SELECT GROUP_CONCAT(CONCAT_WS(', ',(CONCAT_WS(' ', n.primerApellido, n.segundoApellido)),"
                            + "(CONCAT_WS(' ', n.primerNombre, n.segundoNombre)))) nombre FROM nombre n WHERE n.idNombre = c.idNombre  ), c.dni, "
                            + "(SELECT GROUP_CONCAT(CONCAT_WS(' ', d.calle, d.numero, d.depto)) direccion FROM direccion d WHERE d.idDireccion = c.idDireccion) , "
                            + "l.nombreLocalidad, t.telefonoPrincipal, t.telefonoSecundario, c.correo\n"
                            + "FROM cliente c, nombre n, telefono t, direccion d, localidad l, tipoCliente tc WHERE d.idLocalidad = l.idLocalidad "
                            + "AND c.idNombre = n.idNombre AND c.idTelefono = t.idTelefono AND c.idDireccion = d.idDireccion AND c.idTipoCliente = tc.idTipoCliente \n"
                            + "AND dni LIKE '%" + PanelCliente.tfBuscar.getText() + "%' ORDER BY c.idCliente";
                } else {
                    if (PanelCliente.filtro.getSelectedItem() == "Tipo de Cliente") {
                        sql = "SELECT c.idcliente, tc.nombreTipoCliente,(SELECT GROUP_CONCAT(CONCAT_WS(', ',(CONCAT_WS(' ', n.primerApellido, n.segundoApellido)),"
                                + "(CONCAT_WS(' ', n.primerNombre, n.segundoNombre)))) nombre FROM nombre n WHERE n.idNombre = c.idNombre  ) , c.dni,"
                                + "(SELECT GROUP_CONCAT(CONCAT_WS(' ', d.calle, d.numero, d.depto)) direccion FROM direccion d WHERE d.idDireccion = c.idDireccion) , "
                                + "l.nombreLocalidad, t.telefonoPrincipal, t.telefonoSecundario, c.correo\n"
                                + "FROM cliente c, nombre n, telefono t, direccion d, localidad l, tipoCliente tc WHERE d.idLocalidad = l.idLocalidad "
                                + "AND c.idNombre = n.idNombre AND c.idTelefono = t.idTelefono AND c.idDireccion = d.idDireccion and c.idTipoCliente = tc.idTipoCliente \n"
                                + "AND tc.nombreTipoCliente LIKE '%" + PanelCliente.tfBuscar.getText() + "%' ORDER BY c.idCliente";
                    } else {
                        if (PanelCliente.filtro.getSelectedItem() == "Localidad") {
                            sql = "SELECT c.idcliente, tc.nombreTipoCliente,(SELECT GROUP_CONCAT(CONCAT_WS(', ',(CONCAT_WS(' ', n.primerApellido, n.segundoApellido)),"
                                    + "(CONCAT_WS(' ', n.primerNombre, n.segundoNombre)))) nombre FROM nombre n WHERE n.idNombre = c.idNombre  ) , c.dni,"
                                    + "(SELECT GROUP_CONCAT(CONCAT_WS(' ', d.calle, d.numero, d.depto)) direccion FROM direccion d WHERE d.idDireccion = c.idDireccion) , "
                                    + "l.nombreLocalidad, t.telefonoPrincipal, t.telefonoSecundario, c.correo\n"
                                    + "FROM cliente c, nombre n, telefono t, direccion d, localidad l, tipoCliente tc WHERE d.idLocalidad = l.idLocalidad "
                                    + "AND c.idNombre = n.idNombre AND c.idTelefono = t.idTelefono AND c.idDireccion = d.idDireccion AND c.idTipoCliente = tc.idTipoCliente \n"
                                    + "AND l.nombreLocalidad LIKE '%" + PanelCliente.tfBuscar.getText() + "%' ORDER BY c.idCliente";
                        } else {
                            if (PanelCliente.filtro.getSelectedItem() == "Dirección") {
                                sql = "SELECT c.idcliente, tc.nombreTipoCliente,(SELECT GROUP_CONCAT(CONCAT_WS(', ',(CONCAT_WS(' ', n.primerApellido, n.segundoApellido)),"
                                        + "(CONCAT_WS(' ', n.primerNombre, n.segundoNombre)))) nombre FROM nombre n WHERE n.idNombre = c.idNombre  ) , c.dni,"
                                        + "(SELECT GROUP_CONCAT(CONCAT_WS(' ', d.calle, d.numero, d.depto)) direccion FROM direccion d WHERE d.idDireccion = c.idDireccion) , "
                                        + "l.nombreLocalidad, t.telefonoPrincipal, t.telefonoSecundario, c.correo\n"
                                        + "FROM cliente c, nombre n, telefono t, direccion d, localidad l, tipoCliente tc WHERE d.idLocalidad = l.idLocalidad "
                                        + "AND c.idNombre = n.idNombre AND c.idTelefono = t.idTelefono AND c.idDireccion = d.idDireccion AND c.idTipoCliente = tc.idTipoCliente \n"
                                        + "AND d.calle LIKE '%" + PanelCliente.tfBuscar.getText() + "%'";
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
            modelo.addColumn("Tipo de Cliente");
            modelo.addColumn("Nombre");
            modelo.addColumn("DNI");
            modelo.addColumn("Dirección");
            modelo.addColumn("Localidad");
            modelo.addColumn("Teléfono Principal");
            modelo.addColumn("Teléfono Secundario");
            modelo.addColumn("Correo");
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

    public TableModel buscarClienteX() {
        DefaultTableModel modelo = new DefaultTableModel() {
            public boolean isCellEditable(int columnas, int filas) {
                return false;
            }
        };
        String sql = "";
        if (BuscarCliente.filtro.getSelectedItem() == "Todos") {
            sql = "SELECT c.idcliente, tc.nombreTipoCliente, (SELECT GROUP_CONCAT(CONCAT_WS(', ',(CONCAT_WS(' ', n.primerApellido, n.segundoApellido)),"
                    + "(CONCAT_WS(' ', n.primerNombre, n.segundoNombre)))) nombre FROM nombre n WHERE n.idNombre = c.idNombre  ), c.dni \n"
                    + "FROM cliente c, nombre n, tipoCliente tc WHERE c.idNombre = n.idNombre AND c.idTipoCliente = tc.idTipoCliente;";
        } else {
            if (BuscarCliente.filtro.getSelectedItem() == "Nombre") {
                sql = "SELECT c.idcliente, tc.nombreTipoCliente, (SELECT GROUP_CONCAT(CONCAT_WS(', ',(CONCAT_WS(' ', n.primerApellido, n.segundoApellido)),"
                        + "(CONCAT_WS(' ', n.primerNombre, n.segundoNombre)))) nombre FROM nombre n WHERE n.idNombre = c.idNombre  ), c.dni \n"
                        + "FROM cliente c, nombre n, tipoCliente tc WHERE c.idNombre = n.idNombre AND c.idTipoCliente = tc.idTipoCliente \n"
                        + " AND n.primerNombre LIKE '%" + BuscarCliente.tfBuscar.getText() + "%' OR n.segundoNombre LIKE '%" + BuscarCliente.tfBuscar.getText() + "%' OR n.primerApellido LIKE '%" + BuscarCliente.tfBuscar.getText() + "%' OR n.segundoApellido LIKE '%" + BuscarCliente.tfBuscar.getText() + "%'";
            } else {
                if (BuscarCliente.filtro.getSelectedItem() == "Dni") {
                    sql = "SELECT c.idcliente, tc.nombreTipoCliente, (SELECT GROUP_CONCAT(CONCAT_WS(', ',(CONCAT_WS(' ', n.primerApellido, n.segundoApellido)),"
                            + "(CONCAT_WS(' ', n.primerNombre, n.segundoNombre)))) nombre FROM nombre n WHERE n.idNombre = c.idNombre  ), c.dni \n"
                            + "FROM cliente c, nombre n, tipoCliente tc WHERE c.idNombre = n.idNombre AND c.idTipoCliente = tc.idTipoCliente \n"
                            + "AND dni LIKE '%" + BuscarCliente.tfBuscar.getText() + "%'";
                } else {
                    if (BuscarCliente.filtro.getSelectedItem() == "Tipo de Cliente") {
                        sql = "SELECT c.idcliente, tc.nombreTipoCliente, (SELECT GROUP_CONCAT(CONCAT_WS(', ',(CONCAT_WS(' ', n.primerApellido, n.segundoApellido)),"
                                + "(CONCAT_WS(' ', n.primerNombre, n.segundoNombre)))) nombre FROM nombre n WHERE n.idNombre = c.idNombre  ), c.dni \n"
                                + "FROM cliente c, nombre n, tipoCliente tc WHERE c.idNombre = n.idNombre AND c.idTipoCliente = tc.idTipoCliente \n"
                                + "AND tc.nombreTipoCliente LIKE '%" + BuscarCliente.tfBuscar.getText() + "%'";
                    }
                }
            }
        }
        try {
            Consulta consulta = new Consulta();
            ResultSet resultado = consulta.ConsultaBase(sql);
            ResultSetMetaData Columnas = resultado.getMetaData();
            modelo.addColumn("Id");
            modelo.addColumn("Tipo de Cliente");
            modelo.addColumn("Nombre");
            modelo.addColumn("DNI");
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

    public TableModel clienteXId(String id) {
        DefaultTableModel modelo = new DefaultTableModel();
        String sql = "SELECT c.idCliente, tc.nombreTipoCliente, n.primerNombre, n.segundoNombre, n.primerApellido, n.segundoApellido, c.dni, "
                + "d.calle, d.numero, d.depto, l.nombreLocalidad, t.telefonoPrincipal, t.telefonoSecundario, c.correo FROM cliente c, "
                + "tipoCliente tc, nombre n, direccion d, localidad l, telefono t WHERE c.idTipoCliente = tc.idTipoCliente "
                + "AND c.idNombre = n.idNombre AND c.idDireccion = d.idDireccion AND d.idLocalidad = l.idLocalidad "
                + "AND c.idTelefono = t.idTelefono AND idCliente='" + id + "'";
        try {
            Consulta consulta = new Consulta();
            ResultSet resultado = consulta.ConsultaBase(sql);
            ResultSetMetaData Columnas = resultado.getMetaData();
            modelo.addColumn("Id");
            modelo.addColumn("Tipo de Cliente");
            modelo.addColumn("Primer Nombre");
            modelo.addColumn("Segundo Nombre");
            modelo.addColumn("Primer Apellido");
            modelo.addColumn("Segundo Apellido");
            modelo.addColumn("DNI");
            modelo.addColumn("Calle");
            modelo.addColumn("Número");
            modelo.addColumn("Departamento");
            modelo.addColumn("Localidad");
            modelo.addColumn("Telefono Principal");
            modelo.addColumn("Telefono Secundario");
            modelo.addColumn("Correo");
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

    public int obtenerId(String dni) {
        ResultSet resultado = null;
        int id = 0;
        String sql = "SELECT idCliente FROM cliente WHERE dni= '" + dni + "'";
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

    public boolean existeTel(String id) {
        boolean respuesta = false;
        String sql = "SELECT t.telefonoSecundario FROM telefono t, cliente c WHERE c.idCliente='" + id + "' AND t.idTelefono = c.idTelefono";
        ResultSet resultado = null;
        try {
            Consulta consulta = new Consulta();
            resultado = consulta.ConsultaBase(sql);
            while (resultado.next()) {
                if (resultado.getDate("telefonoSecundario") != null) {
                    respuesta = true;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }
        return respuesta;
    }

    public String obtenerDni(String nombre, int id, String form) {
        ResultSet resultado = null;
        String sql = null;
        String dni = null;
        sql = "SELECT c.dni FROM cliente c, nombre n WHERE (SELECT GROUP_CONCAT(CONCAT_WS(', ',(CONCAT_WS(' ', n.primerApellido, n.segundoApellido)),"
                + "(CONCAT_WS(' ', n.primerNombre, n.segundoNombre)))) nombre FROM nombre n, cliente c WHERE n.idNombre = c.idNombre "
                + "AND c.idCliente = '" + id + "') = '" + nombre + "' AND n.idNombre = c.idNombre AND c.idCliente = '" + id + "';";
        try {
            Consulta consulta = new Consulta();
            resultado = consulta.ConsultaBase(sql);
            if (resultado.next()) {
                dni = Integer.toString(resultado.getInt(1));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }
        return dni;
    }

    public int obtenerDireccion(Cliente c) {
        ResultSet resultado = null;
        String sql = null;
        int id = 0;
        sql = "SELECT idDireccion FROM cliente WHERE idCliente = '" + c.getIdCliente() + "';";
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

    public TableModel clienteTasacion(int id) {
        DefaultTableModel modelo = new DefaultTableModel();
        String sql = "SELECT c.idCliente, (SELECT GROUP_CONCAT(CONCAT_WS(', ',(CONCAT_WS(' ', n.primerApellido, n.segundoApellido)),"
                + "(CONCAT_WS(' ', n.primerNombre, n.segundoNombre)))) nombre FROM nombre n WHERE n.idNombre = c.idNombre), c.dni, "
                + "(SELECT GROUP_CONCAT(CONCAT_WS(' ', d.calle, d.numero, d.depto)) direccion FROM direccion d "
                + "WHERE d.idDireccion = c.idDireccion), l.nombreLocalidad FROM cliente c, nombre n, direccion d, localidad l, tasacion t "
                + "WHERE  c.idNombre = n.idNombre AND c.idDireccion = d.idDireccion AND d.idLocalidad = l.idLocalidad "
                + "AND c.idCliente= t.idCliente AND t.idTasacion = '" + id + "'";
        try {
            Consulta consulta = new Consulta();
            ResultSet resultado = consulta.ConsultaBase(sql);
            ResultSetMetaData Columnas = resultado.getMetaData();
            modelo.addColumn("Id");
            modelo.addColumn("Nombre");
            modelo.addColumn("DNI");
            modelo.addColumn("Dirección");
            modelo.addColumn("Localidad");
            int cantColumnas = Columnas.getColumnCount();
            while (resultado.next()) {
                Object[] fila = new Object[cantColumnas];
                for (int i = 0; i < cantColumnas; i++) {
                    fila[i] = resultado.getObject(i + 1);
                }
                modelo.addRow(fila);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }
        return modelo;
    }

    public TableModel imprimir() {
        DefaultTableModel modelo = new DefaultTableModel() {
            public boolean isCellEditable(int columnas, int filas) {
                return false;
            }
        };
        String sql = "";
        if (FormReportes.filtro.getSelectedItem() == "Todos") {
            sql = " SELECT c.idcliente, tc.nombreTipoCliente, (SELECT GROUP_CONCAT(CONCAT_WS(', ',(CONCAT_WS(' ', n.primerApellido, n.segundoApellido)),"
                    + "(CONCAT_WS(' ', n.primerNombre, n.segundoNombre)))) nombre FROM nombre n WHERE n.idNombre = c.idNombre  ), c.dni,"
                    + "(SELECT GROUP_CONCAT(CONCAT_WS(' ', d.calle, d.numero, d.depto)) direccion FROM direccion d WHERE d.idDireccion = c.idDireccion), "
                    + "l.nombreLocalidad, t.telefonoPrincipal, t.telefonoSecundario, c.correo\n"
                    + "FROM cliente c, nombre n, telefono t, direccion d, localidad l, tipoCliente tc WHERE d.idLocalidad = l.idLocalidad "
                    + "AND c.idNombre = n.idNombre AND c.idTelefono = t.idTelefono AND c.idDireccion = d.idDireccion "
                    + "AND c.idTipoCliente = tc.idTipoCliente";
        } else if (FormReportes.filtro.getSelectedItem() == "Nombre") {
            sql = "SELECT c.idcliente, tc.nombreTipoCliente, (SELECT GROUP_CONCAT(CONCAT_WS(', ',(CONCAT_WS(' ', n.primerApellido, n.segundoApellido)),"
                    + "(CONCAT_WS(' ', n.primerNombre, n.segundoNombre)))) nombre FROM nombre n WHERE n.idNombre = c.idNombre  ) , c.dni, "
                    + "(SELECT GROUP_CONCAT(CONCAT_WS(' ', d.calle, d.numero, d.depto)) direccion FROM direccion d WHERE d.idDireccion = c.idDireccion) , "
                    + "l.nombreLocalidad, t.telefonoPrincipal, t.telefonoSecundario, c.correo\n"
                    + "FROM cliente c, nombre n, telefono t, direccion d, localidad l, tipoCliente tc WHERE d.idLocalidad = l.idLocalidad "
                    + "AND c.idNombre = n.idNombre AND c.idTelefono = t.idTelefono AND c.idDireccion = d.idDireccion AND c.idTipoCliente = tc.idTipoCliente \n"
                    + " AND (n.primerNombre LIKE '%" + FormReportes.tFiltro.getText() + "%' OR n.segundoNombre LIKE '%" + FormReportes.tFiltro.getText() + "%' "
                    + "OR n.primerApellido LIKE '%" + FormReportes.tFiltro.getText() + "%' OR n.segundoApellido "
                    + "LIKE '%" + FormReportes.tFiltro.getText() + "%')";
        } else if (FormReportes.filtro.getSelectedItem() == "Dni") {
            sql = "SELECT c.idcliente, tc.nombreTipoCliente, (SELECT GROUP_CONCAT(CONCAT_WS(', ',(CONCAT_WS(' ', n.primerApellido, n.segundoApellido)),"
                    + "(CONCAT_WS(' ', n.primerNombre, n.segundoNombre)))) nombre FROM nombre n WHERE n.idNombre = c.idNombre  ), c.dni, "
                    + "(SELECT GROUP_CONCAT(CONCAT_WS(' ', d.calle, d.numero, d.depto)) direccion FROM direccion d WHERE d.idDireccion = c.idDireccion) , "
                    + "l.nombreLocalidad, t.telefonoPrincipal, t.telefonoSecundario, c.correo\n"
                    + "FROM cliente c, nombre n, telefono t, direccion d, localidad l, tipoCliente tc WHERE d.idLocalidad = l.idLocalidad "
                    + "AND c.idNombre = n.idNombre AND c.idTelefono = t.idTelefono AND c.idDireccion = d.idDireccion AND c.idTipoCliente = tc.idTipoCliente \n"
                    + "AND dni LIKE '%" + FormReportes.tFiltro.getText() + "%'";
        } else if (FormReportes.filtro.getSelectedItem() == "Tipo de Cliente") {
            sql = "SELECT c.idcliente, tc.nombreTipoCliente,(SELECT GROUP_CONCAT(CONCAT_WS(', ',(CONCAT_WS(' ', n.primerApellido, n.segundoApellido)),"
                    + "(CONCAT_WS(' ', n.primerNombre, n.segundoNombre)))) nombre FROM nombre n WHERE n.idNombre = c.idNombre  ) , c.dni,"
                    + "(SELECT GROUP_CONCAT(CONCAT_WS(' ', d.calle, d.numero, d.depto)) direccion FROM direccion d WHERE d.idDireccion = c.idDireccion) , "
                    + "l.nombreLocalidad, t.telefonoPrincipal, t.telefonoSecundario, c.correo\n"
                    + "FROM cliente c, nombre n, telefono t, direccion d, localidad l, tipoCliente tc WHERE d.idLocalidad = l.idLocalidad "
                    + "AND c.idNombre = n.idNombre AND c.idTelefono = t.idTelefono AND c.idDireccion = d.idDireccion and c.idTipoCliente = tc.idTipoCliente \n"
                    + "AND tc.nombreTipoCliente LIKE '%" + FormReportes.tFiltro.getText() + "%'";
        } else if (FormReportes.filtro.getSelectedItem() == "Localidad") {
            sql = "SELECT c.idcliente, tc.nombreTipoCliente,(SELECT GROUP_CONCAT(CONCAT_WS(', ',(CONCAT_WS(' ', n.primerApellido, n.segundoApellido)),"
                    + "(CONCAT_WS(' ', n.primerNombre, n.segundoNombre)))) nombre FROM nombre n WHERE n.idNombre = c.idNombre  ) , c.dni,"
                    + "(SELECT GROUP_CONCAT(CONCAT_WS(' ', d.calle, d.numero, d.depto)) direccion FROM direccion d WHERE d.idDireccion = c.idDireccion) , "
                    + "l.nombreLocalidad, t.telefonoPrincipal, t.telefonoSecundario, c.correo\n"
                    + "FROM cliente c, nombre n, telefono t, direccion d, localidad l, tipoCliente tc WHERE d.idLocalidad = l.idLocalidad "
                    + "AND c.idNombre = n.idNombre AND c.idTelefono = t.idTelefono AND c.idDireccion = d.idDireccion AND c.idTipoCliente = tc.idTipoCliente \n"
                    + "AND l.nombreLocalidad LIKE '%" + FormReportes.tFiltro.getText() + "%'";
        } else if (FormReportes.filtro.getSelectedItem() == "Dirección") {
            sql = "SELECT c.idcliente, tc.nombreTipoCliente,(SELECT GROUP_CONCAT(CONCAT_WS(', ',(CONCAT_WS(' ', n.primerApellido, n.segundoApellido)),"
                    + "(CONCAT_WS(' ', n.primerNombre, n.segundoNombre)))) nombre FROM nombre n WHERE n.idNombre = c.idNombre  ) , c.dni,"
                    + "(SELECT GROUP_CONCAT(CONCAT_WS(' ', d.calle, d.numero, d.depto)) direccion FROM direccion d WHERE d.idDireccion = c.idDireccion) , "
                    + "l.nombreLocalidad, t.telefonoPrincipal, t.telefonoSecundario, c.correo\n"
                    + "FROM cliente c, nombre n, telefono t, direccion d, localidad l, tipoCliente tc WHERE d.idLocalidad = l.idLocalidad "
                    + "AND c.idNombre = n.idNombre AND c.idTelefono = t.idTelefono AND c.idDireccion = d.idDireccion AND c.idTipoCliente = tc.idTipoCliente \n"
                    + "AND d.calle LIKE '%" + FormReportes.tFiltro.getText() + "%'";
        }
        if (FormReportes.ordenar.getSelectedIndex() == 0) {
            sql = sql + " ORDER BY c.idCliente";
        } else if (FormReportes.ordenar.getSelectedItem() == "Localidad") {
            sql = sql + " ORDER BY l.nombreLocalidad";
        } else if (FormReportes.ordenar.getSelectedItem() == "Tipo de Cliente") {
            sql = sql + " ORDER BY tc.nombreTipoCliente";
        }
        try {
            Consulta consulta = new Consulta();
            ResultSet resultado = consulta.ConsultaBase(sql);
            ResultSetMetaData Columnas = resultado.getMetaData();
            modelo.addColumn("Id");
            modelo.addColumn("Tipo de Cliente");
            modelo.addColumn("Nombre");
            modelo.addColumn("DNI");
            modelo.addColumn("Dirección");
            modelo.addColumn("Localidad");
            modelo.addColumn("Teléfono Principal");
            modelo.addColumn("Teléfono Secundario");
            modelo.addColumn("Correo");
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
}
