package Modelo;

/**
 *
 * @author Camila Carrero
 */
public class Comunicacion {
    private int idComunicacion;
    private String fecha;
    private int idCliente;
    private String observaciones;
    private int idInconveniente;

    public Comunicacion() {
    }

    public Comunicacion(int idComunicacion, String fecha, int idCliente, String observaciones, int idInconveniente) {
        this.idComunicacion = idComunicacion;
        this.fecha = fecha;
        this.idCliente = idCliente;
        this.observaciones = observaciones;
        this.idInconveniente = idInconveniente;
    }

    public int getIdComunicacion() {
        return idComunicacion;
    }

    public void setIdComunicacion(int idComunicacion) {
        this.idComunicacion = idComunicacion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getIdInconveniente() {
        return idInconveniente;
    }

    public void setIdInconveniente(int idInconveniente) {
        this.idInconveniente = idInconveniente;
    }  
}
