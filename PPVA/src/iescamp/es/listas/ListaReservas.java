package iescamp.es.listas;

import iescamp.es.movimientos.Reserva;
import iescamp.es.tablas.EstadoReserva;
import iescamp.es.usuarios.Cliente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

public class ListaReservas {
    private ArrayList<Reserva> reservas;

    public ListaReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    public ListaReservas() {
        reservas= new ArrayList<Reserva>();
    }

    /**
     * AÑADIR RESERVA, DEVUELVE UN BOOLEAN
     * @param res
     * @return
     */
    public boolean crearReserva(Reserva res) {
        boolean respuesta = false;
        respuesta = reservas.add(res);
        return respuesta;
    }

    /**
     * ELIMINAR RESERVA POR OBJETO, DEVUELVE UN BOOLEAN
     * @param res
     * @return
     */
    public boolean eliminarReserva(Reserva res) {
        boolean borrado = false;
        if (reservas.contains(res)) {
            reservas.remove(res);
            borrado = true;
        }
        return borrado;
    }

    /**
     * BUSCAR ÚLTIMA RESERVA POR DNI DEL CLIENTE, DEVUELVE EL OBJETO
     * @param dni
     * @return
     */
    public Reserva buscarUltimaResDni(String dni) {
        Reserva encontrado = null;
        int i = reservas.size()-1;

        while (i >= 0 && encontrado == null) {
            Reserva res = reservas.get(i);
            if (res.getCliente().getDni().equalsIgnoreCase(dni)) {
                encontrado = res;
            } else {
                i--;
            }
        }
        return encontrado;
    }

    /**
     * BUSCAR ÚLTIMO MOVIMIENTO POR DNI DEL CLIENTE, DEVUELVE LA POSICIÓN
     * @param dni
     * @return
     */
    public int buscarUltimaRes(String dni) {
        int posicion = -1;
        int i = reservas.size() - 1;
        while (i >=0 && posicion == -1) {
            Reserva res = reservas.get(i);
            if (res.getCliente().getDni().equalsIgnoreCase(dni)) {
                posicion = i;
            } else {
                i--;
            }
        }
        return posicion;
    }

    /**
     * LISTAR TODAS LAS RESERVAS
     */
    public void listarReservas() {
        for (Reserva res : reservas) {
            System.out.println(res.toString());
        }
    }

    /**
     * MOSTAR RESERVAS DEL UN CLIENTE POR DNI
     * @param dni
     */
    public void listarReservasCliente(String dni) {
        for (Reserva res : reservas) {
            if (res.getCliente().getDni().equalsIgnoreCase(dni)) {
                System.out.println(res.toString());
            }
        }
    }

    /**
     * MODIFICAR UN MOVIMIENTO BUSCADO POR OBJETO, DEVUELVE UN BOOLEAN
     * @param res
     * @param nuevaFecha
     * @param nuevoCliente
     * @param nuevoEstadoReserva
     * @return
     */
    public boolean modificaRes(Reserva res, LocalDate nuevaFecha, Cliente nuevoCliente, EstadoReserva nuevoEstadoReserva) {
        boolean modificado = false;

        if (reservas.contains(res)) {
            if (nuevaFecha != null) res.setFecha(nuevaFecha);
            if (nuevoCliente != null) res.setCliente(nuevoCliente);
            if (nuevoEstadoReserva != null) res.setEstadoReserva(nuevoEstadoReserva);
            modificado = true;
        }
        return modificado;
    }
}
