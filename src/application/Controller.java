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
	
	public boolean login(String username, int pin) {
		return db.isValid(username, pin);
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
}
