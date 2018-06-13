package JGraph;

// Class To Compute The Shortest Paths From A Souce Vertex To All Other Vertices Using The Bellman-Ford Algorithm 
// If The Maximum Number Of Vertices Be N. Then The Graph Will Have Vertex Values From 0 To N-1

// Importing required packages
import java.io.*;
import java.util.*;

public class Bellman_Ford{
    
    public int[][] adj_matrix; // Adjacency Matrix
    public int N; // Total number of vertices
    public int[] distances; // Will store the distances
    public final int max=Integer.MAX_VALUE;
    
    public Bellman_Ford(int n, int[][] a){ // Constructor  n : Total number of vertices  a : Adjacency Matrix
        N=n;
        adj_matrix=new int[N][N];
        adj_matrix=a;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(i==j){
                    adj_matrix[i][j]=0;
                    continue;
                }
                if(adj_matrix[i][j]==0)
                    adj_matrix[i][j]=max;
            }
        }
        distances=new int[N];
    }
    
    public int[] BellmanFord(int s){ // To compute the shortest paths from a souce vertex to all other vertices using the Bellman-Ford algorithm  s : Source vertex
        for(int node=0;node<N;node++)
            distances[node]=max;
        distances[s]=0;
        
        for(int node=0;node<N-1;node++){
            for(int sourcenode=0;sourcenode<N;sourcenode++){
                for(int destinationnode=0;destinationnode<N;destinationnode++){
                    if(adj_matrix[sourcenode][destinationnode]!=max){
                        if(distances[destinationnode]>(distances[sourcenode]+adj_matrix[sourcenode][destinationnode]))
                            distances[destinationnode]=distances[sourcenode]+adj_matrix[sourcenode][destinationnode];
                    }
                }
            }
        }
        
        for(int sourcenode=0;sourcenode<N;sourcenode++){
            for(int destinationnode=0;destinationnode<N;destinationnode++){
                if(adj_matrix[sourcenode][destinationnode]!=max){
                    if(distances[destinationnode]>distances[sourcenode]+adj_matrix[sourcenode][destinationnode])
                        System.out.println("The Graph contains negative egde cycle");
                }
            }
        }
        
        return distances; // Returning the shortest distances. distances[i] represent the shortest distance distance from vertex s to vertex i
    }
}