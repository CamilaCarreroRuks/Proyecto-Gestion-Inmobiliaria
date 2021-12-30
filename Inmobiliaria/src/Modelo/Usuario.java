package Modelo;

/**
 *
 * @author Camila Carrero
 */
public class Usuario {

    private int idUsuario;
    private String nombreUsuario;
    private String contraseña;
    private int idTipoUsuario;

    public Usuario() {

    }

    public Usuario(int id, String usuario, String contraseña, int idTipo) {
        this.idUsuario = id;
        this.nombreUsuario = usuario;
        this.contraseña = contraseña;
        this.idTipoUsuario = idTipo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int id) {
        this.idUsuario = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String usuario) {
        this.nombreUsuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(int idTipo) {
        this.idTipoUsuario = idTipo;
    }
}
