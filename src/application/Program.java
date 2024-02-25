package application;

import java.util.Scanner;

public class Program {
	
    static Scanner s;
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to Library Management System!\n"
				+ "1. Login\n2. New User");
		
		s = new Scanner(System.in);
		
		int n = s.nextInt();
		
		switch(n) {
		case 1: login();
		case 2: newUser();
		default: System.out.println("Error!");
		}
		
	}
	
	private static void login() {
		System.out.println("Enter phone number: ");
		String phoneNumber = s.next();
		System.out.println("Enter email: ");
		String email = s.next();
	}
	
	private static void newUser() {
		System.out.println("Enter name: ");
		String name = s.next();
		System.out.println("Enter phone number: ");
		String phoneNumber = s.next();
		System.out.println("Enter email: ");
		String email = s.next();
	}

}
