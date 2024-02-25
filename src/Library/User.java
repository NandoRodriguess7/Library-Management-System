package Library;

import UI.IOOperation;

public abstract class User {
	
	protected String name;
	protected String email;
	protected String phoneNumber;
	protected IOOperation[] operations;
	
	public User() {
	}
	
	public User(String name) {
		this.name = name;
	}
	
	public User(String name, String email, String phoneNumber) {
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public abstract void menu(DataBase dataBase, User user);
}
