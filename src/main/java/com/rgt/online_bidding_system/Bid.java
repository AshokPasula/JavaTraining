package com.rgt.online_bidding_system;

/**
 * 
 * @author ashok This a Bid class In this I created a objects for Item class and
 *         User class Created variable for Amount and winning bid and created
 *         getter methods for variables and Objects
 */
public class Bid {
	private Item item;
	private User bidder;
	private double amount;
	private boolean isWinningBid;

	// constructor for Bid with parameters
	public Bid(Item item, User bidder, double amount, boolean isWinningBid) {
		this.item = item;
		this.bidder = bidder;
		this.amount = amount;
		this.isWinningBid = isWinningBid;
	}

	// getter method for Item class object
	public Item getItem() {
		return item;
	}

	// getter method for User class object
	public User getBidder() {
		return bidder;
	}

	// getter method for Amount variable
	public double getAmount() {
		return amount;
	}

	// getter method for winning bid variable
	public boolean isWinningBid() {
		return isWinningBid;
	}

}
