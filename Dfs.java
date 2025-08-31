package Graphs;

import java.util.ArrayList;

public class Dfs {
    public static void main(String[] args){
        int V=9;
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for (int i = 0; i <V ; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(0).add(3);
        adj.get(0).add(2);

        adj.get(1).add(0);
        adj.get(1).add(7);
        adj.get(1).add(4);

        adj.get(2).add(0);
        adj.get(2).add(5);

        adj.get(3).add(0);

        adj.get(4).add(1);
        adj.get(4).add(5);

        adj.get(5).add(4);
        adj.get(5).add(6);
        adj.get(5).add(2);

        adj.get(6).add(5);

        adj.get(7).add(1);
        boolean[]visited=new boolean[V];
        dfs(0,adj,visited);
    }
    static void dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean[]visited){
        visited[node]=true;
        System.out.println(node+" ");
        for(int neighbour:adj.get(node)){
            if (!visited[neighbour]){
                 dfs(neighbour,adj,visited);
                }
        }
    }

}
