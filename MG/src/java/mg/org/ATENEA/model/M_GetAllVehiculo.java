
package mg.org.ATENEA.model;


public class M_GetAllVehiculo {
    

    private String numeroSerie;
    private String modelo;
    private String color;
    private String tapiceria;
    private int anio;
    private int IDV;
    private String fraCompra;
    private int diasStock;
    private String ubicacion;
    private String categoria;
    private String estatus;

    public M_GetAllVehiculo() {
    }

    public M_GetAllVehiculo( String numeroSerie, String modelo, String color, String tapiceria, int anio, int IDV, String fraCompra, int diasStock, String ubicacion, String categoria, String estatus) {

        this.numeroSerie = numeroSerie;
        this.modelo = modelo;
        this.color = color;
        this.tapiceria = tapiceria;
        this.anio = anio;
        this.IDV = IDV;
        this.fraCompra = fraCompra;
        this.diasStock = diasStock;
        this.ubicacion = ubicacion;
        this.categoria = categoria;
        this.estatus = estatus;
    }



    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTapiceria() {
        return tapiceria;
    }

    public void setTapiceria(String tapiceria) {
        this.tapiceria = tapiceria;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getIDV() {
        return IDV;
    }

    public void setIDV(int IDV) {
        this.IDV = IDV;
    }

    public String getFraCompra() {
        return fraCompra;
    }

    public void setFraCompra(String fraCompra) {
        this.fraCompra = fraCompra;
    }

    public int getDiasStock() {
        return diasStock;
    }

    public void setDiasStock(int diasStock) {
        this.diasStock = diasStock;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        return "M_GetAllVehiculo{" + ", numeroSerie=" + numeroSerie + ", modelo=" + modelo + ", color=" + color + ", tapiceria=" + tapiceria + ", anio=" + anio + ", IDV=" + IDV + ", fraCompra=" + fraCompra + ", diasStock=" + diasStock + ", ubicacion=" + ubicacion + ", categoria=" + categoria + ", estatus=" + estatus + '}';
    }
    
}
