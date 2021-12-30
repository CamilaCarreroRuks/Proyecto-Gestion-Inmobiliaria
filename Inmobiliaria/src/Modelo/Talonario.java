package Modelo;

/**
 *
 * @author Camila Carrero
 */
public class Talonario {
    private int idTalonario;
    private String nombreTalonario;
    private int idTipoComprobante;
    private int vigente;
    private int nComprobanteActual;
    private int nComprobanteTotal;

    public Talonario() {
    }

    public Talonario(int idTalonario, String nombreTalonario, int idTipoComprobante, int vigente, int nComprobanteActual, int nComprobanteTotal) {
        this.idTalonario = idTalonario;
        this.nombreTalonario = nombreTalonario;
        this.idTipoComprobante = idTipoComprobante;
        this.vigente = vigente;
        this.nComprobanteActual = nComprobanteActual;
        this.nComprobanteTotal = nComprobanteTotal;
    }

    public int getIdTalonario() {
        return idTalonario;
    }

    public void setIdTalonario(int idTalonario) {
        this.idTalonario = idTalonario;
    }

    public String getNombreTalonario() {
        return nombreTalonario;
    }

    public void setNombreTalonario(String nombreTalonario) {
        this.nombreTalonario = nombreTalonario;
    }

    public int getIdTipoComprobante() {
        return idTipoComprobante;
    }

    public void setIdTipoComprobante(int idTipoComprobante) {
        this.idTipoComprobante = idTipoComprobante;
    }

    public int getVigente() {
        return vigente;
    }

    public void setVigente(int vigente) {
        this.vigente = vigente;
    }

    public int getnComprobanteActual() {
        return nComprobanteActual;
    }

    public void setnComprobanteActual(int nComprobanteActual) {
        this.nComprobanteActual = nComprobanteActual;
    }

    public int getnComprobanteTotal() {
        return nComprobanteTotal;
    }

    public void setnComprobanteTotal(int nComprobanteTotal) {
        this.nComprobanteTotal = nComprobanteTotal;
    }
}
