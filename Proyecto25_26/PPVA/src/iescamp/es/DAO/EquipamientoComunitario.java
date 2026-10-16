package iescamp.es.DAO;

import iescamp.es.tablas.TipoEstado;

public class EquipamientoComunitario extends ArticuloNoFungible {
    private float alto;
    private float ancho;

    public EquipamientoComunitario(int codArticulo, String nombre, String estadoFisico, float alto, float ancho) {
        super(codArticulo, nombre, estadoFisico);
        this.alto = alto;
        this.ancho = ancho;
    }

    public EquipamientoComunitario(int codArticulo, String nombre, String marca, String descripcion, int credito, String imagen, TipoEstado estado, String estadoFisico, float alto, float ancho) {
        super(codArticulo, nombre, marca, descripcion, credito, imagen, estado, estadoFisico);
        this.alto = alto;
        this.ancho = ancho;
    }

    public EquipamientoComunitario(String nombre, String estadoFisico, float alto, float ancho) {
        super(nombre, estadoFisico);
        this.alto = alto;
        this.ancho = ancho;
    }

    public EquipamientoComunitario(String nombre, String marca, String descripcion, int credito, String imagen, TipoEstado estado, String estadoFisico, float alto, float ancho) {
        super(nombre, marca, descripcion, credito, imagen, estado, estadoFisico);
        this.alto = alto;
        this.ancho = ancho;
    }

    public float getAlto() {
        return alto;
    }

    public void setAlto(float alto) {
        this.alto = alto;
    }

    public float getAncho() {
        return ancho;
    }

    public void setAncho(float ancho) {
        this.ancho = ancho;
    }


    @Override
    public String mostrarDatos() {
        String cadena = super.muestraArtNoFung();
        cadena +="\nEquipamiento Comunitario.";
        cadena +="\n\tAncho : " + getAncho();
        cadena +="\n\tAlto  : " + getAlto();

        return cadena;
    }
}