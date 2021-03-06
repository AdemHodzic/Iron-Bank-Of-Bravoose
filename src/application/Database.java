package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Database {
	private Path path = Paths.get("files/users.txt");
	private ArrayList<User> userDatabase = new ArrayList<>();
	
	Database(){
		
	}
	
	public void readUsers()throws Exception{  //For inputing from files to list
		userDatabase.clear();
		BufferedReader reader = Files.newBufferedReader(path);
		String temp;
		while((temp=reader.readLine())!=null) {
			String[] arr = temp.split(" ");
			User user = new User(arr[0], Integer.parseInt(arr[1]), Double.parseDouble(arr[2]));
			userDatabase.add(user);
		}
		reader.close();
	}
	
	private void writeUsers() throws Exception{ //For inputing from list to files
		BufferedWriter writer = Files.newBufferedWriter(path);
		for(User user:userDatabase) {
			writer.write(user.toString());
			writer.newLine();
		}
		writer.close();
	}
	
	public void addUser(String userID, int userPIN) throws Exception{
		readUsers();
		if(validate(userPIN)) {
			User user = new User(userID,userPIN);
			userDatabase.add(user);
			writeUsers();
		}else {
			//Add pop up window for invalid user
			ErrorView err = new ErrorView();
			err.display("Wrong input", "USER WITH THAT PIN ALREADY EXISTS");
		}
	}
	
	public String info(String userID) {
		try {
			readUsers();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userDatabase.get(getUserIndex(userID)).toString();
	}
	
	public String info(int pin) {
		try {
			readUsers();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userDatabase.get(getUserIndex(pin)).toString();
	}
	
	public void transfer(int source, String target, double amount) throws Exception {
		userDatabase.get(getUserIndex(source))
		.transfer(userDatabase.get(
				getUserIndex(target)), amount);
		writeUsers();
	}
	
	public void withdraw(int pin, double amount) throws Exception {
		userDatabase
		.get(getUserIndex(pin))
		.withdraw(amount);
		writeUsers();
	}
	
	public boolean isValid(String username, int pin) throws Exception{
		readUsers();
		if(pin<0) return false;
		for(User user:userDatabase) {
			if(user.getUserID().equals(username) && user.getUserPIN()==pin) return true;
		}
		
		return false;
	}
	
	public void deposit(int pin, double amount) throws Exception {
		userDatabase
		.get(getUserIndex(pin))
		.deposit(amount);
		writeUsers();
	}
	
	private boolean validate(int num) {
		if(num<0) return false;
		for(User user:userDatabase) {
			if(user.getUserPIN()==num) return false;
		}
		
		return true;
	}
	
	private int getUserIndex(int num) {
		for(int i = 0;i<userDatabase.size();i++) {
			if(userDatabase.get(i).getUserPIN()==num) return i;
		}
		return 0;
	}
	
	private int getUserIndex(String str) {
		for(int i = 0;i<userDatabase.size();i++) {
			if(userDatabase.get(i).getUserID().equals(str)) return i;
		}
		return 0;
	}
	
	public User getUser(int index) {
		return userDatabase.get(index);
	}

	public ArrayList<User> getUserDatabase() {
		return userDatabase;
	}
	
	
}
