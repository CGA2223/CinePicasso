package api;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class ApiBase {

	private static final String BaseImage = "https://image.tmdb.org/t/p/w500";
    private static final String API_KEY = "d6957df483c600a6ffda46d472fd168e"; // Coloca aquí tu clave de API

    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();

        String movieTitle = "The Matrix"; // Título de la película que quieres buscar

        // Construir la URL de la consulta de búsqueda de película
        String url = "https://api.themoviedb.org/3/search/movie" +
                "?api_key=" + API_KEY +
                "&query=" + movieTitle;

        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("accept", "application/json")
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                String responseBody = response.body().string();
                // Aquí puedes procesar la respuesta JSON según tus necesidades
                System.out.println(responseBody);
            } else {
                System.out.println("Error: " + response.code() + " - " + response.message());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
