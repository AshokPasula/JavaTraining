package com.rgt.online_bidding_system;
/**
 * 
 * @author Ashok
 *
 */
public interface BiddingStrategy {
	public double bid(Item item, User user);
}
