package OrderPack;

import java.awt.BorderLayout;
import java.util.Scanner;

import Library.DataBase;
import Library.User;
import UI.IOOperation;

public class ViewOrders implements IOOperation{

	@Override
	public void oper(DataBase dataBase, User user) {
		
		System.out.println("\nEnter book name:");
		Scanner sc = new Scanner(System.in);
		String bookName = sc.next();
		int i = dataBase.getBook(bookName);
		if(i>-1) {
			System.out.println("Book\t\tUser\t\tQty\tPrice");
			for (Order order : dataBase.getAllOrders()) {
				if (order.getBook().getName().matches(bookName)) {
					System.out.println(order.getBook().getName() + "\t\t" +
				    order.getUser().getName() + "\t\t" + order.getQty() + "\t" +
					order.getPrice());
				}
			}
			System.out.println();
		}
		else {
			System.out.println("Book doesn´t exist!\n");
		}
		user.menu(dataBase, user);
		
	}

}
