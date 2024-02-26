package Menu;

import java.util.Scanner;

import Library.Book;
import Library.DataBase;
import Library.User;
import UI.IOOperation;

public class AddBook implements IOOperation {

	@Override
	public void oper(DataBase dataBase, User user) {
		
		Scanner sc = new Scanner(System.in);
		Book book = new Book();
		System.out.println("\nEnter book name: ");
		String name = sc.next();
		if (dataBase.getBook(name)>-1) {
			System.out.println("There is a book with this name!\n");
			user.menu(dataBase, user);
			return;
		}
		else {
			book.setName(name);
			System.out.println("Enter book author: ");
			book.setAuthor(sc.next());
			System.out.println("Enter book publisher: ");
			book.setPublisher(sc.next());
			System.out.println("Enter book collection adress: ");
			book.setAdress(sc.next());
			System.out.println("Enter qty: ");
			book.setQty(sc.nextInt());
			System.out.println("Enter price: ");
			book.setPrice(sc.nextDouble());
			System.out.println("Enter borrowing copies: ");
			book.setBrwCopies(sc.nextInt());
			dataBase.AddBook(book);
			System.out.println("Book added sucessfully\n");
			user.menu(dataBase, user);
			sc.close();
		}
	
		}

}
