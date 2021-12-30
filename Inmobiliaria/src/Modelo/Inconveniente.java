package Modelo;

/**
 *
 * @author Camila Carrero
 */
public class Inconveniente {
    private int idIncoveniente;
    private String nombreInconveniente;
    private String estado;
    private int idPropiedad;

    public Inconveniente() {
    }

    public Inconveniente(int idIncoveniente, String nombreInconveniente, String estado, int idPropiedad) {
        this.idIncoveniente = idIncoveniente;
        this.nombreInconveniente = nombreInconveniente;
        this.estado = estado;
        this.idPropiedad = idPropiedad;
    }

    public int getIdIncoveniente() {
        return idIncoveniente;
    }

    public void setIdIncoveniente(int idIncoveniente) {
        this.idIncoveniente = idIncoveniente;
    }

    public String getNombreInconveniente() {
        return nombreInconveniente;
    }

    public void setNombreInconveniente(String nombreInconveniente) {
        this.nombreInconveniente = nombreInconveniente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdPropiedad() {
        return idPropiedad;
    }

    public void setIdPropiedad(int idPropiedad) {
        this.idPropiedad = idPropiedad;
    }
    
    
}
