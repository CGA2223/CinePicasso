package application;

import controlador.LoginController;
import controler.pantallaController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

/**
 * La clase Main es la clase principal de la aplicación. 
 * Extiende la clase Application de JavaFX y define el método start(),
 * que inicia la aplicación y muestra la ventana de inicio de sesión.
 */
public class Main extends Application {
    
    /** El objeto Stage para la aplicación. */
    public static Stage stage = new Stage();
    
    /**
     * Método estático para ocultar la ventana de inicio de sesión.
     */
    public static void ocultarLoggin() {
        stage.hide();
    }
    
    /**
     * Método estático para mostrar la ventana de inicio de sesión.
     */
    public static void mostrarLoggin() {
        try {
            stage.show();
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Método start() heredado de la clase Application.
     * Se ejecuta al iniciar la aplicación y muestra la ventana de inicio de sesión.
     * @param primaryStage El objeto Stage principal de la aplicación.
     */
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/login.fxml"));
            Parent root = loader.load();
            
            LoginController controlador = loader.getController();
                        
            Scene scene = new Scene(root);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Método main de la aplicación.
     * Llama al método launch() de Application para iniciar la aplicación.
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        launch(args);
    }
}

