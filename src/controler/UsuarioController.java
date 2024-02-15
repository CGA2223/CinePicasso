package controler;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class UsuarioController {

    @FXML
    private ChoiceBox<?> CboxGusto;

    @FXML
    private Label btnAgregar;

    @FXML
    private Label btnBuscador;

    @FXML
    private Button btnCerrarSesion;

    @FXML
    private Label btnInicio;

    @FXML
    private Label btnUsuario;

    @FXML
    private TextField txtContraseña;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtFechaDeNacimiento;

    @FXML
    private TextField txtGenero;

    @FXML
    private TextField txtNombre;
    
	private String logginRuta = "/view/Login.fxml";
	private String pantallaUsuario = "/view/PantallaUsuario.fxml";
	private String pantallaPrincipalRuta = "/view/PantallaPrincipal.fxml";
	private String pantallaBuscadorRuta = "/view/buscador.fxml";
	private String pantallaAgregarRuta = "/view/PantallaParaSubirPelicula.fxml";
	private String ruta = "/view/";

	 private Stage stage;
	 private Scene scene;
	 private Parent root;
	 
	 public void CambiarAInicio(MouseEvent event) throws IOException {
		  root = FXMLLoader.load(getClass().getResource(pantallaPrincipalRuta));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		 }
	
	 public void CambiarAUsuario(MouseEvent event) throws IOException {
		  root = FXMLLoader.load(getClass().getResource(pantallaUsuario));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		 }
	 
	 public void CambiarAAgregar(MouseEvent event) throws IOException {
		  root = FXMLLoader.load(getClass().getResource(pantallaAgregarRuta));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		 }
	 
	 public void CambiarABuscador(MouseEvent event) throws IOException {
		  root = FXMLLoader.load(getClass().getResource(pantallaBuscadorRuta));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		 }
	 
	 public void CambiarALoggin(ActionEvent event) throws IOException {
		  Parent root = FXMLLoader.load(getClass().getResource(logginRuta));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		 }

    @FXML
    void CerrarSesion(ActionEvent event) throws IOException {
    	CambiarALoggin(event);
    }

    @FXML
    void clickAgregar(MouseEvent event) throws IOException {
    	CambiarAAgregar(event);
    }

    @FXML
    void clickBuscador(MouseEvent event) throws IOException {
    	CambiarABuscador(event);
    }

    @FXML
    void clickInicio(MouseEvent event) throws IOException {
    	CambiarAInicio(event);
    }

}
