package Modelo;

/**
 *
 * @author Camila Carrero
 */
public class TipoCliente {

    private int idTipoCliente;
    private String nombreTipoCliente;

    public TipoCliente() {
    }

    public TipoCliente(int idTipoCliente, String nombreTipoCliente) {
        this.idTipoCliente = idTipoCliente;
        this.nombreTipoCliente = nombreTipoCliente;
    }

    public int getIdTipoCliente() {
        return idTipoCliente;
    }

    public void setIdTipoCliente(int idTipoCliente) {
        this.idTipoCliente = idTipoCliente;
    }

    public String getNombreTipoCliente() {
        return nombreTipoCliente;
    }

    public void setNombreTipoCliente(String nombreTipoCliente) {
        this.nombreTipoCliente = nombreTipoCliente;
    }
}
