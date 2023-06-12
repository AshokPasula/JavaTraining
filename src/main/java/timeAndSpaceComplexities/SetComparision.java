package timeAndSpaceComplexities;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetComparision {

	public static void main(String[] args) {
		Set<String> hashset = new HashSet<>();
		Set<String> treeset = new TreeSet<>();

		
		long startTime, endTime;
		// add elements to HashSet and TreeSet
		startTime = System.nanoTime();
		hashset.add("java");
		endTime = System.nanoTime();
		System.out.println("The hashset values are: " + hashset);
		System.out.println("HashSet insertion time is " + (endTime - startTime) + " ns");

		startTime = System.nanoTime();
		treeset.add("java");
		endTime = System.nanoTime();
		System.out.println("The treeset values are: " + hashset);
		System.out.println("TreeSet insertion time AddTime is " + (endTime - startTime) + " ns");
		System.out.println("---------------------------------------------------------------------------------------");

		// Get elements from HashSet and TreeSet
		startTime = System.nanoTime();
		endTime = System.nanoTime();
		System.out.println("The hashset values are: " + hashset);
		System.out.println("HashSet retrive time is " + (endTime - startTime) + " ns");

		startTime = System.nanoTime();
		endTime = System.nanoTime();
		System.out.println("The treeset values are: " + hashset);
		System.out.println("TreeSet retrive time is " + (endTime - startTime) + " ns");
		System.out.println("---------------------------------------------------------------------------------------");

		// Delete elements from HashSet and TreeSet
		startTime = System.nanoTime();
		hashset.remove("java");
		endTime = System.nanoTime();
		System.out.println("The hashset values are: " + hashset);
		System.out.println("HashSet deletion time is " + (endTime - startTime) + " ns");

		startTime = System.nanoTime();
		treeset.remove("java");
		endTime = System.nanoTime();
		System.out.println("The treeset values are: " + hashset);
		System.out.println("TreeSet deletion time is " + (endTime - startTime) + " ns");
		System.out.println("---------------------------------------------------------------------------------------");

	}
}
