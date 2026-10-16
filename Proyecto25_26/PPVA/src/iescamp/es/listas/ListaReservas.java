package iescamp.es.listas;

import iescamp.es.DAO.Articulo;
import iescamp.es.movimientos.Reserva;
import iescamp.es.tablas.EstadoReserva;
import iescamp.es.usuarios.Cliente;

import java.time.LocalDate;
import java.util.ArrayList;

public class ListaReservas {
    private ArrayList<Reserva> reservas;

    public ListaReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    public ListaReservas() {
        reservas= new ArrayList<Reserva>();
    }

    //Método para añadir una reserva.
    public boolean crearReserva(Reserva res) {
        boolean respuesta = false;
        respuesta = reservas.add(res);
        return respuesta;
    }

    //Método para eliminar una reserva por objeto.
    public boolean eliminarReserva(Reserva res) {
        boolean borrado = false;

        if (reservas.contains(res)) {
            reservas.remove(res);
            borrado = true;
        }
        return borrado;
    }

    //Método para buscar la última reserva, por dni de Cliente.
    // Devuelve el objeto.
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

    // Método para buscar la última reserva, por dni de Cliente.
    // Devuelve la posición.
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

    //Método para listar todas las reservas.
    public void listarReservas() {
        for (Reserva res : reservas) {
            System.out.println(res.toString());
        }
    }

    //Método para mostrar el historial completo de reservas de un cliente
    public void listarReservasCliente(String dni) {
        for (Reserva res : reservas) {
            if (res.getCliente().getDni().equalsIgnoreCase(dni)) {
                System.out.println(res.toString());
            }
        }
    }

    //Método para modificar reservas, búsqueda por objeto.
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
    //Método para contar cuántos artículos hay.
    public int totalReservas() {
        return reservas.size();
    }

    public boolean vaciarLista() {
        reservas.clear();
        return reservas.isEmpty();
    }

    //Método que devuelve un artículo de una posición concreta.
    public Reserva getReservaPos(int pos) {
        Reserva resultado = null;
        if (pos >= 0 && pos < reservas.size()) {
            resultado = reservas.get(pos);
        }
        return resultado;
    }

}
