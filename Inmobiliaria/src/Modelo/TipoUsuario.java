package Modelo;

/**
 *
 * @author Camila Carrero
 */
public class TipoUsuario {
    private int idTipoUsuario;
    private String nombreTipoUsuario;

    public TipoUsuario(int idTipoUsuario, String nombreTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
        this.nombreTipoUsuario = nombreTipoUsuario;
    }

    public TipoUsuario() {
    }

    public int getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(int idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public String getNombreTipoUsuario() {
        return nombreTipoUsuario;
    }

    public void setNombreTipoUsuario(String nombreTipoUsuario) {
        this.nombreTipoUsuario = nombreTipoUsuario;
    }
    
}
