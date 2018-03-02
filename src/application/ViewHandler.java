package application;

import javafx.scene.Scene;

public class ViewHandler {
	private LoginView login = new LoginView();
	private ErrorView error;
	private UserView user; //VERY BAD
	ViewHandler() {}
	
	public Scene getLoginScene() {
		return login.getScene();
	}
	
	public Scene getUserScene(User user) {
		this.user = new UserView(user);
		return this.user.getScene();
	}
	
	public void getErrorWindow(String err, String title) {
		error = new ErrorView();
		error.display(err, title);
	}
}
