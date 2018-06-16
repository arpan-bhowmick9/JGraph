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

// Assumption : If The Maximum Number Of Vertices Be N. Then The Graph Will Have Vertex Values From 0 To N-1
```

* Adjacency Matrix

	* *create_edge(int source_vertex, int destination_vertex, boolean weighted, int weight)* : Creates an edge and returns a two dimensional array (Adjacency Matrix) of 	dimension N x N. (N is the maximum number of vertices of the graph.) If the graph is weighted then weighted=true and weight>0 else weight=flase and weight=0.

	* *get_edge(int source_vertex, int destination_vertex)* : Returns an integer value representing the value of the edge between the source_vertex and destination_vertex.

```
AdjacencyMatrix object=new AdjacencyMatrix(maximum_number_of_vertices); // Creating the object

adjacency_matrix=object.create_edge(source_vertex, destination_vertex, weighted, weight); // Creating edge
int edge=object.get_edge(source_vertex, destination_vertex); // Getting the value of the edge
```

## Author 

Arpan Bhowmik (@arpan-bhowmick9)