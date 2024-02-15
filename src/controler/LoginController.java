package controler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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
import models.Usuario;
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
    

	private String registroRuta = "/view/CrearUsuario.fxml";
	private String PantallaPrincipalruta = "/view/PantallaPrincipal.fxml";
	private String ruta = "/view/";

	 private Stage stage;
	 private Scene scene;
	 private Parent root;
	
	 public void CambiarARegistro(ActionEvent event) throws IOException {
		  root = FXMLLoader.load(getClass().getResource(registroRuta));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		 }
	 public void CambiarAPantallaPrincipal(ActionEvent event) throws IOException {
		  root = FXMLLoader.load(getClass().getResource(PantallaPrincipalruta));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		 }
		 
	 


    @FXML
    /**
     * Metodo que inicia sesión si se introduce un usuario ya creado pero que lanza un error si se introduce uno inexistente
     * @throws IOException 
     */
    void iniciarSesion(ActionEvent event) throws IOException {
    	Usuario usuarioAIniciar;
    	usuarioAIniciar = ListaUsuario.getUser(txtCorreo.getText(), txtContrasena.getText());
    	if(usuarioAIniciar != null) {
    		
    		CambiarAPantallaPrincipal(event);
    		
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
    
 
    @FXML
    void crearUnNuevoUsuario(ActionEvent event) throws IOException {
    	CambiarARegistro(event);
    	/*
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
    	*/

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
