package api;

import com.google.gson.Gson;

import models.Pelicula;

import static spark.Spark.*;

/**
 * Clase que representa una API de búsqueda de películas.
 */
public class BuscadorApi {

    /**
     * Método principal que inicia el servidor web de la API.
     * @param args Los argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        port(8082); // Puerto en el que escucha el servidor

        // Endpoint para buscar películas
        get("/search", (req, res) -> searchMovie(req.queryParams("cars")));
    }

    /**
     * Método privado que realiza la búsqueda de películas.
     * @param title El título de la película a buscar.
     * @return Una lista de resultados de búsqueda en formato JSON.
     */
    private static String searchMovie(String title) {
        // Aquí iría la lógica para buscar películas en la base de datos o en una API externa
        // Por simplicidad, vamos a devolver algunos resultados ficticios


    	
    	Pelicula peli = new Pelicula(title, title, title, null, title, null, title, title, title, null, 0, title, title);
        // Convertir los objetos Movie a JSON
        String jsonMovie1 = new Gson().toJson(peli);
       /* String jsonMovie2 = new Gson().toJson(movie2);
        String jsonMovie3 = new Gson().toJson(movie3);*/

        // Simular una lista de resultados de búsqueda
        String[] searchResults = {jsonMovie1};

        // Convertir la lista de resultados a JSON
        String jsonResponse = new Gson().toJson(searchResults);

        return jsonResponse;
    }

}