package JGraph;

// Class To Compute The BreadthFirstSearch Traversal Of A Graph
// If The Total Number Of Vertices Be N. Then The Graph Will Have Vertex Values From 0 To N-1

// Importing required packages
import java.io.*;
import java.util.*;

public class BreadthFirstSearch{
    
    public int[][] adj_matrix; // Adjacency Matrix
    public int N; // Total number of vertices
    Queue<Integer> queue;
    Queue<Integer> bfs; // Will store the BreadthFirstSearch traversal
    
    public BreadthFirstSearch(int n, int[][] a){ // Constructor  n : Total number of vertices  a : Adjacency Matrix
        N=n;
        adj_matrix=new int[N][N];
        adj_matrix=a;
        queue=new LinkedList<Integer>();
        bfs=new LinkedList<Integer>();
    }
    
    public Queue<Integer> BFS(int s){ // To compute the BreadthFirstSearch traversal of the graph  s : Source Vertex
        boolean[] visited=new boolean[N];
        int i=0,element=0;
        
        visited[s]=true; // Marking the vertex as visited
        queue.add(s);
        
        while(!queue.isEmpty()){ // While the queue is not empty
            element=queue.remove();
            i=element;
            bfs.add(element);
            
            while(i<N){
                if((adj_matrix[element][i]>0)&&(visited[i]==false)){
                    queue.add(i);
                    visited[i]=true; // Marking the vertex as visited
                }
                i++;
            }
        }
        return bfs; // Returning the queue
    }
}
        