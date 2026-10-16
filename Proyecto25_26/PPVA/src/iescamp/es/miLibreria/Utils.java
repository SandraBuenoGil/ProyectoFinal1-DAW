package iescamp.es.miLibreria;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utils {
    // método para leer una cadena
    public static String leerTexto(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    // método para leer un número entre min y max, ambos incluidos
    public static int leerOpcion(String mensaje, int min, int max) {
        Scanner sc = new Scanner(System.in);
        int r = -1;
        do {
            try {
                System.out.print(mensaje);
                r = sc.nextByte();
                if (r < min || r > max) {
                    System.out.println("Error : Opción incorrecta ");
                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR: ESCRIBE SOLO NÚMEROS");
                sc.next();
            }
        } while (r < min || r > max);
        return r;
    }

    // método para leer un número entero
    public static int leerEntero(String mensaje) {
        Scanner sc = new Scanner(System.in);
        int num=0;
        boolean correcto = false;
        do {
            try {
                System.out.print(mensaje);
                num = sc.nextInt();
                correcto = true;
            } catch (InputMismatchException e) {
                System.out.println("ERROR: ESCRIBE SOLO NÚMEROS");
                sc.next();
            }
        }while(!correcto);
        return num;
    }
    // método para leer un número mayor que valor (excluido)
    public static int leerEntero(String mensaje, int valor) {
        Scanner sc = new Scanner(System.in);
        int x=0;
        boolean correcto = false;;
        do {
            try {
                System.out.print(mensaje);
                x = sc.nextInt();
                if (x < valor) {
                    System.out.println("ERROR: valor no válido.");
                    System.out.println("El valor debe ser > " + valor);
                }
                else
                    correcto = true;
            } catch (InputMismatchException e) {
                System.out.println("ERROR: ESCRIBE SOLO NÚMEROS");
                sc.next();
            }
        }while (x<=valor && !correcto);
        return x;
    }

    // método para leer un float mayor que valor (excluido)
    public static float leerFloat(String mensaje, int valor) {
        Scanner sc = new Scanner(System.in);
        float x=0;
        boolean correcto = false;;
        do {
            try {
                System.out.print(mensaje);
                x = sc.nextFloat();
                if (x < valor) {
                    System.out.println("ERROR: valor no válido.");
                    System.out.println("El valor debe ser > " + valor);
                }
                else
                    correcto = true;
            } catch (InputMismatchException e) {
                System.out.println("ERROR: ESCRIBE SOLO NÚMEROS");
                sc.next();
            }
        }while (x<=valor && !correcto);
        return x;
    }

    // método para leer un número float
    public static float leerFloat(String mensaje) {
        Scanner sc = new Scanner(System.in);
        float num=0;
        boolean correcto = false;
        do {
            try {
                System.out.print(mensaje);
                num = sc.nextFloat();
                correcto = true;
            } catch (InputMismatchException e) {
                System.out.println("ERROR: ESCRIBE SOLO NÚMEROS");
                sc.next();
            }
        }while(!correcto);
        return num;
    }

    // método que lee solamente sí o no
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
        } while (!r.equalsIgnoreCase("Sí") && !r.equalsIgnoreCase("No"));
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
        if (x!=null && x != "") {
            resp = true;
        }
        return resp;
    }

}
