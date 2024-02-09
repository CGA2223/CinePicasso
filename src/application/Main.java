package application;
	
import java.sql.Date;

import controler.LoginController;
import controler.pantallaController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Usuarios;
import utiles.ListaUsuario;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	public static Stage stage = new Stage();
	
	public static void ocultarLoggin() {
		stage.hide();
	}
	
	public static void mostrarLoggin() {
		try {
			stage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/login.fxml"));
			Parent root = loader.load();
			
			LoginController	controlador = loader.getController();
						
			Scene scene = new Scene(root);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setScene(scene);
			stage.showAndWait();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		Usuarios user = new Usuarios("Ej", Date.valueOf("2002-2-2"), "ej", "ej", "ej", "ej");
		ListaUsuario.addUser(user);
		launch(args);
	}
}
