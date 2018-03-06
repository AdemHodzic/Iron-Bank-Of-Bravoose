package application;

public class WindowHandler {
	
	WindowHandler(){}

	public void deposit(User user) {
		DepositWindow window = new DepositWindow(user);
		window.display();
	}
	
	public void transfer() {
		
	}
	
	public void withdraw(User user) {
		WithdrawWindow window = new WithdrawWindow(user);
		window.display();
	}
	
	public void infor() {
		
	}
}
