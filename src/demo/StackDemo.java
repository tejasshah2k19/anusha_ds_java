package demo;

import java.util.Scanner;

public class StackDemo {
	final int SIZE = 5;
	int stack[] = new int[SIZE];
	int top = -1;
	void push(int num) {
		if (top == SIZE - 1)
			System.out.println("STACK OverFLow");
		else {
			stack[++top] = num;
		}
	}
	void pop() {
		int num;
		if (top == -1)
			System.out.println("STACk UNDERFLOW");
		else {
			num = stack[top];
			System.out.println(num + " pop");
			top--;
		}
	}
	void display() {
		for (int i = top; i >= 0; i--) {
			System.out.println(stack[i]);
		}
	}
	void peep(int location) {
		int index = top - location + 1;
		System.out.println(stack[index]);
	}
	public static void main(String[] args) {
		StackDemo stack = new StackDemo();
		int choice, num;
		Scanner scr = new Scanner(System.in);

		while (true) {
			System.out.println("0 For Exit");
			System.out.println("1 For PUSH");
			System.out.println("2 For POP");
			System.out.println("3 For Display");
			System.out.println("4 For Peep");
			System.out.println("Enter your choice...");
			choice = scr.nextInt();

			switch (choice) {
			case 0:
				System.exit(0);
			case 1:
				System.out.println("Enter number");
				num = scr.nextInt();
				stack.push(num);
				break;
			case 2:
				stack.pop();
				break;
			case 3:
				stack.display();
				break;
			case 4:
				System.out.println("Enter location");
				num = scr.nextInt();
				stack.peep(num);
				break;
			default:
				System.out.println("invalid choice PTA");
				break;
			}
		}
	}
}
