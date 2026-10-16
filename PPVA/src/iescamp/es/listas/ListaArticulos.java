package iescamp.es.listas;

import iescamp.es.DAO.Articulo;
import iescamp.es.tablas.TipoEstado;

import java.util.ArrayList;

public class ListaArticulos {
    private ArrayList<Articulo> misArticulos;

    public ListaArticulos(ArrayList<Articulo> misArticulos) {
        this.misArticulos = misArticulos;
    }

    public ListaArticulos() {
        misArticulos = new ArrayList<Articulo>();
    }

    /**
     * AÑADIR UN ARTÍCULO, SE LE PASA UN ARTÍCULO
     * @param art
     * @return boolean
     */
    public boolean anyadirArticulo(Articulo art) {
        boolean respuesta = false;
        respuesta = misArticulos.add(art);
        return respuesta;
    }

    /**
     * BORRAR UN ARTÍCULO, SE LE PASA UN ARTÍCULO
     * @param art
     * @return boolean
     */
    public boolean borrarArticulo(Articulo art) {
        boolean borrado = false;

        if (misArticulos.contains(art)) {
            misArticulos.remove(art);
            borrado = true;
        }
        return borrado;
    }

    /**
     * BORRAR ARTÍCULO POR SU CÓDIGO, DEVUELVE UN BOOLEAN
     *
     * @param codArt
     * @return boolean
     */
    public boolean borrarArticulo(int codArt) {
        boolean borrado = false;

        Articulo articulo = buscarArtCod(codArt);
        if (articulo != null) {
            misArticulos.remove(articulo);
            borrado = true;
        }
        return borrado;

    }

    /**
     * BORRAR ARTÍCULO POR SU POSICION, DEVUELVE UN BOOLEAN
     * @param pos
     * @return boolean
     */
    public boolean borrarArticuloPos(int pos) {
        boolean borrado = false;

        if (pos >= 0 && pos < misArticulos.size()) {
            misArticulos.remove(pos);
            borrado = true;
        }
        return borrado;
    }

    /**
     * BUSCAR ARTÍCULO POR CODIGO, DEVUELVE EL OBJETO
     * @param codArt
     * @return objeto
     */
    public Articulo buscarArtCod(int codArt) {
        Articulo encontrado = null;
        int i = 0;

        while (i < misArticulos.size() && encontrado == null) {
            Articulo art = misArticulos.get(i);
            if (art.getCodArticulo() == codArt) {
                encontrado = art;
            } else {
                i++;
            }
        }
        return encontrado;
    }

    /**
     * BUSCAR ARTÍCULO POR CÓDIGO, DEVUELVE LA POSICIÓN
     * @param codArt
     * @return
     */
    public int buscarArt(int codArt) {
        int posicion = -1;
        int i = 0;

        while (i < misArticulos.size() && posicion == -1) {
            Articulo art = misArticulos.get(i);
            if (art.getCodArticulo() == codArt) {
                posicion = i;
            } else {
                i++;
            }
        }

        return posicion;
    }

    /**
     * OBTENER OBJETO POR SU POSICIÓN
     * @param pos
     * @return objeto
     */
    public Articulo getArticuloPosicion(int pos) {
        Articulo art = null;
        if (pos >= 0 && pos < misArticulos.size()) {
            art = misArticulos.get(pos);
        }
        return art;
    }

    /**
     * MODIFICAR ARTICULO BUSCADO POR CÓDIGO, DEVUELVE UN BOOLEAN
     *
     * @param codArt
     * @param nuevoNombre
     * @param nuevaDescripcion
     * @return boolean
     */
    public boolean modificaArt(int codArt, String nuevoNombre, String nuevaDescripcion) {
        boolean modificado = false;
        Articulo art = buscarArtCod(codArt);
        if (art != null) {
            if (nuevoNombre != null) art.setNombre(nuevoNombre);
            if (nuevaDescripcion != null) art.setDescripcion(nuevaDescripcion);
            modificado = true;
        }
        return modificado;
    }


    /** MODIFICAR UN ARTICULO BUSCADO POR OBJETO, DEVUELVE UN BOOLEAN
     * @param art
     * @param nuevoNombre
     * @param nuevaDescripcion
     * @return boolean
     */
    public boolean modificaArt(Articulo art, String nuevoNombre, String nuevaDescripcion) {
        boolean modificado = false;
        if (misArticulos.contains(art)) {
            if (nuevoNombre != null) art.setNombre(nuevoNombre);
            if (nuevaDescripcion != null) art.setDescripcion(nuevaDescripcion);
            modificado = true;
        }
        return modificado;
    }


    /**
     * LISTAR TODOS LOS ARTÍCULOS DE LA LISTA
     */
    public void listarArticulos() {
        for (Articulo art : misArticulos) {
            System.out.println(art.mostrarDatos());
        }
    }

    /**
     * LISTAR EL TIPO DE ARTÍCULO DADO POR TIPO
     * @param tipo
     */
    public void listarArtTipo(String tipo) {
        for (Articulo art : misArticulos) {
            if (art.getClass().getSimpleName().equalsIgnoreCase(tipo)) {
                System.out.println(art.mostrarDatos());
            }
        }
    }

    /**
     * SABER SI UN ARTÍCULO ESTÁ DISPONIBLE BUSCADO POR CÓDIGO, DEVUELVE UN BOOLEAN
     * @param codArt
     * @return boolean
     */
    public boolean disponibleArt(int codArt) {
        boolean disponible = false;
        Articulo art = buscarArtCod(codArt);
        if (art != null && art.getEstado() == TipoEstado.DISPONIBLE) {
            disponible = true;
        }
        return disponible;
    }

    /**
     * LISTAR TODOS LOS ARTÍCULOS DISPONIBLES
     */
    public void listarDisponible() {
        for (Articulo art : misArticulos) {
            if (art.getEstado() == TipoEstado.DISPONIBLE) {
                System.out.println(art.mostrarDatos());
            }
        }
    }

    /**
     * COMPROBAR QUE EXISTE EL ARTÍCULO POR SU CÓDIGO, DEVUELVE UN BOOLEAN
     * @param codArt
     * @return boolean
     */
    public boolean existeArticulo(int codArt) {
        boolean existe = false;
        int i = 0;
        while (i < misArticulos.size() && !existe) {
            Articulo art = misArticulos.get(i);
            if (art.getCodArticulo() == codArt) {
                existe = true;
            }
            i++;
        }
        return existe;
    }

    /**
     * SABER EL TOTAL DE TODOS LOS ARTÍCULOS DE LA LISTA
     * @return int con el total
     */
    public int totalArticulos() {
        return this.misArticulos.size();
    }

    /**
     * VACIAR LISTA
     */
    public boolean vaciarLista() {
        misArticulos.clear();
        return misArticulos.isEmpty();
    }
}