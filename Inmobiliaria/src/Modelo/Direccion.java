package Modelo;

/**
 *
 * @author Camila Carrero
 */
public class Direccion {

    private int idDireccion;
    private String calle;
    private int numero;
    private String departamento;
    private int idLocalidad;

    public Direccion() {
    }

    public Direccion(int idDireccion, String calle, int numero, String departamento, int idLocalidad) {
        this.idDireccion = idDireccion;
        this.calle = calle;
        this.numero = numero;
        this.departamento = departamento;
        this.idLocalidad = idLocalidad;
    }

    public int getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(int idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

}
