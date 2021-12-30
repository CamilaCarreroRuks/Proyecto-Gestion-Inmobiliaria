package Modelo;

import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Camila Carrero
 */
public class DireccionConsulta {

    public boolean registrar(Direccion d) {
        boolean respuesta = true;
        String sql = "INSERT INTO direccion (calle, numero, depto, idLocalidad) VALUES ('" + d.getCalle() + "', '" + d.getNumero() + "', '"+ d.getDepartamento() +"', '" + d.getIdLocalidad() + "')";
        if (direccionExiste(d) == false) {
            try {
                Consulta consulta = new Consulta();
                respuesta = consulta.InsercionBase(sql);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error de registro \n" + e);
            }
        }
        return respuesta;
    }

    public boolean modificar(Direccion d) {
        String sql = "UPDATE direccion SET calle= '" + d.getCalle() + "', numero = '" + d.getNumero() + "', depto = '"+d.getDepartamento()+"', idLocalidad= '" + d.getIdLocalidad() + "' WHERE idDireccion= '"+ d.getIdDireccion() +"'";
        boolean respuesta = true;
        try {
            Consulta consulta = new Consulta();
            respuesta = consulta.ActualizacionBase(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de modificación \n" + e);
        }
        return respuesta;
    }

    public boolean direccionExiste(Direccion d) {
        boolean respuesta = false;
        String sql = "SELECT * FROM direccion WHERE calle='" + d.getCalle() + "' and numero='" + d.getNumero() + "' and depto = '"+d.getDepartamento()+"' and idLocalidad ='" + d.getIdLocalidad() + "'";
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

    public int obtenerId(Direccion d) {
        String sql = "SELECT idDireccion FROM direccion WHERE calle='" + d.getCalle() + "' and numero='" + d.getNumero() + "' and depto = '"+d.getDepartamento()+"' and idLocalidad ='" + d.getIdLocalidad() + "'";
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

    public boolean eliminar(Direccion d) {
        boolean respuesta = true;
        String sql1 = "SELECT idCliente FROM clientes WHERE idDireccion = '" + d.getIdDireccion() + "'";
        ResultSet resultado = null;
        try {
            Consulta consulta = new Consulta();
            resultado = consulta.ConsultaBase(sql1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }
        if (resultado == null) {
            String sql2 = "DELETE FROM direccion WHERE calle='" + d.getCalle() + "' and numero = '" + d.getNumero() + "' and depto = '"+d.getDepartamento()+"' and idLocalidad= '" + d.getIdLocalidad() + "'";
            try {
                Consulta consulta = new Consulta();
                respuesta = consulta.EliminacionBase(sql2);
                JOptionPane.showMessageDialog(null, "Dirección Eliminada");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error en la eliminación \n");
            }
            return respuesta;
        } else {
            JOptionPane.showMessageDialog(null, "La Dirección NO puede ser Eliminada. Esta siendo utilizada en un Cliente o Propiedad");
        }
        return respuesta;
    }
    
    public ArrayList esUsada(Direccion d){
        String sql = "SELECT idCliente FROM cliente WHERE idDireccion ='" + d.getIdDireccion() + "'";
        ResultSet resultado = null;
        int u = 0;
        int i = 0;
        ArrayList<String> dir = new ArrayList<String>();
        try {
            Consulta consulta = new Consulta();
            resultado = consulta.ConsultaBase(sql);  
            while (resultado.next()) {    
                 Object[] id = new Object[0];
                id[i] = resultado.getNString(1);
                dir.add(id.toString());
            }          
            return dir;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }
        return dir;
    }
}
