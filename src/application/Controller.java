package application;

public class Controller {
	private Database db = new Database();;
	
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
}
