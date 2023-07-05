package com.rgt.online_bidding_system;

public class Item {
	private String name;
	private String description;
	private double currentHighestBid;
	private User highestBidder;

	public Item(String name, String description, double currentHighestBid) {
		this.name = name;
		this.description = description;
		this.currentHighestBid = currentHighestBid;
	}

	public void placeBid(User user, double bidAmount) {
		if (bidAmount > currentHighestBid) {
			currentHighestBid = bidAmount;
			highestBidder = user;
		}
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public double getCurrentHighestBid() {
		return currentHighestBid;
	}

	public User getHighestBidder() {
		return highestBidder;
	}
	
}
