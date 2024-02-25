package application;

import java.util.Scanner;

import Library.Admin;
import Library.DataBase;
import Library.NormalUser;
import Library.User;

public class Program {
	
    static Scanner s;
    static DataBase dataBase;
	
	public static void main(String[] args) {
		
	    dataBase = new DataBase();
	    System.out.println("Welcome to Library Management System!");
		
		int num;
		do {
			System.out.println("0. Exit\n1. Login\n2. New User");
			
			s = new Scanner(System.in);
			
		    num = s.nextInt();
			
			switch(num) {
			    case 1: login();
			    case 2: newUser();
			}
		} while (num != 0);
		
	}
	
	private static void login() {
		System.out.println("Enter phone number: ");
		String phoneNumber = s.next();
		System.out.println("Enter email: ");
		String email = s.next();
		int n = dataBase.login(phoneNumber, email);
		if (n != -1) {
			User user = dataBase.getUser(n);
			user.menu(dataBase, user);
		}
		else {
			System.out.println("User doesn´t exist!");;
		}
	}
	
	private static void newUser() {
		System.out.println("Enter name: ");
		String name = s.next();
		System.out.println("Enter phone number: ");
		String phoneNumber = s.next();
		System.out.println("Enter email: ");
		String email = s.next();
		System.out.println("1. Admin\n2. Normal User");
		int n2 = s.nextInt();
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
