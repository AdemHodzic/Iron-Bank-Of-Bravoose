package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WithdrawWindow extends Window{

	private User user;
	
	WithdrawWindow(User user){
		this.user = user;
	}
	
	@Override
	public void display() {
		Stage window = new Stage();
		Label amount = new Label("How many funds do you want to withdraw: ");
		TextField input = new TextField();
		Button btn = new Button("Withdraw");
		
		btn.setOnAction(e->{
			try {
				controller.withdraw(this.user.getUserPIN(), Double.parseDouble(input.getText()));
				window.close();
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		});
		
		HBox inputLayout = new HBox();
		inputLayout.getChildren().addAll(amount, input);
		
		VBox layout = new VBox();
		layout.getChildren().addAll(inputLayout, btn);
		
		Scene scene = new Scene(layout, 480,320);
		scene.getStylesheets().add(getClass().getResource("window.css").toExternalForm());
		
		window.setScene(scene);
		window.show();
	}
	
	
}
