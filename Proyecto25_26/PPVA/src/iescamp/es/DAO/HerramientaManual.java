package iescamp.es.DAO;

import iescamp.es.tablas.TipoEstado;

public class HerramientaManual extends ArticuloNoFungible {

    private String tipo;

    public HerramientaManual(int codArticulo, String nombre, String estadoFisico, String tipo) {
        super(codArticulo, nombre, estadoFisico);
        this.tipo = tipo;
    }

    public HerramientaManual(int codArticulo, String nombre, String marca, String descripcion, int credito, String imagen, TipoEstado estado, String estadoFisico, String tipo) {
        super(codArticulo, nombre, marca, descripcion, credito, imagen, estado, estadoFisico);
        this.tipo = tipo;
    }

    public HerramientaManual(String nombre, String estadoFisico, String tipo) {
        super(nombre, estadoFisico);
        this.tipo = tipo;
    }

    public HerramientaManual(String nombre, String marca, String descripcion, int credito, String imagen, TipoEstado estado, String estadoFisico, String tipo) {
        super(nombre, marca, descripcion, credito, imagen, estado, estadoFisico);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    @Override
    public String mostrarDatos() {
        String cadena = super.muestraArtNoFung();
        cadena += "\nHerramienta manual";
        cadena += "\n\tTipo : " + getTipo();
        return cadena;
    }
}