package Modelo;

/**
 *
 * @author Camila Carrero
 */
public class Agenda {
   private int idAgenda;
   private String fecha;
   private String lugar;
   private String hora;
   private int idCliente;
   private String observaciones;

    public Agenda() {
    }

    public Agenda(int idAgenda, String fecha, String lugar, String hora, int idCliente, String observaciones) {
        this.idAgenda = idAgenda;
        this.fecha = fecha;
        this.lugar = lugar;
        this.hora = hora;
        this.idCliente = idCliente;
        this.observaciones = observaciones;
    }

    public int getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(int idAgenda) {
        this.idAgenda = idAgenda;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
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
   
   
}
