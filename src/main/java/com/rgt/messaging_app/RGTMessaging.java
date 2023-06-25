package com.rgt.messaging_app;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RGTMessaging {
	private static Scanner scanner = new Scanner(System.in);
	private boolean exit;
	private DataStore dataStore = new DataStore();;
	private User user = new User();;
	private List<Tweet> timeline;

	public void userOpeartion(String Username) {
		exit = false;
		User loginUser = dataStore.loadData().get(Username);
		while (!exit) {
			System.out.println("\nWelcome " + loginUser.getName());
			System.out.println("1. Post a Tweet");
			System.out.println("2. View your Timline");
			System.out.println("3. Search for User");
			System.out.println("4. Search for Tweets");
			System.out.println("5. View your Profile");
			System.out.println("6. Logout");
			System.out.print("\nEnter your choice: ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				user.postTweet(loginUser.getName());
				break;
			case 2:
				List<Tweet> allTwts = getTimeline();
				System.out.println("Your Timeline:");
				for (Tweet twt : allTwts) {
					System.out.println(twt.getContent() + " " + twt.getId());
				}
				System.out.print("\n");
				break;
			case 3:
				System.out.print("Enter the username of your going to search: ");
				String searchUserName = scanner.next();
				System.out.println("\nResult of user search :");
				searchUser(dataStore.loadData(), searchUserName, loginUser.getUserName());
				break;
			case 4:
				System.out.print("Enter the tweet conntent of your going to search: ");
				String searchTweetContent = scanner.next();
				Tweet searchedTweets = searchTweet(searchTweetContent);
				System.out.println("Result of tweet search :");
				if (searchedTweets != null) {
					System.out.println(searchedTweets.getContent());
				} else {
					System.out.println("Tweest not found");
				}
				break;
			case 5:
				this.getProfile(Username);
				break;
			case 6:
				this.logout();
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}

	public void registerUser() {
		System.out.print("\nEnter your name:");
		String name = scanner.next();
		System.out.print("Create your username:");
		String userName = scanner.next();
		System.out.print("Create your password:");
		String password = scanner.next();
		System.out.print("Enter your Bio:");
		String bio = scanner.next();
		if (dataStore.loadData().containsKey(userName)) {
			System.out.println("UserName is alreay taken, Please give another one");
		} else {
			User newUser = new User(userName, password, name, bio);
			dataStore.saveData(userName, newUser);
			System.out.println("User created succefully\n");
		}
	}

	public void login() {
		System.out.print("\nEnter your username:");
		String userName = scanner.next();
		if (dataStore.loadData().containsKey(userName)) {
			System.out.print("Enter your Password:");
			String password = scanner.next();
			User loadUser = dataStore.loadData().get(userName);
			if (password.equalsIgnoreCase(loadUser.getPassword())) {
				this.userOpeartion(loadUser.getUserName());
			} else {
				System.out.println("Incorrect Password\n");
			}
		} else {
			System.out.println("Incorrect Username\n");
		}
	}

	public void logout() {
		exit = true;
		System.out.println("Successfully Logout from your Account\n");
	}

	public void searchUser(Map<String, User> map, String partialText, String userName) {
		for (Map.Entry<String, User> entry : map.entrySet()) {
			String key = entry.getKey();
			if (key.contains(partialText)) {
				if (key.equals(userName)) {
					continue;
				}
				System.out.println(key);
			}
		}
		searchedUserOperatin();
	}

	public Tweet searchTweet(String content) {
		for (Tweet searchTweet : timeline) {
			if (searchTweet.getContent().equalsIgnoreCase(content)) {
				return searchTweet;
			}
		}
		return null;
	}

	public List<Tweet> getTimeline() {
		List<Tweet> timeline = new ArrayList<>();
		for (User following : user.getFollowings()) {
			timeline.addAll(following.getTweets());
		}
		timeline.addAll(user.getTweets());
		return timeline;
	}

	public void getProfile(String userName) {
		User loaduser = dataStore.loadData().get(userName);
		System.out.println("User profile details");
		System.out.println("Name: " + loaduser.getName());
		System.out.println("User name: " + loaduser.getUserName());
		System.out.println("Bio: " + loaduser.getBio());
		System.out.println("Followers: " + loaduser.getFollowersSize());
		System.out.println("Following: " + loaduser.getFollowersSize());
		System.out.println("Tweets:    " + loaduser.getTweets().size());
	}

	public void searchedUserOperatin() {
		System.out.print("Please select the user from above list:");
		String name = scanner.next();
		User loaduser = dataStore.loadData().get(name);
		if (name.equals(loaduser.getUserName())) {
			System.out.println("UserName:  " + loaduser.getUserName());
			System.out.println("Name:      " + loaduser.getName());
			System.out.println("bio:       " + loaduser.getBio());
			System.out.println("Followers: " + loaduser.getFollowersSize());
			System.out.println("Following: " + loaduser.getFollowingsSize());
			System.out.println("Tweets:    " + loaduser.getTweets().size());
			if (!user.isfollow(loaduser.getUserName())) {
				System.out.println("To follow click 1 \nTo skip click 2 \nchoose your option");
				int follow = scanner.nextInt();
				switch (follow) {
				case 1:
					user.follow(loaduser);
					break;
				case 2:
					break;
				}
			} else {
				System.out.println("To unfollow click 1 \nTo skip click 2 \nchoose your option");
				int unfollow = scanner.nextInt();
				switch (unfollow) {
				case 1:
					user.unfollow(loaduser);
					break;
				case 2:
					break;
				}
			}
		} else {
			System.out.println("Given username is not Exist...");
		}
	}
}
