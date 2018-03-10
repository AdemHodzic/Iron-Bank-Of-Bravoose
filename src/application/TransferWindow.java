package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
		
		btn.setOnAction(e -> {
			transfer(transferInput.getText(),amountInput.getText());
			window.close();
		});
	
		HBox transferLayout = new HBox();
		transferLayout.getChildren().addAll(transfer,transferInput);
		HBox amountLayout = new HBox();
		transferLayout.getChildren().addAll(amount,amountInput);
		VBox layout = new VBox();
		layout.getChildren().addAll(transferLayout,amountLayout,btn);
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
