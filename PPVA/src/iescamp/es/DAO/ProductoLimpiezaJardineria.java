package iescamp.es.DAO;

import iescamp.es.tablas.TipoEstado;

import java.time.LocalDate;

public class ProductoLimpiezaJardineria extends ArticuloFungible {
    private boolean toxicidad;

    public ProductoLimpiezaJardineria(int codArticulo, String nombre, int cantidad, LocalDate fechaCaducidad, boolean toxicidad) {
        super(codArticulo, nombre, cantidad, fechaCaducidad);
        this.toxicidad = toxicidad;
    }

    public ProductoLimpiezaJardineria(int codArticulo, String nombre, String marca, String descripcion, int credito, String imagen, TipoEstado estado, int cantidad, LocalDate fechaCaducidad, boolean toxicidad) {
        super(codArticulo, nombre, marca, descripcion, credito, imagen, estado, cantidad, fechaCaducidad);
        this.toxicidad = toxicidad;
    }

    public ProductoLimpiezaJardineria(int codArticulo, String nombre, String marca, String descripcion, int credito, TipoEstado estado, int cantidad, LocalDate fechaCaducidad, boolean toxicidad) {
        super(codArticulo, nombre, marca, descripcion, credito, estado, cantidad, fechaCaducidad);
        this.toxicidad = toxicidad;
    }

    public ProductoLimpiezaJardineria(String nombre, int cantidad, LocalDate fechaCaducidad, boolean toxicidad) {
        super(nombre, cantidad, fechaCaducidad);
        this.toxicidad = toxicidad;
    }

    public ProductoLimpiezaJardineria(String nombre, String marca, String descripcion, int credito, String imagen, TipoEstado estado, int cantidad, LocalDate fechaCaducidad, boolean toxicidad) {
        super(nombre, marca, descripcion, credito, imagen, estado, cantidad, fechaCaducidad);
        this.toxicidad = toxicidad;
    }

    public boolean isToxicidad() {
        return toxicidad;
    }

    public void setToxicidad(boolean toxicidad) {
        this.toxicidad = toxicidad;
    }

    @Override
    public String mostrarDatos() {
        return super.muestraArtFung() +
        "\nProducto de limpieza o jardinería" +
        "\nToxicidad        : " + (isToxicidad() ? "Si" : "No");
    }
}