package iescamp.es.DAO;

import iescamp.es.tablas.TipoEstado;

import java.time.LocalDate;

public class MaterialConstruccion extends ArticuloFungible {
    private String forma;

    public MaterialConstruccion(int codArticulo, String nombre, int cantidad,
                                LocalDate fechaCaducidad, String forma) {
        super(codArticulo, nombre, cantidad, fechaCaducidad);
        this.forma = forma;
    }

    public MaterialConstruccion(int codArticulo, String nombre, String marca, String descripcion,
                                int credito, String imagen, TipoEstado estado, int cantidad,
                                LocalDate fechaCaducidad, String forma) {
        super(codArticulo, nombre, marca, descripcion, credito, imagen, estado, cantidad, fechaCaducidad);
        this.forma = forma;
    }

    public MaterialConstruccion(String nombre, int cantidad, LocalDate fechaCaducidad, String forma) {
        super(nombre, cantidad, fechaCaducidad);
        this.forma = forma;
    }

    public MaterialConstruccion(String nombre, String marca, String descripcion, int credito,
                                String imagen, TipoEstado estado, int cantidad,
                                LocalDate fechaCaducidad, String forma) {
        super(nombre, marca, descripcion, credito, imagen, estado, cantidad, fechaCaducidad);
        this.forma = forma;
    }

    public MaterialConstruccion(String nombre, int cantidad, LocalDate fechaCaducidad) {
        super(nombre, cantidad, fechaCaducidad);
        forma = "Sin descripción";
    }

    public MaterialConstruccion(int codArticulo, String nombre, int cantidad, LocalDate fechaCaducidad) {
        super(codArticulo, nombre, cantidad, fechaCaducidad);
        forma = "Sin descripción";
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    @Override
    public String mostrarDatos() {
        String cadena = super.muestraArtFung();
        cadena += "\nMaterial de construcción";
        cadena += "\n\tForma : " + getForma();
        return cadena;
    }
}

