package Menu;

import java.util.Scanner;

import Library.Book;
import Library.Borrowing;
import Library.DataBase;
import Library.User;
import UI.IOOperation;

public class BorrowBook implements IOOperation {

	@Override
	public void oper(DataBase dataBase, User user) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter book name: ");
		String bookName = sc.next();
		
		int i = dataBase.getBook(bookName);
		if (i>-1) {
			Book book = dataBase.getBook(i);
			if (book.getBrwCopies()>1) {
				Borrowing borrowing = new Borrowing(book, user);
				book.setBrwCopies(book.getBrwCopies());
				dataBase.borrowBook(borrowing, book, i);
				System.out.println("You must return the book before 14 days from now\n" +
				         "Expiry date: "+ borrowing.getFinish() + "\nEnjoy!\n");
			}
			System.out.println("This book isn´t avaible for borrowing!\n");
		} else {
			System.out.println("Book doesn´t exist!\n");
		}
		user.menu(dataBase, user);
	}
	
	
}
