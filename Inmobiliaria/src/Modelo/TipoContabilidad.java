package Modelo;

/**
 *
 * @author Camila Carrero
 */
public class TipoContabilidad {

    private int idTipoContabilidad;
    private String nombreTipoContabilidad;

    public TipoContabilidad() {
    }

    public TipoContabilidad(int idTipoContabilidad, String nombreTipoContabilidad) {
        this.idTipoContabilidad = idTipoContabilidad;
        this.nombreTipoContabilidad = nombreTipoContabilidad;
    }

    public int getIdTipoContabilidad() {
        return idTipoContabilidad;
    }

    public void setIdTipoContabilidad(int idTipoContabilidad) {
        this.idTipoContabilidad = idTipoContabilidad;
    }

    public String getNombreTipoContabilidad() {
        return nombreTipoContabilidad;
    }

    public void setNombreTipoContabilidad(String nombreTipoContabilidad) {
        this.nombreTipoContabilidad = nombreTipoContabilidad;
    }
}
