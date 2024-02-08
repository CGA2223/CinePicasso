package controler;

import java.sql.Date;
import java.util.ArrayList;

import controlador.LoginController;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
    	
    	if(txtContrasena.getText().equals(txtConfirmarContrasena.getText())) {
        	Usuarios usuario = ListaUsuario.creaUser(txtNombre.getText(), Date.valueOf(txtFechaDeNacimiento.getText()) , txtGenero.getText(),
        			txtCorreo.getText(), txtContrasena.getText(), (String) cboxGusto.getValue());
        	ListaUsuario.addUser(usuario);
    	} else {
    		System.out.println("Error: La contraseña no es igual a confirmar contraseña");
    	}

    }

    @FXML
    void volverALoggin(ActionEvent event) {
    	LoginController.volverALoggin();
    }

}
