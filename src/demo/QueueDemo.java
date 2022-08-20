package demo;

import java.util.Scanner;

public class QueueDemo {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		MyQueue q = new MyQueue();
		int num;
		while (true) {
			System.out.println("0 For exit\n1 For insert");
			System.out.println("2 For Delete\n3 For Print");
			System.out.println("Enter choice");
			int choice = scr.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Enter num");
				num = scr.nextInt();
				q.add(num);
				break;
			case 2:
				q.remove();
				break;
			case 3:
				q.display();
				break;
			case 0:
				System.exit(0);
			}
		}
	}
}
  //  0		1	2	3	4 
 //   10	20 30   40 50 
 //                     
//-1 
//simple queue
//circular queue 

class MyQueue {
	final int SIZE = 5;
	int q[] = new int[SIZE];
	int f = -1;
	int r = -1;

	void add(int num) {
		if (r == SIZE - 1) {
			System.out.println("Queue is Full");
		} else {
			r++;
			q[r] = num;
			if (f == -1)
				f++;
		}
	}

	//
	// f=-1,r=-1
	void remove() {
		if (f == -1)
			System.out.println("Q is Empty...");
		else {
			int num = q[f];
			System.out.println(num + " deleted....");
			if (f == r) {
				f = -1;
				r = -1;
			} else {
				f++;
			}

		}
	}

	void display() {
		for (int i = f; i <= r; i++) {
			System.out.print(q[i] + "  ");
		}
		System.out.println("");
	}
}
