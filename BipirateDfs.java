package Graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class BipirateDfs {
    static class Graph{
        int V;
        ArrayList<ArrayList<Integer>>adj;
        Graph(int V){
            this.V=V;
            adj=new ArrayList<>();
            for (int i = 0; i <V ; i++) {
                adj.add(new ArrayList<>());
            }
        }
        void addEdge(int u,int v){
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
    }

    static boolean isBipartiteDfs(  Graph g){
        int v=g.V;
        int[]color=new int[v];
        Arrays.fill(color,-1);
        for (int i=0;i<v;i++){
            if (color[i]==-1){
                if (!dfs(i,0, color,g)){
                    return false;
                }
            }
        }
        return true;

    }
    static boolean dfs(int node ,int c,int[]color,Graph g){
        color[node]=c;
        for(int neighbour: g.adj.get(node)){
            if (color[neighbour]==-1){
                if (!dfs(neighbour,1-c,color,g)){
                    return false;
                }
            }
            else if (color[neighbour]==color[node]){
                return false;
            }

        }
        return true;
    }
    public static  void main(String[]args){
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        System.out.println(isBipartiteDfs(g) ? "Yes Graph is Bipartite" : "No Graph is not Bipartite");
    }
}
