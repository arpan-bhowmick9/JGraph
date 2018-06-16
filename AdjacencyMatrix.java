package JGraph;

// Class To Create An Adjacency Matrix For A Graph
// If The Total Number Of Vertices Be N. Then The Graph Will Have Vertex Values From 0 To N-1

// Importing required packages
import java.io.*;
import java.util.*;

public class AdjacencyMatrix{
    
    public int N; // To store the total number of vertices
    public int[][] adj_matrix; // Adjacency Matrix
    public AdjacencyMatrix(int n){ // Constructor  n : Total number of vertices
        N=n;
        adj_matrix=new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++)
                adj_matrix[i][j]=0;
        }
    }
    
    public int[][] create_edge(int from, int to, boolean weighted, int weight){ // To create the edge
        // from : Source Vertex,  to : Destination Vertex,  weighted : Whether it is a weighted edge,  weight : If weighted is true then value of weight
        try{
            if(weighted==true) // If weighted edge
                adj_matrix[from][to]=weight;
            else
                adj_matrix[from][to]=1;
        }
        catch(ArrayIndexOutOfBoundsException index){ // If invalid index
            System.out.println(" Invalid Vertex!");
        }
        return adj_matrix;
    }
    
    public int get_edge(int from, int to){ // To get the value of the edge
        // from : Source Vertex,  to : Destination Vertex
        int temp=0;
        try{
            temp=adj_matrix[from][to];
        }
        catch(ArrayIndexOutOfBoundsException index){ // If invalid index
            System.out.println(" Invalid Vertex!");
        }
        return temp;
    }
    
    public void display(){ // To display the adjacency matrix
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++)
                System.out.print(adj_matrix[i][j]+" ");
            System.out.println();
        }
    }
}
