package Library;

import java.util.Scanner;

import Menu.AddBook;
import Menu.DeleteAllData;
import Menu.DeleteBook;
import Menu.Exit;
import Menu.Search;
import Menu.ViewBooks;
import Order.ViewOrders;
import UI.IOOperation;

public class Admin extends User{
	
	public Admin(String name) {
		super(name);
		this.operations = new IOOperation[] {
				new ViewBooks(),
				new AddBook(),
				new DeleteBook(),
				new Search(),
				new DeleteAllData(),
				new ViewOrders(),
				new Exit()
		};
	}
	
	public Admin(String name, String email, String phoneNumber) {
		super(name, email, phoneNumber);
		this.operations = new IOOperation[] {
						new ViewBooks(),
						new AddBook(),
						new DeleteBook(),
						new Search(),
						new DeleteAllData(),
						new ViewOrders(),
						new Exit()
				};
	}
	
	@Override
	public void menu(DataBase dataBase, User user) {
		System.out.println("1. View Books");
		System.out.println("2. Add Book");
		System.out.println("3. Delete Book");
		System.out.println("4. Search");
		System.out.println("5. Delete all data");
		System.out.println("6. View Order");
		System.out.println("7. Exit");
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		this.operations[n-1].oper(dataBase, user);
		sc.close();
	}
	
	public String toString() {
		return name+"<N/>"+email+"<N/>"+phoneNumber+"<N/>"+"Admin";
	}
	
}