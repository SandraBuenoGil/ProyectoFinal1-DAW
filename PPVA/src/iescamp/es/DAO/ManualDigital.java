package iescamp.es.DAO;

import iescamp.es.tablas.TipoEstado;

public class ManualDigital extends ArticuloDigital {
    private String tematica;
    private int version;
    private int maxDiasPrestamo;

    public ManualDigital(int codArticulo, String nombre, String formato, float tamanyo, String licencia, boolean conexion, String tematica, int version, int maxDiasPrestamo) {
        super(codArticulo, nombre, formato, tamanyo, licencia, conexion);
        this.tematica = tematica;
        this.version = version;
        this.maxDiasPrestamo = maxDiasPrestamo;
    }

    public ManualDigital(int codArticulo, String nombre, String marca, String descripcion, int credito, String imagen, TipoEstado estado, String formato, float tamanyo, String licencia, boolean conexion, String tematica, int version, int maxDiasPrestamo) {
        super(codArticulo, nombre, marca, descripcion, credito, imagen, estado, formato, tamanyo, licencia, conexion);
        this.tematica = tematica;
        this.version = version;
        this.maxDiasPrestamo = maxDiasPrestamo;
    }

    public ManualDigital(String nombre, String formato, float tamanyo, String licencia, boolean conexion, String tematica, int version, int maxDiasPrestamo) {
        super(nombre, formato, tamanyo, licencia, conexion);
        this.tematica = tematica;
        this.version = version;
        this.maxDiasPrestamo = maxDiasPrestamo;
    }

    public ManualDigital(String nombre, String marca, String descripcion, int credito, String imagen, TipoEstado estado, String formato, float tamanyo, String licencia, boolean conexion, String tematica, int version, int maxDiasPrestamo) {
        super(nombre, marca, descripcion, credito, imagen, estado, formato, tamanyo, licencia, conexion);
        this.tematica = tematica;
        this.version = version;
        this.maxDiasPrestamo = maxDiasPrestamo;
    }

    public ManualDigital(int codArticulo, String nombre, String marca, String descripcion, int credito, TipoEstado estado, String formato, float tamanyo, String licencia, boolean conexion, String tematica, int version, int maxDiasPrestamo) {
        super(codArticulo, nombre, marca, descripcion, credito, estado, formato, tamanyo, licencia, conexion);
        this.tematica = tematica;
        this.version = version;
        this.maxDiasPrestamo = maxDiasPrestamo;
    }

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getMaxDiasPrestamo() {
        return maxDiasPrestamo;
    }

    public void setMaxDiasPrestamo(int maxDiasPrestamo) {
        this.maxDiasPrestamo = maxDiasPrestamo;
    }

    @Override
    public String mostrarDatos() {
        return super.muestraArticulo() +
                "\nTemática:    " + tematica +
                "\nVersión:     " + version +
                "\nDías máximos:" + maxDiasPrestamo;
    }

    @Override
    public int calcularCreditoUso(int dias) {
        int totalCredito;
        if (dias > 3) {
            dias = 3;
        }
        totalCredito = dias * getCredito();
        return totalCredito;
    }
}
