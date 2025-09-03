package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TopologicalSort {
    public static void main(String[]args) {
        int V=7;
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for (int i = 0; i <V ; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(5).add(0);
        adj.get(5).add(2);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

      ArrayList<Integer>topOrder=TopoSort(V,adj);
        System.out.println(topOrder);
    }

    static void DFS(int node, ArrayList<ArrayList<Integer>>adj, boolean[]visited, Stack<Integer>stack){
        visited[node]=true;
        for(int neighbour:adj.get(node)){
            if (!visited[neighbour]){
                DFS(neighbour,adj,visited,stack);
            }
        }
        stack.push(node);
    }
    static ArrayList<Integer>TopoSort(int V,ArrayList<ArrayList<Integer>>adj){
      boolean[]visited=new boolean[V];
      Stack<Integer>stack=new Stack<>();
        for (int i = 0; i <V; i++) {
            if (!visited[i]){
                DFS(i,adj,visited,stack);
            }
        }
        ArrayList<Integer>result=new ArrayList<>();

        while(!stack.isEmpty()){
            result.add(stack.pop());
        }
        return result;
    }


}