package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class UserView implements View{
	private Scene scene;
	private final int  WIDTH = 640;
	private final int HEIGHT = WIDTH/12 * 9;
	private User user;
	
	UserView(User user){
		this.user = user;
	}
	
	public Scene getScene() {
		Button depositButton = new Button("Deposit");
		Button withdrawButton = new Button("Withdraw");
		HBox firstRow = new HBox();
		firstRow.getChildren().addAll(depositButton, withdrawButton);
		
		Button transferButton = new Button("Transfer");
		Button infoButton = new Button("Info");
		HBox secondRow = new HBox();
		secondRow.getChildren().addAll(transferButton, infoButton);
		
		Button exitButton = new Button("Exit");

		VBox layout = new VBox();
		layout.getChildren().addAll(firstRow, secondRow,exitButton);
		scene = new Scene(layout, WIDTH, HEIGHT);
		return scene;
	}
}
