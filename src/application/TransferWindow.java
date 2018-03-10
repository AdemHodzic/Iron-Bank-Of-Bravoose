package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TransferWindow extends Window{
	private User user;
	private Controller controller = new Controller();
	
	public TransferWindow(User user) {
		this.user = user;
	}
	
	public void display() {
		Stage window = new Stage();
		Label transfer = new Label("NAME OF ACCOUNT TO TRANSFER TO: ");
		TextField transferInput = new TextField();
		Label amount = new Label("AMOUNT TO TRANSFER: ");
		TextField amountInput = new TextField();
		Button btn = new Button("TRANSFER");
		GridPane.setConstraints(transfer,0,0);
		GridPane.setConstraints(transferInput,1,0);
		GridPane.setConstraints(amount,0,1);
		GridPane.setConstraints(amountInput,1,1);
		GridPane.setConstraints(btn, 0, 2);
		
		btn.setOnAction(e -> {
			transfer(transferInput.getText(),amountInput.getText());
			window.close();
		});

		GridPane layout = new GridPane();
		layout.setPadding(new Insets(10,10,10,10));
		layout.setVgap(10);
		layout.setHgap(12);
		layout.setAlignment(Pos.CENTER);
		layout.getChildren().addAll(transfer,transferInput,amount,amountInput,btn);
		
		Scene scene = new Scene(layout,480,360);
		scene.getStylesheets().add(getClass().getResource("window.css").toExternalForm());
		window.setScene(scene);
		window.setTitle("TRANSFER");
		window.show();
	}
	
	private void transfer(String target, String amount) {
		if(Double.parseDouble(amount)<=user.getUserBalance())
			try {
				controller.transfer(user.getUserPIN(), controller.getUser(controller.getUserIndex(target)).getUserID(), Double.parseDouble(amount));
			}catch(Exception e) {
				ErrorView err = new ErrorView();
				err.display("ERROR WHILE TRYING TO TRANSFER FUNDS!\nPLEASE TRY AGAIN", "FATAL ERROR");
		}else {
			ErrorView err = new ErrorView();
			err.display("INSUFICIENT FUNDS!\nPLEASE TRY AGAIN", "FATAL ERROR");
		}
	}
}
