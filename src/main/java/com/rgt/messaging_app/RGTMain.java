package com.rgt.messaging_app;

import java.util.Scanner;

public class RGTMain {
	private static Scanner scanner = new Scanner(System.in);
    private static RGTMessaging rgtMessaging =new RGTMessaging();
	public static void main(String[] args) {

		boolean exit = false;

		while (!exit) {
			System.out.println("Welcome to RGT Messaging");
			System.out.println("1. Register");
			System.out.println("2. Log In");
			System.out.println("3. Exit");
			System.out.print("\nEnter your choice: ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				rgtMessaging.registerUser();
				break;
			case 2:
				rgtMessaging.login();
				break;
			case 3:
				exit = true;
				System.out.println("Thansk for using RGT Messaging");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}
}
