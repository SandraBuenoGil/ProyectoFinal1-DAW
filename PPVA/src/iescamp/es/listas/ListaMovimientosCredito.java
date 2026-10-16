package iescamp.es.listas;

import iescamp.es.movimientos.MovimientoCredito;
import iescamp.es.tablas.TipoMovimientoCredito;
import iescamp.es.usuarios.Cliente;
import iescamp.es.miLibreria.Utils;

import java.util.ArrayList;

public class ListaMovimientosCredito {
    private ArrayList<MovimientoCredito> movimientoCredito;

    public ListaMovimientosCredito(ArrayList<MovimientoCredito> movimientoCredito) {
        this.movimientoCredito = movimientoCredito;
    }

    public ListaMovimientosCredito() {
        movimientoCredito= new ArrayList<MovimientoCredito>();
    }

    /**
     * CREAR MOVIMIENTOS DE CRÉDITO, DEVUELVE UN BOOLEAN
     * @param mov
     * @return
     */
    public boolean crearMovimientosCredito(MovimientoCredito mov) {
        boolean respuesta = false;
        respuesta = movimientoCredito.add(mov);
        return respuesta;
    }

    /**
     * ELIMINAR MOVIMIENTOS POR OBJETO, DEVUELVE UN BOOLEAN
     * @param mov
     * @return
     */
    public boolean eliminarMovimientosCredito(MovimientoCredito mov) {
        boolean borrado = false;
        if (movimientoCredito.contains(mov)) {
            movimientoCredito.remove(mov);
            borrado = true;
        }
        return borrado;
    }

    /**
     * BUSCAR ÚLTIMO MOVIMIENTO POR DNI DEL CLIENTE, DEVUELVE EL OBJETO
     * @param dni
     * @return
     */
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

    /**
     * BUSCAR ÚLTIMO MOVIMIENTO POR DNI DEL CLIENTE, DEVUELVE LA POSICIÓN
     * @param dni
     * @return
     */
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

    /**
     * LISTAR TODOS LOS MOVIMIENTOS
     */
    public void listarMovimientosCredito() {
        for (MovimientoCredito mov : movimientoCredito) {
            System.out.println(mov.toString());
        }
    }

    /**
     * MOSTAR HISORIAL DEL UN CLIENTE POR DNI
     * @param dni
     */
    public void listarMovimientosCliente(String dni) {
        for (MovimientoCredito mov : movimientoCredito) {
            if (mov.getCliente().getDni().equalsIgnoreCase(dni)) {
                System.out.println(mov.toString());
            }
        }
    }

    /**
     * MODIFICAR UN MOVIMIENTO BUSCADO POR OBJETO, DEVUELVE UN BOOLEAN
     * @param mov
     * @param nuevosPuntos
     * @param nuevaFecha
     * @param nuevoCliente
     * @param nuevoMovimientoCredito
     * @return
     */
    public boolean modificaMovCre(MovimientoCredito mov, int nuevosPuntos, String nuevaFecha,
                                  Cliente nuevoCliente, TipoMovimientoCredito nuevoMovimientoCredito) {
        boolean modificado = false;
        if (movimientoCredito.contains(mov)) {
            if (nuevosPuntos >=0) mov.setPuntos(nuevosPuntos);
            if (nuevaFecha != null) mov.setFecha(nuevaFecha);
            if (nuevoCliente != null) mov.setCliente(nuevoCliente);
            if (nuevoMovimientoCredito != null) mov.setMovimientoCredito(nuevoMovimientoCredito);
            modificado = true;
        }
        return modificado;
    }
}
