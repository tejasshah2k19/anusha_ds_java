package demo;

import java.util.Scanner;

public class LinkedListDemo {

	Node head = null;

	Node createNode(int num) {
		Node node = new Node();
		node.data = num;
		node.next = null;
		return node;
	}

	void addNode(int num) {

		if (head == null) { // first we need to check head
			head = createNode(num);// 100
		} else {
			Node tmp = createNode(num); // 300
			Node x = head;
			while (x.next != null) {
				x = x.next;
			}

			x.next = tmp;

		}

	}

	void display() {
		Node p = head;
		while (p != null) {
			System.out.print(p.data + "->");
			p = p.next;
		}
		System.out.println("");
	}

	public static void main(String[] args) {

		LinkedListDemo list = new LinkedListDemo();
		int num;
		Scanner scr = new Scanner(System.in);

		while (true) {

			System.out.println("0 for exit\n1 for add node\n2 for display\n3 for delete\nenter your choice!");
			int choice = scr.nextInt();

			switch (choice) {
			case 0:
				System.exit(0);
			case 1:
				System.out.println("Enter data");
				num = scr.nextInt();// 10 20 30 40
				list.addNode(num);
				break;
			case 2:
				list.display();
				break;
			}
		}
	}
}

class Node {
	int data;
	Node next;// address of next node [ object ]
	// c or c++ we can take pointer

}