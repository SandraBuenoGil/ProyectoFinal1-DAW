package iescamp.es.movimientos;

import iescamp.es.DAO.Articulo;
import iescamp.es.tablas.EstadoReserva;
import iescamp.es.usuarios.Cliente;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;

public class Reserva {
    private int numeroReserva;
    private LocalDate fecha;
    private Cliente cliente; // Usamos el objeto completo
    private EstadoReserva estadoReserva;
    private ArrayList<Articulo> articulosReservados;

    public Reserva(int numeroReserva, LocalDate fecha, Cliente cliente, EstadoReserva estadoReserva, ArrayList<Articulo> articulosReservados) {
        this.numeroReserva = numeroReserva;
        this.fecha = fecha;
        this.cliente = cliente;
        this.estadoReserva = estadoReserva;
        this.articulosReservados = articulosReservados;
    }

    public Reserva(LocalDate fecha, Cliente cliente, ArrayList<Articulo> articulosReservados) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.estadoReserva = EstadoReserva.PENDIENTECONFIRMAR;
        this.articulosReservados = articulosReservados;
    }

    public Reserva(int numeroReserva, LocalDate fecha, Cliente cliente, EstadoReserva estadoReserva) {
        this.numeroReserva = numeroReserva;
        this.fecha = fecha;
        this.cliente = cliente;
        this.estadoReserva = estadoReserva;
        this.articulosReservados = new ArrayList<Articulo>();
    }

    public Reserva(LocalDate fecha, Cliente cliente) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.estadoReserva = EstadoReserva.PENDIENTECONFIRMAR;
        this.articulosReservados = new ArrayList<Articulo>();
    }

    public int getNumeroReserva() {
        return numeroReserva;
    }

    public void setNumeroReserva(int numeroReserva) {
        this.numeroReserva = numeroReserva;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public EstadoReserva getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(EstadoReserva estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    @Override
    public String toString() {
        String dniCli = (cliente != null) ? cliente.getDni() : "Sin asignar";
        int numArticulos = (articulosReservados != null) ? articulosReservados.size() : 0;

        return "Reserva : " +
                "\nNúmero : " + numeroReserva +
                "\nFecha : " + fecha.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)) +
                "\nCliente (DNI): " + dniCli +
                "\nEstado : " + estadoReserva +
                "\nArtículos Reservados : " + numArticulos;
    }
}
