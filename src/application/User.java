package application;

public class User {
	private String userID;
	private int userPIN;
	private double userBalance;

	public User(String userID, int userPIN, double userBalance) {
		this.userID = userID;
		this.userPIN = userPIN;
		this.userBalance = userBalance;
	}

	public User(String userID, int userPIN) {
		this.userID = userID;
		this.userPIN = userPIN;
		this.userBalance = 0;
	}
	
	public void transfer(User user, double amount) {
		user.deposit(amount);
		this.withdraw(amount);
	}
	
	public void deposit(double amount) {
		this.userBalance+=amount;
	}
	
	public void withdraw(double amount) {
		this.userBalance-=amount;
	}
	
	@Override
	public String toString() {
		return this.userID + " " + this.userPIN + " " + this.userBalance;
	}

	public double getUserBalance() {
		return userBalance;
	}

	public void setUserBalance(double userBalance) {
		this.userBalance = userBalance;
	}

	public String getUserID() {
		return userID;
	}

	public int getUserPIN() {
		return userPIN;
	}
}
