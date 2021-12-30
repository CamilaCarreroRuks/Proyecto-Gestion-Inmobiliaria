package Modelo;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Camila Carrero
 */
public class CategoriaConsulta {
    
    public boolean registrar(Categoria c) {
        boolean respuesta = false;
        String sql = "INSERT INTO categoria (tipoA, tipoB, tipoC, tipoD) VALUES ('" + c.getTipoA() + "', '" + c.getTipoB() + "', '"+ c.getTipoC() +"', '" + c.getTipoD() + "')";
        if (categoriaExiste(c) == false) {
            try {
                Consulta consulta = new Consulta();
                respuesta = consulta.InsercionBase(sql);
                 respuesta = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error de registro \n" + e);
            }
        }
        return respuesta;
    }
    
    public boolean modificar(Categoria c){
        boolean respuesta = false;
        String sql = "UPDATE categoria SET tipoA = '" + c.getTipoA() + "', tipoB = '" + c.getTipoB() + "', tipoC =  '"+ c.getTipoC() +"', tipoD = '" + c.getTipoD() + "' WHERE idCategoria = '"+ c.getIdCategoria() +"'";
        try {
            Consulta consulta = new Consulta();
            consulta.ActualizacionBase(sql);
            respuesta = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de modificación \n" + e);
        }
        return respuesta;
    }
    
    public boolean categoriaExiste(Categoria c) {
        boolean respuesta = false;
        String sql = "SELECT * FROM categoria WHERE tipoA='" + c.getTipoA() + "' and tipoB='" + c.getTipoB() + "' and tipoC = '"+ c.getTipoC() +"' and tipoD ='" + c.getTipoD() + "'";
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
    
    public int obtenerId(Categoria c) {
        String sql = "SELECT idCategoria FROM categoria WHERE tipoA='" + c.getTipoA() + "' AND tipoB='"+ c.getTipoB() +"' AND tipoC='"+ c.getTipoC() +"' AND tipoD='"+ c.getTipoD() +"'";
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
    
    public static ArrayList<String> listaCategoria(int id) {
        ArrayList<String> lista = new ArrayList<String>();
        ResultSet resultado = null;
        String sql = "SELECT tipoA, tipoB, tipoC, tipoD FROM categoria WHERE idCategoria='"+ id +"'";
        try {
            Consulta consulta = new Consulta();
            resultado = consulta.ConsultaBase(sql);
            ResultSetMetaData columna = resultado.getMetaData();
            int cantColumnas = columna.getColumnCount();
            while (resultado.next()) {
                Object[] filas = new Object[cantColumnas];
                for (int i = 0; i < cantColumnas; i++) {
                    filas[i] = resultado.getObject(i + 1);
                    lista.add(filas[i].toString());
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }
        return lista;
    }
}
