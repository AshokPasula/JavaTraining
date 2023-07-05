package com.rgt.online_bidding_system;
/**
 * 
 * @author Ashok
 *
 */
public class UserObserver implements Observer {
	private User user;

	public UserObserver(User user) {
		this.user = user;
	}

	public UserObserver() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(Item item) {
		System.out.println("You have been outbid on item: " + item.getName());
	}

}
