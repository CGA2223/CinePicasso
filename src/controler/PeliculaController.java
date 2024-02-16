package controler;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

import api.Buscador;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.Pelicula;
import utiles.PeliculaSeleccionada;

public class PeliculaController implements Initializable{

    @FXML
    private ComboBox<?> ComboBoxPuntuaciones;

    @FXML
    private Label btnAgregar;

    @FXML
    private Label btnBuscador;

    @FXML
    private Button btnCSV;

    @FXML
    private Label btnInicio;

    @FXML
    private Button btnJson;

    @FXML
    private Button btnSubirValoración;

    @FXML
    private Label btnUsuario;

    @FXML
    private ImageView imagePelicula;

    @FXML
    private Label txtActores;

    @FXML
    private TextArea txtAreaDescriptcion;

    @FXML
    private Label txtDirector;

    @FXML
    private Label txtDuracion;

    @FXML
    private Label txtDuración;

    @FXML
    private Label txtFechaDeUltimaVisualizacion;

    @FXML
    private Label txtGeneroDePelicula;

    @FXML
    private Label txtProductora;

    @FXML
    private Label txtPuntuacion;

    @FXML
    private Label txtTituloPelicula;

    @FXML
    private Label txtValoracionDeLosUsuarios;
    
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
	 
	 @FXML
	    void IrAAgrefar(MouseEvent event) throws IOException {
		 CambiarAAgregar(event);
	    }

	    @FXML
	    void IrABuscador(MouseEvent event) throws IOException {
	    	CambiarABuscador(event);
	    }

	    @FXML
	    void IrAInicio(MouseEvent event) throws IOException {
	    	CambiarAInicio(event);
	    }

	    @FXML
	    void IrAUsuario(MouseEvent event) throws IOException {
	    	CambiarAUsuario(event);
	    }

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			Pelicula peli = PeliculaSeleccionada.getPelicula();
			txtTituloPelicula.setText(peli.getTitulo());
			txtAreaDescriptcion.setText(peli.getDescripcion());
			txtDuracion.setText(peli.getFechaEstreno().toString());
	    	Buscador buscador = new Buscador();
	    	String urlPeli = buscador.CreaUrl(peli.getCartel());
	    	InputStream inputStream;
			try {
				inputStream = new URL(urlPeli).openStream();
				Image image = new Image(inputStream);
				inputStream.close();
		    	imagePelicula.setImage(image);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		}

}
