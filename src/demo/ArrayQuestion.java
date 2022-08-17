package demo;

import java.util.Scanner;

public class ArrayQuestion {
	int a[] = new int[2];

	void printArray() {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	void add(int data, int location) {

		for (int i = a.length - 1; i >= location; i--) {
			a[i] = a[i - 1];
		}
		a[location - 1] = data;
		if (a[a.length - 1] != 0) {
			System.out.println("Array is Full");

			int b[] = new int[a.length + (a.length / 2)];// main + 50%
			for (int i = 0; i < a.length; i++) {
				b[i] = a[i];
			}
			a = b;
		}
	}

	void delete(int location) {
		for (int i = location - 1; i < a.length - 1; i++) {
			a[i] = a[i + 1];
		}
		a[a.length - 1] = 0;
	}

	public static void main(String[] args) {
		ArrayQuestion aq = new ArrayQuestion();
		Scanner scr = new Scanner(System.in);

		while (true) {
			System.out.println("0 for exit");
			System.out.println("1 for add");
			System.out.println("2 for display");
			System.out.println("3 for delete");
			System.out.println("Enter your choice");
			int choice = scr.nextInt();

			switch (choice) {
			case 0:
				System.exit(0);

			case 1:
				System.out.println("enter number ");
				int data = scr.nextInt();
				System.out.println("enter location");
				int location = scr.nextInt();
				aq.add(data, location);
				break;
			case 2:
				aq.printArray();
				break;
			case 3:
				System.out.println("enter location");
				location = scr.nextInt();
				aq.delete(location);

			}

		}

	}
}
