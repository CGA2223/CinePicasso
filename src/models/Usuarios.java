package models;

import java.sql.Date;

/**
 * La clase Usuarios representa un usuario de la aplicación.
 * Contiene información sobre el usuario, como su nombre, fecha de nacimiento, género, correo electrónico,
 * contraseña y preferencias de gustos.
 */
public class Usuarios {
    
    private int id;
    private String nombre;
    private Date fechaNacimiento;
    private String genero;
    private String correo;
    private String contrasena;
    private String gusto;

    /**
     * Constructor de la clase Usuarios.
     * @param nombre El nombre del usuario.
     * @param fechaNacimiento La fecha de nacimiento del usuario.
     * @param genero El género del usuario.
     * @param correo El correo electrónico del usuario.
     * @param contrasena La contraseña del usuario.
     * @param gusto Las preferencias de gustos del usuario.
     */
    public Usuarios(String nombre, Date fechaNacimiento, String genero, String correo, String contrasena,
            String gusto) {
        super();
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.correo = correo;
        this.contrasena = contrasena;
        this.gusto = gusto;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public String getGusto() {
        return gusto;
    }
    public void setGusto(String gusto) {
        this.gusto = gusto;
    }
}
