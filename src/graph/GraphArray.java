package graph;

import java.util.LinkedList;
import java.util.Scanner;

class Q {

	int f = -1, r = -1;

	int a[] = new int[10];

	void add(int num) {
		r++;
		a[r] = num;
		if (f == -1)
			f++;
	}

	int delete() {
		int num = a[f];
		f++;
		return num;
	}
}

public class GraphArray {

	void bfs(int graph[][], int size) {
		LinkedList<Integer> q = new LinkedList<Integer>();

		q.add(1); // 3 4 5
		q.add(2);

		int i = q.poll();// first element remove
		q.add(3);
		q.add(4);
		i = q.poll(); // 2
		q.add(5);

		Q qq = new Q();

		qq.add(1);// 1 2
		qq.add(2);//

	}

	void dfs(int graph[][], int size) {
		int visited[] = new int[size];
		int count = 0;
		int i = 0;
		System.out.println(i + " -> ");
		visited[i] = 1;// 0->visited
		count++;// 1 node visit
		int cost = 0;
		while (count != size) {
			for (int j = 0; j < size; j++) {// 0 1 2
				if (graph[i][j] == 1 && visited[j] == 0) {
					System.out.println(j + " -> ");
					visited[j] = 1;
					i = j;// 3
					count++;// 4
					cost = cost + graph[i][j];
					break;
				}
			}
		}
//		System.out.println("Total cost => " + cost);

	}

	public static void main(String[] args) {
		int size = 4;
		int graph[][] = new int[size][size]; // 4 vertices
		Scanner scan = new Scanner(System.in);

		for (int row = 0; row < graph.length; row++) {
			for (int col = 0; col < graph[row].length; col++) {
				if (graph[row][col] == 0) {
					System.out.println("row: " + row + " col: " + col);
					graph[row][col] = scan.nextInt();
					graph[col][row] = graph[row][col];
				}
			}
		}

		for (int row = 0; row < graph.length; row++) {
			System.out.print(row + "is connected with => ");
			for (int col = 0; col < graph[row].length; col++) {
				if (graph[row][col] != -1)
					System.out.print(col + " ");
			}
			System.out.println("\n");
		}

		System.out.println("Travel :->");
		GraphArray g = new GraphArray();
		g.dfs(graph, size);
	}
}
