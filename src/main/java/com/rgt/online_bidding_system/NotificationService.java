package com.rgt.online_bidding_system;
/**
 * 
 * @author Ashok
 *
 */
public class NotificationService {
	public void notifyUser(User user, Item item) {
        System.out.println("You have been outbid on " + item.getName() + ". Current highest bid: " + item.getCurrentHighestBid());
    }
}
