package application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ErrorView implements View{
	
	
	ErrorView(){
		
	}
	
	public void display(String errorMessage, String errorTitle) {
		Stage window = new Stage();
		window.setMinWidth(250);
		window.setTitle(errorTitle);
		window.initModality(Modality.APPLICATION_MODAL);
		
		Label label = new Label(errorMessage);
		Button button = new Button("OK!");
		
		button.setOnAction(e->{
			window.close();
		});
		
		VBox vbox = new VBox(10);
		vbox.getChildren().addAll(label,button);
		vbox.setAlignment(Pos.CENTER);
		Scene scene = new Scene(vbox,400,250);
		window.setScene(scene);
		window.showAndWait();
	}
}
