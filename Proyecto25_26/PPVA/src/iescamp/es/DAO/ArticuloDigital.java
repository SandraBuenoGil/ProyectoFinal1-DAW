package iescamp.es.DAO;

import iescamp.es.tablas.TipoEstado;

public abstract class ArticuloDigital extends Articulo{
    // declarción de atributos
    private String formato;
    private float tamanyo;
    private String licencia;
    private boolean conexion;

    public ArticuloDigital(int codArticulo, String nombre, String formato, float tamanyo, String licencia, boolean conexion) {
        super(codArticulo, nombre);
        this.formato = formato;
        this.tamanyo = tamanyo;
        this.licencia = licencia;
        this.conexion = conexion;
    }

    public ArticuloDigital(int codArticulo, String nombre, String marca, String descripcion, int credito, String imagen, TipoEstado estado, String formato, float tamanyo, String licencia, boolean conexion) {
        super(codArticulo, nombre, marca, descripcion, credito, imagen, estado);
        this.formato = formato;
        this.tamanyo = tamanyo;
        this.licencia = licencia;
        this.conexion = conexion;
    }

    public ArticuloDigital(String nombre, String formato, float tamanyo, String licencia, boolean conexion) {
        super(nombre);
        this.formato = formato;
        this.tamanyo = tamanyo;
        this.licencia = licencia;
        this.conexion = conexion;
    }

    public ArticuloDigital(String nombre, String marca, String descripcion, int credito, String imagen, TipoEstado estado, String formato, float tamanyo, String licencia, boolean conexion) {
        super(nombre, marca, descripcion, credito, imagen, estado);
        this.formato = formato;
        this.tamanyo = tamanyo;
        this.licencia = licencia;
        this.conexion = conexion;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public float getTamanyo() {
        return tamanyo;
    }

    public void setTamanyo(float tamanyo) {
        this.tamanyo = tamanyo;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public boolean isConexion() {
        return conexion;
    }

    public void setConexion(boolean conexion) {
        this.conexion = conexion;
    }

    public abstract int calculoCreditoUso(int dias);

    //Método que muestra los atributos del artículo fungible + los de artículo.
    public String muestraArtDigital() {
        return  super.muestraArticulo()+
                "\n Artículo Digital" +
                "\n\t Formato :" + formato +
                "\n\t Tamaño :" + tamanyo +
                "\n\t Licencia :" + licencia +
                "\n\t Conexión : " + (isConexion() ? "Si" : "No");
    }
}
