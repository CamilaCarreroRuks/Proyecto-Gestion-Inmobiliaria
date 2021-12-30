package Modelo;

/**
 *
 * @author Camila Carrero
 */
public class Operacion {
    private int idOperacion;
    private String nombreOperacion;

    public Operacion() {
    }

    public Operacion(int idOperacion, String nombreOperacion) {
        this.idOperacion = idOperacion;
        this.nombreOperacion = nombreOperacion;
    }

    public int getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(int idOperacion) {
        this.idOperacion = idOperacion;
    }

    public String getNombreOperacion() {
        return nombreOperacion;
    }

    public void setNombreOperacion(String nombreOperacion) {
        this.nombreOperacion = nombreOperacion;
    }
    
    
}
