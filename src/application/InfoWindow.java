package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InfoWindow extends Window{
	private User user;
	
	InfoWindow(User user){
		this.user=user;
	}
	
	public void display() {
		Stage window = new Stage();
		String[] info = controller.getInfo(user.getUserPIN()).split(" ");
		Label userID = new Label("USER ID: " + info[0]);
		Label userPIN = new Label("USER PIN: " + info[1]);
		Label userBalance = new Label("USER BALANCE: " + info[2]);
		Button btn = new Button("OK");
		
		btn.setOnAction(e-> window.close());
		
		VBox layout = new VBox();
		layout.getChildren().addAll(userID,userPIN,userBalance,btn);
		Scene scene = new Scene(layout,480,360);
		scene.getStylesheets().add(getClass().getResource("window.css").toExternalForm());
		
		window.setScene(scene);
		window.setTitle("INFO");
		window.show();
	}
}
