package iescamp.es.DAO;

import iescamp.es.tablas.TipoEstado;

import java.io.Serializable;

public abstract class Articulo implements Serializable {
    private int codArticulo;
    private String nombre;
    private String marca;
    private String descripcion;
    private int credito;
    private String imagen;
    private TipoEstado estado;

    public Articulo(int codArticulo, String nombre) {
        this.codArticulo = codArticulo;
        this.nombre = nombre;
        this.credito = 0;
        this.estado = TipoEstado.DISPONIBLE;
    }

    public Articulo(int codArticulo, String nombre, String marca, String descripcion, int credito, String imagen, TipoEstado estado) {
        this.codArticulo = codArticulo;
        this.nombre = nombre;
        this.marca = marca;
        this.descripcion = descripcion;
        this.credito = credito;
        this.imagen = imagen;
        this.estado = estado;
    }

    public Articulo(String nombre) {
        this.nombre = nombre;
        this.credito = 0;
        this.estado = TipoEstado.DISPONIBLE;
    }

    public Articulo(String nombre, String marca, String descripcion, int credito, String imagen, TipoEstado estado) {
        this.nombre = nombre;
        this.marca = marca;
        this.descripcion = descripcion;
        this.credito = credito;
        this.imagen = imagen;
        this.estado = estado;
    }

    public void setCodArticulo(int codArticulo) {
        this.codArticulo = codArticulo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCredito(int credito) {
        this.credito = credito;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setEstado(TipoEstado estado) {
        this.estado = estado;
    }

    public int getCodArticulo() {
        return codArticulo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMarca() {
        return marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCredito() {
        return credito;
    }

    public String getImagen() {
        return imagen;
    }

    public TipoEstado getEstado() {
        return estado;
    }

    public String muestraArticulo() {
        return "Articulo" +
                "\nCódigo de artículo :" + codArticulo +
                "\nNombre de artículo :" + nombre +
                "\nMarca de artículo  :" + marca +
                "\nDescripción        :" + descripcion +
                "\nCrédito prestamo   :" + credito +
                "\nPath imagen        :" + imagen +
                "\nEstado del artículo :" + estado;
    }
    public abstract String mostrarDatos();
}