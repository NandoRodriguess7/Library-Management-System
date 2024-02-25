package Library;

import java.io.File;
import java.util.ArrayList;

import application.Program;


public class DataBase {
	
	private ArrayList<User> users = new ArrayList<User>();
	private ArrayList<String> userNames = new ArrayList<String>();
	private ArrayList<Book> books = new ArrayList<Book>();
	private ArrayList<String> bookNames = new ArrayList<String>();
	
	private File usersFile = new File(Program.class.getClassLoader().getResource("Users").getFile());
	private File booksFile = new File(Program.class.getClassLoader().getResource("Books").getFile());
	
	public DataBase() {
		if (!usersFile.exists()) {
			usersFile.mkdirs();
		}
		if (!booksFile.exists()) {
			booksFile.mkdirs();
		}
	}
	
	public void AddUser(User s) {
		users.add(s);
		userNames.add(s.getName());
	}
	
	public int login(String phoneNumber, String email) {
		int n = -1;
		for (User s : users) {
			if (s.getPhoneNumber().matches(phoneNumber) && s.getEmail().matches(email)) {
				n = users.indexOf(s);
				break;
			}
		}
		return n;
	}
	
	public User getUser(int n) {
		return users.get(n);
	}
	
	public void AddBook(Book book) {
		books.add(book);
		bookNames.add(book.getName());
	}
	
}
