package application;

import java.util.Scanner;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class UserView implements View{
	private Scene scene;
	private final int  WIDTH = 640;
	private final int HEIGHT = WIDTH/12 * 9;
	private User user;
	private Controller controller = new Controller();
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
//			Scanner input = new Scanner(System.in);
//			System.out.println("How many funds to withdraw: ");
//			double amount = input.nextDouble();
//			try {
//				controller.withdraw(user.getUserPIN(), amount);
//			} catch (Exception e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			input.close();
			windowHandler.withdraw(this.user);
		});
		
		HBox firstRow = new HBox();
		firstRow.getChildren().addAll(depositButton, withdrawButton);
		
		Button transferButton = new Button("Transfer");
		Button infoButton = new Button("Info");
		
		transferButton.setOnAction(e->{
			Scanner input = new Scanner(System.in);
			System.out.println("Name of account you want to transfer to:");
			String target = input.nextLine();
			System.out.println("How many funds to transfer: ");
			double amount = input.nextDouble();
			try {
				controller.transfer(user.getUserPIN(),target, amount);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			input.close();
		});
		
		infoButton.setOnAction(e->{
			System.out.println(controller.getInfo(user.getUserID()));
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
