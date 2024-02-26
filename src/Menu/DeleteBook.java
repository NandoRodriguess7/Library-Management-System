package Menu;

import java.util.Scanner;

import Library.DataBase;
import Library.User;
import UI.IOOperation;

public class DeleteBook implements IOOperation{

	@Override
	public void oper(DataBase dataBase, User user) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter book name: ");
		String bookName = sc.next();
		
		int i = dataBase.getBook(bookName);
		if (i>-1) {
			dataBase.deleteBook(i);
			System.out.println("Book deleted sucessfully!\n");
		}
		else {
			System.out.println("Book doesn´t exist!\n");
		}
		user.menu(dataBase, user);
		
	}

}
