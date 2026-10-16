package iescamp.es.DAO;

import iescamp.es.tablas.TipoEstado;

public class ManualDigital extends ArticuloDigital{
    private String tematica;
    private String version;
    private int diasMax;

    public ManualDigital(int codArticulo, String nombre, String formato, float tamanyo, String licencia, boolean conexion, String tematica, String version, int diasMax) {
        super(codArticulo, nombre, formato, tamanyo, licencia, conexion);
        this.tematica = tematica;
        this.version = version;
        this.diasMax = diasMax;
    }

    public ManualDigital(int codArticulo, String nombre, String marca, String descripcion, int credito, String imagen, TipoEstado estado, String formato, float tamanyo, String licencia, boolean conexion, String tematica, String version, int diasMax) {
        super(codArticulo, nombre, marca, descripcion, credito, imagen, estado, formato, tamanyo, licencia, conexion);
        this.tematica = tematica;
        this.version = version;
        this.diasMax = diasMax;
    }

    public ManualDigital(String nombre, String formato, float tamanyo, String licencia, boolean conexion, String tematica, String version, int diasMax) {
        super(nombre, formato, tamanyo, licencia, conexion);
        this.tematica = tematica;
        this.version = version;
        this.diasMax = diasMax;
    }

    public ManualDigital(String nombre, String marca, String descripcion, int credito, String imagen, TipoEstado estado, String formato, float tamanyo, String licencia, boolean conexion, String tematica, String version, int diasMax) {
        super(nombre, marca, descripcion, credito, imagen, estado, formato, tamanyo, licencia, conexion);
        this.tematica = tematica;
        this.version = version;
        this.diasMax = diasMax;
    }

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getDiasMax() {
        return diasMax;
    }

    public void setDiasMax(int diasMax) {
        this.diasMax = diasMax;
    }


    @Override
    public int calculoCreditoUso(int dias) {
        int precio;
        if (dias>3){
            dias = 3;
        }
        precio = dias * getCredito();
        return precio;
    }

    @Override
    public String mostrarDatos() {
        String cadena = super.muestraArtDigital();
        cadena += "\nManual digital";
        cadena += "\n\tTemática : " + getTematica();
        cadena += "\n\tVersión  : " + getVersion();
        cadena += "\n\tDías máximo de préstamo : " + getDiasMax();
        return cadena;
    }
}
