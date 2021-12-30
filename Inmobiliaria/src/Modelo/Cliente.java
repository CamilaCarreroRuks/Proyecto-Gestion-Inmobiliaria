package Modelo;

/**
 *
 * @author Camila Carrero
 */
public class Cliente {

    private int idCliente;
    private int idTipoCliente;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private int dni;
    private int idDireccion;
    private int telefonoPrincipal;
    private int telefonoSecundario;
    private String correo;

    public Cliente() {
    }

    public Cliente(int idCliente, int idTipoCliente, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, int dni, int idDireccion, int telefonoPrincipal, int telefonoSecundario, String correo) {
        this.idCliente = idCliente;
        this.idTipoCliente = idTipoCliente;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.dni = dni;
        this.idDireccion = idDireccion;
        this.telefonoPrincipal = telefonoPrincipal;
        this.telefonoSecundario = telefonoSecundario;
        this.correo = correo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdTipoCliente() {
        return idTipoCliente;
    }

    public void setIdTipoCliente(int idTipoCliente) {
        this.idTipoCliente = idTipoCliente;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    public int getTelefonoPrincipal() {
        return telefonoPrincipal;
    }

    public void setTelefonoPrincipal(int telefonoPrincipal) {
        this.telefonoPrincipal = telefonoPrincipal;
    }

    public int getTelefonoSecundario() {
        return telefonoSecundario;
    }

    public void setTelefonoSecundario(int telefonoSecundario) {
        this.telefonoSecundario = telefonoSecundario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

}
