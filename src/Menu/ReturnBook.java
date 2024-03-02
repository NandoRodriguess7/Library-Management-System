package Menu;

import java.util.Scanner;

import Library.Book;
import Library.Borrowing;
import Library.DataBase;
import Library.User;
import UI.IOOperation;

public class ReturnBook implements IOOperation {

	@Override
	public void oper(DataBase dataBase, User user) {
		
		System.out.println("Enter book name:");
		Scanner sc = new Scanner(System.in);
		String bookName = sc.next();
		if (!dataBase.getBrws().isEmpty()) {
			for (Borrowing b : dataBase.getBrws()) {
				if (b.getBook().getName().matches(bookName) &&
						b.getUser().getName().matches(bookName)) {
					Book book = b.getBook();
					int i = dataBase.getAllBooks().indexOf(bookName);
					if (b.getDaysLeft()<0) {
						System.out.println("You are late!\n"
								+ "You have to pay " + Math.abs(b.getDaysLeft()*50) + " as fine");
					}
					book.setBrwCopies(book.getBrwCopies()+1);
					dataBase.returnBook(b, book, i);
					System.out.println("Book returned\nThank you!\n");
					break;
				} else {
					System.out.println("You didn´t borrow this book!\n");
				}
			}
		} else {
			System.out.println("You didn´t borrow this book!\n");
		}
		user.menu(dataBase, user);
	}

}
