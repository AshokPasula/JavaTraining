package com.rgt.online_bidding_system;

public class ItemFactory {
	 public static Item createItem(String name, String description, double startingBid) {
	        return new Item(name, description, startingBid);
	    }
}
