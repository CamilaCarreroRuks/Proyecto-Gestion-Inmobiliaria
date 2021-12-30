package Modelo;

/**
 *
 * @author Camila Carrero
 */
public class Propiedad {
    private int idPropiedad;
    private int idTipoPropiedad;
    private int idCliente;
    private int idOperacion;
    private int idCaracteristicas;
    private int idDireccion;
    private int idZona;

    public Propiedad() {
    }

    public Propiedad(int idPropiedad, int idTipoPropiedad, int idCliente, int idOperacion, int idCaracteristicas, int idDireccion, int idZona) {
        this.idPropiedad = idPropiedad;
        this.idTipoPropiedad = idTipoPropiedad;
        this.idCliente = idCliente;
        this.idOperacion = idOperacion;
        this.idCaracteristicas = idCaracteristicas;
        this.idDireccion = idDireccion;
        this.idZona = idZona;
    }

    public int getIdPropiedad() {
        return idPropiedad;
    }

    public void setIdPropiedad(int idPropiedad) {
        this.idPropiedad = idPropiedad;
    }

    public int getIdTipoPropiedad() {
        return idTipoPropiedad;
    }

    public void setIdTipoPropiedad(int idTipoPropiedad) {
        this.idTipoPropiedad = idTipoPropiedad;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(int idOperacion) {
        this.idOperacion = idOperacion;
    }

    public int getIdCaracteristicas() {
        return idCaracteristicas;
    }

    public void setIdCaracteristicas(int idCaracteristicas) {
        this.idCaracteristicas = idCaracteristicas;
    }

    public int getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    public int getIdZona() {
        return idZona;
    }

    public void setIdZona(int idZona) {
        this.idZona = idZona;
    }
    
    
    
}
