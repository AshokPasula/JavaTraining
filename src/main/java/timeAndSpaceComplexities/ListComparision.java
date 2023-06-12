package timeAndSpaceComplexities;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListComparision {

	public static void main(String[] args) {

		List<Double> arraylist = new ArrayList<>();
		List<Double> linkedlist = new LinkedList<>();
		int index = 0;

		long startTime, endTime;
		// add elements to ArrayList and LinkedList
		startTime = System.nanoTime();
		arraylist.add(10000.00);
		endTime = System.nanoTime();
		System.out.println("The ArrayList values are: " + arraylist);
		System.out.println("ArrayList insertion time is " + (endTime - startTime) + " ns");

		startTime = System.nanoTime();
		linkedlist.add(10000.00);
		endTime = System.nanoTime();
		System.out.println("The LinkedList values are: " + linkedlist);
		System.out.println("LinkedList insertion time is " + (endTime - startTime) + " ns");
		System.out.println("--------------------------------------------------------------------------------------------------");
		System.out.println();

		// Get elements from ArrayList and LinkedList
		startTime = System.nanoTime();
		arraylist.get(index);
		endTime = System.nanoTime();
		System.out.println("The ArrayList value at "+index+ ": " + arraylist.get(index));
		System.out.println("ArrayList retrive time is " + (endTime - startTime) + " ns");

		startTime = System.nanoTime();
		linkedlist.get(index);
		endTime = System.nanoTime();
		System.out.println("The LinkedList value at "+index+ ": " + linkedlist.get(index));
		System.out.println("LinkedList retrive time is " + (endTime - startTime) + " ns");
		System.out.println("--------------------------------------------------------------------------------------------------");
		System.out.println();
		
		// Insert elements to ArrayList and LinkedList with index number
		startTime = System.nanoTime();
		arraylist.add(index,  10001.00);
		endTime = System.nanoTime();
		System.out.println("The ArrayList values are: " + arraylist);
		System.out.println("ArrayList insertion time with index " + (endTime - startTime) + " ns");

		startTime = System.nanoTime();
		linkedlist.add(index,10001.01);
		endTime = System.nanoTime();
		System.out.println("The LinkedList values are: " + linkedlist);
		System.out.println("LinkedList insertion time with index " + (endTime - startTime) + " ns");
		System.out.println("--------------------------------------------------------------------------------------------------");
		System.out.println();
		
		// Delete elements from ArrayList and LinkedList
		startTime = System.nanoTime();
		arraylist.remove(index);
		endTime = System.nanoTime();
		System.out.println("The ArrayList values are: " + arraylist);
		System.out.println("ArrayList deletion time is " + (endTime - startTime) + " ns");

		startTime = System.nanoTime();
		linkedlist.remove(index);
		endTime = System.nanoTime();
		System.out.println("The LinkedList values are: " + linkedlist);
		System.out.println("LinkedList deletion time is " + (endTime - startTime) + " ns");
	}

}
