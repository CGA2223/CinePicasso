package controler;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import api.Buscador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.Pelicula;
import utiles.PeliculaAGuardar;
import utiles.PeliculaSeleccionada;

public class BuscadorController implements Initializable{

    @FXML
    private Label btnAgregar;

    @FXML
    private Label btnBuscador;

    @FXML
    private Label btnInicio;

    @FXML
    private Label btnUsuario;

    @FXML
    private ChoiceBox<?> cboxfiltro;

    @FXML
    private ImageView imagePelicula = null;

    @FXML
    private Label lblTituloPelicula;

    @FXML
    private TextField txtanio;
    
    @FXML
    private TextField txtBusqueda;
    
	private String pantallaUsuario = "/view/PantallaUsuario.fxml";
	private String pantallaPrincipalRuta = "/view/PantallaPrincipal.fxml";
	private String pantallaBuscadorRuta = "/view/buscador.fxml";
	private String pantallaAgregarRuta = "/view/PantallaParaSubirPelicula.fxml";
	private String pantallaPelicula = "/view/PantallaAlSeleccionarPelicula.fxml";
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
	 
	 public void CambiarAPelicula(MouseEvent event) throws IOException {
		  root = FXMLLoader.load(getClass().getResource(pantallaPelicula));
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
    void clickAgregar(MouseEvent event) throws IOException  {
    	CambiarAAgregar(event);
    }

    @FXML
    void clickInicio(MouseEvent event) throws IOException  {
    	CambiarAInicio(event);
    }

    @FXML
    void clickUsuario(MouseEvent event) throws IOException {
    	CambiarAUsuario(event);
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//imagePelicula
		/*try {
			
			InputStream inputStream = new URL("https://image.tmdb.org/t/p/w500/hSTervHaROcTd8Ir3DPfepN80dL.jpg").openStream();
			Image image = new Image(inputStream);
			inputStream.close();
			imagePelicula.setImage(image);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
    @FXML
    void buscar(MouseEvent event) throws MalformedURLException, IOException {
    	Buscador buscador = new Buscador();
    	Pelicula peli = buscador.Busqueda(txtBusqueda.getText());
    	String urlPeli = buscador.CreaUrl(peli.getCartel());
    	InputStream inputStream = new URL(urlPeli).openStream();
		Image image = new Image(inputStream);
		inputStream.close();
    	imagePelicula.setImage(image);
    	lblTituloPelicula.setText(peli.getTitulo());
    	PeliculaSeleccionada.setPelicula(peli);
    }
    
    @FXML
    void irAPelicula(MouseEvent event) throws IOException {
    	CambiarAPelicula(event);
    	
    }
    
    @FXML
    void exportarAJson(ActionEvent event) throws IOException {
    	Buscador buscador = new Buscador();
    	String titulo = buscador.Busqueda(txtBusqueda.getText()).getTitulo();
    	Buscador.writeJsonToFile(buscador.getRespuesta(txtBusqueda.getText()), titulo);
    }

}
