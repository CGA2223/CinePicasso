package utiles;

import java.sql.Date;
import java.util.ArrayList;

import models.Usuario;

public class ListaUsuario {
	public static ArrayList<Usuario> listaUsuarios = new ArrayList();

	public static ArrayList<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}
	
	public static void addUser(Usuario user) {
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
	public static Usuario creaUser(String nombre, Date fechaNacimiento, String genero, String correo, String contrasena,
			String gusto) {
		Usuario user = new Usuario(  nombre, fechaNacimiento, genero, correo, contrasena, gusto);
		return user;
	}
	
	/**
	 * Comprueba si existe el usuario
	 * @param correo
	 * @param contrasena
	 * @return
	 */
	public static boolean userExist(String correo, String contrasena) {
		for (Usuario user : listaUsuarios) {
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
	public static Usuario getUser(String correo, String contrasena) {
		if(userExist(correo, contrasena)) {
			for (Usuario user : listaUsuarios) {
				if (user.getCorreo().equals(correo) && user.getContrasena().equals(contrasena)) {
					return user;
				}
			}
		}
		return null;
	}


	
	
	
		

}
