package application;

public class Controller {
	private Database db = new Database();

	
	Controller(){
		try {
			db.readUsers();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addUser(String name, int number)throws Exception {
		db.addUser(name, number);
	}
	
	public boolean login(String username, int pin) throws Exception{
		return db.isValid(username, pin);
	}
	
	public String getInfo(String name) {
		return db.info(name);
	}
	
	public void deposit(int pin, double amount) throws Exception {
		db.deposit(pin, amount);
	}
	
	public void withdraw(int pin, double amount) throws Exception {
		db.withdraw(pin, amount);
	}
	
	public void transfer(int pin, String target, double amount) throws Exception {
		db.transfer(pin, target, amount);
	}
	
	public boolean isNumber(String str) {
		for(int i = 0;i<str.length();i++) {
			if(!Character.isDigit(str.charAt(i))) return false;
		}
		return true;
	}
	
	public User getUser(int number) {
		return db.getUser(number);
	}
	
	public int getUserIndex(int number) {
		for(int i = 0;i<db.getUserDatabase().size();i++) {
			if(db.getUserDatabase().get(i).getUserPIN()==number) return i;
		}
		return -1;
	}
	

	public int getUserIndex(String str) {
		for(int i = 0;i<db.getUserDatabase().size();i++) {
			if(db.getUserDatabase().get(i).getUserID().equals(str)) return i;
		}
		return -1;
	}
	
	public Database getDatabase() {
		return db;
	}
}
