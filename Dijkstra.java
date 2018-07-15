package JGraph;

// Class To Compute The Shortest Paths From A Souce Vertex To All Other Vertices Using The Dijkstra Algorithm 
// If The Total Number Of Vertices Be N. Then The Graph Will Have Vertex Values From 0 To N-1

// Importing required packages
import java.io.*;
import java.util.*;

public class Dijkstra{
    
    public int[][] adj_matrix; // Adjacency Matrix
    public int N; // Total number of vertices
    public int[] distances; // Will store the distances
    public boolean[] shortest_path_tree; // shortest_path_tree[i] will be true if vertex i is included in the shortest path tree
    
    public Dijkstra(int n, int[][] a){ // Constructor  n : Total number of vertices  a : Adjacency Matrix
        N=n;
        adj_matrix=new int[N][N];
        adj_matrix=a;
        distances=new int[N];
        shortest_path_tree=new boolean[N];
    }
    
    public int minDistance(int[] dist, boolean[] spt){ // To find the vertex with the minimum distance from the set of vertices not yet included in the shortest path tree{
        int min=Integer.MAX_VALUE;
        int min_index=-1;
        
        for(int v=0;v<N;v++){ // Iterating through all the vertic
            if((spt[v]==false)&&(dist[v]<=min)){
                min=dist[v];
                min_index=v;
            }
        }
        return min_index;
    }
    
    public int[] dijkstra(int s){ // To compute the shortest paths from a souce vertex to all other vertices using the Dijkstra algorithm  s : Source Vertex
        for (int vertex=0;vertex<N;vertex++){ // Initializing the distances as infinite
            distances[vertex]=Integer.MAX_VALUE;
            shortest_path_tree[vertex]=false;
        }
        
        distances[s] = 0;
        
        for(int count=0;count<N-1;count++){
            int u=minDistance(distances,shortest_path_tree);
            shortest_path_tree[u]=true;
            for(int v=0;v<N;v++)
                if((!shortest_path_tree[v])&&(adj_matrix[u][v]!=0)&&(distances[u]!=Integer.MAX_VALUE)&&((distances[u]+adj_matrix[u][v])<distances[v]))
                    distances[v]=distances[u]+adj_matrix[u][v];
        }
        return distances; // Returning the shortest distances. distances[i] represent the shortest distance distance from vertex s to vertex i
    }
}
    

    