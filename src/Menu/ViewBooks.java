package Menu;

import java.util.ArrayList;

import Library.Book;
import Library.DataBase;
import Library.User;
import UI.IOOperation;

public class ViewBooks implements IOOperation{

	@Override
	public void oper(DataBase dataBase, User user) {
		
		ArrayList<Book> books = dataBase.getAllBooks();
		System.out.println("Name\t\tAuthor\t\tPublisher\tCLA\tQty\tPrice"
				+ "\tBrw cps");
		for (Book b : books) {
			System.out.println(b.getName()+"\t\t"+ b.getAuthor()+"\t\t"+ b.getPublisher()+"\t\t"+
					b.getAdress()+"\t"+ b.getQty()+"\t"+ b.getPrice()+"\t"+ b.getBrwCopies());
		}
		
		System.out.println();
		user.menu(dataBase, user);
	}
	
	
	
}
