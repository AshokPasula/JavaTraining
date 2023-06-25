package com.rgt.messaging_app;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {

	private String username;
	private String password;
	private String name;
	private String bio;
	private List<User> followings  = new ArrayList<>();;
	private List<User> followers  = new ArrayList<>();;
	private List<Tweet> tweets = new ArrayList<>();;
	private DataStore dataStore = new DataStore();;


	public User(String username, String password, String name, String bio) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.bio = bio; 
	}

	public User() {
		
	}

	public String getUserName() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getBio() {
		return bio;
	}
	
	public List<Tweet> getTweets() {
		return tweets;
	}

	public void follow(User user) {
		followers.add(user);
		user.followings.add(this);
		
	}
	
	public void unfollow(User user) {
		followers.remove(user);
		user.followings.remove(this);
	}
	
	public List<User> getFollowers() {
		return followers;
	}
	
	public List<User> getFollowings() {
		return followings;
	}
	
	public int getFollowersSize() {
		return followers.size();
	}
	
	public int getFollowingsSize() {
		return followers.size();
	}

	public boolean isfollow(String string) {
		if(followers.contains(string)) {
			return true;
		}
		return false;
	}
	
	public void postTweet(String authorName) {
		Scanner scanner = new Scanner(System.in);
		int id = dataStore.generateTweetId();
//		System.out.print("Enter tweet id: ");
//		int id = scanner.nextInt();
		System.out.print("Enter your tweet content: ");
		String tweetContent = scanner.nextLine();
		String author = authorName;
		LocalDateTime timeStamp = LocalDateTime.now();
		Tweet tweet = new Tweet(id, tweetContent, author, timeStamp);
		tweets.add(tweet);
	}

	public void deleteTweet(String tweetContent) {
				tweets.remove(tweetContent);
	}	
	
}
