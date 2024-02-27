package Library;

import java.util.Scanner;

import Menu.BorrowBook;
import Menu.CalculatorFine;
import Menu.Exit;
import Menu.ReturnBook;
import Menu.Search;
import Menu.ViewBooks;
import OrderPack.PlaceOrder;
import UI.IOOperation;

public class NormalUser extends User{
	
	public NormalUser(String name) {
		super(name);
		this.operations = new IOOperation[] {
				new ViewBooks(),
				new Search(),
				new PlaceOrder(),
				new BorrowBook(),
				new CalculatorFine(),
				new ReturnBook(),
				new Exit()
		};
	}
	
	public NormalUser(String name, String email, String phoneNumber) {
		super(name, email, phoneNumber);
		this.operations = new IOOperation[] {
				new ViewBooks(),
				new Search(),
				new PlaceOrder(),
				new BorrowBook(),
				new CalculatorFine(),
				new ReturnBook(),
				new Exit()
		};
	}
	
	@Override
	public void menu(DataBase dataBase, User user) {
		System.out.println("View Books");
		System.out.println("Search");
		System.out.println("Place Order");
		System.out.println("Borrow menu");
		System.out.println("Calculate Fine");
		System.out.println("Return Book");
		System.out.println("Exit");
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		this.operations[n-1].oper(dataBase, user);
		sc.close();
	}
	
	public String toString() {
		return name+"<N/>"+email+"<N/>"+phoneNumber+"<N/>"+"Admin";
	}
	
}