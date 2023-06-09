package com.rgt.online_bidding_system;
/**
 * 
 * @author Ashok
 *
 */
public class IncrementalBiddingStrategy implements BiddingStrategy {

	@Override
	public double bid(Item item, User user) {
		double currentBid = item.getCurrentHighestBid();
		double newBid = currentBid + 1.0;
		item.placeBid(user, newBid);
		return newBid;
	}

}
