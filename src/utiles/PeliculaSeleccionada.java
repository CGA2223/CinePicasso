package utiles;

import models.Pelicula;

public class PeliculaSeleccionada {
	public static Pelicula PeliculaIniciada;

	public static Pelicula getPelicula() {
		return PeliculaIniciada;
	}

	public static void setPelicula(Pelicula peliculaIniciada) {
		PeliculaIniciada = peliculaIniciada;
	}

}
