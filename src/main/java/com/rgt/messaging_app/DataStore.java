package com.rgt.messaging_app;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class DataStore {
	private Map<String, User> users;

	public DataStore() {
		this.users = new HashMap<String, User>();
	}

	public void saveData(String userName, User newUser) {
		users.put(userName, newUser);
	}

	public Map<String, User> loadData() {
		return users;
	}

	public int generateTweetId() {
		Random random = new Random();
		int tweetId = random.nextInt(1000);
		return tweetId;
	}
}
