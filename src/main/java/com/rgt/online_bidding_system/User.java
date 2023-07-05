package com.rgt.online_bidding_system;

import java.util.*;

/**
 * 
 * @author Ashok user class
 *
 */
public class User {
	private String username;
	private String password;
	private List<Bid> biddingHistory;

	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.biddingHistory = new ArrayList<>();
	}

// Stroeing all bid history
	public void addBid(Bid bid) {
		biddingHistory.add(bid);
	}

	// getter method for username
	public String getUsername() {
		return username;
	}

// getter method for password
	public String getPassword() {
		return password;
	}

// retruning the bid history
	public List<Bid> getBiddingHistory() {
		return biddingHistory;
	}

// declare method for bid winner
	public void winningBid(Bid bid) {
		if (bid.isWinningBid()) {
			System.out.println("You won bid for this item: " + bid.getItem());
			System.out.println("user name: " + bid.getBidder());
			System.out.println("Final bid amount: " + bid.getAmount());

		}
	}
}
