package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
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
		GridPane.setConstraints(amount,0,0);
		GridPane.setConstraints(input,1,0);
		GridPane.setConstraints(btn,0,1);
		
		btn.setOnAction(e->{
			try {
				controller.withdraw(this.user.getUserPIN(), Double.parseDouble(input.getText()));
				window.close();
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		});
		
		GridPane layout = new GridPane();
		layout.setPadding(new Insets(10,10,10,10));
		layout.setVgap(10);
		layout.setHgap(12);
		layout.setAlignment(Pos.CENTER);
		layout.getChildren().addAll(amount,input,btn);
		
		Scene scene = new Scene(layout, 480,320);
		scene.getStylesheets().add(getClass().getResource("window.css").toExternalForm());
		
		window.setTitle("WITHDRAW");
		window.setScene(scene);
		window.show();
	}
	
	
}
