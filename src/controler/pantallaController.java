package controler;

import java.sql.Date;
import java.util.ArrayList;

import controler.LoginController;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import models.Usuarios;
import utiles.ListaUsuario;

public class pantallaController {

    @FXML
    private Button btnCrearUsuario;

    @FXML
    private Button btnVolverALoggin;

    @FXML
    private ComboBox<String> cboxGusto;

	public void setCboxGusto(ArrayList<String> cboxGusto) {
		this.cboxGusto.setItems(FXCollections.observableArrayList(cboxGusto));
	}

	@FXML
    private ImageView imageDecoracionInferior2;

    @FXML
    private ImageView imageDecoracionInferior21;

    @FXML
    private ImageView imageLogo;

    @FXML
    private Label lblBienvenido;

    @FXML
    private Label lblEdad;

    @FXML
    private Pane panleSuperior;

    @FXML
    private TextField txtConfirmarContrasena;

    @FXML
    private TextField txtContrasena;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtFechaDeNacimiento;

    @FXML
    private TextField txtGenero;

    @FXML
    private TextField txtNombre;

    @FXML
    void anadirUsuarioALaLista(ActionEvent event) {
    	try {
			if(txtContrasena.getText().equals(txtConfirmarContrasena.getText())) {
		    	Usuarios usuario = ListaUsuario.creaUser(txtNombre.getText(), Date.valueOf(txtFechaDeNacimiento.getText()) , txtGenero.getText(),
		    			txtCorreo.getText(), txtContrasena.getText(), (String) cboxGusto.getValue());
		    	ListaUsuario.addUser(usuario);
			    Alert alert = new Alert(Alert.AlertType.INFORMATION);
			    alert.setHeaderText(null);
			    alert.setTitle("Usuario");
			    alert.setContentText("Usuario Creado Con Exito");
			    alert.showAndWait();
			} else {
				// error en  las contraseñas
			    Alert alert = new Alert(Alert.AlertType.ERROR);
			    alert.setHeaderText(null);
			    alert.setTitle("Error");
			    alert.setContentText("Error, Las contraseñas no coinciden");
			    alert.showAndWait();
		
			}
    	} catch(NumberFormatException e){
    		// error en el formato de la  fecha 
		    Alert alert = new Alert(Alert.AlertType.ERROR);
		    alert.setHeaderText(null);
		    alert.setTitle("Error");
		    alert.setContentText("Error, Formato de la fecha incorrecto \n"
		    		+ "Introducir en formato yyyy-mm-dd");
		    alert.showAndWait();
    		
    	}

    }

    @FXML
    void volverALoggin(ActionEvent event) {
    	LoginController.volverALoggin();
    }

}
