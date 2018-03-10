package application;
	
import java.io.File;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
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
			String musicFile = "sound.mp3";     // For example
			Media sound = new Media(new File(musicFile).toURI().toString());
			MediaPlayer mediaPlayer = new MediaPlayer(sound);
			mediaPlayer.play();
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
