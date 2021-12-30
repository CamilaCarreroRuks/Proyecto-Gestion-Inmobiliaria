package Modelo;

/**
 *
 * @author Camila Carrero
 */
public class Categoria {
   private int idCategoria;
   private int tipoA;
   private int tipoB;
   private int tipoC;
   private int tipoD;

    public Categoria() {
    }

    public Categoria(int idCategoria, int tipoA, int tipoB, int tipoC, int tipoD) {
        this.idCategoria = idCategoria;
        this.tipoA = tipoA;
        this.tipoB = tipoB;
        this.tipoC = tipoC;
        this.tipoD = tipoD;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getTipoA() {
        return tipoA;
    }

    public void setTipoA(int tipoA) {
        this.tipoA = tipoA;
    }

    public int getTipoB() {
        return tipoB;
    }

    public void setTipoB(int tipoB) {
        this.tipoB = tipoB;
    }

    public int getTipoC() {
        return tipoC;
    }

    public void setTipoC(int tipoC) {
        this.tipoC = tipoC;
    }

    public int getTipoD() {
        return tipoD;
    }

    public void setTipoD(int tipoD) {
        this.tipoD = tipoD;
    }
   
   
}
