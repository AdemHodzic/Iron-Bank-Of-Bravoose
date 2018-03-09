package application;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
public class LoginView implements View{
	
	private Scene scene;
	private Controller controller = new Controller();
	private UserView userView;
	
	private final int  WIDTH = 640;
	private final int HEIGHT = WIDTH/12 * 9;
	private VBox layout;
	private Button loginButton;
	
	LoginView(){
		
	}
	
	private void makeScene() {
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
		loginButton = new Button("Login");
		Button registerButton = new Button("Register");
		HBox btnHBox = new HBox();

		registerButton.setOnAction(e->{
				try {
					if(controller.isNumber(userPINInput.getText()) && !userIDInput.getText().equals("")) {
						controller.addUser(userIDInput.getText(), Integer.parseInt(userPINInput.getText()));
					}else if(!controller.isNumber(userPINInput.getText())){
						ErrorView err = new ErrorView();
						err.display("PIN NUMBER CAN ONLY CONTAIN NUMERIC CHARACTERS!"
								+ "\nPLEASE TRY AGAIN", "INVALID PIN FORMAT");
					}else if(userIDInput.getText().equals("")) {
						ErrorView err = new ErrorView();
						err.display("ID CANNOT BE BLANK!"
								+ "\nPLEASE TRY AGAIN","INVALID PIN FORMAT");
					}
				} catch(NumberFormatException en) {
					ErrorView err = new ErrorView();
					err.display("PIN NUMBER CANNOT BE BLANK!"
							+ "\nPLEASE TRY AGAIN","INVALID PIN FORMAT");
				}catch (Exception e1) {
					e1.printStackTrace();
				}
		});
		
		loginButton.setOnAction(e->{
			try {
				if(controller.login(userIDInput.getText(),Integer.parseInt(userPINInput.getText()))) {
					User user = controller.getUser(
							controller.getUserIndex(Integer.parseInt(userPINInput.getText())));
					userView = new UserView(user);
					scene = userView.getScene();
				}else {
					ErrorView err = new ErrorView();
					err.display(("YOU HAVE ENTERED WRONG INFORMATION\nPLEASE TRY AGAIN\n" + (userPINInput.getText().length())),"WRONG INFORMATION");
				}
			}catch(NumberFormatException en) {
				ErrorView err = new ErrorView();
				err.display("YOU HAVE ENTERED WRONG PIN FORMAT\nPLEASE TRY AGAIN!","WRONG PIN INFORMATION");
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
			
		);
		btnHBox.getChildren().addAll(loginButton,registerButton);
		
		//VBOX and scene setup
		layout = new VBox();
		layout.getChildren().addAll(userIDHBox,userPINHBox,btnHBox);
		layout.setAlignment(Pos.CENTER_LEFT);
		
	}
	
	public Scene getScene() {
		makeScene();
		if(scene==null) {
			scene = new Scene(layout,WIDTH,HEIGHT);
			scene.setOnKeyPressed(e->{
				if(e.getCode().equals(KeyCode.ENTER)) {
					loginButton.fire();
					e.consume();
				}
			});
		}
		return scene;
	}
}
