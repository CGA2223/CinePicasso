package controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PrincipalController {

    @FXML
    private ImageView imagen1;

    @FXML
    private ImageView imagen11;

    @FXML
    private ImageView imagen12;

    @FXML
    private ImageView imagen13;

    @FXML
    private ImageView imagen131;

    @FXML
    private ImageView imagen14;

    @FXML
    private ImageView imagen111;

    @FXML
    private ImageView imagen121;

    @FXML
    private ImageView imagen1311;

    @FXML
    private ImageView imagen141;

    @FXML
    private Label label1;

    @FXML
    private Label label11;

    @FXML
    private Label label12;

    @FXML
    private Label label13;

    @FXML
    private Label label131;

    @FXML
    private Label label14;

    @FXML
    private Label label111;

    @FXML
    private Label label121;

    @FXML
    private Label label1311;

    @FXML
    private Label label141;

    public void initialize() {
        cargarImagenes();
        establecerTextoEnEtiquetas();
    }

    private void cargarImagenes() {
        // Cargar imágenes desde tus recursos o ubicación deseada
        imagen1.setImage(new Image(getClass().getResourceAsStream("../images/paceHolder.jpg")));
        imagen11.setImage(new Image(getClass().getResourceAsStream("../images/paceHolder.jpg")));
        imagen12.setImage(new Image(getClass().getResourceAsStream("../images/paceHolder.jpg")));
        imagen13.setImage(new Image(getClass().getResourceAsStream("../images/paceHolder.jpg")));
        imagen131.setImage(new Image(getClass().getResourceAsStream("../images/paceHolder.jpg")));
        imagen14.setImage(new Image(getClass().getResourceAsStream("../images/paceHolder.jpg")));
        imagen111.setImage(new Image(getClass().getResourceAsStream("../images/paceHolder.jpg")));
        imagen121.setImage(new Image(getClass().getResourceAsStream("../images/paceHolder.jpg")));
        imagen1311.setImage(new Image(getClass().getResourceAsStream("../images/paceHolder.jpg")));
        imagen141.setImage(new Image(getClass().getResourceAsStream("../images/paceHolder.jpg")));
    }

    private void establecerTextoEnEtiquetas() {
        // Establecer texto en etiquetas
        label1.setText("Nombre de la película");
        label11.setText("Nombre de la película");
        label12.setText("Nombre de la película");
        label13.setText("Nombre de la película");
        label131.setText("Nombre de la película");
        label14.setText("Nombre de la película");
        label111.setText("Nombre de la película");
        label121.setText("Nombre de la película");
        label1311.setText("Nombre de la película");
        label141.setText("Nombre de la película");
    }
}
