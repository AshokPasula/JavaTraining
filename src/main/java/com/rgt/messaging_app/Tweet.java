package com.rgt.messaging_app;

import java.time.LocalDateTime;
import java.util.*;

public class Tweet {

	private int id;
	private String content;
	private String author;
	private LocalDateTime timestamp;
	private List<User> likes= new ArrayList<>();
	final HashMap<String,User> replies= new HashMap<>();
	final HashMap<String,User> retweets= new HashMap<>();
	
	
	public Tweet(int id, String content, String author, LocalDateTime timestamp) {
		this.id=id;
		this.content=content;
		this.author=author;
		this.timestamp=timestamp;
	}

	public Tweet() {
		
	}

	public int getId() {
		return id;
	}
	
	public String getContent() {
		return content;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void likes(User user) {
		likes.add(user);

	} 
	public void retweet(String retweet, User user) {
		retweets.put(retweet, user);
		
	} 
	public void reply(String reply, User user) {
		replies.put(reply, user);
		
	} 
	
}
