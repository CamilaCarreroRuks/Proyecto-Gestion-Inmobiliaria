package Modelo;

/**
 *
 * @author Camila Carrero
 */
public class Contabilidad {
    private int idContabilidad;
    private int idCliente;
    private String fecha;
    private Double monto;
    private String concepto;
    private int idTipoContabilidad;

    public Contabilidad() {
    }

    public Contabilidad(int idContabilidad, int idCliente, String fecha, Double monto, String concepto, int idTipoContabilidad) {
        this.idContabilidad = idContabilidad;
        this.idCliente = idCliente;
        this.fecha = fecha;
        this.monto = monto;
        this.concepto = concepto;
        this.idTipoContabilidad = idTipoContabilidad;
    }

    public int getIdContabilidad() {
        return idContabilidad;
    }

    public void setIdContabilidad(int idContabilidad) {
        this.idContabilidad = idContabilidad;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public int getIdTipoContabilidad() {
        return idTipoContabilidad;
    }

    public void setIdTipoContabilidad(int idTipoContabilidad) {
        this.idTipoContabilidad = idTipoContabilidad;
    }
    
    
}
