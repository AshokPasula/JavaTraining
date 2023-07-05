package com.rgt.online_bidding_system;

import java.util.*;
/**
 * 
 * @author Ashok
 *
 */
public class ItemManagementService {
	private Auction auction;

    public ItemManagementService() {
        this.auction = Auction.getInstance();
    }

    public void addItem(String name, String description, double startingBid) {
        Item item = ItemFactory.createItem(name, description, startingBid);
        auction.addItem(item);
    }

    public List<Item> searchItems(String keyword) {
        List<Item> searchResults = new ArrayList<>();
        for (Item item : auction.getItems()) {
            if (item.getName().toLowerCase().contains(keyword.toLowerCase())) {
                searchResults.add(item);
            }
        }
        return searchResults;
    }
}
