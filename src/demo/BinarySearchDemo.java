package demo;

import java.util.Scanner;

public class BinarySearchDemo {
	boolean isFound = false;//primitive -- instance -- heap 

	public static void main(String[] args) {
		boolean isFound = false;//stack 
		// 0 1 2 3 4 5 6 7 8 9
		int a[] = { 1, 2, 4, 5, 67, 88, 120, 230, 450, 500 };// 10
		// start end
		// START
		Scanner scr = new Scanner(System.in);
		System.out.println("Enter number search?");
		int search = scr.nextInt(); // 500

		// start time
		int start = 0;
		int end = a.length - 1;
		// n/2 => O(log n) 
		while (start <= end) {
			System.out.println("searching....");
			int mid = (start + end) / 2;

			if (a[mid] == search) {
				isFound = true;
				break;
			} else if (a[mid] > search) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		if (isFound)
			System.out.println("number is present");
		else
			System.out.println("numer not present");
		// end time

	}
}
