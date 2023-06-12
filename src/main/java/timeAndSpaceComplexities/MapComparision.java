package timeAndSpaceComplexities;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapComparision {

	public static void main(String[] args) {

		Map<Integer, String> hashmap = new HashMap<>();
		Map<Integer, String> treemap = new TreeMap<>();

		long startTime, endTime;
		// add elements to HashMap and TreeMap
		startTime = System.nanoTime();
		hashmap.put(0, "development");
		endTime = System.nanoTime();
		System.out.println("The hashmap values are: " + hashmap);
		System.out.println("HashMap insertion time is " + (endTime - startTime) + " ns");

		startTime = System.nanoTime();
		treemap.put(0, "development");
		endTime = System.nanoTime();
		System.out.println("The treemap values are: " + treemap);
		System.out.println("TreeMap insertion time is " + (endTime - startTime) + " ns");
		System.out.println("------------------------------------------------------------------------");
		System.out.println();
		
		// Get elements from HashMap and TreeMap
		startTime = System.nanoTime();
		hashmap.get(0);
		endTime = System.nanoTime();
		System.out.println("The hashmap value at index '0' is: " + hashmap.get(0));
		System.out.println("HashMap retrive time is " + (endTime - startTime) + " ns");

		startTime = System.nanoTime();
		treemap.get(0);
		endTime = System.nanoTime();
		System.out.println("The treemap value at index '0' is: " + treemap.get(0));
		System.out.println("TreeMap retrive time is " + (endTime - startTime) + " ns");
		System.out.println("------------------------------------------------------------------------");
		System.out.println();
		
		// Delete elements from HashMap and TreeMap
		startTime = System.nanoTime();
		hashmap.remove(0);
		endTime = System.nanoTime();
		System.out.println("The hashmap values are: " + hashmap);
		System.out.println("HashMap deletion time is " + (endTime - startTime) + " ns");

		startTime = System.nanoTime();
		treemap.remove(0);
		endTime = System.nanoTime();
		System.out.println("The treemap values are: " + treemap);
		System.out.println("TreeMap deletion time is " + (endTime - startTime) + " ns");
		System.out.println("------------------------------------------------------------------------");
		System.out.println();
	}
	
}
