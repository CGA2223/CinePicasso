package utiles;

import java.sql.Date;
import java.util.ArrayList;

import models.Usuarios;

/**
 * La clase ListaUsuario proporciona métodos útiles para administrar una lista de usuarios.
 * Permite agregar usuarios, crear nuevos usuarios y verificar la existencia de usuarios en la lista.
 */
public class ListaUsuario {
    public static ArrayList<Usuarios> listaUsuarios = new ArrayList();

    /**
     * Método para obtener la lista de usuarios.
     * @return La lista de usuarios.
     */
    public static ArrayList<Usuarios> getListaUsuarios() {
        return listaUsuarios;
    }
    
    /**
     * Método para agregar un nuevo usuario a la lista.
     * @param user El usuario a agregar.
     */
    public static void addUser(Usuarios user) {
        listaUsuarios.add(user);
    }
    
    /**
     * Crea un nuevo usuario con los datos proporcionados y lo devuelve.
     * @param nombre El nombre del usuario.
     * @param fechaNacimiento La fecha de nacimiento del usuario.
     * @param genero El género del usuario.
     * @param correo El correo electrónico del usuario.
     * @param contrasena La contraseña del usuario.
     * @param gusto Las preferencias de gustos del usuario.
     * @return El usuario creado.
     */
    public static Usuarios creaUser(String nombre, Date fechaNacimiento, String genero, String correo, String contrasena,
            String gusto) {
        Usuarios user = new Usuarios(  nombre, fechaNacimiento, genero, correo, contrasena, gusto);
        return user;
    }
    
    /**
     * Comprueba si un usuario con el correo electrónico y la contraseña proporcionados existe en la lista.
     * @param correo El correo electrónico del usuario.
     * @param contrasena La contraseña del usuario.
     * @return true si el usuario existe en la lista, false en caso contrario.
     */
    public static boolean userExist(String correo, String contrasena) {
        for (Usuarios user : listaUsuarios) {
            if (user.getCorreo().equals(correo) && user.getContrasena().equals(contrasena)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Devuelve el usuario correspondiente al correo electrónico y contraseña proporcionados, si existe.
     * @param correo El correo electrónico del usuario.
     * @param contrasena La contraseña del usuario.
     * @return El usuario correspondiente si existe, null si no se encuentra.
     */
    public static Usuarios getUser(String correo, String contrasena) {
        if(userExist(correo, contrasena)) {
            for (Usuarios user : listaUsuarios) {
                if (user.getCorreo().equals(correo) && user.getContrasena().equals(contrasena)) {
                    return user;
                }
            }
        }
        return null;
    }
}
