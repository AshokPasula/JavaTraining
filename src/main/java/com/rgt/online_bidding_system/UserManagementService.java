package com.rgt.online_bidding_system;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author Ashok This class having user main menu operation
 *
 */
public class UserManagementService {
	private List<User> users;
	private static Scanner scanner;
	private static ItemManagementService itemManagementService;
	private static BiddingStrategy biddingStrategy;
	private static Observer observer;

	/**
	 * In constructor I create list for to store the user. Created for Object for
	 * ItemManagementService class, IncrementalBiddingStrategy class,and
	 * UserObserver class
	 */
	public UserManagementService() {
		this.users = new ArrayList<>();
		itemManagementService = new ItemManagementService();
		biddingStrategy = new IncrementalBiddingStrategy();
		observer = new UserObserver();
	}

	/**
	 * Creating new user and Storing it in User list
	 * 
	 * @param username
	 * @param password
	 */
	public void createUser(String username, String password) {
		scanner = new Scanner(System.in);
		User user = new User(username, password);
		users.add(user);
	}

	/**
	 * return the particular user to login
	 * 
	 * @param userName
	 * @return
	 */
	public User logedUser(String userName) {
		for (User user : users) {
			if (user.getUsername().equals(userName)) {
				return user;
			}
		}
		return null;
	}

	/**
	 * login method for particular and user menu
	 */
	public void authenticateUser() {
		System.out.print("Enter your username: ");
		String userName = scanner.next();
		User user = logedUser(userName);
		if (user != null) {
			System.out.print("Enter your password: ");
			String password = scanner.next();
			if (user.getPassword().equals(password)) {
				userBiddingMenu(user);
			} else {
				System.out.println("Invalid password\n ");
			}
		} else {
			System.out.println("Invalid username\n ");
		}

	}

	/**
	 * 
	 * user menu method
	 */
	public static void userBiddingMenu(User user) {
		boolean exit = false;
		while (!exit) {
			System.out.println("\n===== Welcome " + user.getUsername() + " Online Bidding System! =====");
			System.out.println("1. Search Items");
			System.out.println("2. View Bidding History");
			System.out.println("3. Logout");
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("\nType the item name into the search box to start a bid: ");
				String itemName = scanner.next();

				List<Item> searchResults = itemManagementService.searchItems(itemName);
				Item item = searchResults.get(0);
				System.out.println("Searched item: ");
				System.out.println("Item Name: " + item.getName());
				System.out.println("Item description: " + item.getDescription());
				System.out.println("Current bid amount: " + item.getCurrentHighestBid());
				System.out.println("Do you place the bid for above Item: Y/N");
				String itemChoice = scanner.next();
				if ("Y".equals(itemChoice)) {
					double bidItem = biddingStrategy.bid(item, user);
					observer.update(item);
					System.out.println("New bid amount: " + bidItem);
					boolean winningBidValue = false;
					int highestBidValue = 1005;
					if (bidItem >= highestBidValue) {
						winningBidValue = true;
					}
					Bid bid = new Bid(item, user, bidItem, winningBidValue);
					user.addBid(bid);
					user.winningBid(bid);
				} else {
					System.out.println("do you want search for other item with same given item name: Y/N");
					String itemListChoice = scanner.next();
					if ("Y".equals(itemListChoice)) {
						System.out.println("Here the list of search item");
						for (int i = 0; i < searchResults.size(); i++) {
							Item itemList = searchResults.get(i);
							System.out.println("Item_" + i + ": " + itemList.getName());
						}
						System.out.print("Please pick the item from below list: ");
						scanner.nextLine();
						String itemName01 = scanner.nextLine();
						List<Item> searchResults01 = itemManagementService.searchItems(itemName01);
						Item item01 = searchResults01.get(0);
						System.out.println("Searched item: ");
						System.out.println("Item Name: " + item01.getName());
						System.out.println("Item description: " + item01.getDescription());
						System.out.println("Current bid amount: " + item01.getCurrentHighestBid());
						double bidItem01 = biddingStrategy.bid(item01, user);
						observer.update(item01);
						System.out.println("New bid amount: " + bidItem01);
						boolean winningBidValue = false;
						int highestBidValue = 1005;
						if (bidItem01 >= highestBidValue) {
							winningBidValue = true;
						}
						Bid bid01 = new Bid(item01, user, bidItem01, winningBidValue);
						user.addBid(bid01);
						user.winningBid(bid01);
					}
				}

				break;
			case 2:
				List<Bid> biddingHistory = user.getBiddingHistory();
				System.out.println("Your bidding history:");
				for (Bid bid : biddingHistory) {
					System.out.println(bid.getItem().getName() + " - Bid amount: " + bid.getAmount()
							+ " - Winning bid: " + bid.isWinningBid());
				}
				break;
			case 3:
				exit = true;
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}
}
