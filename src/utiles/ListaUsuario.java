package utiles;

import java.sql.Date;
import java.util.ArrayList;

import models.Usuarios;

public class ListaUsuario {
	public static ArrayList<Usuarios> listaUsuarios = new ArrayList();

	public static ArrayList<Usuarios> getListaUsuarios() {
		return listaUsuarios;
	}
	
	public static void addUser(Usuarios user) {
		listaUsuarios.add(user);
	}
	/**
	 * Crea un usuario con los datos proporcionados y lo devuelve, los datos son proporcionados en cadenas de texto,
	 *  menos la fecha de nacimiento la ual se da en Date
	 * @param nombre
	 * @param fechaNacimiento
	 * @param genero
	 * @param correo
	 * @param contrasena
	 * @param gusto
	 * @return
	 */
	public static Usuarios creaUser(String nombre, Date fechaNacimiento, String genero, String correo, String contrasena,
			String gusto) {
		Usuarios user = new Usuarios(  nombre, fechaNacimiento, genero, correo, contrasena, gusto);
		return user;
	}
	
	/**
	 * Comprueba si existe el usuario
	 * @param correo
	 * @param contrasena
	 * @return
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
	 * devuelve el usuario tras comprobar si existe
	 * @param correo
	 * @param contrasena
	 * @return
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
