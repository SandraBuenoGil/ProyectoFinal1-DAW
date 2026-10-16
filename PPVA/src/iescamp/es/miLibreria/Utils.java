package iescamp.es.miLibreria;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Utils {
    public static String leerTexto(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public static int leerOpcion(String mensaje, int min, int max) {
        Scanner sc = new Scanner(System.in);
        int r;
        do {
            System.out.print(mensaje);
            r = sc.nextInt();
            if (r < min || r > max) {
                System.out.println("Error : Opción incorrecta");
            }
        } while (r < min || r > max);
        return r;
    }

    public static int leerOpcionTryCatch(String mensaje, int min, int max) {
        Scanner sc = new Scanner(System.in);
        int r = -1;
        boolean valido = false;

        do {
            try {
                System.out.print(mensaje);
                r = sc.nextInt();
                sc.nextLine();
                if (r < min || r > max) {
                    System.out.println("Error: Opción incorrecta");
                } else {
                    valido = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ser un carácter numérico entero.");
                sc.nextLine();
                r = -1;
            }
        } while (!valido);
        return r;
    }

    public static int leerEntero(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(mensaje);
        return scanner.nextInt();
    }

    public static int leerEnteroTryCatch(String mensaje) {
        Scanner sc = new Scanner(System.in);
        int r = -1;
        boolean valido = false;
        do {
            try {
                System.out.print(mensaje);
                r = sc.nextInt();
                sc.nextLine();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ser un carácter numérico entero.");
            }
        } while (!valido);
        return r;
    }


    public static int leerEntero(String mensaje, int valor) {
        Scanner scanner = new Scanner(System.in);
        int x;
        do {
            System.out.print(mensaje);
            x = scanner.nextInt();
            if (x < valor) {
                System.out.println("ERROR: valor no válido.");
                System.out.println("El valor debe ser > " + valor);
            }
        } while (x <= valor);
        return x;
    }

    public static float leerFloat(String mensaje, int valor) {
        Scanner scanner = new Scanner(System.in);
        float x;
        do {
            System.out.print(mensaje);
            x = scanner.nextInt();
            if (x < valor) {
                System.out.println("ERROR: valor no válido.");
                System.out.println("El valor debe ser > " + valor);
            }
        } while (x <= valor);
        return x;
    }

    public static float leerFloat(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(mensaje);
        return scanner.nextFloat();
    }

    public static float leerFloatTryCatch(String mensaje) {
        Scanner sc = new Scanner(System.in);
        float r = -1;
        boolean valido = false;
        String fr;
        do {
            try {
                System.out.print(mensaje);
                fr = sc.nextLine();
                fr = fr.replace(",", ".");
                r = Float.parseFloat(fr);
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ser un carácter numérico.");
            }
        } while (!valido);
        return r;
    }

    public static boolean leerBooleano(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(mensaje);
        return scanner.nextBoolean();
    }

    public static boolean leerSiNO(String mensaje) {
        boolean resp = false;
        String r;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print(mensaje);
            r = sc.nextLine();
            if (!r.equalsIgnoreCase("Sí") && !r.equalsIgnoreCase("No")) {
                System.out.println("Error : responda Sí o No");
            }
        } while (r.equalsIgnoreCase("Sí") || r.equalsIgnoreCase("No"));
        if (r.equalsIgnoreCase("Sí"))
            resp = true;
        return resp;
    }

    public static boolean valida(Object x) {
        boolean resp = false;
        if (x != null) {
            resp = true;
        }
        return resp;
    }

    public static boolean valida(String x) {
        boolean resp = false;
        if (x != null && x != "") {
            resp = true;
        }
        return resp;
    }

    public static boolean valida(int x) {
        boolean resp = false;
        if (x != 0) {
            resp = true;
        }
        return resp;
    }

    public static boolean valida(float x) {
        boolean resp = false;
        if (x != 0) {
            resp = true;
        }
        return resp;
    }

    public int generarNumeroAleatorio(int min, int max) {
        int rango = (max - min) + 1;
        return (int) (Math.random() * rango) + min;
    }

    public Object buscarObjetoEnArrayList(ArrayList lista, Object o) {
        int i = 0;
        boolean encontrado = false;
        while (i < lista.size() && !encontrado) {
            o = lista.get(i);
            if (o.equals(o)) {
                encontrado = true;
            }
            i++;
        }
        return o;
    }

    /*public LocalDate leerFechaTryCatch(String mensaje, String formato) {
        Scanner sc = new Scanner(System.in);
        LocalDate fechaValida =  null;
        String fecha;
        boolean valido = false;
        do {
            try {
                System.out.println(mensaje);
                fecha = sc.nextLine();
                fechaValida = LocalDate.parse(fecha, DateTimeFormatter.ofPattern(formato));
                valido = true;
            } catch (DateTimeParseException e) {
                System.out.println("Error: Formato de fecha no valido");
            }
        } while (!valido);
        return fechaValida;
    }*/
}