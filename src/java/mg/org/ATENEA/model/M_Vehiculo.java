
package mg.org.ATENEA.model;

public class M_Vehiculo {
    
    private int idVehiculo;
    
    private String numeroSerie;
    private String modelo;
    private String color;
    private String tapiceria;
    private int anio;
    private int IDV;
    private String fraCompra;
    private int diasStock;
    private int ubicacion;
    private int categoria;
    private int estatusVehiculo;

    public M_Vehiculo() {
    }

    public M_Vehiculo(int idVehiculo, String numeroSerie, String modelo, String color, String tapiceria, int anio, int IDV, String fraCompra, int diasStock, int ubicacion, int categoria, int estatusVehiculo) {
        this.idVehiculo = idVehiculo;
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
        this.estatusVehiculo = estatusVehiculo;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
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

    public int getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(int ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getEstatus() {
        return estatusVehiculo;
    }

    public void setEstatus(int estatusVehiculo) {
        this.estatusVehiculo = estatusVehiculo;
    }

    @Override
    public String toString() {
        return "M_Vehiculo{" + "idVehiculo=" + idVehiculo + ", numeroSerie=" + numeroSerie + ", modelo=" + modelo + ", color=" + color + ", tapiceria=" + tapiceria + ", anio=" + anio + ", IDV=" + IDV + ", fraCompra=" + fraCompra + ", diasStock=" + diasStock + ", ubicacion=" + ubicacion + ", categoria=" + categoria + ", estatusVehiculo=" + estatusVehiculo + '}';
    }
    
    
}
