package Library;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;


public class DataBase {
	
	private ArrayList<User> users = new ArrayList<User>();
	private ArrayList<String> userNames = new ArrayList<String>();
	private ArrayList<Book> books = new ArrayList<Book>();
	private ArrayList<String> bookNames = new ArrayList<String>();
	
	private File usersFile = new File("C:\\Library Management System\\Data\\Users");
	private File booksFile = new File("C:\\Library Management System\\Data\\Books");
	private File folder = new File("C:\\Library Management System\\Data");
	
	public DataBase() {
		if (!folder.exists()) {
			folder.mkdirs();
		}
		if (!usersFile.exists()) {
			try {
				usersFile.createNewFile();
			}
			catch (Exception e) {}
		}
		if (!booksFile.exists()) {
			try {
				booksFile.createNewFile();
			}
			catch (Exception e) {}
		}
		getUsers();
		getBooks();
	}
	
	public void AddUser(User s) {
		users.add(s);
		userNames.add(s.getName());
		saveUsers();
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
		saveBooks();
	}
	
	private void getUsers() {
		String text1 = "";
		try {
			BufferedReader br1 = new BufferedReader(new FileReader(usersFile));
			String s1;
			while((s1 = br1.readLine()) != null) {
				text1 = text1 + s1;
			}
		}
		catch (Exception e) {
			System.err.println(e.toString());
		}
		
		if (!text1.matches("") || !text1.isEmpty()) {
			String[] a1 = text1.split("<NewUser/>");
			for (String s : a1) {
				 String[] a2 = s.split("<N/>");
				 if (a2[3].matches("Admin")) {
					 User user = new Admin(a2[0], a2[1], a2[2]);
					 users.add(user);
					 userNames.add(user.getName());
				 }
				 else {
					 User user = new NormalUser(a2[0], a2[1], a2[2]);
					 users.add(user);
					 userNames.add(user.getName());
				 }
			}
		}
	}
	
	private void saveUsers() {
		String text1 = "";
		for (User user : users) {
			text1 = text1 + user.toString()+"<NewUser/>\n";
		}
		try {
			PrintWriter pw = new PrintWriter(usersFile);
			pw.print(text1);
			pw.close();
		}
		catch (Exception e) {
			System.err.println(e.toString());
		}
	}
	
	private void saveBooks() {
		String text1 = "";
		for (Book book : books) {
			text1 = text1 + book.toString2()+"<NewBook/>\n";
		}
		try {
			PrintWriter pw = new PrintWriter(booksFile);
			pw.print(text1);
			pw.close();
		}
		catch (Exception e) {
			System.err.println(e.toString());
		}
	}
	
	private void getBooks() {
		String text1 = "";
		try {
			BufferedReader br1 = new BufferedReader(new FileReader(booksFile));
			String s1;
			while((s1 = br1.readLine()) != null) {
				text1 = text1 + s1;
			}
		}
		catch (Exception e) {
			System.err.println(e.toString());
		}
		
		if (!text1.matches("") || !text1.isEmpty()) {
			String[] a1 = text1.split("<NewBook/>");
			for (String s : a1) {
				Book book = parseBook(s);
				books.add(book);
				bookNames.add(book.getName());
			}
		}
		
	}
	
	public Book parseBook(String s) {
		String[] a = s.split("<N/>");
		Book book = new Book();
		book.setName(a[0]);
		book.setAuthor(a[1]);
		book.setPublisher(a[2]);
		book.setAdress(a[3]);
		book.setQty(Integer.parseInt(a[4]));
		book.setPrice(Double.parseDouble(a[5]));
		book.setBrwCopies(Integer.parseInt(a[6]));
		return book;
	}
	
	public ArrayList<Book> getAllBooks(){
		return books;
	}
	
	public int getBook(String bookName) {
		int i = -1;
		for (Book book : books) {
			if (book.getName().matches(bookName));
			i = books.indexOf(book);
		}
		return i;
	}
	
	public void deleteBook(int i) {
		books.remove(i);
		bookNames.remove(i);
		saveBooks();
	}
	
}
