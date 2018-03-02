package application;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.*;

public class LoginView implements View{
	private Scene scene;
	private Controller controller;
	
	private final int  WIDTH = 640;
	private final int HEIGHT = WIDTH/12 * 9;
	
	
	LoginView(){
		
	}
	
	public Scene getScene() {
		//UserID
		Label userIDLabel = new Label("UserID: ");
		TextField userIDInput = new TextField();
		HBox userIDHBox = new HBox();
		userIDHBox.getChildren().addAll(userIDLabel, userIDInput);
		
		//User PIN
		Label userPINLabel = new Label("UserPIN: ");
		TextField userPINInput = new TextField();
		HBox userPINHBox = new HBox();
		userPINHBox.getChildren().addAll(userPINLabel, userPINInput);
		
		//Login button and register button
		Button loginButton = new Button("Login");
		Button registerButton = new Button("Register");
		HBox btnHBox = new HBox();

		registerButton.setOnAction(e->{
			if(controller.isNumber(userPINInput.getText())) {
				try {
					controller.addUser(userIDInput.getText(), Integer.parseInt(userPINInput.getText()));
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		loginButton.setOnAction(e->{
			if(controller.login(userIDInput.getText(), Integer.parseInt(userPINInput.getText()))) {
					System.out.println("Login succesful");
				}else {
					System.out.println("Error");
				}
			}
		);
		btnHBox.getChildren().addAll(loginButton,registerButton);
		
		//VBOX and scene setup
		VBox vbox = new VBox();
		vbox.getChildren().addAll(userIDHBox,userPINHBox,btnHBox);
		vbox.setAlignment(Pos.CENTER_LEFT);
		scene = new Scene(vbox,WIDTH, HEIGHT);
		return scene;
	}
}
