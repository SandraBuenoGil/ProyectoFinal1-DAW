package iescamp.es.principal;

import iescamp.es.DAO.*;
import iescamp.es.listas.*;

import static iescamp.es.miLibreria.Utils.*;

import iescamp.es.miLibreria.Ficheros;
import iescamp.es.movimientos.Reserva;
import iescamp.es.tablas.EstadoReserva;
import iescamp.es.tablas.TipoEstado;
import iescamp.es.usuarios.Administrador;
import iescamp.es.usuarios.Cliente;
import iescamp.es.usuarios.Usuario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static iescamp.es.tablas.EstadoReserva.convertirOpcionEnEstadoReserva;
import static iescamp.es.tablas.TipoEstado.convertirOpcionEnTipoEstado;

public class Proyecto25_26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Declaración de variables
        int menu = -1, codigo, dias, pos, opTipoArt;
        String nombre, descripcion, dni;
        Articulo artEncontrado;
        Usuario usuario;
        Reserva reserva;
        boolean valido = false;

        //instanciación de listas
        ListaArticulos misArticulos = new ListaArticulos();
        ListaUsuarios misUsuaros = new ListaUsuarios();
        ListaReservas misReservas = new ListaReservas();

        //--MENU PRINCIPAL--
        do {
            mostrarMenuPrincipal();
            menu = leerOpcionTryCatch("Introduce la opción: ", 1, 5);
            switch (menu) {//OPCIONES MENU PRINCIPAL
                case 1://GESTION DE ARTICULOS
                    gestionAticulos(misArticulos);
                    break;
                case 2://GESTION DE USUARIOS
                    gestionUsuarios(misUsuaros);
                    break;
                case 3://GESTION DE RESERVAS
                    gestionReservar(misReservas, misArticulos, misUsuaros);
                    break;
                case 4://CARGAR FICHEROS
                    Ficheros.cargaArticulos(misArticulos);
                    Ficheros.cargaUsuarios(misUsuaros);
                    break;
                case 5://GUARDAR FICHEROS
                    Ficheros.guardaArticulos(misArticulos);
                    Ficheros.guardaUsuarios(misUsuaros);
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
            }
        } while (menu != 5);//FIN MENU PRINCIPAL
    }

    /**
     * MOSTRAR MENU PRINCIPAL
     */
    public static void mostrarMenuPrincipal() {
        System.out.println("---SELECCIONA UNA OPCIÓN---" +
                "\n1. Gestión de artículos" +
                "\n2. Gestión de Usuarios" +
                "\n3. Gestion de reservas" +
                "\n3. Cargar ficheros" +
                "\n4. Guardar ficheros" +
                "\n5. Salir.");
    }

    /**
     * MOSTRAR MENÚ GESTION ARTÍCULOS
     */
    public static void mostrarMenuGestionArticulos() {
        System.out.println("---SELECCIONA UNA OPCIÓN---" +
                "\n1. Añadir un artículo" +
                "\n2. Borrar un artículo" +
                "\n3. Consultar un artículo" +
                "\n4. Listar todos los artículos" +
                "\n5. Modificar un artículo" +
                "\n6. Mostrar un tipo de artículo" +
                "\n7. Salir");
    }

    /**
     * MOSTRAR MENU GESTIÓN USUARIOS
     */
    public static void mostrarMenuGestionUsuarios() {
        System.out.println("---SELECCIONA UNA OPCIÓN---" +
                "\n1. Añadir un usuario" +
                "\n2. Borrar un usuario" +
                "\n3. Consultar un usuario" +
                "\n4. Listar todos los usuarios" +
                "\n5. Modificar un usuario" +
                "\n6. Mostrar un tipo de usuario" +
                "\n7. Salir");
    }

    /**
     * MOSTRAR MENU GESTIÓN RESERVAS
     */
    public static void mostrarMenuGestionReservas() {
        System.out.println("---SELECCIONA UNA OPCIÓN---" +
                "\n1. Reservar un artículo" +
                "\n2. Modificar una reserva" +
                "\n3. Consultar una reserva" +
                "\n4. Listar reservas de un usuario" +
                "\n5. Salir");
    }

    /**
     * OPCIÓN AÑADIR ARTÍCULO, DEVUELVE UN ARTÍCULO
     *
     * @param misArticulos
     * @param menu
     */
    public static void opcionAnyadirArticulo(ListaArticulos misArticulos, int menu) {
        Scanner sc = new Scanner(System.in);
        int codigo = 0, cantidad = 0, credito = 0, estado = 0;
        float alto, ancho, potencia, energia;
        String nombre, fecha, estadoFisico, tipoHerramienta, forma, marca, descripcion;
        char toxico;
        boolean toxicoboolean, valido = false;
        Articulo art = null;
        TipoEstado tipoEstado;
        LocalDate fechaCad = null;

        do {
            try {
                codigo = leerEntero("Introduce el código: ");
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Carácter invalido. Debe ser un número.");
            }
        } while (!valido);
        System.out.println("Introduce el nombre: ");
        nombre = sc.nextLine();
        System.out.println("Introduce la marca: ");
        marca = sc.nextLine();
        System.out.println("Introduce la descripción: ");
        descripcion = sc.nextLine();
        do {
            try {
                credito = leerEntero("Introduce el coste del producto(créditos): ");
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Carácter invalido. Debe ser un número.");
            }
        } while (!valido);
        do {
            System.out.println("Selecciona la opción de la disponibilidad del producto:" +
                    "\n1. Disponible" +
                    "\n2. Reservado" +
                    "\n3. En uso" +
                    "\n4. Fuera de servicio");
            try {
                estado = leerOpcion("Introduce la opción: ", 1, 4);
            } catch (InputMismatchException e) {
                System.out.println("Carácter invalido. Debe ser un número.");
            }
        } while (estado < 1 || estado > 4);
        tipoEstado = convertirOpcionEnTipoEstado(estado);

        if (menu == 1) {//opción FUNGIBLE
            do {
                System.out.println("Selecciona la opción del tipo del artículo:" +
                        "\n1. Material de construcción" +
                        "\n2. Producto de limpieza y jardinería");
                try {
                    menu = leerOpcion("Introduce la opción: ", 1, 2);
                } catch (InputMismatchException e) {
                    System.out.println("Carácter inválido. Debe ser un número.");
                }
            } while (menu != 1 && menu != 2);
            do {
                valido = false;
                try {
                    cantidad = leerEntero("Introduce el cantidad: ");
                    valido = true;
                } catch (InputMismatchException e) {
                    System.out.println("Carácter inválido. Debe ser un número.");
                }
            } while (!valido);
            do {
                try {
                    valido = false;
                    System.out.println("Introduce el fecha de caducidad dd/mm/yyyy:");
                    fecha = sc.nextLine();
                    fechaCad = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    valido = true;
                } catch (DateTimeParseException e) {
                    System.out.println("Formato incorrecto.");
                }
            } while (!valido);

            if (menu == 1) {//FUNGIBLE-->MATERIAL
                System.out.println("Qué forma tiene?");
                forma = sc.nextLine();
                art = new MaterialConstruccion(codigo, nombre, marca, descripcion, credito, tipoEstado, cantidad, fechaCad, forma);
            } else {//FUNGIBLE-->PRODUCTO
                System.out.println("Es tóxico? S/N");
                toxico = sc.nextLine().toUpperCase().charAt(0);

                while (toxico != 'S' && toxico != 'N') {
                    System.out.println("Carácter inválido. Introduce 'S' o 'N'");
                    toxico = sc.nextLine().toUpperCase().charAt(0);
                }
                toxicoboolean = toxico == 'S';
                art = new ProductoLimpiezaJardineria(codigo, nombre, marca, descripcion, credito, tipoEstado, cantidad, fechaCad, toxicoboolean);
            }
        } else if (menu == 2) {//opción NO FUNGIBLE
            do {
                try {
                    menu = leerOpcion("Selecciona la opcíon del tipo de artículo: " +
                            "\n1. Equipamiento comunitario" +
                            "\n2. Equipo de maquinaria" +
                            "\n3. Herramienta manual", 1, 3);
                } catch (InputMismatchException e) {
                    System.out.println("Error: Debe ser un número entero.");
                }
            } while (menu < 1 || menu > 3);
            System.out.println("Introduce el estado físico");
            estadoFisico = sc.nextLine();

            if (menu == 1) {//NO FUNGIBLE-->COMUNITARIO
                System.out.println("Introduce el alto:");
                alto = sc.nextFloat();
                System.out.println("Introduce el ancho:");
                ancho = sc.nextFloat();
                sc.nextLine();
                art = new EquipamientoComunitario(codigo, nombre, marca, descripcion, credito, tipoEstado, estadoFisico, alto, ancho);
            } else if (menu == 2) {//NO FUNGIBLE-->MAQUINARIA
                System.out.println("Introduce la potencia:");
                potencia = sc.nextFloat();
                System.out.println("Introduce la energía:");
                energia = sc.nextFloat();
                art = new EquipoMaquinaria(codigo, nombre, marca, descripcion, credito, tipoEstado, estadoFisico, potencia, energia);
            } else { //NO FUNGIBLE-->HERRAMIENTA
                System.out.println("Introduce el tipo de herramienta manual");
                tipoHerramienta = sc.nextLine();
                art = new HerramientaManual(codigo, nombre, marca, descripcion, credito, tipoEstado, estadoFisico, tipoHerramienta);
            }
        }
        if (misArticulos.anyadirArticulo(art))
            System.out.println("Producto añadido");
        else System.out.println("Producto no añadido");
    }

    /**
     * MENÚ OPCIONES DE GESTIÓN DE ARTÍCULOS
     *
     * @param misArticulos
     */
    public static void gestionAticulos(ListaArticulos misArticulos) {
        Scanner sc = new Scanner(System.in);
        int opcion, codigo;
        Articulo artEncontrado;
        String nombre, descripcion, tipoArt;

        do {
            mostrarMenuGestionArticulos();
            opcion = leerOpcionTryCatch("Introduce el número de la opción: ", 1, 7);
            switch (opcion) {
                case 1://AÑADIR ARTICULO
                    crearArticulo(misArticulos);
                    break;
                case 2://BORRAR ARTÍCULO
                    codigo = leerEnteroTryCatch("Introduce el código del producto: ");
                    if (misArticulos.borrarArticulo(codigo)) {
                        System.out.println("Articulo eliminado");
                    } else {
                        System.out.println("El artículo no existe");
                    }
                    break;
                case 3://CONSULTAR ARTICULO
                    codigo = leerEnteroTryCatch("Introduce el código del artículo: ");
                    artEncontrado = misArticulos.buscarArtCod(codigo);
                    if (artEncontrado != null) {
                        System.out.println(artEncontrado.mostrarDatos());
                    } else System.out.println("El articulo no existe");
                    break;
                case 4://LISTAR TODOS LOS ARTÍCULOS
                    misArticulos.listarArticulos();
                    break;
                case 5://MODIFICAR UN ARTÍCULO
                    codigo = leerEnteroTryCatch("Introduce el código del artículo a modificar: ");
                    artEncontrado = misArticulos.buscarArtCod(codigo);
                    if (artEncontrado != null) {
                        nombre = leerTexto("Introduce el nuevo nombre: ");
                        descripcion = leerTexto("Introduce la nueva descripcion: ");
                        misArticulos.modificaArt(codigo, nombre, descripcion);
                        System.out.println("Artículo modificado");
                    } else System.out.println("No se ha podido modificar. El artículo no existe");
                    break;
                case 6://MOSTRAR UN TIPO DE ARTICULO
                    mostrarTipoArt(misArticulos);
                    break;
                case 7:
                    System.out.println("Saliendo...");
            }
        } while (opcion != 7);
    }

    /**
     * MENÚ OPCIONES GESTIÓN DE USUARIOS
     *
     * @param misUsuarios
     */
    public static void gestionUsuarios(ListaUsuarios misUsuarios) {
        Scanner sc = new Scanner(System.in);
        int opcion, codigo;
        Usuario usuEncontrado;
        String nombre, apellido, direccion, dni;

        do {
            mostrarMenuGestionUsuarios();
            opcion = leerOpcionTryCatch("Introduce el número de la opción: ", 1, 7);
            switch (opcion) {
                case 1://AÑADIR USUARIO
                    crearUsuario(misUsuarios);
                    break;
                case 2://BORRAR USUARIO
                    dni = leerTexto("Introduce el DNI del usuario a eliminar: ");
                    if (misUsuarios.borrarUsuario(dni)) {
                        System.out.println("Usuario eliminado");
                    } else {
                        System.out.println("El usuario no existe");
                    }
                    break;
                case 3://CONSULTAR USUARIO
                    dni = leerTexto("Introduce el DNI del usuario: ");
                    usuEncontrado = misUsuarios.buscarUsuDni(dni);
                    if (usuEncontrado != null) {
                        System.out.println(usuEncontrado.mostrarDatosUsuario());
                    } else System.out.println("El articulo no existe");
                    break;
                case 4://LISTAR TODOS LOS USUARIOS
                    misUsuarios.listarUsuarios();
                    break;
                case 5://MODIFICAR UN USUARIO
                    dni = leerTexto("Introduce el DNI del usuario a modificar: ");
                    usuEncontrado = misUsuarios.buscarUsuDni(dni);
                    if (usuEncontrado != null) {
                        nombre = leerTexto("Introduce el nuevo nombre: ");
                        apellido = leerTexto("Introduce los nuevos apellidos: ");
                        direccion = leerTexto("Introduce la nueva dirección: ");
                        misUsuarios.modificaUsu(dni, nombre, apellido, direccion);
                        System.out.println("Artículo modificado");
                    } else System.out.println("No se ha podido modificar. El usuario no existe");
                    break;
                case 6://MOSTRAR UN TIPO DE USUARIO
                    mostrarTipoUsu(misUsuarios);
                    break;
                case 7:
                    System.out.println("Saliendo...");
            }
        } while (opcion != 7);
    }

    /**
     * MENÚ OPCIONES GESTIÓN DE RESERVAS
     *
     * @param misReservas
     * @param misArticulos
     * @param misUsuarios
     */
    public static void gestionReservar(ListaReservas misReservas, ListaArticulos misArticulos, ListaUsuarios misUsuarios) {
        Scanner sc = new Scanner(System.in);
        int opcion, codReserva;
        String fecha, dni;
        LocalDate fechaRes;
        EstadoReserva estado;
        Reserva reserva;
        boolean valido = false;

        do {
            mostrarMenuGestionReservas();
            opcion = leerOpcionTryCatch("Introduce la opción: ", 1, 5);

            switch (opcion) {
                case 1://RESERVAR ARTICULO
                    crearReserva(misReservas, misUsuarios, misArticulos);
                    break;
                case 2://MODIFICAR RESERVA
                    codReserva = leerEnteroTryCatch("Introduce el número de la reserva a modificar:");
                    /*TODO TERMINAR MODIFICAR RESERVA
                    se han pedido los datos pero se tiene que buscar la reserva para poder modificarla.
                    */
                    do {
                        fecha = leerTexto("Introduce la nueva fecha:");
                        try {
                            fechaRes = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                            valido = true;
                        } catch (DateTimeParseException e) {
                            System.out.println("Error: Formato de fecha no valido");
                        }
                    } while (!valido);
                    System.out.println("---SELECCIONA EL ESTADO DE LA RESERVA---" +
                            "\n1. Pendiente" +
                            "\n2. Esperando recogida" +
                            "\n3. En uso" +
                            "\n4. Finalizada" +
                            "\n5. Cancelada" +
                            "\n6. Vencida");
                    opcion = leerEnteroTryCatch("Introduce la opción: ");
                    estado = convertirOpcionEnEstadoReserva(opcion);
                    break;
                case 3://CONSULTAR UNA RESERVA

                    break;
                case 4://LISTAR RESERVAS DE UN CLIENTE
                    dni = leerTexto("Introduce el DNI del cliente para ver sus reservas: ");
                    misReservas.listarReservasCliente(dni);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
            }
        } while (opcion != 5);
    }

    /**
     * OPCION CREAR UN ARTICULO DEL MENU GESTION ARTICULOS
     *
     * @param misArticulos
     */
    public static void crearArticulo(ListaArticulos misArticulos) {
        Scanner sc = new Scanner(System.in);
        int opTipoArt, codigo, credito, cantidad = 0;
        float potencia, energia, ancho, alto;
        String nombre, marca, descripcion, fecha, estadoFisico = "", forma, tipoHerramienta;
        char toxico;
        boolean toxicoB, valido = false;
        LocalDate fechaCad = null;
        Articulo art = null;

        System.out.println("Qué tipo de artículo desea añadir?" +
                "\n1. Producto de limpieza y jardinería" +
                "\n2. Material de construcción" +
                "\n3. Herramienta manual" +
                "\n4. Equipo de maquinaria" +
                "\n5. Equipamiento comunitario");
        opTipoArt = leerOpcionTryCatch("Introduce el número de la opción", 1, 5);

        codigo = leerEnteroTryCatch("Introduce el código: ");
        nombre = leerTexto("Introduce el nombre: ");
        marca = leerTexto("Introduce la marca: ");
        descripcion = leerTexto("Introduce la descripcion: ");
        credito = leerEnteroTryCatch("Introduce el coste del producto(crédito): ");

        if (opTipoArt == 1 || opTipoArt == 2) {
            cantidad = leerEnteroTryCatch("Intoduce la cantidad del producto: ");
            valido = false;
            do {
                try {
                    fecha = leerTexto("Introduce la fecha del producto (dd/mm/yyyy): ");
                    fechaCad = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    valido = true;
                } catch (DateTimeParseException e) {
                    System.out.println("Error: Formato de fecha no valido");
                }
            } while (!valido);
        } else {
            estadoFisico = leerTexto("Introduce el estado fisico: ");
        }
        switch (opTipoArt) {
            case 1://PRODUCTO LIMPIEZA
                System.out.println("Es tóxico? S/N");
                toxico = sc.nextLine().toUpperCase().charAt(0);
                while (toxico != 'S' && toxico != 'N') {
                    System.out.println("Carácter inválido. Introduce 'S' o 'N'");
                    toxico = sc.nextLine().toUpperCase().charAt(0);
                }
                toxicoB = toxico == 'S';
                art = new ProductoLimpiezaJardineria(codigo, nombre, marca, descripcion, credito, TipoEstado.DISPONIBLE, cantidad, fechaCad, toxicoB);
                break;
            case 2://MATERIAL CONSTRUCCION
                forma = leerTexto("Introduce la forma del producto: ");
                art = new MaterialConstruccion(codigo, nombre, marca, descripcion, credito, TipoEstado.DISPONIBLE, cantidad, fechaCad, forma);
                break;
            case 3://HERRAMIENTA MANUAL
                tipoHerramienta = leerTexto("Qué tipo de herramienta manual es?: ");
                art = new HerramientaManual(codigo, nombre, marca, descripcion, credito, TipoEstado.DISPONIBLE, estadoFisico, tipoHerramienta);
                break;
            case 4://EQUIPO MAQUINARIA
                potencia = leerFloatTryCatch("Introduce la potencia: ");
                energia = leerFloatTryCatch("Introduce la energía: ");
                art = new EquipoMaquinaria(codigo, nombre, marca, descripcion, credito, TipoEstado.DISPONIBLE, estadoFisico, potencia, energia);
                break;
            case 5://EQUIPO COMUNITARIO
                alto = leerFloatTryCatch("Introduce el alto: ");
                ancho = leerFloatTryCatch("Introduce el ancho: ");
                sc.nextLine();
                art = new EquipamientoComunitario(codigo, nombre, marca, descripcion, credito, TipoEstado.DISPONIBLE, estadoFisico, alto, ancho);
                break;
        }
        if (misArticulos.anyadirArticulo(art)) {
            System.out.println("Artículo añadido correctamente.");
        } else System.out.println("No se ha podido añadir el artículo.");
    }

    /**
     * OPCION CREAR UN USUARIO DEL MENU GESTION USUARIOS
     *
     * @param listaUsuarios
     */
    public static void crearUsuario(ListaUsuarios listaUsuarios) {
        Scanner sc = new Scanner(System.in);

        String dni, nombre, apellidos, telefono, direccion, email, password, fecha;
        LocalDate fechaNac = null, fechaNom = null, fechaCese;
        int opcion, credito;
        Usuario usu = null;
        boolean valido = false;

        System.out.println("---SELECCIONA UNA OPCION---" +
                "\n1. Administrador" +
                "\n2. Usuario");
        opcion = leerEnteroTryCatch("Introduce la opción: ");

        dni = leerTexto("Introduce el dni: ");
        nombre = leerTexto("Introduce el nombre: ");
        apellidos = leerTexto("Introduce los apellidos: ");
        telefono = leerTexto("Introduce el teléfono: ");
        do {
            try {
                fecha = leerTexto("Introduce la fecha de naciemiento: ");
                fechaNac = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                valido = true;
            }catch (DateTimeParseException e) {
                System.out.println("Error: Formato de fecha no valido");
            }
        } while (!valido);
        valido = false;
        direccion = leerTexto("Introduce el direccion: ");
        email = leerTexto("Introduce el email: ");
        password = leerTexto("Introduce el password: ");

        switch (opcion) {
            case 1://ADMINISTRADOR
                do {
                    try {
                        fecha = leerTexto("Introduce la fecha de inicio: ");
                        fechaNom = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        valido = true;
                    }catch (DateTimeParseException e) {
                        System.out.println("Error: Formato de fecha no valido");
                    }
                } while (!valido);
                usu = new Administrador(dni, nombre, apellidos, telefono, fechaNac, direccion, email, password, true, fechaNom, null);
                break;
            case 2://CLIENTE
                usu = new Cliente(dni, nombre, apellidos, telefono, fechaNac, direccion, email, password, true, 0, false);
                break;
        }
        if (listaUsuarios.anyadirUsuario(usu)) {
            System.out.println("Usuario añadido correctamente.");
        } else {
            System.out.println("No se ha podido añadir el usuario");
        }
    }

    /**
     * OPCIÓN CREAR RESERVA DEL MENÚ GESTION RESERVAS
     *
     * @param misReservas
     * @param misUsuarios
     * @param misArticulos
     */
    public static void crearReserva(ListaReservas misReservas, ListaUsuarios misUsuarios, ListaArticulos misArticulos) {
        Scanner sc = new Scanner(System.in);
        int codReserva = 0, opcion, codArticulo, dias;
        String fecha = "", dni;
        LocalDate fechaRes = null;
        Cliente cliente;
        Articulo art;
        EstadoReserva estado = null;
        Reserva reserva = null;
        boolean valido = false;

        dni = leerTexto("Introduce el dni del cliente: ");
        cliente = (Cliente) misUsuarios.buscarUsuDni(dni);

        if (cliente != null) {
            codArticulo = leerEnteroTryCatch("Introduce el codigo del articulo que desea reservar: ");
            art = misArticulos.buscarArtCod(codArticulo);
            if (art != null) {
                System.out.println("Introduce el número de reserva");
                codReserva = leerEnteroTryCatch("Introduce el numero de reserva: ");
                do {
                    try {
                        System.out.println("Introduce la fecha");
                        fecha = leerTexto("Introduce la fecha(dd/mm/yyyy): ");
                        fechaRes = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        valido = true;
                    } catch (DateTimeParseException e) {
                        System.out.println("Error: Formato incorrecto.");
                    }
                } while (!valido);
                reserva = new Reserva(codReserva, fechaRes, cliente, EstadoReserva.PENDIENTECONFIRMAR);
                if (misReservas.crearReserva(reserva)) {
                    art.setEstado(TipoEstado.RESERVADO);
                    System.out.println("Reserva añadida correctamente.");
                    dias = leerEnteroTryCatch("Introduce la canitdad de días a reservar: ");
                    if (art instanceof ManualDigital) {
                        if (dias <= ((ManualDigital) art).getMaxDiasPrestamo()) {
                            System.out.println("Precio de la reserva: " + ((ManualDigital) art).calcularCreditoUso(dias));
                        } else {
                            System.out.println("No se puede reservar tantos días.");
                        }
                    } else {
                        System.out.println("Precio de la reserva: " + art.getCredito() * dias);
                    }
                } else {
                    System.out.println("No se ha podido realizar la reserva.");
                }
            }
            System.out.println("El aetículo no existe");
        } else {
            System.out.println("El cliente no existe");
        }
    }

    /**
     * MUESTRA UNA LISTA DE UN TIPO DE ARTÍCULOS PASADO POR PARAMETRO
     *
     * @param misArticulos
     */
    public static void mostrarTipoArt(ListaArticulos misArticulos) {
        int op;
        String tipoArt = "";
        System.out.println("Qué tipo de artículo desea ver?" +
                "\n1. Producto de limpieza y jardinería" +
                "\n2. Material de construcción" +
                "\n3. Herramienta manual" +
                "\n4. Equipo de maquinaria" +
                "\n5. Equipamiento comunitario");
        op = leerOpcionTryCatch("Introduce el número de la opción", 1, 5);
        switch (op) {
            case 1:
                tipoArt = "ProductoLimpiezaJardineria";
                break;
            case 2:
                tipoArt = "MaterialConstruccion";
                break;
            case 3:
                tipoArt = "HerramientaManual";
                break;
            case 4:
                tipoArt = "EquipoMaquinaria";
                break;
            case 5:
                tipoArt = "EquipamientoComunitario";
                break;
        }
        misArticulos.listarArtTipo(tipoArt);
    }

    /**
     * MUESTRA UNA LISTA DE UN TIPO DE USUARIOS PASADOS POR PARÁMETRO
     *
     * @param misUsuarios
     */
    public static void mostrarTipoUsu(ListaUsuarios misUsuarios) {
        int op;
        String tipoUsu = "";
        System.out.println("Qué tipo de usuario desea ver?" +
                "\n1. Administrador" +
                "\n2. Cliente");
        op = leerOpcionTryCatch("Introduce el número de la opción", 1, 5);
        switch (op) {
            case 1:
                tipoUsu = "Administrador";
                break;
            case 2:
                tipoUsu = "Cliente";
                break;
        }
        misUsuarios.listarUsuTipo(tipoUsu);
    }
}