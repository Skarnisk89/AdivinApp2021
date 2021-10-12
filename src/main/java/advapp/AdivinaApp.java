package advapp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdivinaApp extends Application {
	private int intento = 0;
	private VBox vista;
	private Label texto;
	private TextField campo;
	private Button boton;
	

	@Override
	public void start(Stage primaryStage) throws Exception {

		vista = new VBox();
		texto = new Label();
		texto.setText("introduce un numero del 1 al 100");

		campo = new TextField();
		campo.setText("0");

		boton = new Button();
		boton.setText("Comprobar");
		boton.setOnAction(e -> onComprobar(e)); 

		vista.getChildren().addAll(texto, campo, boton);
		vista.setSpacing(5);
		vista.setFillWidth(false);
		vista.setAlignment(Pos.CENTER);

		Scene scene = new Scene(vista, 480, 320);
		primaryStage.setTitle("AdivinaApp"); // nombre de arriba de la caja
		primaryStage.setScene(scene); // mostrar caja
		primaryStage.show();

	}

	int random = (int) (Math.random() * 100); // math random te da un numero entre el 0 y el 1, y al multiplicarlo por
												// 100

	public static void main(String[] args) {

		launch(args);

	}
	
	// los metodos van completamente a parte

	public void onComprobar(ActionEvent e) {

		int n = Integer.parseInt(campo.getText()); // para recoger los datos
		
		intento++;
		
		if(n > 0 && n <= 100) {
			if(n == random) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("AdivinaApp");
				alert.setHeaderText(null);
				alert.setContentText("CHOS te la botaste al " + intento +" intento !");

				alert.showAndWait();
		}else if (n != random) {
			String mayor = "El numero a adivinar es mayor";
			String menor = "El numero a adivinar es menor";
			if (n < random) {
				
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("AdivinaApp");
				alert.setHeaderText("WARNING");
				alert.setContentText(mayor);
				alert.showAndWait();
				
			}else if (n > random) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("AdivinaApp");
				alert.setHeaderText("WARNING");
				alert.setContentText(menor);
				alert.showAndWait();
			}

			
		}

	}else {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("AdivinaApp");
		alert.setHeaderText("ERROR !!!");
		alert.setContentText(" Echale un ojo a eso mi niño!");

		alert.showAndWait();
	}
	}

}
