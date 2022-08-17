package demo;

import java.util.Scanner;

public class ArrayDemo {

	public static void main(String[] args) {
		int x; //4 byte -> stack | heap | 
		
		int a[];
		a = new int[5];

		Scanner scr = new Scanner(System.in);

		// 5 - is present
		for (int i = 0; i < a.length; i++) {
			System.out.println("Enter number");
			a[i] = scr.nextInt();
		}

		boolean isFound = false; // not present;
		System.out.println("Enter number that you want to search");
		int search = scr.nextInt();
		for (int i = 0; i < a.length; i++) {
			if (a[i] == search) {
				isFound = true;
				break;
			}
		}

		if (isFound)
			System.out.println("Number is presnet");
		else
			System.out.println("Number not present");

	}
}
// time complexity 
// 2second 

// space complexity 
// 5 mb 

//