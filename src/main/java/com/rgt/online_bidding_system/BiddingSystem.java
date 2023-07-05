package com.rgt.online_bidding_system;

import java.util.*;

/**
 * 
 * @author Ashok This is main class for Bidding System
 *
 */
public class BiddingSystem {
	private static Scanner scanner;
	private static UserManagementService userManagementService;
	private static ItemManagementService itemManagementService;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);

		// Users created by hard code
		userManagementService = new UserManagementService();
		userManagementService.createUser("user1", "password1");
		userManagementService.createUser("user", "password");

		// Add items to the auction by hard code
		itemManagementService = new ItemManagementService();
		itemManagementService.addItem("Men's North Face Jacket", "A waterproof jacket for men", 1000.0);
		itemManagementService.addItem("Women's Columbia Jacket", "A warm and stylish jacket for women", 750.0);

		boolean exit = false;
		while (!exit) {
			displayMenu();
			int choice = getChoice();

			switch (choice) {
			case 1:
				userManagementService.authenticateUser();
				break;
			case 2:
				System.out.print("Create your username: ");
				String createUserName = scanner.next();
				System.out.print("Create your password: ");
				String createPassword = scanner.next();
				userManagementService.createUser(createUserName, createPassword);
				break;
			case 3:
				exit = true;
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}

	}

	/**
	 * Displaying the main menu of Bidding system
	 */

	private static void displayMenu() {
		System.out.println("===== Welcome to the Online Bidding System! =====");
		System.out.println("1. Login");
		System.out.println("2. Create Account");
		System.out.println("3. Exit");
		System.out.print("Enter your choice: ");
	}

	/**
	 * Method return the choice of main menu
	 * 
	 * @return
	 */
	private static int getChoice() {
		while (!scanner.hasNextInt()) {
			scanner.next();
			System.out.print("Invalid input. Please enter a number: ");
		}
		return scanner.nextInt();
	}
}
