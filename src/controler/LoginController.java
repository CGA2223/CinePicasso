package controler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import application.Main;
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
    public PantallaPrincipalController controladorPantallaPrincipal;

    @FXML
    /**
     * Metodo que inicia sesión si se introduce un usuario ya creado pero que lanza un error si se introduce uno inexistente
     */
    void iniciarSesion(ActionEvent event) {
    	Usuarios usuarioAIniciar;
    	usuarioAIniciar = ListaUsuario.getUser(txtCorreo.getText(), txtContrasena.getText());
    	if(usuarioAIniciar != null) {
    		
    		Main.ocultarLoggin();
        	try {
        		
    			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/PantallaPrincipal.fxml"));
    			Parent root = loader.load();
    			
    			controladorPantallaPrincipal = loader.getController();
    			stageRegistro = new Stage();
    			Scene scene = new Scene(root);
    			stageRegistro.initModality(Modality.APPLICATION_MODAL);
    			stageRegistro.setScene(scene);
    			stageRegistro.showAndWait();
    			// Main.modifyStage();
        	} catch(Exception e) {
    			e.printStackTrace();
    		}
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
    		
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/CrearUsuario.fxml"));
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
	public static Stage getStageRegistro() {
		return stageRegistro;
	}
	public  void cambiarEscena(String rutaPantalla, Class controlador) {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaPantalla));
		Parent root = null;
		try {
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		controlador = loader.getController();
		stageRegistro = new Stage();
		Scene scene = new Scene(root);
		stageRegistro.initModality(Modality.APPLICATION_MODAL);
		stageRegistro.setScene(scene);
		stageRegistro.showAndWait();
		// Main.modifyStage();
		
	}


}
