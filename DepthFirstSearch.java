package JGraph;

// Class To Compute The DepthFirstSearch Traversal Of A Graph
// If The Maximum Number Of Vertices Be N. Then The Graph Will Have Vertex Values From 0 To N-1

// Importing required packages
import java.io.*;
import java.util.*;

public class DepthFirstSearch{
    
    public int[][] adj_matrix; // Adjacency Matrix
    public int N; // Total number of vertices
    Stack<Integer> stack;
    Queue<Integer> dfs; // Will store the BreadthFirstSearch traversal
    
    public DepthFirstSearch(int n, int[][] a){ // Constructor  n : Total number of vertices  a : Adjacency Matrix
        N=n;
        adj_matrix=new int[N][N];
        adj_matrix=a;
        stack=new Stack<Integer>();
        dfs=new LinkedList<Integer>();
    }
    
    public Queue<Integer> DFS(int s){ // To compute the BreadthFirstSearch traversal of the graph  s : Source vertex
        boolean[] visited=new boolean[N];
        int i=0,element=0;
        
        element=s;
        i=s;
        dfs.add(element);
        visited[i]=true; // Marking the vertex as visited
        stack.push(s);
        
        while(!stack.isEmpty()){ // While the queue is not empty
            element=stack.peek();
            i=element;
            
            while(i<N){
                if((adj_matrix[element][i]>0)&&(visited[i]==false)){
                    stack.push(i);
                    visited[i]=true; // Marking the vertex as visited
                    element=i;
                    i=1;
                    dfs.add(element);
                    continue;
                }
                i++;
            }
            stack.pop();
        }
        return dfs; // Returning the queue
    }
}
        