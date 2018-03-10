package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
public class LoginView implements View{
	
	private Scene scene;
	private Controller controller = new Controller();
	private UserView userView;
	
	private final int  WIDTH = 640;
	private final int HEIGHT = WIDTH/12 * 9;
	private Button loginButton;
	private GridPane grid;
	
	LoginView(){
		
	}
	
	private void makeScene() {
		//UserID
		Label userIDLabel = new Label("UserID: ");
		GridPane.setConstraints(userIDLabel, 0, 0);
		TextField userIDInput = new TextField();
		GridPane.setConstraints(userIDInput, 1, 0);
		//User PIN
		Label userPINLabel = new Label("UserPIN: ");
		TextField userPINInput = new TextField();
		GridPane.setConstraints(userPINLabel, 0, 1);
		GridPane.setConstraints(userPINInput, 1, 1);
		
		//Login button and register button
		loginButton = new Button("Login");
		Button registerButton = new Button("Register");
		GridPane.setConstraints(loginButton, 0, 2);
		GridPane.setConstraints(registerButton, 1, 2);
		
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
					err.display("YOU HAVE ENTERED WRONG INFORMATION\nPLEASE TRY AGAIN\n","WRONG INFORMATION");
				}
			}catch(NumberFormatException en) {
				ErrorView err = new ErrorView();
				err.display("YOU HAVE ENTERED WRONG PIN FORMAT\nPLEASE TRY AGAIN!","WRONG PIN INFORMATION");
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
			
		);
		
		grid = new GridPane();
		grid.setPadding(new Insets(10,10,10,10));
		grid.setVgap(10);
		grid.setHgap(12);
		grid.getChildren().addAll(userIDLabel,userIDInput,userPINLabel,userPINInput,loginButton,registerButton);
		grid.setAlignment(Pos.CENTER);
	}
	
	public Scene getScene() {
		makeScene();
		if(scene==null) {
			scene = new Scene(grid,WIDTH,HEIGHT);
			scene.setOnKeyPressed(e->{
				if(e.getCode().equals(KeyCode.ENTER)) {
					loginButton.fire();
					e.consume();
				}
			});
		}
		scene.getStylesheets().add(getClass().getResource("login.css").toExternalForm());
		return scene;
	}
}
