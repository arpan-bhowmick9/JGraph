# JGRAPH

JAVA package for Graph Algorithms.

## Algorithms Included

* Adjacency Matrix
* Breadth First Search
* Depth First Search
* Bellman-Ford Algorithm
* Dijkstra's Algorithm
* Ford-Fulkerson Algorithm
* Kruskal's Algorithm
* Prim's Algorithm
* Kahn's Algorithm

## Prerequisites

JAVA 8 (JDK and JRE) must be installed.

## Documentation

First download the JGraph directory and place it inside your project directory.

To import the JGraph package or a particular class from JGraph :

```
import JGraph.*; // Import all the classes
import JGraph.BreadthFirstSearch; // Import a particular class

// Assumption : If The Total Number Of Vertices Be N. Then The Graph Will Have Vertex Values From 0 To N-1
```

* Adjacency Matrix

	* *create_edge(int source_vertex, int destination_vertex, boolean weighted, int weight)* : Creates an edge and returns a two dimensional array (Adjacency Matrix) of 	dimension N x N. (N is the maximum number of vertices of the graph.) If the graph is weighted then weighted=true and weight>0 else weighted=flase and weight=0.

	* *get_edge(int source_vertex, int destination_vertex)* : Returns an integer value representing the value of the edge between the source_vertex and destination_vertex.

```
AdjacencyMatrix object=new AdjacencyMatrix(total_number_of_vertices); // Creating the object

adjacency_matrix=object.create_edge(source_vertex, destination_vertex, weighted, weight); // Creating edge
int edge=object.get_edge(source_vertex, destination_vertex); // Getting the value of the edge
```

* Breadth First Search

	* *BFS(int source_vertex)* : Computes and returns a queue which contains the Breadth First Search traversal 		of the graph from source_vertex.

```
BreadthFirstSearch object=new BreadthFirstSearch(total_number_of_vertices, adjacency_matrix); // Creating the object

Queue<Integer> q=new LinkedList<Integer>();
q=object.BFS(source_vertex); // Computing the Breadth First Search traversal of the graph from source_vertex
```

* Depth First Search

	* *DFS(int source_vertex)* : Computes and returns a queue which contains the Depth First Search traversal 		of the graph from source_vertex.

```
DepthFirstSearch object=new DepthFirstSearch(total_number_of_vertices, adjacency_matrix); // Creating the object

Queue<Integer> q=new LinkedList<Integer>();
q=object.DFS(source_vertex); // Computing the Breadth First Search traversal of the graph from source_vertex
```

* Bellman-Ford

	* *BellmanFord(int source_vertex)* : Computes and returns a one dimensional array which contains the shortest 	distances from the source_vertex to every other vertex of the graph. The indices of the array represents the 	vertices of the graph.

```
Bellman_Ford object=new Bellman_Ford(total_number_of_vertices, adjacency_matrix); // Creating the object

int[] shortest_distances=new int[N]; // N : Total number of vertices in the graph
shortest_distances=object.BellmanFord(source_vertex); // Computing the shortest distances from the source_vertex to every other vertex of the graph.
```

* Dijkstra

	* *dijkstra(int source_vertex)* : Computes and returns a one dimensional array which contains the shortest 	distances from the source_vertex to every other vertex of the graph. The indices of the array represents the 	vertices of the graph.

```
Dijkstra object=new Dijkstra(total_number_of_vertices, adjacency_matrix); // Creating the object

int[] shortest_distances=new int[N]; // N : Total number of vertices in the graph
shortest_distances=object.dijkstra(source_vertex); // Computing the shortest distances from the source_vertex to every other vertex of the graph.
```

## Author 

Arpan Bhowmik (@arpan-bhowmick9)