package graph;

import java.util.HashSet;

public class GraphLL {

	public static void main(String[] args) {
		Graph g = new Graph(5, 6);// 4 vertices and 4 edges

		g.edges[0].addEdge(0, 1, 2);
		g.edges[1].addEdge(1, 0, 2);

		g.edges[2].addEdge(1, 3, 3);
		g.edges[3].addEdge(3, 1, 3);

		g.edges[4].addEdge(3, 2, 1);
		g.edges[5].addEdge(2, 3, 1);

		g.edges[6].addEdge(2, 0, 2);
		g.edges[7].addEdge(0, 2, 2);

		g.edges[8].addEdge(2, 4,1);
		g.edges[9].addEdge(4, 2, 1);

		
		g.edges[10].addEdge(3, 4, 1);
		g.edges[11].addEdge(4, 3, 1);

		
		g.printGraph();
		System.out.println("Edges ==> ");
		g.printEdges();
		g.sortEdges();
		System.out.println("Edges===> ");
		g.printEdges();

		g.kruskal();
	}
}

class Graph {
	int V, E;// V = total Vertices , E = total Edges
	Edge edges[]; // 0:{0,1,4} 1:{} 2:{} 3:{}

	public Graph(int v, int e) {
		this.V = v;
		this.E = e * 2;

		this.edges = new Edge[this.E]; // 8[] edges
		for (int i = 0; i < this.E; i++) {
			this.edges[i] = new Edge(); // memory allocate -> src dest weight
		}
	}

	void printGraph() {
		for (int i = 0; i < this.V; i++) {
			System.out.println("Vertex => " + i);
			for (int j = 0; j < this.E; j++) {
				if (this.edges[j].src == i) {
					System.out.print(this.edges[j].dest + " ");
				}
			}
			System.out.println("");
		}
	}

	void sortEdges() {
		Edge tmp;
		for (int i = 0; i < this.E; i++) {
			for (int j = 0; j < this.E - 1; j++) {
				if (edges[j].weight > edges[j + 1].weight) {
					tmp = edges[j];
					edges[j] = edges[j + 1];
					edges[j + 1] = tmp;
				}
			}
		}
	}

	void printEdges() {
		for (int i = 0; i < this.E; i++) {
			System.out.println(this.edges[i].src + " " + this.edges[i].dest + " " + this.edges[i].weight);
		}
	}

	void kruskal() {
		Edge tmp;
		System.out.println("********KRUSKAL************");
		int count = 0;
		int i = 0;
		int cost = 0;

		while (count != this.V - 1) {// 3
			if (this.edges[i].visited == false && intersection(this.edges[i].src, this.edges[i].dest) == false) {
				this.edges[i].visited = true; // 3 2 => true
				setVisited(this.edges[i].dest, this.edges[i].src, true);
				count++;// 1 2
				System.out.println(this.edges[i].src + "-" + this.edges[i].dest);// 3-0 ,
				cost = cost + this.edges[i].weight;
			}

			i++;// 0 1 2 3
		}
		System.out.println("cost => " + cost);
		System.out.println("************END**************");
	}

	void setVisited(int src, int dest, boolean status) {
		for (int i = 0; i < this.E; i++) {
			if (this.edges[i].src == src && this.edges[i].dest == dest) {
				this.edges[i].visited = status; // true
				break;
			}
		}
	}

	boolean intersection(int x, int y) {
		HashSet<Integer> xSet = new HashSet<Integer>();
		HashSet<Integer> ySet = new HashSet<Integer>();

		for (int i = 0; i < this.E; i++) {
			if (this.edges[i].visited == true && this.edges[i].src == x) {
				xSet.add(this.edges[i].dest);
			}
			if (this.edges[i].visited == true && this.edges[i].src == y) {
				ySet.add(this.edges[i].dest);
			}

		}
		xSet.retainAll(ySet);

		if (xSet.size() == 0) {
			return false;
		}
		return true;
	}
}

class Edge {
	int src, dest, weight; // 0 - 1 : 2
	boolean visited;

	void addEdge(int src, int dest, int weight) {
		this.src = src;
		this.dest = dest;
		this.weight = weight;
	}
}
