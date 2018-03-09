package application;

public class WindowHandler {
	
	WindowHandler(){}

	public void deposit(User user) {
		DepositWindow window = new DepositWindow(user);
		window.display();
	}
	
	public void transfer(User user) {
		TransferWindow window = new TransferWindow(user);
		window.display();
	}
	
	public void withdraw(User user) {
		WithdrawWindow window = new WithdrawWindow(user);
		window.display();
	}
	
	public void info(User user) {
		InfoWindow window = new InfoWindow(user);
		window.display();
	}
}
