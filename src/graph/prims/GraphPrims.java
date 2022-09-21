package graph.prims;

import java.util.HashSet;

public class GraphPrims {

	public static void main(String[] args) {
		Graph g = new Graph(5, 6);// 4 vertices and 4 edges

		g.edges[0].addEdge(0, 1, 3);
		g.edges[1].addEdge(1, 0, 3);

		g.edges[2].addEdge(1, 3, 3);
		g.edges[3].addEdge(3, 1, 3);

		g.edges[4].addEdge(3, 2, 1);
		g.edges[5].addEdge(2, 3, 1);

		g.edges[6].addEdge(2, 0, 2);
		g.edges[7].addEdge(0, 2, 2);

		g.edges[8].addEdge(2, 4, 2);
		g.edges[9].addEdge(4, 2, 2);

		g.edges[10].addEdge(3, 4, 1);
		g.edges[11].addEdge(4, 3, 1);

		g.printGraph();
		System.out.println("Edges ==> ");
		g.printEdges();
		
		System.out.println("*******PRIMS***********");
		g.prims();

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

	void printEdges() {
		for (int i = 0; i < this.E; i++) {
			System.out.println(this.edges[i].src + " " + this.edges[i].dest + " " + this.edges[i].weight);
		}
	}

	void prims() {
		int min = Integer.MAX_VALUE;
		int edgeIndex = 0;
		int count = 0; // V-1
		int vertex = 0; // initial vertex
		boolean visited[] = new boolean[V];// [t,t,t,t,t]
		visited[0] = true;

		while (count != V - 1) {

			// 0 2
			min = Integer.MAX_VALUE;

			for (int x = 0; x < visited.length; x++) {// 0 1 2 3 4

				if (visited[x] == true) {

					vertex = x;//0 2 

					for (int i = 0; i < edges.length; i++) {// 0 1
						if (edges[i].src == vertex) {
							if (visited[edges[i].dest] == false) {
								if (edges[i].weight < min) {
									min = edges[i].weight;// 2
									edgeIndex = i;
								}
							}
						}
					} // Edges search
				}//if

			} //for 
			System.out.println(edges[edgeIndex].src + "  " + edges[edgeIndex].dest + " :  " + edges[edgeIndex].weight);
			visited[edges[edgeIndex].dest] = true;
			count++;// 1 2 3 4 
			// min = 2
			// edgeIndex = 8
		} // loop

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
