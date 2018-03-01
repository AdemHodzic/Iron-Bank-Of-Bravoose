package application;
	
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {
	private Stage window;
	private Scene loginScene;
	private Controller controller = new Controller();
	
	private final int  WIDTH = 640;
	private final int HEIGHT = WIDTH/12 * 9;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			window = primaryStage;
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
			
			//Login button and registre button
			Button loginButton = new Button("Login");
			Button registerButton = new Button("Register");
			HBox btnHBox = new HBox();

			registerButton.setOnAction(e->{
				if(isNumber(userPINInput.getText())) {
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
			loginScene = new Scene(vbox, WIDTH, HEIGHT);
			window.setScene(loginScene);
			window.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	private boolean isNumber(String str) {
		for(int i = 0;i<str.length();i++) {
			if(!Character.isDigit(str.charAt(i))) return false;
		}
		return true;
	}
}
