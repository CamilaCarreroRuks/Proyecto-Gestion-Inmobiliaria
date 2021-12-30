package Modelo;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSetMetaData;
import Vista.PanelPropiedad;

/**
 *
 * @author Camila Carrero
 */
public class PropiedadConsulta {

    public boolean registrar(Propiedad p) {
        String sql = "INSERT INTO propiedad (idTipoPropiedad, idCliente, idOperacion, idCaracteristicas, idDireccion, idZona) VALUES ('"+ p.getIdTipoPropiedad() +"', '"+ p.getIdCliente() +"', '"+ p.getIdOperacion() +"', '"+ p.getIdCaracteristicas() +"', '"+ p.getIdDireccion() +"', '"+ p.getIdZona() +"')";
        boolean respuesta = true;
        try {
            Consulta consulta = new Consulta();
            respuesta = consulta.InsercionBase(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de registro \n" + e);
        }
        return respuesta;
    }
    
    public boolean propiedadExiste(Propiedad p) {
        boolean respuesta = false;
        String sql = "SELECT * FROM propiedad WHERE idPropiedad='" + p.getIdPropiedad() + "'";
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

    public boolean eliminar(Propiedad p) {
        String sql = "DELETE FROM propiedad WHERE idPropiedad='" + p.getIdPropiedad() + "'";
        boolean respuesta = true;
        try {
            Consulta consulta = new Consulta();
            respuesta = consulta.EliminacionBase(sql);
            JOptionPane.showMessageDialog(null, "Propiedad Eliminada");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la eliminación \n");
        }
        return respuesta;
    }
    
    public boolean modificar(Propiedad p) {
        String sql = "UPDATE propiedad SET idTipoPropiedad='"+ p.getIdTipoPropiedad() +"', idCliente= '"+ p.getIdCliente() +"', idOperacion= '"+ p.getIdOperacion() +"', idCaracteristicas='"+ p.getIdCaracteristicas() +"', idDireccion'"+ p.getIdDireccion() +"', idZona='"+ p.getIdZona() +"'";
        boolean respuesta = true;
        try {
            Consulta consulta = new Consulta();
            respuesta = consulta.ActualizacionBase(sql);
            //JOptionPane.showMessageDialog(null, "Modificación exitosa");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de modificación \n" + e);
        }
        return respuesta;
    }
    
     public TableModel buscarPropiedad() {
        DefaultTableModel modelo = new DefaultTableModel() {
            public boolean isCellEditable(int columnas, int filas) {
                return false;
            }
        };
        String sql = "";
        if (PanelPropiedad.filtro.getSelectedItem() == "Todos") {
            sql = "" ;
                    } else {
            if (PanelPropiedad.filtro.getSelectedItem() == "Nombre") {
                sql = "";
                        } else {
                if (PanelPropiedad.filtro.getSelectedItem() == "Dni") {
                    sql = "";
                            } else {
                    if (PanelPropiedad.filtro.getSelectedItem() == "Tipo de Cliente") {
                        sql = "";
                                }else{
                        if(PanelPropiedad.filtro.getSelectedItem() == "Localidad"){
                             sql = "";
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
            System.out.println("Error: " + e);
        }
        return modelo;
    }
     
     public TableModel propiedadXId(String id) {
        DefaultTableModel modelo = new DefaultTableModel();
        String sql = "";
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
}
