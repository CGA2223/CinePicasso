package controler;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControladorGeneral {
	private String logginRuta = "/view/Login.fxml";
	private String registroRuta = "/view/CrearUsuario";
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
		 
	 public void CambiarALoggin2(ActionEvent event) throws IOException {
		  Parent root = FXMLLoader.load(getClass().getResource(logginRuta));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		 }

}
