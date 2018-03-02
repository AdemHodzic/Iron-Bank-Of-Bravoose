package application;
	
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
	private Stage window;
	private Controller controller = new Controller();
	private ViewHandler viewController = new ViewHandler();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			window = primaryStage;
			viewController.getErrorWindow("test","test");
			window.setScene(viewController.getUserScene(controller.getUser(0)));
			window.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
