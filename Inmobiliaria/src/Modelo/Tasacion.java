package Modelo;

/**
 *
 * @author Camila Carrero
 */
public class Tasacion {

    private int idTasacion;
    private String fecha;
    private int idCliente;
    private int idDireccion;
    private int idTipoPropiedad;
    private int idCategoria;
    private int idValores;
    private int idDatos;
    private int idConstantes;
    private int valorConstruccion;
    private int valorTerreno;
    private int valorTotal;
    private Double valorBolsa;
    private Double valorM2Terreno;
    private Double valorResidual;
    private int años;
    private String estado;
    private Double m2Construccion;
    private Double m2Terreno;

    public Tasacion() {
    }

    public Tasacion(int idTasacion, String fecha, int idCliente, int idDireccion, int idTipoPropiedad, int idCategoria, 
            int idValores, int idDatos, int idConstantes, int valorConstruccion, int valorTerreno, int valorTotal, 
            Double valorBolsa, Double valorM2Terreno, Double valorResidual, int años, String estado, Double m2Construccion, Double m2Terreno) {
        this.idTasacion = idTasacion;
        this.fecha = fecha;
        this.idCliente = idCliente;
        this.idDireccion = idDireccion;
        this.idTipoPropiedad = idTipoPropiedad;
        this.idCategoria = idCategoria;
        this.idValores = idValores;
        this.idDatos = idDatos;
        this.idConstantes = idConstantes;
        this.valorConstruccion = valorConstruccion;
        this.valorTerreno = valorTerreno;
        this.valorTotal = valorTotal;
        this.valorBolsa = valorBolsa;
        this.valorM2Terreno = valorM2Terreno;
        this.valorResidual = valorResidual;
        this.años = años;
        this.estado = estado;
        this.m2Construccion = m2Construccion;
        this.m2Terreno = m2Terreno;
    }

       public int getIdTasacion() {
        return idTasacion;
    }

    public void setIdTasacion(int idTasacion) {
        this.idTasacion = idTasacion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    public int getIdTipoPropiedad() {
        return idTipoPropiedad;
    }

    public void setIdTipoPropiedad(int idTipoPropiedad) {
        this.idTipoPropiedad = idTipoPropiedad;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdValores() {
        return idValores;
    }

    public void setIdValores(int idValores) {
        this.idValores = idValores;
    }

    public int getIdDatos() {
        return idDatos;
    }

    public void setIdDatos(int idDatos) {
        this.idDatos = idDatos;
    }

    public int getIdConstantes() {
        return idConstantes;
    }

    public void setIdConstantes(int idConstantes) {
        this.idConstantes = idConstantes;
    }

    public int getValorConstruccion() {
        return valorConstruccion;
    }

    public void setValorConstruccion(int valorConstruccion) {
        this.valorConstruccion = valorConstruccion;
    }

    public int getValorTerreno() {
        return valorTerreno;
    }

    public void setValorTerreno(int valorTerreno) {
        this.valorTerreno = valorTerreno;
    }

    public int getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(int valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getValorBolsa() {
        return valorBolsa;
    }

    public void setValorBolsa(Double valorBolsa) {
        this.valorBolsa = valorBolsa;
    }

    public Double getValorM2Terreno() {
        return valorM2Terreno;
    }

    public void setValorM2Terreno(Double valorM2Terreno) {
        this.valorM2Terreno = valorM2Terreno;
    }

    public Double getValorResidual() {
        return valorResidual;
    }

    public void setValorResidual(Double valorResidual) {
        this.valorResidual = valorResidual;
    }

    public int getAños() {
        return años;
    }

    public void setAños(int años) {
        this.años = años;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getM2Construccion() {
        return m2Construccion;
    }

    public void setM2Construccion(Double m2Construccion) {
        this.m2Construccion = m2Construccion;
    }

    public Double getM2Terreno() {
        return m2Terreno;
    }

    public void setM2Terreno(Double m2Terreno) {
        this.m2Terreno = m2Terreno;
    }
}
