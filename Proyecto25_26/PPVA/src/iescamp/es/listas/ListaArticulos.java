package iescamp.es.listas;

import iescamp.es.DAO.Articulo;
import iescamp.es.DAO.ManualDigital;
import iescamp.es.tablas.TipoEstado;

import java.util.ArrayList;

public class ListaArticulos {
    private ArrayList<Articulo> misArticulos;

    //Constructor con parámetro, para crear la Lista de artículos a partir de datos existentes.
    public ListaArticulos(ArrayList<Articulo> misArticulos) {
        this.misArticulos = misArticulos;
    }

    //Constructor sin parámetros, para crear a partir de cero.
    public ListaArticulos() {
        misArticulos = new ArrayList<Articulo>();
    }

    //Método para añadir artículo.
    public boolean anyadirArticulo(Articulo art) {
        boolean respuesta = false;
        respuesta = misArticulos.add(art);
        return respuesta;
    }

    //Método para borrar artículo por objeto.
    public boolean borrarArticulo(Articulo art) {
        boolean borrado = false;

        if (misArticulos.contains(art)) {
            misArticulos.remove(art);
            borrado = true;
        }
        return borrado;
    }

    //Método para borrar artículo por código.
    public boolean borrarArticulo(int codArt) {
        boolean borrado = false;

        Articulo articulo = buscarArtCod(codArt);
        if (articulo != null) {
            misArticulos.remove(articulo);
            borrado = true;
        }
        return borrado;

    }

    //Método para borrar artículo por posición.
    public boolean borrarArticuloPos(int pos) {
        boolean borrado = false;

        if (pos >= 0 && pos < misArticulos.size()) {
            misArticulos.remove(pos);
            borrado = true;
        }
        return borrado;
    }

    //Método para buscar artículo por código. Devuelve el objeto.
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

    //Método para buscar artículo por código. Devuelve la posición.
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

    //Método para modificar artículo, búsqueda por código.
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


    //Método para modificar artículo, búsqueda por objeto.
    public boolean modificaArt(Articulo art, String nuevoNombre, String nuevaDescripcion) {
        boolean modificado = false;

        if (misArticulos.contains(art)) {
            if (nuevoNombre != null) art.setNombre(nuevoNombre);
            if (nuevaDescripcion != null) art.setDescripcion(nuevaDescripcion);
            modificado = true;
        }

        return modificado;
    }


    //Método para listar todos los artículos.
    public void listarArticulos() {
        for (Articulo art : misArticulos) {
            System.out.println(art.mostrarDatos());
        }
    }

    //Método para listar artículos por tipo.
    public void listarArtTipo(String tipo) {
        for (Articulo art : misArticulos) {
            if (art.getClass().getSimpleName().equalsIgnoreCase(tipo)) {
                System.out.println(art.mostrarDatos());
            }
        }
    }

    //Método para comprobar si un artículo está disponible.
    public boolean disponibleArt(int codArt) {
        boolean disponible = false;

        Articulo art = buscarArtCod(codArt);

        if (art != null && art.getEstado() == TipoEstado.DISPONIBLE) {
            disponible = true;
        }

        return disponible;
    }

    //Método para listar artículos disponibles.
    public void listarDisponible() {
        for (Articulo art : misArticulos) {
            if (art.getEstado() == TipoEstado.DISPONIBLE) {
                System.out.println(art.mostrarDatos());
            }
        }
    }

    //Método que devuelve un artículo de una posición concreta.
    public Articulo getArticuloPos(int pos) {
        Articulo resultado = null;
        if (pos >= 0 && pos < misArticulos.size()) {
            resultado = misArticulos.get(pos);
        }
        return resultado;
    }

    //Método para comprobar si existe un artículo por código.
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

    //Método para contar cuántos artículos hay.
    public int totalArticulos() {
        return this.misArticulos.size();
    }
    public boolean vaciarLista() {
        misArticulos.clear();
        return misArticulos.isEmpty();
    }

}
