package JGraph;

// Class To Compute The Maximum Flow From A Souce Vertex To A Sink Vertex (Considering Flow Throug An Edge Does Not Exceed The Given Capacity Of That Edge And Incoming Flow Is Equal To Outgoing Flow For Every Vertex Except The Source And Sink Vertex) Using The Ford-Fulkerson Algorithm 
// If The Total Number Of Vertices Be N. Then The Graph Will Have Vertex Values From 0 To N-1

// Importing required packages
import java.io.*;
import java.util.*;

public class Ford_Fulkerson{
    
    public int[][] adj_matrix; // Adjacency Matrix
    public int N; // Total number of vertices
    
    public Ford_Fulkerson(int n, int[][] a){ // Constructor  n : Total number of vertices  a : Adjacency Matrix
        N=n;
        adj_matrix=new int[N][N];
        adj_matrix=a;
    }
    
    public boolean bfs(int[][] rgraph, int s, int t, int[] parent){ // To check if there is a path from source vertex to sink vertex  rgraph : Adjacency Matrix (Residual Graph)  s : Source Vertex  t : Sink Vertex  parent : Stores Parent Of Each Vertex
        boolean[] visited=new boolean[N];
        for(int vertex=0;vertex<N;vertex++)
            visited[vertex]=false;
        
        Queue<Integer> q=new LinkedList<Integer>();
        q.add(s);
        visited[s]=true;
        parent[s]=-1;
        
        while(!q.isEmpty()){
            int u=q.remove();
            for(int v=0;v<N;v++){
                if((visited[v]==false)&&(rgraph[u][v]>0)){
                    q.add(v);
                    parent[v]=u;
                    visited[v]=true;
                }
            }
        }
        
        return visited[t]; // Returning whether the sink vertex has been reached
    }
    
    public int FordFulkerson(int s, int t){ // To compute the maximum flow from a source vertex to a sink vertex  s : Source Vertex  t : Sink Vertex
        int u=0,v=0;
        int[][] rgraph=new int[N][N];
        for(u=0;u<N;u++){ // Creating the residual graph
            for(v=0;v<N;v++)
                rgraph[u][v]=adj_matrix[u][v];
        }
        
        int[] parent=new int[N];
        int max_flow=0; // Initially there is no flow
        
        while(bfs(rgraph,s,t,parent)){ // Augmenting the flow as long as the path from source vertex to sink vertex extsts
            int path_flow=Integer.MAX_VALUE;
            for(v=t;v!=s;v=parent[v]){
                u=parent[v];
                path_flow=(int)Math.min(path_flow,rgraph[u][v]);
            }
            for(v=t;v!=s;v=parent[v]){
                u=parent[v];
                rgraph[u][v]-=path_flow;
                rgraph[v][u]+=path_flow;
            }
            max_flow+=path_flow;
        }
        return max_flow; // Returning the maximum flow from the source vertex to sink vertex
    }
}
        