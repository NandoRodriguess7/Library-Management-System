package Menu;

import java.util.Scanner;

import Library.Admin;
import Library.DataBase;
import Library.NormalUser;
import Library.User;
import UI.IOOperation;

public class Exit implements IOOperation{
	
	Scanner sc;
	DataBase dataBase;
	User user;
	
	@Override
	public void oper(DataBase dataBase, User user) {
		this.dataBase = dataBase;
		this.user = user;
		System.out.println("\nAre you sure that you want to quit?\n"
				+ "1. Yes\n2. Main Menu");
		new Scanner(System.in);;
		int i = sc.nextInt();
		if (i==1) {
			System.out.println("0. Exit\n1. Login\n2. New User");
			
			sc = new Scanner(System.in);
			
		    int num = sc.nextInt();
			
			switch(num) {
			    case 1: login(); break;
			    case 2: newUser(); break;
			}
		}
		else {
			user.menu(dataBase, user);
		}
		
	}
	
	private void login() {
		System.out.println("Enter phone number: ");
		String phoneNumber = sc.next();
		System.out.println("Enter email: ");
		String email = sc.next();
		int n = dataBase.login(phoneNumber, email);
		if (n != -1) {
			User user = dataBase.getUser(n);
			user.menu(dataBase, user);
		}
		else {
			System.out.println("User doesn´t exist!");;
		}
	}
	
	private void newUser() {
		System.out.println("Enter name: ");
		String name = sc.next();
		System.out.println("Enter phone number: ");
		String phoneNumber = sc.next();
		System.out.println("Enter email: ");
		String email = sc.next();
		System.out.println("1. Admin\n2. Normal User");
		int n2 = sc.nextInt();
		User user;
		if(n2==1) {
			user = new Admin(name, email, phoneNumber);
		}
		else {
			user = new NormalUser(name, email, phoneNumber);
		}
		dataBase.AddUser(user);
		user.menu(dataBase, user);
	}
}
