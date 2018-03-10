package application;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

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
		Button transferButton = new Button("Transfer");
		Button infoButton = new Button("Info");
		Button exitButton = new Button("Exit");

		depositButton.setPrefWidth(WIDTH);
		withdrawButton.setPrefWidth(WIDTH);
		transferButton.setPrefWidth(WIDTH);
		infoButton.setPrefWidth(WIDTH);
		exitButton.setPrefWidth(WIDTH);
		
		depositButton.setPrefHeight(HEIGHT);
		withdrawButton.setPrefHeight(HEIGHT);
		transferButton.setPrefHeight(HEIGHT);
		infoButton.setPrefHeight(HEIGHT);
		exitButton.setPrefHeight(HEIGHT);
		
		GridPane.setConstraints(depositButton, 0, 0);
		GridPane.setConstraints(withdrawButton, 1, 0);
		GridPane.setConstraints(transferButton, 0, 1);
		GridPane.setConstraints(infoButton, 1, 1);
		GridPane.setConstraints(exitButton, 0, 2);
		
		depositButton.setOnAction(e->{
			windowHandler.deposit(this.user);
		});
		
		withdrawButton.setOnAction(e->{
			windowHandler.withdraw(this.user);
		});
		
		
		transferButton.setOnAction(e->{
			windowHandler.transfer(this.user);
		});
		
		infoButton.setOnAction(e->{
			windowHandler.info(this.user);
		});
		
		exitButton.setOnAction(e-> System.exit(0));
		exitButton.setId("exit");
		
		GridPane layout = new GridPane();
		layout.setPadding(new Insets(10,10,10,10));
		layout.setVgap(8);
		layout.setHgap(10);
		layout.getChildren().addAll(depositButton, withdrawButton, transferButton, infoButton, exitButton);
		layout.setAlignment(Pos.CENTER);
		scene = new Scene(layout, WIDTH, HEIGHT);
		scene.getStylesheets().add(getClass().getResource("user.css").toExternalForm());
		return scene;
	}
}
