package OrderPack;

import java.util.Scanner;

import OrderPack.Order;
import Library.Book;
import Library.DataBase;
import Library.User;
import UI.IOOperation;

public class PlaceOrder implements IOOperation{

	@Override
	public void oper(DataBase dataBase, User user) {
		
		Order order = new Order();
		System.out.println("\nEnter book name:");
		Scanner sc = new Scanner(System.in);
		String bookName = sc.next();
		int i = dataBase.getBook(bookName);
		if (i<=-1) {
			System.out.println("Book doesn´t exist!");
		}
		else {
			Book book = dataBase.getBook(i);
			order.setBook(book);
			order.setUser(user);
			System.out.println("Enter qty:");
			int qty = sc.nextInt();
			order.setQty(qty);
			order.setPrice(book.getPrice()*qty);
			int bookIndex = dataBase.getBook(book.getName());
			book.setQty(book.getQty()-qty);
			dataBase.addOrder(order, book, bookIndex);
			System.out.println("Order placed sucessfully!\n");
		}
		user.menu(dataBase, user);
	}

}
