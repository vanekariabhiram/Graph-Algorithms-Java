package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Cycle {
    public static void main(String[] args){
        int V=9;
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for (int i = 0; i <V ; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(2).add(3);
        adj.get(3).add(2);

        adj.get(3).add(0);
        adj.get(0).add(3);

        adj.get(4).add(5);
        adj.get(5).add(4);
        boolean[]visited=new boolean[V];
        if (CycleDetectDfs(V,adj)){
            System.out.println("Cycle is present");
        }
        else {
            System.out.println("Cycle is not present");
        }
        if (CycleDetectBfs(V,adj)){
            System.out.println("Cycle is present");
        }
        else {
            System.out.println("Cycle is not present");
        }
    }

    static boolean Dfs(int node,int parent,ArrayList<ArrayList<Integer>>adj,boolean[]visited){
        visited[node]=true;
        for(int neighbour:adj.get(node)){
            if (!visited[neighbour]){
                if (Dfs(neighbour,node,adj,visited)){
                    return true;
                }
            }
            else if (neighbour!=parent) {
                return true;
            }
        }
        return false;
    }
     static boolean CycleDetectDfs(int V,ArrayList<ArrayList<Integer>>adj){
        boolean[]visited=new boolean[V];
         for (int i = 0; i <V ; i++) {
            if (!visited[i]){
                if (Dfs(i,-1,adj,visited)){
                    return true;
                }
            }
         }
         return false;
     }
// cycle detect using bfs technique
   static class pair {
        int node,parent;
        pair(int node,int parent){
            this.node=node;
            this.parent=parent;

        }
    }

    static boolean CycleDetectBfs(int V,ArrayList<ArrayList<Integer>>adj){
        boolean [] visited=new boolean[V];
        for (int i = 0; i <V ; i++) {
            if (!visited[i]){
                if (bfsCycle(i,adj,visited)){
                    return true;
                }
            }

        }
        return false;
    }
    static boolean bfsCycle(int start,ArrayList<ArrayList<Integer>>adj,boolean[]visited){

        Queue<pair>queue=new LinkedList<>();
        queue.offer(new pair(start,-1));
        visited[start]=true;
        while(!queue.isEmpty()){
            pair P= queue.poll();
            int node=P.node;
            int parent=P.parent;
            for(int neigbour:adj.get(node)){
                if (!visited[neigbour]){
                    visited[neigbour]=true;
                    queue.add(new pair(neigbour,node));
                }
                else if (neigbour!=parent){
                    return true;
                }
            }
        }
        return false;
    }
}