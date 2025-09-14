package Graphs;

import java.util.List;
import java.util.Stack;
import java.util.*;

public class ShortestPathDir {
   // node relaxation
 static class Edge{
     int v;
     int w;
     Edge(int v,int w){
         this.v=v;
         this.w=w;
     }
   }
   static void topoDfs(int u, boolean[]visited, Stack<Integer>stack,List<List<Edge>>adj){
     visited[u]=true;
     for(Edge e:adj.get(u)){
         if(!visited[e.v]){
             topoDfs(e.v,visited,stack,adj);
         }
     }
     stack.push(u);
   }
   static void shortestPath(int n,int src,List<List<Edge>>adj){
     Stack<Integer>stack=new Stack<>();
     boolean[]visited=new boolean[n];
       for (int i = 0; i <n ; i++) {
           if (!visited[i]){
               topoDfs(i,visited,stack,adj);
           }
       }
       // initializing dist[] and parent[]
       int[]dist=new int[n];
       int[]parent=new int[n];
       Arrays.fill(dist,Integer.MAX_VALUE);
       Arrays.fill(parent,-1);

       dist[src]=0;

       // now relaxation of  edges
       while(!stack.isEmpty()){
           int u=stack.pop();
           if (dist[u]!=Integer.MAX_VALUE){
               for (Edge e:adj.get(u)){
                   if (dist[u]+e.w<dist[e.v]){
                       dist[e.v]=dist[u]+e.w;
                       parent[e.v]=u;
                   }
               }
           }
       }

       System.out.println("Node Dist path");
       for (int i = 0; i <n ; i++) {
           System.out.print(i + " ");
           if (dist[i] == Integer.MAX_VALUE) {
               System.out.println(" INF ");
           } else {
               System.out.print(dist[i] + " ");
               printpath(i, parent);
               System.out.println();
           }
       }
 }
 public static void  printpath(int v,int[]parent){
     List<Integer>path=new ArrayList<>();
     while(v!=-1){
         path.add(v);
         v=parent[v];
     }
     Collections.reverse(path);
     for(int node:path){
         System.out.print(node+" ");
     }
 }
    public static void main(String[] args) {
        int n = 8; // number of nodes
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        // Build the graph
        adj.get(0).add(new Edge(1, 4));
        adj.get(0).add(new Edge(2, 3));
        adj.get(1).add(new Edge(3, 6));
        adj.get(2).add(new Edge(4, 2));
        adj.get(3).add(new Edge(6, 5));
        adj.get(4).add(new Edge(5, 1));
        adj.get(5).add(new Edge(3, 2));
        adj.get(6).add(new Edge(7, 4));

        int src = 0;
        shortestPath(n, src, adj);
    }

}
