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

    //Método para añadir un Usuario.
    public boolean anyadirUsuario(Usuario usu) {
        boolean respuesta = false;
        respuesta = misUsuarios.add(usu);
        return respuesta;
    }

    //Método para borrar usuario por objeto.
    public boolean borrarUsuario(Usuario usu) {
        boolean borrado = false;

        if (misUsuarios.contains(usu)) {
            misUsuarios.remove(usu);
            borrado = true;
        }
        return borrado;
    }

    //Método para borrar usuario por dni.
    public boolean borrarUsuario(String dni) {
        boolean borrado = false;

        Usuario usu = buscarUsuDni(dni);
        if (usu != null) {
            misUsuarios.remove(usu);
            borrado = true;
        }
        return borrado;

    }

    //Método para borrar Usuario por posición.
    public boolean borrarUsuarioPos(int pos) {
        boolean borrado = false;

        if (pos >= 0 && pos < misUsuarios.size()) {
            misUsuarios.remove(pos);
            borrado = true;
        }
        return borrado;
    }

    //Método para buscar usuario por dni. Devuelve el objeto.
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
    //Método para buscar usuario por dni. Devuelve la posición.
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

    //Método para modificar usuario, búsqueda por dni.
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

    //Método para modificar Usuario, búsqueda por objeto.
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


    //Método para listar todos los usuarios.
    public void listarUsuarios() {
        for (Usuario usu : misUsuarios) {
            System.out.println(usu.mostrarDatosUsuario());
        }
    }

    //Método para listar usuarios por tipo.
    public void listarUsuTipo(String tipo) {
        for (Usuario usu : misUsuarios) {
            // (Class.forName(tipo).isInstance(a))
            if (usu.getClass().getSimpleName().equalsIgnoreCase(tipo)) {
                System.out.println(usu.mostrarDatosUsuario());
            }
        }
    }

    //Método que devuelve un usuario de una posición concreta.
    public Usuario getUsuarioPos(int pos) {
        Usuario resultado = null;
        if (pos >= 0 && pos < misUsuarios.size()) {
            resultado = misUsuarios.get(pos);
        }
        return resultado;
    }

    //Método para comprobar si existe un usuario por dni.
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

    //Método para contar cuántos usuarios hay.
    public int totalUsuarios() {
        return this.misUsuarios.size();
    }

    public boolean vaciarLista() {
        misUsuarios.clear();
        return misUsuarios.isEmpty();
    }

}

