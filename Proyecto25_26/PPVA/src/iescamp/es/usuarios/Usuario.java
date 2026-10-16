package iescamp.es.usuarios;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public abstract class Usuario {

    private String dni;
    private String nombre;
    private String apellidos;
    private String telefono;
    private LocalDate fechaNacimiento;
    private String direccion;
    private String email;
    private String contrasenya;
    private boolean activo;

    public Usuario(String dni, String nombre, String apellidos, String telefono, LocalDate fechaNacimiento,
                   String direccion, String email, String contrasenya, boolean activo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.email = email;
        this.contrasenya = contrasenya;
        this.activo = activo;
    }

    public Usuario(String dni, String email, String contrasenya) {
        this.dni = dni;
        this.email = email;
        this.contrasenya = contrasenya;
    }

    public Usuario(String dni, String contrasenya) {
        this.dni = dni;
        this.contrasenya = contrasenya;
        email = "Sin correo";
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String muestraUsuario() {
        return "Usuario" +
                "\n DNI:" + dni +
                "\n Nombre :" + nombre + " "+ apellidos +
                "\n Teléfono :" + telefono + '\'' +
                "\n Fecha de nacimiento :" + fechaNacimiento.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)) +
                "\n Dirección :" + direccion +
                "\n Email :" + email +
                "\n Activo:" + ((activo) ? "Si":"No")+
                '\n';
    }

    public abstract String mostrarDatosUsuario();
}

