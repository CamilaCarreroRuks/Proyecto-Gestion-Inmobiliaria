package Modelo;

/**
 *
 * @author Camila Carrero
 */
public class TipoPropiedad {
    private int idTipoPropiedad;
    private String nombreTipoPropiedad;

    public TipoPropiedad() {
    }

    public TipoPropiedad(int idTipoPropiedad, String nombreTipoPropiedad) {
        this.idTipoPropiedad = idTipoPropiedad;
        this.nombreTipoPropiedad = nombreTipoPropiedad;
    }

    public int getIdTipoPropiedad() {
        return idTipoPropiedad;
    }

    public void setIdTipoPropiedad(int idTipoPropiedad) {
        this.idTipoPropiedad = idTipoPropiedad;
    }

    public String getNombreTipoPropiedad() {
        return nombreTipoPropiedad;
    }

    public void setNombreTipoPropiedad(String nombreTipoPropiedad) {
        this.nombreTipoPropiedad = nombreTipoPropiedad;
    }
    
    
}
