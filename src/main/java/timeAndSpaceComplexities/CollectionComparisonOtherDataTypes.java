package timeAndSpaceComplexities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class CollectionComparisonOtherDataTypes {
	private static Long getMemoryUsage() {
		Runtime runtime = Runtime.getRuntime();
		return runtime.totalMemory() - runtime.freeMemory();
	}

	public static void main(String[] args) {
		List<Double> arraylist = new ArrayList<>();
		List<Double> linkedlist = new LinkedList<>();

		Set<String> hashset = new HashSet<>();
		Set<String> treeset = new TreeSet<>();

		Map<Integer, Integer> hashmap = new HashMap<>();
		Map<Integer, Integer> treemap = new TreeMap<>();

		long startTime, endTime;
		long memoryBefore, memoryAfter;

		// ArrayList and LinkedList
		startTime = System.nanoTime();
		memoryBefore = getMemoryUsage();

		for (int i = 0; i < 100000; i++) {
			arraylist.add(i+.00);
		}

		endTime = System.nanoTime();
		memoryAfter = getMemoryUsage();

		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("ArrayList insertion time of double: " + (endTime - startTime) + " ns");
		System.out.println("ArrayList Memory usage of double: " + (memoryAfter - memoryBefore) + " bytes");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println();
		System.out.println();

		startTime = System.nanoTime();
		memoryBefore = getMemoryUsage();

		for (int i = 0; i < 100000; i++) {
			linkedlist.add(i+.00);
		}

		endTime = System.nanoTime();
		memoryAfter = getMemoryUsage();

		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("LinkedList insertion time of double: " + (endTime - startTime) + " ns");
		System.out.println("LinkedList Memory usage of double: " + (memoryAfter - memoryBefore) + " bytes");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println();
		System.out.println();

		// HashSet and TreeSet
		startTime = System.nanoTime();
		memoryBefore = getMemoryUsage();

		for (int i = 0; i < 100000; i++) {
			hashset.add("value " + i);
		}

		endTime = System.nanoTime();
		memoryAfter = getMemoryUsage();

		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("HashSet insertion time of string: " + (endTime - startTime) + " ns");
		System.out.println("HashSet Memory usage of string: " + (memoryAfter - memoryBefore) + " bytes");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println();
		System.out.println();

		startTime = System.nanoTime();
		memoryBefore = getMemoryUsage();

		for (int i = 0; i < 100000; i++) {
			treeset.add("value " + i);
		}

		endTime = System.nanoTime();
		memoryAfter = getMemoryUsage();

		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("TreeSet insertion time of string: " + (endTime - startTime) + " ns");
		System.out.println("TreeSet Memory usage of string: " + (memoryAfter - memoryBefore) + " bytes");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println();
		System.out.println();

		// HashMap and TreeMap
		startTime = System.nanoTime();
		memoryBefore = getMemoryUsage();
		int value=10000;
		for (int i = 0; i < 100000; i++) {
			hashmap.put(i, value-- );
		}

		endTime = System.nanoTime();
		memoryAfter = getMemoryUsage();

		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Hashmap insertion time of int & int: " + (endTime - startTime) + " ns");
		System.out.println("Hashmap Memory usage of int & int: " + (memoryAfter - memoryBefore) + " bytes");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println();
		System.out.println();

		startTime = System.nanoTime();
		memoryBefore = getMemoryUsage();
		
		for (int i = 0; i < 100000; i++) {
			treemap.put(i, value-- );
		}

		endTime = System.nanoTime();
		memoryAfter = getMemoryUsage();

		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("TreeMap insertion time of int & int: " + (endTime - startTime) + " ns");
		System.out.println("TreeMap Memory usage of int & int: " + (memoryAfter - memoryBefore) + " bytes");
		System.out.println("--------------------------------------------------------------------------------");
		
	}
}
