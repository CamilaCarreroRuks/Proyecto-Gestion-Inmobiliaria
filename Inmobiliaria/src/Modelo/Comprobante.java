package Modelo;

/**
 *
 * @author Camila Carrero
 */
public class Comprobante {

    private int idComprobante;
    private int idContabilidad;
    private int idTipoComprobante;
    private String fecha;
    private int idComprobanteTalonario;
    private int idTalonario;
    private int numeroComprobante;
    private int vigente;
    private Double monto;

    public Comprobante() {
    }

    public Comprobante(int idComprobante, int idContabilidad, int idTipoComprobante, String fecha, int idComprobanteTalonario, int idTalonario, int numeroComprobante, int vigente, Double monto) {
        this.idComprobante = idComprobante;
        this.idContabilidad = idContabilidad;
        this.idTipoComprobante = idTipoComprobante;
        this.fecha = fecha;
        this.idComprobanteTalonario = idComprobanteTalonario;
        this.idTalonario = idTalonario;
        this.numeroComprobante = numeroComprobante;
        this.vigente = vigente;
        this.monto = monto;
    }

    public int getIdComprobante() {
        return idComprobante;
    }

    public void setIdComprobante(int idComprobante) {
        this.idComprobante = idComprobante;
    }

    public int getIdContabilidad() {
        return idContabilidad;
    }

    public void setIdContabilidad(int idContabilidad) {
        this.idContabilidad = idContabilidad;
    }

    public int getIdTipoComprobante() {
        return idTipoComprobante;
    }

    public void setIdTipoComprobante(int idTipoComprobante) {
        this.idTipoComprobante = idTipoComprobante;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdComprobanteTalonario() {
        return idComprobanteTalonario;
    }

    public void setIdComprobanteTalonario(int idComprobanteTalonario) {
        this.idComprobanteTalonario = idComprobanteTalonario;
    }

    public int getIdTalonario() {
        return idTalonario;
    }

    public void setIdTalonario(int idTalonario) {
        this.idTalonario = idTalonario;
    }

    public int getNumeroComprobante() {
        return numeroComprobante;
    }

    public void setNumeroComprobante(int numeroComprobante) {
        this.numeroComprobante = numeroComprobante;
    }

    public int getVigente() {
        return vigente;
    }

    public void setVigente(int vigente) {
        this.vigente = vigente;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }
}
