package application;
	
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
	private Stage window;
	private ViewHandler viewController = new ViewHandler();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			window = primaryStage;
			AnimationTimer timer = new AnimationTimer() {
				@Override
				public void handle(long now) {
					window.setScene(viewController.getLoginScene());
				}
			};
			window.setTitle("Iron Bank Of Bravoose");
			timer.start();
			window.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
