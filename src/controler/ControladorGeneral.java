package controler;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControladorGeneral {
	
	public static Stage stage = new Stage();
	
	private void cambiarVentana(String ventana, Class controlador) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(ventana));
		Parent root = null;
		try {
			root = loader.load();
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		controlador = loader.getController();
					
		Scene scene = new Scene(root);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setScene(scene);
		stage.showAndWait();
	}

}
