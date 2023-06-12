package timeAndSpaceComplexities;

import java.util.*;

public class CollectionComparison {

	private static long getMemoryUsage() {
		Runtime runtime = Runtime.getRuntime();
		return runtime.totalMemory() - runtime.freeMemory();
	}

	public static void main(String[] args) {
		List<Integer> arraylist = new ArrayList<>();
		List<Integer> linkedList = new LinkedList<>();

		Set<Integer> hashSet = new HashSet<>();
		Set<Integer> treeSet = new TreeSet<>();

		Map<Integer, String> hashMap = new HashMap<>();
		Map<Integer, String> treeMap = new TreeMap<>();

		long startTime, endTime;
		long memoryBefore, memoryAfter;

		// ArrayList and LinkedList
		startTime = System.nanoTime();
		memoryBefore = getMemoryUsage();
		// ArrayList
		for (int i = 0; i < 100000; i++) {
			arraylist.add(i);
		}

		endTime = System.nanoTime();
		memoryAfter = getMemoryUsage();

		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("ArrayList insertion time : " + (endTime - startTime) + " ns");
		System.out.println("ArrayList Memory usage: " + (memoryAfter - memoryBefore) + " bytes");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println();
		System.out.println();
		startTime = System.nanoTime();
		memoryBefore = getMemoryUsage();
		// LinkedList
		for (int i = 0; i < 100000; i++) {
			linkedList.add(i);
		}

		endTime = System.nanoTime();
		memoryAfter = getMemoryUsage();

		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("LinkedList insertion time: " + (endTime - startTime) + " ns");
		System.out.println("LinkedList Memory usage: " + (memoryAfter - memoryBefore) + " bytes");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println();
		System.out.println();
		
		// HashSet and TreeSet
//		HashSet
		startTime = System.nanoTime();
		memoryBefore = getMemoryUsage();
		for (int i = 0; i < 100000; i++) {
			hashSet.add(i);
		}
		endTime = System.nanoTime();
		memoryAfter = getMemoryUsage();

		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("HashSet insertion time: " + (endTime - startTime) + " ns");
		System.out.println("HashSet Memory usage: " + (memoryAfter - memoryBefore) + " bytes");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println();
		System.out.println();
		
//		TreeSet
		startTime = System.nanoTime();
		memoryBefore = getMemoryUsage();
		for (int i = 0; i < 100000; i++) {
			treeSet.add(i);
		}
		endTime = System.nanoTime();
		memoryAfter = getMemoryUsage();

		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("TreeSet insertion time : " + (endTime - startTime) + " ns");
		System.out.println("TreeSet Memory usage: " + (memoryAfter - memoryBefore) + " bytes");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println();
		System.out.println();

		// HashMap and TreeMap
		//HashMap
		startTime = System.nanoTime();
		memoryBefore = getMemoryUsage();
		for (int i = 0; i < 100000; i++) {
			hashMap.put(i, "value " + i);
		}
		endTime = System.nanoTime();
		memoryAfter = getMemoryUsage();

		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Hashmap insertion time: " + (endTime - startTime) + " ns");
		System.out.println("Hashmap Memory usage: " + (memoryAfter - memoryBefore) + " bytes");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println();
		System.out.println();

		//TreeMap
		startTime = System.nanoTime();
		memoryBefore = getMemoryUsage();

		for (int i = 0; i < 100000; i++) {
			treeMap.put(i, "value " + i);
		}

		endTime = System.nanoTime();
		memoryAfter = getMemoryUsage();

		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("TreeMap insertion time: " + (endTime - startTime) + " ns");
		System.out.println("TreeMap Memory usage: " + (memoryAfter - memoryBefore) + " bytes");
		System.out.println("--------------------------------------------------------------------------------");

	}

}
