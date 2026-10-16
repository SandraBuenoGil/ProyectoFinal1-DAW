package iescamp.es.movimientos;

import iescamp.es.tablas.TipoMovimientoCredito;
import iescamp.es.usuarios.Administrador;
import iescamp.es.usuarios.Cliente;

public class MovimientoCredito {
    private int idMovimientoCredito;
    private int puntos;
    private String fecha;
    private String motivo;
    private Cliente cliente;
    private Administrador admin;
    private TipoMovimientoCredito movimientoCredito;

    public MovimientoCredito(int idMovimientoCredito, int puntos, String fecha, String motivo, Cliente cliente, Administrador admin, TipoMovimientoCredito movimientoCredito) {
        this.idMovimientoCredito = idMovimientoCredito;
        this.puntos = puntos;
        this.fecha = fecha;
        this.motivo = motivo;
        this.cliente = cliente;
        this.admin = admin;
        this.movimientoCredito = movimientoCredito;
    }

    public MovimientoCredito(int puntos, String fecha, String motivo, Cliente cliente, Administrador admin, TipoMovimientoCredito movimientoCredito) {
        this.puntos = puntos;
        this.fecha = fecha;
        this.motivo = motivo;
        this.cliente = cliente;
        this.admin = admin;
        this.movimientoCredito = movimientoCredito;
    }


    public MovimientoCredito(int codMovimientoCredito, int puntos, Cliente cliente, Administrador admin) {
        this.idMovimientoCredito = codMovimientoCredito;
        this.puntos = puntos;
        this.cliente = cliente;
        this.admin = admin;
        this.movimientoCredito = TipoMovimientoCredito.RecargaDinero;
    }

    public MovimientoCredito(int puntos, Cliente cliente, Administrador admin) {
        this.puntos = puntos;
        this.cliente = cliente;
        this.admin = admin;
        this.movimientoCredito = TipoMovimientoCredito.RecargaDinero;
    }

    public int getIdMovimientoCredito() {
        return idMovimientoCredito;
    }

    public void setIdMovimientoCredito(int idMovimientoCredito) {
        this.idMovimientoCredito = idMovimientoCredito;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Administrador getAdmin() {
        return admin;
    }

    public void setAdmin(Administrador admin) {
        this.admin = admin;
    }

    public TipoMovimientoCredito getMovimientoCredito() {
        return movimientoCredito;
    }

    public void setMovimientoCredito(TipoMovimientoCredito movimientoCredito) {
        this.movimientoCredito = movimientoCredito;
    }

    @Override
    public String toString() {
        return "Movimiento de Crédito: " +
                "\nID Movimiento: " + idMovimientoCredito +
                "\nPuntos: " + puntos +
                "\nFecha: " + fecha +
                "\nMotivo: " + motivo +
                "\nCliente (DNI): " + cliente.getDni() + cliente.getApellidos()+","+cliente.getNombre()+
                "\nAdministrador (DNI): " + admin.getDni() + admin.getApellidos()+","+admin.getNombre()+
                "\nTipo: " + movimientoCredito;
    }
}