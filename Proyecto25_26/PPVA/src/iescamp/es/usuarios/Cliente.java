package iescamp.es.usuarios;

import java.time.LocalDate;

public class Cliente extends Usuario{

    private int credito;
    private boolean penalizado;

    public Cliente(String dni, String nombre, String apellidos, String telefono, LocalDate fechaNacimiento,
                   String direccion, String email, String contrasenya, boolean activo, int credito,
                   boolean penalizado) {
        super(dni, nombre, apellidos, telefono, fechaNacimiento, direccion, email, contrasenya, activo);
        this.credito = credito;
        this.penalizado = penalizado;
    }

    public Cliente(String dni, String email, String contrasenya, int credito, boolean penalizado) {
        super(dni, email, contrasenya);
        this.credito = credito;
        this.penalizado = penalizado;
    }

    public Cliente(String dni, String contrasenya, int credito, boolean penalizado) {
        super(dni, contrasenya);
        this.credito = credito;
        this.penalizado = penalizado;
    }

    public boolean isPenalizado() {
        return penalizado;
    }

    public void setPenalizado(boolean penalizado) {
        this.penalizado = penalizado;
    }

    public int getCredito() {
        return credito;
    }

    public void setCredito(int credito) {
        this.credito = credito;
    }

    @Override
    public String mostrarDatosUsuario() {
        String cadena = super.muestraUsuario();
        cadena +="\nCliente";
        cadena += "\nCrédito: " + getCredito();
        cadena += "\nPenalizado: " + (isPenalizado() ? "Sí" : "No");

        return cadena;
    }
}

