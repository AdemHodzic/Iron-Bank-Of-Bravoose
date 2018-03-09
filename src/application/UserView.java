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
	WindowHandler windowHandler = new WindowHandler();
	UserView(User user){
		this.user = user;
	}
	
	public Scene getScene() {
		Button depositButton = new Button("Deposit");
		Button withdrawButton = new Button("Withdraw");
		
		depositButton.setOnAction(e->{
			windowHandler.deposit(this.user);
		});
		
		withdrawButton.setOnAction(e->{
			windowHandler.withdraw(this.user);
		});
		
		HBox firstRow = new HBox();
		firstRow.getChildren().addAll(depositButton, withdrawButton);
		
		Button transferButton = new Button("Transfer");
		Button infoButton = new Button("Info");
		
		transferButton.setOnAction(e->{
			windowHandler.transfer(this.user);
		});
		
		infoButton.setOnAction(e->{
			windowHandler.info(this.user);
		});
		
		HBox secondRow = new HBox();
		secondRow.getChildren().addAll(transferButton, infoButton);
		
		Button exitButton = new Button("Exit");
		
		exitButton.setOnAction(e-> System.exit(0));
		VBox layout = new VBox();
		layout.getChildren().addAll(firstRow, secondRow,exitButton);
		scene = new Scene(layout, WIDTH, HEIGHT);
		return scene;
	}
}
