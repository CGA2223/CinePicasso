package api;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.TextFormat.ParseException;

import models.Pelicula;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Buscador {
	
	private final String BaseImage = "https://image.tmdb.org/t/p/w500";
    private final String API_KEY = "d6957df483c600a6ffda46d472fd168e";
    
    public String tituloPelicula;
    private String movieTitle;
    private String url = "https://api.themoviedb.org/3/search/movie" +
            "?api_key=" + API_KEY +
            "&query=";
    
    private OkHttpClient client = new OkHttpClient();
    
    public Pelicula Busqueda(String tituloPelicula) {
        Request request = new Request.Builder()
                .url(url + tituloPelicula)
                .get()
                .addHeader("accept", "application/json")
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                String responseBody = response.body().string();
                ArrayList<Pelicula> lista = PeliculasEncontradas(responseBody);
                if(lista.size() == 0) {
                	return null;
                } else {
                	return lista.get(0);
                }
                
            } else {
                System.out.println("Error: " + response.code() + " - " + response.message());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    	
    }
    
    public String getRespuesta(String tituloPelicula) {
        Request request = new Request.Builder()
                .url(url + tituloPelicula)
                .get()
                .addHeader("accept", "application/json")
                .build();

        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
    	return null;
    }
    
    public static void writeJsonToFile(String jsonString, String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Object json = mapper.readValue(jsonString, Object.class);
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), json);
    }
    
    private static java.sql.Date parseDate(String dateString) throws ParseException, java.text.ParseException {
        if (dateString == null || dateString.isEmpty()) {
            return null;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate = dateFormat.parse(dateString);
        return new java.sql.Date(utilDate.getTime());
    }
    public static Date utilDateToSqlDate(java.util.Date utilDate) {
        if (utilDate == null) {
            return null;
        }
        return new Date(utilDate.getTime());
    }
    
    private ArrayList<Pelicula> PeliculasEncontradas(String jsonString){
    	ArrayList<Pelicula> lista = new ArrayList();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jsonString);
            JsonNode resultsNode = rootNode.get("results");

            if (resultsNode.isArray()) {
                for (JsonNode movieNode : resultsNode) {
                    String titulo = movieNode.get("original_title").asText();
                    String descripcion = movieNode.get("overview").asText();
                    Double puntuacion = movieNode.get("vote_average").asDouble();
                    String fechaEstrenoString = movieNode.get("release_date").asText();
                    Date fechaEstreno = parseDate(fechaEstrenoString);
                    String cartel = movieNode.get("poster_path").asText();

                    // Crear objeto Pelicula
                    Pelicula pelicula = new Pelicula(titulo, descripcion, "", puntuacion, "", fechaEstreno, "", "", "", fechaEstreno, 0, cartel, "");
                    lista.add(pelicula);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public String CreaUrl(String terminacion) {
    	return BaseImage + terminacion;
    }
    
    
    
}
