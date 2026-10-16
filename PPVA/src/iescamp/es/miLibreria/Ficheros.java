package iescamp.es.miLibreria;

import iescamp.es.DAO.Articulo;
import iescamp.es.listas.ListaArticulos;
import iescamp.es.listas.ListaUsuarios;
import iescamp.es.usuarios.Usuario;

import java.io.*;

public class Ficheros {
    public static boolean guardaArticulos(ListaArticulos miListaArticulos) {
        boolean guardado;
        Articulo art;
        FileOutputStream fileStream = null;
        ObjectOutputStream objectStream = null;
        String path;

        try {
            path = "PPVA_SandraBuenoGil/PPVA/src/iescamp/es/ficheros/articulos.txt";
            fileStream = new FileOutputStream(path);//se crea la conexión con el destino de los archivos
            objectStream = new ObjectOutputStream(fileStream);//se traducen los objetos a arhivos
            for (int i = 0; i < miListaArticulos.totalArticulos(); i++) {
                art = miListaArticulos.getArticuloPosicion(i);//se coge cada objeto de la lista
                objectStream.writeObject(art);//se guarda en la dirección (path) dada ya traducidos
            }
            System.out.println("Articulo guardado exitosamente");
            objectStream.close();//se cierra el flujo
            fileStream.close();
            guardado = true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            guardado = false;
        }
        return guardado;
    }

    public static int cargaArticulos(ListaArticulos miListaArticulos) {
        boolean disponible = false;
        int resultado = 2;//por defecto se deja como resultado 2 que sería equivalente a ha habido un error
        Articulo art;
        FileInputStream fileStream = null;
        ObjectInputStream objectStream = null;
        DataInputStream dataStream = null;
        File file;
        String path;
        try {/*se hace otro try para que el finally capture el IOException al cerrar los flujos (objectSream.close()), se ponen en el finally
        para que pase una cosa u otra se cierren*/
            try {
                path = "PPVA_SandraBuenoGil\\PPVA\\src\\iescamp\\es\\ficheros\\articulos.txt";
                file = new File(path);//directorio al que se le da el path
                if (file.exists()) {
                    System.out.println("Fichero encontrado. Cargango archivos...");
                    miListaArticulos.vaciarLista();//vaciamos la lista primero para que no se dupliquen los datos
                    fileStream = new FileInputStream(file);//conexión con el directorio para pasar los archivos a guardar en bruto
                    objectStream = new ObjectInputStream(fileStream);//traductor de los archivos en bruto que se pasan
                    while (fileStream.available() > 0) {
                        art = (Articulo) objectStream.readObject();//traduce los archivos guardado a objetos que se leen en el programa para guardarlos de nuevo
                        miListaArticulos.anyadirArticulo(art);//aquí se guardan de nuevo los archivos que se han sacado a través de objectStream y se han traducido al objeto correspondiente
                        resultado = 1;//esto es para que dependiendo de lo que haga (encuentre, no encuentre, haya un fallo) a la hora de llamarlo de más que dos opciones, como lo haría con boolean
                        disponible = true;
                    }
                    if (!disponible) {
                        resultado = 0;//aquí si no se ha encontrado archivos devuelve 0
                    }
                } else {
                    System.out.println("El fichero no existe");
                }
            } catch (FileNotFoundException fnfe) {
                System.out.println("Fichero no encontrado.");
            } catch (ClassNotFoundException cnft) {
                System.out.println("Objeto no encontrado.");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } finally {
                if (dataStream != null) {
                    objectStream.close();
                    fileStream.close();
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return resultado;
    }

    public static boolean guardaUsuarios(ListaUsuarios miListaUsuarios) {
        boolean guardado;
        Usuario usu;
        FileOutputStream fileStream = null;
        ObjectOutputStream objectStream = null;
        String path;

        try {
            path = "PPVA_SandraBuenoGil/PPVA/src/iescamp/es/ficheros/usuarios.txt";
            fileStream = new FileOutputStream(path);//se crea la conexión con el destino de los archivos
            objectStream = new ObjectOutputStream(fileStream);//se traducen los objetos a arhivos
            for (int i = 0; i < miListaUsuarios.totalUsuarios(); i++) {
                usu = miListaUsuarios.getUsuarioPos(i);//se coge cada objeto de la lista
                objectStream.writeObject(usu);//se guarda en la dirección (path) dada ya traducidos
            }
            System.out.println("Usuarios guardado exitosamente");
            objectStream.close();//se cierra el flujo
            fileStream.close();
            guardado = true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            guardado = false;
        }
        return guardado;
    }

    public static int cargaUsuarios(ListaUsuarios miListaUsuarios) {
        boolean disponible = false;
        int resultado = 2;//por defecto se deja como resultado 2 que sería equivalente a ha habido un error
        Usuario usu;
        FileInputStream fileStream = null;
        ObjectInputStream objectStream = null;
        DataInputStream dataStream = null;
        File file;
        String path;
        try {/*se hace otro try para que el finally capture el IOException al cerrar los flujos (objectSream.close()), se ponen en el finally
        para que pase una cosa u otra se cierren*/
            try {
                path = "PPVA_SandraBuenoGil\\PPVA\\src\\iescamp\\es\\ficheros\\usuarios.txt";
                file = new File(path);//directorio al que se le da el path
                if (file.exists()) {
                    miListaUsuarios.vaciarLista();//vaciamos la lista primero para queno se dupliquen los datos
                    System.out.println("Fichero encontrado. Cargango archivos...");
                    fileStream = new FileInputStream(file);//conexión con el directorio para pasar los archivos a guardar en bruto
                    objectStream = new ObjectInputStream(fileStream);//traductor de los archivos en bruto que se pasan
                    while (fileStream.available() > 0) {
                        usu = (Usuario) objectStream.readObject();//traduce los archivos guardado a objetos que se leen en el programa para guardarlos de nuevo
                        miListaUsuarios.anyadirUsuario(usu);//aquí se guardan de nuevo los archivos que se han sacado a través de objectStream y se han traducido al objeto correspondiente
                        resultado = 1;//esto es para que dependiendo de lo que haga (encuentre, no encuentre, haya un fallo) a la hora de llamarlo de más que dos opciones, como lo haría con boolean
                        disponible = true;
                    }
                    if (!disponible) {
                        resultado = 0;//aquí si no se ha encontrado archivos devuelve 0
                    }
                } else {
                    System.out.println("El fichero no existe");
                }
            } catch (FileNotFoundException fnfe) {
                System.out.println("Fichero no encontrado.");
            } catch (ClassNotFoundException cnft) {
                System.out.println("Objeto no encontrado.");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } finally {
                if (dataStream != null) {
                    objectStream.close();
                    fileStream.close();
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return resultado;
    }
}
