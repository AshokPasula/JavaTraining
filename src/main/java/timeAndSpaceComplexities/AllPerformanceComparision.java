package timeAndSpaceComplexities;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllPerformanceComparision {
	
	private static final int NUMBER_OF_ELEMENTS=100000;
	private static final int NUMBER_OF_OPERATION=1500;
	
	public static void main(String[] args) {
		compareAddition(NUMBER_OF_ELEMENTS);
		compareGet(NUMBER_OF_ELEMENTS, NUMBER_OF_OPERATION);
		compareInsertion(NUMBER_OF_ELEMENTS, NUMBER_OF_OPERATION);
		compareDeletion(NUMBER_OF_ELEMENTS, NUMBER_OF_OPERATION);
	}

	public static void compareAddition(int numberOfElements) {

		List<Integer> arraylist = new ArrayList<>();
		List<Integer> linkedlist = new LinkedList<>();

		long startTime = System.currentTimeMillis();
		for (int i = 0; i < numberOfElements; i++) {
			arraylist.add(i);
		}
		long arrayListTime = System.currentTimeMillis() - startTime;

		startTime = System.currentTimeMillis();
		for (int i = 0; i < numberOfElements; i++) {
			linkedlist.add(i);
		}
		long linkedListTime = System.currentTimeMillis() - startTime;
		System.out.printf("Adding: Arraylist= %d ms, Linkedlist= %d ms\n", arrayListTime, linkedListTime);

	}

	public static void compareGet(int numberOfElements, int numberOfOperations) {
		List<Integer> arraylist = new ArrayList<>(numberOfElements);
		List<Integer> linkedlist = new LinkedList<>();

		for (int i = 0; i < numberOfElements; i++) {
			arraylist.add(i);
			linkedlist.add(i);
		}

		long startTime = System.currentTimeMillis();
		for (int i = 0; i < numberOfOperations; i++) {
			int index = (int) (Math.random() * numberOfOperations);
			arraylist.get(index);
		}
		long arrayListTime = System.currentTimeMillis() - startTime;

		startTime = System.currentTimeMillis();
		for (int i = 0; i < numberOfOperations; i++) {
			int index = (int) (Math.random() * numberOfOperations);
			linkedlist.get(index);
		}
		long linkedListTime = System.currentTimeMillis()- startTime;
		System.out.printf("Get: Arraylist= %d ms, Linkedlist= %d ms\n", arrayListTime, linkedListTime);
	}

	public static void compareInsertion(int numberOfElements, int numberOfOperations) {

		List<Integer> arraylist = new ArrayList<>(numberOfElements);
		List<Integer> linkedlist = new LinkedList<>();

		for (int i = 0; i < 100000; i++) {
			arraylist.add(i);
			linkedlist.add(i);
		}

		long startTime = System.currentTimeMillis();
		for (int i = 0; i < numberOfOperations; i++) {
			int index = (int) (Math.random() * numberOfElements);
			arraylist.add(index, i);
		}
		long arrayListTime = System.currentTimeMillis() - startTime;

		startTime = System.currentTimeMillis();
		for (int i = 0; i < numberOfOperations; i++) {
			int index = (int)  (Math.random() * numberOfElements);
			linkedlist.add( index, i);
		}
		long linkedListTime = System.currentTimeMillis() - startTime;
		System.out.printf("Insertion: Arraylist= %d ms, Linkedlist= %d ms\n", arrayListTime, linkedListTime);
	}

	public static void compareDeletion(int numberOfElements, int numberOfOperations) {

		List<Integer> arraylist = new ArrayList<>(numberOfElements);
		List<Integer> linkedlist = new LinkedList<>();

		for (int i = 0; i < numberOfElements; i++) {
			arraylist.add(i);
			linkedlist.add(i);
		}

		long startTime = System.currentTimeMillis();
		for (int i = 0; i < numberOfOperations; i++) {
			int index = (int) (Math.random() * (numberOfElements));
			arraylist.remove(index);
		}
		long arrayListTime = System.currentTimeMillis() - startTime;

		startTime = System.currentTimeMillis();
		for (int i = 0; i < numberOfOperations; i++) {
			int index = (int) (Math.random() * (numberOfElements));
			linkedlist.remove(index);
		}
		long linkedListTime = System.currentTimeMillis() - startTime;
		System.out.printf("Deletion: Arraylist= %d ms, Linkedlist= %d ms\n", arrayListTime, linkedListTime);
	}
}
