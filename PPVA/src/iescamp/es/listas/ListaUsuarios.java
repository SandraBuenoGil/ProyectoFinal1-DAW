package iescamp.es.listas;


import iescamp.es.usuarios.Usuario;

import java.util.ArrayList;

public class ListaUsuarios {
    private ArrayList<Usuario> misUsuarios;

    public ListaUsuarios(ArrayList<Usuario> misUsuarios) {
        this.misUsuarios = misUsuarios;
    }

    public ListaUsuarios() {
        misUsuarios = new ArrayList<Usuario>();
    }

    /**
     * AÑADIR UN USUARIO, SE LE PASA UN USUARIO DEVUELVE UN BOOLEAN
     * @param usu
     * @return boolean
     */
    public boolean anyadirUsuario(Usuario usu) {
        return misUsuarios.add(usu);
    }

    /**
     * BORRAR UN USUARIO, SE LE PASA UN USUARIO
     * @param usu
     * @return boolean
     */
    public boolean borrarUsuario(Usuario usu) {
        boolean borrado = false;
        if (misUsuarios.contains(usu)) {
            misUsuarios.remove(usu);
            borrado = true;
        }
        return borrado;
    }

    /**
     * BORRAR USUARIO POR SU DNI, DEVUELVE UN BOOLEAN
     *
     * @param dni
     * @return boolean
     */
    public boolean borrarUsuario(String dni) {
        boolean borrado = false;
        Usuario usu = buscarUsuDni(dni);
        if (usu != null) {
            misUsuarios.remove(usu);
            borrado = true;
        }
        return borrado;
    }

    /**
     * BORRAR USUARIO POR SU POSICION, DEVUELVE UN BOOLEAN
     * @param pos
     * @return boolean
     */
    public boolean borrarUsuarioPos(int pos) {
        boolean borrado = false;
        if (pos >= 0 && pos < misUsuarios.size()) {
            misUsuarios.remove(pos);
            borrado = true;
        }
        return borrado;
    }

    /**
     * BUSCAR USUARIO POR CODIGO, DEVUELVE EL OBJETO
     * @param dni
     * @return objeto
     */
    public Usuario buscarUsuDni(String dni) {
        Usuario encontrado = null;
        int i = 0;
        while (i < misUsuarios.size() && encontrado == null) {
            Usuario usu = misUsuarios.get(i);
            if (usu.getDni().equalsIgnoreCase(dni)) {
                encontrado = usu;
            } else {
                i++;
            }
        }
        return encontrado;
    }

    /**
     * BUSCAR USUARIO POR DNI, DEVUELVE LA POSICIÓN
     * @param dni
     * @return
     */
    public int buscarUsuario(String dni) {
        int posicion = -1;
        int i = 0;

        while (i < misUsuarios.size() && posicion == -1) {
            Usuario usu = misUsuarios.get(i);
            if (usu.getDni().equalsIgnoreCase(dni)) {
                posicion = i;
            } else {
                i++;
            }
        }
        return posicion;
    }

    /**
     * MODIFICAR USUARIO BUSCADO POR DNI, DEVUELVE UN BOOLEAN
     *
     * @param dni
     * @param nuevoNombre
     * @param nuevoApell
     * @param nuevaDirec
     * @return boolean
     */
    public boolean modificaUsu(String  dni, String nuevoNombre, String nuevoApell, String nuevaDirec) {
        boolean modificado = false;
        Usuario usu = buscarUsuDni(dni);

        if (usu!=null) {
            if (nuevoNombre != null) usu.setNombre(nuevoNombre);
            if (nuevoApell != null) usu.setApellidos(nuevoApell);
            if (nuevaDirec!=null) usu.setDireccion(nuevaDirec);
            modificado = true;
        }

        return modificado;
    }

    /** MODIFICAR UN USUARIO BUSCADO POR OBJETO, DEVUELVE UN BOOLEAN
     * @param usu
     * @param nuevoNombre
     * @param nuevoApell
     * @param nuevaDirec
     * @return boolean
     */
    public boolean modificaUsu(Usuario usu, String nuevoNombre, String nuevoApell, String nuevaDirec) {
        boolean modificado = false;
        if (misUsuarios.contains(usu)) {
            if (nuevoNombre != null) usu.setNombre(nuevoNombre);
            if (nuevoApell != null) usu.setApellidos(nuevoApell);
            if (nuevaDirec!=null) usu.setDireccion(nuevaDirec);
            modificado = true;
        }
        return modificado;
    }


    /**
     * LISTAR TODOS LOS USUARIO DE LA LISTA
     */
    public void listarUsuarios() {
        for (Usuario usu : misUsuarios) {
            System.out.println(usu.mostrarDatosUsuario());
        }
    }

    /**
     * LISTAR EL TIPO DE USUARIO DADO POR TIPO
     * @param tipo
     */
    public void listarUsuTipo(String tipo) {
        for (Usuario usu : misUsuarios) {
            // (Class.forName(tipo).isInstance(a))
            if (usu.getClass().getSimpleName().equalsIgnoreCase(tipo)) {
                System.out.println(usu.mostrarDatosUsuario());
            }
        }
    }

    /**
     * BUSCAR USUARIO POR POSICIÓN, DEVUELVE EL OBJETO
     * @param pos
     * @return objeto
     */
    public Usuario getUsuarioPos(int pos) {
        Usuario resultado = null;
        if (pos >= 0 && pos < misUsuarios.size()) {
            resultado = misUsuarios.get(pos);
        }
        return resultado;
    }

    /**
     * COMPROBAR QUE EXISTE EL USUARIO POR SU DNI, DEVUELVE UN BOOLEAN
     * @param dni
     * @return boolean
     */
    public boolean existeUsuario(String dni) {
        boolean existe = false;
        int i = 0;

        while (i < misUsuarios.size() && !existe) {
            Usuario usu = misUsuarios.get(i);

            if (usu.getDni().equalsIgnoreCase(dni)) {
                existe = true;
            }
            i++;
        }
        return existe;
    }

    /**
     * TOTAL DE TODOS LOS USUARIOS DE LA LISTA
     * @return int con el total
     */
    public int totalUsuarios() {
        return this.misUsuarios.size();
    }

    /**
     * VACIAR LISTA
     */
    public boolean vaciarLista() {
        misUsuarios.clear();
        return misUsuarios.isEmpty();
    }

}

