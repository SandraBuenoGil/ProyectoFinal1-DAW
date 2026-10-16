package iescamp.es.usuarios;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Administrador extends Usuario{

    private LocalDate fechaNombramiento;
    private LocalDate fechaCese;

    public Administrador(String dni, String nombre, String apellidos, String telefono, LocalDate fechaNacimiento,
                         String direccion, String email, String contrasenya, boolean activo,
                         LocalDate fechaNombramiento, LocalDate fechaCese) {
        super(dni, nombre, apellidos, telefono, fechaNacimiento, direccion, email, contrasenya, activo);
        this.fechaNombramiento = fechaNombramiento;
        this.fechaCese = fechaCese;
    }

    public Administrador(String dni, String email, String contrasenya, LocalDate fechaNombramiento,
                         LocalDate fechaCese) {
        super(dni, email, contrasenya);
        this.fechaNombramiento = fechaNombramiento;
        this.fechaCese = fechaCese;
    }

    public Administrador(String dni, String contrasenya, LocalDate fechaNombramiento, LocalDate fechaCese) {
        super(dni, contrasenya);
        this.fechaNombramiento = fechaNombramiento;
        this.fechaCese = fechaCese;
    }


    public LocalDate getFechaNombramiento() {
        return fechaNombramiento;
    }

    public void setFechaNombramiento(LocalDate fechaNombramiento) {
        this.fechaNombramiento = fechaNombramiento;
    }

    public LocalDate getFechaCese() {
        return fechaCese;
    }

    public void setFechaCese(LocalDate fechaCese) {
        this.fechaCese = fechaCese;
    }

    @Override
    public String mostrarDatosUsuario() {
        String cadena = super.muestraUsuario();
        cadena +="\nAdministrador";
        // modificar para visualizar fechas
        cadena += "\nNombramiento: "+ getFechaNombramiento().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)) ;;
        cadena += "\nCese: "+ getFechaCese().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)) ;;
        return cadena;
    }
}

