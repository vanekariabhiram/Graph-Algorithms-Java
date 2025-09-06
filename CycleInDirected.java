package Graphs;

import java.util.ArrayList;
import java.util.List;

public class CycleInDirected {
    static class Graph {
        int V;
        List<List<Integer>>adj;
        Graph(int V){
           this.V=V;
           adj=new ArrayList<>();
            for (int i = 0; i <V ; i++) {
               adj.add(new ArrayList<>());
            }
        }
        void addEdge(int u,int v){
            adj.get(u).add(v);
        }
    }
    static boolean isCyclic(int V,List<List<Integer>>adj) {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, visited, recStack,adj)) {
                    return true;
                }
            }
        }
        return false;
    }
    static boolean dfs(int node,boolean[]visited,boolean[]recStack,List<List<Integer>>adj){

        visited[node] = true;
        recStack[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, visited, recStack,adj)) {
                    return true;
                }
            } else if (recStack[neighbor]) {

                return true;
            }
        }
        recStack[node] = false;
        return false;
    }
    static void main() {

//        Graph g=new Graph(9);
//        g.addEdge(0,1);
//        g.addEdge(1, 2);
//        g.addEdge(2, 7);
//        g.addEdge(2, 3);
//        g.addEdge(7, 8);
//        g.addEdge(3, 4);
//        g.addEdge(4, 5);
//        g.addEdge(4, 6);
//        g.addEdge(5, 2);
        Graph g=new Graph(7);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(2,5);
        g.addEdge(3,4);
        g.addEdge(5,4);
        g.addEdge(4,6);

        System.out.println( isCyclic(7,g.adj));
    }
}
