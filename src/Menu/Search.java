package Menu;

import java.util.Scanner;

import Library.DataBase;
import Library.User;
import UI.IOOperation;

public class Search implements IOOperation {

	@Override
	public void oper(DataBase dataBase, User user) {
		
		System.out.println("\nEnter book name: ");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		int i = dataBase.getBook(name);
		if (i>-1) {
			System.out.println("\n"+ dataBase.getBook(i).toString()+ "\n");;
		}
		else {
			System.out.println("Book doesn´t exist!\n");
		}
		user.menu(dataBase, user);
		
	}

}
