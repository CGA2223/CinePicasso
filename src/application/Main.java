package application;
	
import java.io.IOException;
import java.sql.Date;

import controler.ControladorGeneral;
import controler.LoginController;
import controler.pantallaController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Usuario;
import utiles.ListaUsuario;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	public static Stage stage = new Stage();
	
	@Override
	public void start(Stage primaryStage) {
		
		   Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
		    Scene scene = new Scene(root);
		    stage.setScene(scene);
		    stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		Usuario user = new Usuario("Ej", Date.valueOf("2002-2-2"), "ej", "ej", "ej", "ej");
		ListaUsuario.addUser(user);
		launch(args);
	}
}
