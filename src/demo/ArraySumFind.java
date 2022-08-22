package demo;

import java.util.HashMap;

public class ArraySumFind {

	public static void main(String[] args) {

		int a[] = { 7, 2, 13, 4, 5, 23 };//4
		findIndex(a, 20);
	}

	// O(1)

	static void findIndex(int a[], int target) {
		int count = 0;
		boolean isFound = false;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < a.length; i++) {
			map.put(a[i], i);
		}

		for (int i = 0; i < a.length; i++) {
			count++;
			int diff = target - a[i]; // 9 - 1 -> 8
			if (diff > 0) {
				if (map.get(diff) != null) {
					System.out.println(a[i] + " ==  " + diff);
					System.out.println(i + " ===  " + map.get(diff));
					isFound = true;
					break;
				}
			}
		}
		System.out.println("counter => " + count);
		if (!isFound) {
			System.out.println("No Possible pair found...");
		}
	}
}
//  map 
//	7  :  0
//	2  :  1
//	13 :  2
//  4  :  3
//key - unique 
//value - duplicate 
