package iescamp.es.DAO;

import iescamp.es.tablas.TipoEstado;

public class EquipoMaquinaria extends ArticuloNoFungible {
    private float potencia;
    private float energia;

    public EquipoMaquinaria(int codArticulo, String nombre, String estadoFisico, float potencia, float energia) {
        super(codArticulo, nombre, estadoFisico);
        this.potencia = potencia;
        this.energia = energia;
    }

    public EquipoMaquinaria(int codArticulo, String nombre, String marca, String descripcion, int credito, String imagen, TipoEstado estado, String estadoFisico, float potencia, float energia) {
        super(codArticulo, nombre, marca, descripcion, credito, imagen, estado, estadoFisico);
        this.potencia = potencia;
        this.energia = energia;
    }

    public EquipoMaquinaria(int codArticulo, String nombre, String marca, String descripcion, int credito, TipoEstado estado, String estadoFisico, float potencia, float energia) {
        super(codArticulo, nombre, marca, descripcion, credito, estado, estadoFisico);
        this.potencia = potencia;
        this.energia = energia;
    }

    public EquipoMaquinaria(String nombre, String estadoFisico, float potencia, float energia) {
        super(nombre, estadoFisico);
        this.potencia = potencia;
        this.energia = energia;
    }

    public EquipoMaquinaria(String nombre, String marca, String descripcion, int credito, String imagen, TipoEstado estado, String estadoFisico, float potencia, float energia) {
        super(nombre, marca, descripcion, credito, imagen, estado, estadoFisico);
        this.potencia = potencia;
        this.energia = energia;
    }

    public EquipoMaquinaria(String nombre, String marca, String descripcion, int credito, String imagen, TipoEstado estado, String estadoFisico) {
        super(nombre, marca, descripcion, credito, imagen, estado, estadoFisico);
        potencia = 0;
        energia = 0;
    }

    public EquipoMaquinaria(String nombre, String estadoFisico) {
        super(nombre, estadoFisico);
        potencia = 0;
        energia = 0;
    }

    public EquipoMaquinaria(int codArticulo, String nombre, String marca, String descripcion, int credito, String imagen, TipoEstado estado, String estadoFisico) {
        super(codArticulo, nombre, marca, descripcion, credito, imagen, estado, estadoFisico);
        potencia = 0;
        energia = 0;

    }

    public EquipoMaquinaria(int codArticulo, String nombre, String estadoFisico) {
        super(codArticulo, nombre, estadoFisico);
        potencia = 0;
        energia = 0;
    }

    public float getPotencia() {
        return potencia;
    }

    public void setPotencia(float potencia) {
        this.potencia = potencia;
    }

    public float getEnergia() {
        return energia;
    }

    public void setEnergia(float energia) {
        this.energia = energia;
    }

    @Override
    public String mostrarDatos() {
        return super.muestraArtNoFung() +
        "\nEquipo de Maquinaria" +
        "\nPotencia     : " + getPotencia() +
        "\nEnergía      : " + getEnergia();
    }
}