package Menu;

import java.util.Scanner;

import Library.Borrowing;
import Library.DataBase;
import Library.User;
import UI.IOOperation;

public class CalculatorFine implements IOOperation{

	@Override
	public void oper(DataBase dataBase, User user) {
		
		System.out.println("Enter book name: ");
		Scanner sc = new Scanner(System.in);
		String bookName = sc.next();
		
		for (Borrowing b : dataBase.getBrws()) {
			if (b.getBook().getName().matches(bookName) &&
					b.getUser().getName().matches(bookName)) {
				if (b.getDaysLeft()<0) {
					System.out.println("You are late!\n"
							+ "You have to pay " + Math.abs(b.getDaysLeft()*50)+" as fine\n");
				} else {
					System.out.println("You don´t have to pay fine\n");
				}
			}
		}
		user.menu(dataBase, user);
	}

}
