package Menu;

import java.util.Scanner;

import Library.DataBase;
import Library.User;
import UI.IOOperation;

public class DeleteAllData implements IOOperation{

	@Override
	public void oper(DataBase dataBase, User user) {
		
		System.out.println("\nAre you sure that you want to delete all data?\n"
				+ "1. Contine\n2. Main Menu");
		Scanner sc = new Scanner(System.in);;
		int i = sc.nextInt();
		if (i==1) {
			dataBase.deleteAllData();
		}
		else {
			user.menu(dataBase, user);
		}
	}

}
