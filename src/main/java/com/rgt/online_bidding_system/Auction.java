package com.rgt.online_bidding_system;

import java.util.*;

/**
 * 
 * @author Ashok Aution class for storing the items for Bidding
 *
 */
public class Auction {
	private static Auction instance = null;
	private List<Item> items;

//    constructor of Aution class and created arraylist
	private Auction() {
		items = new ArrayList<>();
	}

//    creating instance for Aution class
	public static Auction getInstance() {
		if (instance == null) {
			instance = new Auction();
		}
		return instance;
	}

//Adding the items in item list
	public void addItem(Item item) {
		items.add(item);
	}

//	returning item list
	public List<Item> getItems() {
		return items;
	}
}
