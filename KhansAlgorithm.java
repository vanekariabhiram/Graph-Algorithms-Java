package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class KhansAlgorithm {
    public static void main(String[]args){
        int V=7;
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for (int i = 0; i <V ; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(3);
        adj.get(1).add(4);
        adj.get(3).add(4);
        adj.get(5).add(6);
        adj.get(5).add(4);
        adj.get(6).add(3);
        KhanAlgo(V,adj);
    }
    // BFS -  kahns algorithm
    static void KhanAlgo(int V,ArrayList<ArrayList<Integer>>adj){
        int[]Indegrees=new int[V];
        for (int i = 0; i <V ; i++) {
            for(int node:adj.get(i)){
                Indegrees[node]++;
            }
        }
        // adding all nodes with InDegree Zero in queue
        Queue<Integer> queue=new LinkedList<>();
        for (int i = 0; i <V ; i++) {
            if (Indegrees[i]==0){
                queue.offer(i);
            }
        }

        ArrayList<Integer>topOrder=new ArrayList<>();
        while(!queue.isEmpty()){
            int node=queue.poll();
            topOrder.add(node);

            for(int neighbor:adj.get(node)){
                Indegrees[neighbor]--;
                if (Indegrees[neighbor]==0){
                    queue.add(neighbor);
                }
            }
        }
        // cycle detection
        if (topOrder.size()!=V){
            System.out.println("Graph is not a DAG");
        }
        else {
            System.out.println(topOrder);
        }
    }
}
