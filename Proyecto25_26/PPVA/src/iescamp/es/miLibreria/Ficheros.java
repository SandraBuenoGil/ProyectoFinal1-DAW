package iescamp.es.miLibreria;

import iescamp.es.DAO.Articulo;
import iescamp.es.listas.ListaArticulos;
import iescamp.es.listas.ListaReservas;
import iescamp.es.listas.ListaUsuarios;
import iescamp.es.movimientos.Reserva;
import iescamp.es.usuarios.Usuario;

import java.io.*;

public class Ficheros {

    public static boolean escribeObjArticulos(ListaArticulos misArticulos) {
        boolean guardado;
        Articulo art;
        FileOutputStream fs;
        ObjectOutputStream oos;
        String path;
        File f;
        try {
            path = "PPVA/src/iescamp/es/ficheros/articulos.txt";
            fs = new FileOutputStream(path);
            oos = new ObjectOutputStream(fs);
            for (int i = 0; i < misArticulos.totalArticulos(); i++) {
                art = (Articulo) misArticulos.getArticuloPos(i);
                oos.writeObject(art);//escribe el objeto en el flujo de salida
            }
            //cerramos los flujos abiertos una vez utilizados
            System.out.println("Archivo escrito");
            oos.close();
            fs.close();
            guardado = true;
        } catch (IOException e) {
            System.out.println("Error :" + e.getMessage());

            guardado = false;
        }
        return guardado;
    }
    //devuelve 0 si no hay nada, 1 si se han cargado, 2 si no se ha cargado
    public static int cargaArticulos(ListaArticulos miLista) {
        boolean disponible = false;
        int result = 2;
        Articulo art;
        FileInputStream fe = null;
        DataInputStream d = null;
        ObjectInputStream ois;
        File f;
        String path;

        //lectura del fichero (de manera analogo a la escritura)
        try {
            try {
                path = "PPVA/src/iescamp/es/ficheros/articulos.txt";
                f = new File(path);
                if (f.exists()) {
                    System.out.println("El fichero existe !");
                    fe = new FileInputStream(f);
                    ois = new ObjectInputStream(fe);
                    while (fe.available() > 0) {
                        art = (Articulo) ois.readObject();
                        miLista.anyadirArticulo(art);
                        result = 1;
                        disponible = true;
                    }
                    if (!disponible) {
                        result = 0;
                    }
                }
                else{
                    System.out.println("El fichero no exite. ");
                }
            } catch (EOFException eof) {
                System.err.println("Fin de Fichero encontrado. No se han cargado datos");
            } catch (FileNotFoundException fnf) {
                System.err.println("Fichero no encontrado " + fnf);
            } catch (IOException e) {
                System.err.println("Se ha producido un error IOException. No se han cargado datos");
            } catch (ClassNotFoundException e) {
                System.err.println("Error de programa " + e);
            } finally {
                if (d != null) {
                    d.close();
                    fe.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static boolean escribeObjUsuarios(ListaUsuarios misUsuarios) {
        boolean guardado;
        Usuario usu;
        FileOutputStream fs;
        ObjectOutputStream oos;
        String path;
        File f;
        try {
            path = "PPVA/src/iescamp/es/ficheros/usuarios.txt";
            fs = new FileOutputStream(path);
            oos = new ObjectOutputStream(fs);
            for (int i = 0; i < misUsuarios.totalUsuarios(); i++) {
                usu = (Usuario) misUsuarios.getUsuarioPos(i);
                oos.writeObject(usu);//escribe el objeto en el flujo de salida
            }
            //cerramos los flujos abiertos una vez utilizados
            System.out.println("Archivo escrito");
            oos.close();
            fs.close();
            guardado = true;
        } catch (IOException e) {
            System.out.println("Error :" + e.getMessage());
            guardado = false;
        }
        return guardado;
    }
    //devuelve 0 si no hay nada, 1 si se han cargado, 2 si no se ha cargado
    public static int cargaUsuarios(ListaUsuarios misUsuarios) {
        boolean disponible = false;
        int result = 2;
        Usuario usu;
        FileInputStream fe = null;
        DataInputStream d = null;
        ObjectInputStream ois;
        File f;
        String path;

        //lectura del fichero (de manera analogo a la escritura)
        try {
            try {
                path = "PPVA/src/iescamp/es/ficheros/usuarios.txt";
                f = new File(path);
                if (f.exists()) {
                    System.out.println("El fichero existe !");
                    fe = new FileInputStream(f);
                    ois = new ObjectInputStream(fe);
                    while (fe.available() > 0) {
                        usu = (Usuario) ois.readObject();
                        misUsuarios.anyadirUsuario(usu);
                        result = 1;
                        disponible = true;
                    }
                    if (!disponible) {
                        result = 0;
                    }
                }
                else{
                    System.out.println("El fichero no exite. ");
                }
            } catch (EOFException eof) {
                System.err.println("Fin de Fichero encontrado. No se han cargado datos");
            } catch (FileNotFoundException fnf) {
                System.err.println("Fichero no encontrado " + fnf);
            } catch (IOException e) {
                System.err.println("Se ha producido un error IOException. No se han cargado datos");
            } catch (ClassNotFoundException e) {
                System.err.println("Error de programa " + e);
            } finally {
                if (d != null) {
                    d.close();
                    fe.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static boolean escribeObjReservas(ListaReservas misReservas) {
        boolean guardado;
        Reserva reserva;
        FileOutputStream fs;
        ObjectOutputStream oos;
        String path;
        File f;
        try {
            path = "PPVA/src/iescamp/es/ficheros/reservas.txt";
            fs = new FileOutputStream(path);
            oos = new ObjectOutputStream(fs);
            for (int i = 0; i < misReservas.totalReservas(); i++) {
                reserva = (Reserva) misReservas.getReservaPos(i);
                oos.writeObject(reserva);//escribe el objeto en el flujo de salida
            }
            //cerramos los flujos abiertos una vez utilizados
            System.out.println("Archivo escrito");
            oos.close();
            fs.close();
            guardado = true;
        } catch (IOException e) {
            System.out.println("Error :" + e.getMessage());
            guardado = false;
        }
        return guardado;
    }
    //devuelve 0 si no hay nada, 1 si se han cargado, 2 si no se ha cargado
    public static int cargaReservas(ListaReservas misReservas) {
        boolean disponible = false;
        int result = 2;
        Reserva reserva;
        FileInputStream fe = null;
        DataInputStream d = null;
        ObjectInputStream ois;
        File f;
        String path;

        //lectura del fichero (de manera analogo a la escritura)
        try {
            try {
                path = "PPVA/src/iescamp/es/ficheros/reservas.txt";
                f = new File(path);
                if (f.exists()) {
                    System.out.println("El fichero existe !");
                    fe = new FileInputStream(f);
                    ois = new ObjectInputStream(fe);
                    while (fe.available() > 0) {
                        reserva = (Reserva) ois.readObject();
                        misReservas.crearReserva(reserva);
                        result = 1;
                        disponible = true;
                    }
                    if (!disponible) {
                        result = 0;
                    }
                }
                else{
                    System.out.println("El fichero no exite. ");
                }
            } catch (EOFException eof) {
                System.err.println("Fin de Fichero encontrado. No se han cargado datos");
            } catch (FileNotFoundException fnf) {
                System.err.println("Fichero no encontrado " + fnf);
            } catch (IOException e) {
                System.err.println("Se ha producido un error IOException. No se han cargado datos");
            } catch (ClassNotFoundException e) {
                System.err.println("Error de programa " + e);
            } finally {
                if (d != null) {
                    d.close();
                    fe.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
