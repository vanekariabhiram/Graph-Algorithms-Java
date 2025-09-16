package Graphs;

import java.util.List;
import java.util.*;


public class BellmanFord {
  static class Edge{
      int u;
      int v;
      int weight;
      Edge(int s,int d,int w){
          this.u=s;
          this.v=d;
          this.weight=w;
      }
  }
  public static void BellmanFord(int V, int E, List<Edge> adj, int src){
      int[]dist=new int[V];
      Arrays.fill(dist,Integer.MAX_VALUE);
      dist[src]=0;
      // now relaxation of nodes
      for (int i = 1; i <V ; i++) {
          for(Edge edges:adj){
              if (dist[edges.u]!=Integer.MAX_VALUE && dist[edges.u]+edges.weight<dist[edges.v]){
                  dist[edges.v]=dist[edges.u]+edges.weight;
              }
          }
      }
      // checking for negative cycle
      for (Edge edge:adj){
          if (dist[edge.u]!=Integer.MAX_VALUE&&dist[edge.u]+edge.weight<dist[edge.v]){
              System.out.println("Graph contains Negative weight cycle");
              return;
          }
      }
      System.out.println("shortest distance from single source"+Arrays.toString(dist));
  }

    static void main() {
        int V = 5;
        int E = 6;

        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(2,4,2));
        edges.add(new Edge(3,4,-2));
        edges.add(new Edge(2,3,-3));
        edges.add(new Edge(0,2,5));
        edges.add(new Edge(1,3,1));
        edges.add(new Edge(0,1,3));


        BellmanFord(V, E, edges, 0);
    }
}
