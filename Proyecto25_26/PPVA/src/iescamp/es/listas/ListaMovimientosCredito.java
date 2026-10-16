package iescamp.es.listas;

import iescamp.es.miLibreria.Utils;
import iescamp.es.movimientos.MovimientoCredito;
import iescamp.es.tablas.TipoMovimientoCredito;
import iescamp.es.usuarios.Cliente;

import java.util.ArrayList;

public class ListaMovimientosCredito {
    private ArrayList<MovimientoCredito> movimientoCredito;

    public ListaMovimientosCredito(ArrayList<MovimientoCredito> movimientoCredito) {
        this.movimientoCredito = movimientoCredito;
    }

    public ListaMovimientosCredito() {
        movimientoCredito= new ArrayList<MovimientoCredito>();
    }

    //Método para crear movimiento de crédito.
    public boolean crearMovimientosCredito(MovimientoCredito mov) {
        boolean respuesta = false;
        respuesta = movimientoCredito.add(mov);
        return respuesta;
    }

    //Método para eliminar reservas por objeto.
    public boolean eliminarMovimientosCredito(MovimientoCredito mov) {
        boolean borrado = false;

        if (movimientoCredito.contains(mov)) {
            movimientoCredito.remove(mov);
            borrado = true;
        }
        return borrado;
    }

    //Método para buscar la última reserva, por dni de Cliente. Devuelve el objeto.
    public MovimientoCredito buscarUltimoMovCreDni(String dni) {
        MovimientoCredito encontrado = null;
        int i = movimientoCredito.size() - 1;

        while (i >= 0 && encontrado == null) {
            MovimientoCredito mov = movimientoCredito.get(i);
            if (mov.getCliente().getDni().equalsIgnoreCase(dni)) {
                encontrado = mov;
            } else {
                i--;
            }
        }

        return encontrado;
    }

    //Método para buscar la última reserva, por dni de Cliente. Devuelve la posición.
    public int buscarUltimoMovCre(String dni) {
        int posicion = -1;
        int i = movimientoCredito.size() - 1;

        while (i >= 0 && posicion == -1) {
            MovimientoCredito mov = movimientoCredito.get(i);
            if (mov.getCliente().getDni().equalsIgnoreCase(dni)) {
                posicion = i;
            } else {
                i--;
            }
        }

        return posicion;
    }

    //Método para listar todas las reservas.
    public void listarMovimientosCredito() {
        for (MovimientoCredito mov : movimientoCredito) {
            System.out.println(mov.toString());
        }
    }

    //Método para mostrar el historial completo de un cliente específico
    public void listarMovimientosCliente(String dni) {
        for (MovimientoCredito mov : movimientoCredito) {
            if (mov.getCliente().getDni().equalsIgnoreCase(dni)) {
                System.out.println(mov.toString());
            }
        }
    }

    //Método para modificar reservas, búsqueda por objeto.
    public boolean modificaMovCre(MovimientoCredito mov, int nuevosPuntos, String nuevaFecha,
                                  Cliente nuevoCliente, TipoMovimientoCredito nuevoMovimientoCredito) {
        boolean modificado = false;

        if (movimientoCredito.contains(mov)) {
            if (nuevosPuntos>0) mov.setPuntos(nuevosPuntos);
            if (nuevaFecha != null) mov.setFecha(nuevaFecha);
            if (nuevoCliente != null) mov.setCliente(nuevoCliente);
            if (nuevoMovimientoCredito != null) mov.setMovimientoCredito(nuevoMovimientoCredito);
            modificado = true;
        }

        return modificado;
    }
}
