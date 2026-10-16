package iescamp.es.principal;

import iescamp.es.DAO.*;
import iescamp.es.listas.ListaArticulos;
import iescamp.es.listas.ListaReservas;
import iescamp.es.listas.ListaUsuarios;
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

import static iescamp.es.miLibreria.Utils.*;

public class Proyecto25_26 {
    public static void main(String[] args) {
        ListaArticulos misArticulos = new ListaArticulos();
        ListaUsuarios  misUsuarios = new ListaUsuarios();
        ListaReservas  misReservas = new ListaReservas();
        int opPrincipal, codArt;
        String tipo, dniCli, fecha;
        Articulo arti;
        Reserva reserva;

        do {
            mostrarMenuPrincipal();
            opPrincipal = leerOpcion("Seleccione una opción: ", 0, 5);
            switch (opPrincipal) {
                case 1:
                    gestionArticulos(misArticulos);
                    break;
                case 2:
                    gestionUsuarios(misUsuarios);
                    break;
                case 3:
                    gestionReservas(misArticulos, misUsuarios, misReservas);
                    break;
                case 4:
                    // guaradamos los objetos en ficheros
                    iescamp.es.miLibreria.Ficheros.escribeObjArticulos(misArticulos);
                    iescamp.es.miLibreria.Ficheros.escribeObjUsuarios(misUsuarios);
                    break;
                case 5:
                    // guaradamos los objetos en ficheros
                    iescamp.es.miLibreria.Ficheros.cargaArticulos(misArticulos);
                    iescamp.es.miLibreria.Ficheros.cargaUsuarios(misUsuarios);
                    break;
                case 0:
                    System.out.println();
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opPrincipal != 0);
    }

    public static void gestionArticulos(ListaArticulos misArticulos) {
        int opArticulos;
        String tipo;
        do {
            mostrarMenuArticulos();
            opArticulos = leerOpcion("Seleccione una opción: ", 0, 7);
            switch (opArticulos) {
                case 1:
                    anyadirArticulo(misArticulos);
                    break;
                case 2:
                    borrarArticulo(misArticulos);
                    break;
                case 3:
                    consultarArticulo(misArticulos);
                    break;
                case 4:
                    misArticulos.listarArticulos();
                    break;
                case 5:
                    modificarArticulo(misArticulos);
                    break;
                case 6:
                    tipo = leerTexto("Tipo de Arículo a mostrar :");
                    misArticulos.listarArtTipo(tipo);
                    break;
                case 0:
                    System.out.println();
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opArticulos != 0);
    }

    public static void gestionUsuarios(ListaUsuarios misUsuarios) {
        int opArticulos;
        String tipo;
        do {
            mostrarMenuUsuarios();
            opArticulos = leerOpcion("Seleccione una opción: ", 0, 7);
            switch (opArticulos) {
                case 1:
                    // añadir
                    anyadirUsuario(misUsuarios);
                    break;
                case 2:
                    // borrar
                    break;
                case 3:
                    // consultar
                    break;
                case 4:
                    // listar
                    break;
                case 5:
                    // modificar
                    break;
                case 6:
                    // listar por tipo
                    break;
                case 0:
                    System.out.println();
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opArticulos != 0);
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\n--- Menú principal ---");
        System.out.println("1. Mantenimiento de Artículos");
        System.out.println("2. Mantenimiento de Usuarios");
        System.out.println("3. Realizar una Reserva");
        System.out.println("4. Almacenar Articulos en fichero");
        System.out.println("5. Cargar Articulos desde fichero");
        System.out.println("0. Salir");
    }

    private static void mostrarMenuArticulos() {
        System.out.println("\n--- Menú principal ---");
        System.out.println("1. Añadir un Artículo");
        System.out.println("2. Borrar un Artículo");
        System.out.println("3. Consultar un Artículo");
        System.out.println("4. Listar todos los Artículos");
        System.out.println("5. Modificar un Artículo");
        System.out.println("6. Mostrar solo un tipo de Artículo");
        System.out.println("0. Salir");
    }

    private static void mostrarMenuUsuarios() {
        System.out.println("\n--- Menú principal ---");
        System.out.println("1. Añadir un Usuario");
        System.out.println("2. Borrar un Usuario");
        System.out.println("3. Consultar un Usuario");
        System.out.println("4. Listar todos los Usuario");
        System.out.println("5. Modificar un Usuario");
        System.out.println("6. Mostrar solo un tipo de Usuario");
        System.out.println("0. Salir");
    }

    private static void mostrarMenuReserva() {
        System.out.println("\n--- Menú principal ---");
        System.out.println("1. ");
        System.out.println("2. ");
        System.out.println("3. ");
        System.out.println("4. ");
        System.out.println("5. ");
        System.out.println("6. ");
        System.out.println("0. Salir");
    }

    private static void anyadirArticulo(ListaArticulos miLista) {
        int tipo;
        Articulo nuevoArticulo = null;
        System.out.println("Seleccione el tipo de artículo a añadir:");
        System.out.println("1. Equipamiento comunitario");
        System.out.println("2. Equipo de maquinaria");
        System.out.println("3. Herramineta manual");
        System.out.println("4. Material de construcción");
        System.out.println("5. Producto de limpiezo o jardinaría");
        tipo = leerOpcion("Seleccione una opción (1,5):", 1, 5);
        switch (tipo) {
            case 1 -> nuevoArticulo = crearEC();
            case 2 -> nuevoArticulo = crearEM();
            case 3 -> nuevoArticulo = crearHM();
            case 4 -> nuevoArticulo = crearMC();
            case 5 -> nuevoArticulo = crearPLJ();
            default -> System.out.println("Tipo no válido.");
        }
        if (nuevoArticulo != null && miLista.anyadirArticulo(nuevoArticulo)) {
            System.out.println("Artículo añadido con éxito.");
        } else {
            System.out.println("No se pudo añadir el artículo.");
        }
    }

    private static void borrarArticulo(ListaArticulos miLista) {
        int codigo = leerEntero("Escribe el código del artículo a borrar: ", 0);
        if (miLista.borrarArticulo(codigo)) {
            System.out.println("Artículo borrado con éxito.");
        } else {
            System.out.println("Artículo no encontrado.");
        }
    }

    private static void consultarArticulo(ListaArticulos miLista) {
        int codigo = leerEntero("Escribe el código del artículo : ", 0);
        Articulo articulo = miLista.buscarArtCod(codigo);
        if (articulo != null) {
            System.out.println("Detalles del artículo:");
            System.out.println(articulo.muestraArticulo());
        } else {
            System.out.println("Artículo no encontrado.");
        }
    }

    private static void modificarArticulo(ListaArticulos miLista) {
        Articulo articuloModificado = null;
        Articulo nuevoArticulo = null;
        String nuevoNombre, nuevaDescrip;
        int codigo;

        codigo = leerEntero("Escribe el código del artículo : ", 0);
        Articulo articuloExistente = miLista.buscarArtCod(codigo);
        if (articuloExistente != null) {
            // Pedimos nuevos valores
            nuevoNombre  = leerTexto("Escribe el nuevo nombre :");
            nuevaDescrip = leerTexto("Escribe la nueva descripción :");
            if (miLista.modificaArt(articuloExistente, nuevoNombre, nuevaDescrip)) {
                System.out.println("Artículo modificado con éxito.");
            } else {
                System.out.println("No se pudo modificar el artículo.");
            }
        } else {
            System.out.println("Artículo no encontrado.");
        }
    }

    private static EquipamientoComunitario crearEC() {
        int codArt;
        String nombre, marca, descripcion, imagen, estado;
        int credito;
        float ancho, alto;
        
        codArt = leerEntero("Escribe el código del artículo : ", 0);
        do {
            nombre = leerTexto("Nombre : ");
        } while (!valida(nombre));
        credito = leerEntero("Crédito : ", 0);
        marca = leerTexto("Marca: ");
        descripcion = leerTexto("Descripción: ");
        imagen = leerTexto("Imagen: ");
        estado = leerTexto("Describe el estado físico :");
        alto = leerFloat("Altura :", 0);
        ancho = leerFloat("Ancho :", 0);
        return new EquipamientoComunitario(codArt, nombre, marca, descripcion,
                credito, imagen, TipoEstado.DISPONIBLE, estado, alto, ancho);
    }

    private static EquipoMaquinaria crearEM() {
        int codArt;
        String nombre, marca, descripcion, imagen, estado;
        int credito;
        float potencia, energia;
        
        codArt = leerEntero("Escribe el código del artículo : ", 0);
        do {
            nombre = leerTexto("Nombre : ");
        } while (!valida(nombre));
        credito = leerEntero("Crédito : ", 0);
        marca = leerTexto("Marca: ");
        descripcion = leerTexto("Descripción: ");
        imagen = leerTexto("Imagen: ");
        estado = leerTexto("Describe el estado físico :");
        potencia = leerFloat("Potencia :", 0);
        energia = leerFloat("Energia consumida: ", 0);
        return new EquipoMaquinaria(codArt, nombre, marca, descripcion,
                credito, imagen, TipoEstado.DISPONIBLE, estado, potencia, energia);
    }

    private static HerramientaManual crearHM() {
        int codArt;
        String nombre, marca, descripcion, imagen, estado, tipo;
        int credito;
        
        codArt = leerEntero("Escribe el código del artículo : ", 0);
        do {
            nombre = leerTexto("Nombre : ");
        } while (!valida(nombre));
        credito = leerEntero("Crédito : ", 0);
        marca = leerTexto("Marca: ");
        descripcion = leerTexto("Descripción: ");
        imagen = leerTexto("Imagen: ");
        estado = leerTexto("Describe el estado :");
        tipo = leerTexto("Tipo de herramienta :");
        return new HerramientaManual(codArt, nombre, marca, descripcion,
                credito, imagen, TipoEstado.DISPONIBLE, estado, tipo);
    }

    private static MaterialConstruccion crearMC() {
        int codArt;
        String nombre, marca, descripcion, imagen, fecha, forma;
        int credito, cant;
        LocalDate fechaCad;

        codArt = leerEntero("Escribe el código del artículo : ", 0);
        do {
            nombre = leerTexto("Nombre : ");
        } while (!valida(nombre));
        credito = leerEntero("Crédito : ", 0);
        marca = leerTexto("Marca: ");
        descripcion = leerTexto("Descripción: ");
        imagen = leerTexto("Imagen: ");
        cant = leerEntero("Cantidad :");
        fecha = leerTexto("Fecha de caducidad dd/mm/aaaa:");
        // cambiar este String a un objeto LocalDate
        fechaCad = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        forma = leerTexto("Forma del material :");
        return new MaterialConstruccion(codArt, nombre, marca, descripcion, credito,
                imagen, TipoEstado.DISPONIBLE, cant, fechaCad, forma);
    }

    private static ProductoLimpiezaJardineria crearPLJ() {
        int codArt;
        String nombre, marca, descripcion, imagen, fecha, forma, resp;
        int credito, cant;
        boolean toxico = false, correcta = false;
        LocalDate fechaCad = null;

        codArt = leerEntero("Escribe el código del artículo : ", 0);
        do {
            nombre = leerTexto("Nombre : ");
        } while (!valida(nombre));
        credito = leerEntero("Crédito : ", 0);
        marca = leerTexto("Marca: ");
        descripcion = leerTexto("Descripción: ");
        imagen = leerTexto("Imagen: ");
        cant = leerEntero("Cantidad :");
        do {
            try {
                fecha = leerTexto("Fecha de caducidad dd/mm/aaaa :");
                // cambiar este String a un objeto LocalDate
                fechaCad = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                correcta=true;
            }
            catch (DateTimeParseException e){
                System.out.println("ERROR: Fecha o formato incorrectos");
                System.out.println(e.getMessage());
            }
            catch (Exception e){
                System.out.println("ERROR: "+e.getMessage());;
            }
        }while(!correcta);
        forma = leerTexto("Forma del material :");
        toxico = leerSiNO("Es tóxico (sí/no):");

        return new ProductoLimpiezaJardineria(codArt, nombre, marca, descripcion, credito,
                imagen, TipoEstado.DISPONIBLE, cant, fechaCad, toxico);
    }

    private static void anyadirUsuario(ListaUsuarios miLista) {
        int tipo;
        Usuario nuevoUsuario = null;
        System.out.println("Seleccione el tipo de artículo a añadir:");
        System.out.println("1. Administrador");
        System.out.println("2. Cliente");
        tipo = leerOpcion("Seleccione una opción (1,5):", 1, 5);
        switch (tipo) {
            case 1 -> System.out.println(); //nuevoUsuario = crearAdmin();
            case 2 -> nuevoUsuario = crearCliente();

            default -> System.out.println("Tipo no válido.");
        }
        if (nuevoUsuario != null && miLista.anyadirUsuario(nuevoUsuario)) {
            System.out.println("Usuario añadido con éxito.");
        } else {
            System.out.println("No se pudo añadir el usuario.");
        }
    }

    private static Cliente crearCliente() {
        String dni, nombre, apellidos, telefono, direccion, email, contrasenya, fecha;
        LocalDate fechaNacimiento = null;
        boolean activo, correcta=false, penalizado;
        int credito;
        do {
            dni = leerTexto("DNI : ");
        } while (!valida(dni));
        do {
            nombre = leerTexto("Nombre : ");
        } while (!valida(nombre));
        do {
            apellidos = leerTexto("Apellidos : ");
        } while (!valida(apellidos));
        do {
            try {
                fecha = leerTexto("Escribe la fecha de nacimiento dd/mm/aaaa :");
                fechaNacimiento = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                correcta=true;
            }
            catch (DateTimeParseException e){
                System.out.println("ERROR: Fecha o formato incorrectos");
                System.out.println(e.getMessage());
            }
            catch (Exception e){
                System.out.println("ERROR: "+e.getMessage());;
            }
        }while(!correcta);
        do {
            telefono = leerTexto("Teléfono : ");
        } while (!valida(telefono));
        do {
            direccion= leerTexto("Dirección : ");
        } while (!valida(direccion));
        do {
            email = leerTexto("email : ");
        } while (!valida(email));
        do {
            contrasenya = leerTexto("Contraseña : ");
        } while (!valida(contrasenya));
       activo = leerSiNO("Está activo sí/no :");
       credito = leerEntero("Crédito inicial :",0);
       penalizado = leerSiNO("Está penalizado sí/no :");

        return new Cliente(dni,nombre,apellidos,telefono,fechaNacimiento,direccion,
                email,contrasenya,activo,credito,penalizado);
    }

    public static void gestionReservas(ListaArticulos misArticulos, ListaUsuarios misUsuarios, ListaReservas misReservas) {
        int codArt, numReserva, dias;
        String dniCli, fecha;
        EstadoReserva estado;
        Cliente c1, c2, cli;
        Articulo arti;
        Reserva reserva;
        ManualDigital artiManual;
        boolean anyadida, correcta= false;
        LocalDate fechaReserva = null;

        dniCli = leerTexto("Escribe el DNI del cliente :");

        cli = (Cliente) misUsuarios.buscarUsuDni(dniCli);
        if (cli != null) {
            // el cliente existe
            codArt = leerEntero("Escribe el artículo a reservar :", 0);
            arti = misArticulos.buscarArtCod(codArt);
            if (arti != null) {
                // el artículo existe
                numReserva = leerEntero("Número de reserva :", 0);
                do {
                    try {
                        fecha = leerTexto("Escribe la fecha de reserva dd/mm/aaaa :");
                        // cambiar este String a un objeto LocalDate
                        fechaReserva = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        correcta=true;
                    }
                    catch (DateTimeParseException e){
                        System.out.println("ERROR: Fecha o formato incorrectos");
                        System.out.println(e.getMessage());
                    }
                    catch (Exception e){
                        System.out.println("ERROR: "+e.getMessage());;
                    }
                }while(!correcta);
                estado = EstadoReserva.PENDIENTECONFIRMAR;
                reserva = new Reserva(numReserva, fechaReserva, cli, estado);
                anyadida = misReservas.crearReserva(reserva);
                if (anyadida) {
                    System.out.println("Reserva añadida con éxito");
                    dias = leerEntero("Días de reserva :", 0);
                    if (arti instanceof ManualDigital) {
                        artiManual = (ManualDigital) arti;
                        if (dias <= artiManual.getDiasMax()) {
                            System.out.println(("Precio :" + artiManual.calculoCreditoUso(dias)));
                        } else {
                            System.out.println("No se puede reservar ese num de días");
                        }
                    } else
                        System.out.println("Precio :" + arti.getCredito() * dias);
                } else {
                    System.out.println("No se ha podido añadir la reserva !");
                }

            } else {
                System.out.println("El artículo no existe !");
            }
        } else {
            System.out.println("El cliente no exite !");
        }
    }
}
