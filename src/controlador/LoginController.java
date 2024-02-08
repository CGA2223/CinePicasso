package controlador;

import java.util.ArrayList;
import java.util.Arrays;

import application.Main;
import controler.pantallaController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Usuarios;
import utiles.ListaUsuario;

public class LoginController {

    @FXML
    private Button btnCrearUsuario;

    @FXML
    private Button btnCrearUsuario1;

    @FXML
    private ImageView imageDecoracionInferior2;

    @FXML
    private ImageView imageDecoracionInferior21;

    @FXML
    private ImageView imageLogo;

    @FXML
    private Label lblEdad;

    @FXML
    private Pane panleSuperior;

    @FXML
    private TextField txtContrasena;

    @FXML
    private TextField txtCorreo;

    @FXML
    void iniciarSesion(ActionEvent event) {
    	Usuarios usuarioAIniciar;
    	usuarioAIniciar = ListaUsuario.getUser(txtCorreo.getText(), txtContrasena.getText());
    	if(usuarioAIniciar != null) {
    		// iniciar sesion
    	} else {
    		// lanzar error
    	    Alert alert = new Alert(Alert.AlertType.ERROR);
    	    alert.setHeaderText(null);
    	    alert.setTitle("Error");
    	    alert.setContentText("Error, Usuario no encontrado");
    	    alert.showAndWait();
    	}
    }
    
    public pantallaController	controlador;
    
    private ArrayList<String> listaClientes = new ArrayList<String>(Arrays.asList("Terror", "SuperHeroes", "Drama", "Comedia"
    		, "Acción", "Ciencia Ficción", " Fantasia", "Musical")); 
    public static Stage stageRegistro;
    public static void volverALoggin() {
    	Main.mostrarLoggin();
    	stageRegistro.hide();
    	
    }
    @FXML
    void crearUnNuevoUsuario(ActionEvent event) {
    	Main.ocultarLoggin();
    	try {
    		
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/pantalla.fxml"));
			Parent root = loader.load();
			
			controlador = loader.getController();
			controlador.setCboxGusto(listaClientes);
			stageRegistro = new Stage();
			Scene scene = new Scene(root);
			stageRegistro.initModality(Modality.APPLICATION_MODAL);
			stageRegistro.setScene(scene);
			stageRegistro.showAndWait();
			// Main.modifyStage();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
    	

    }

}
