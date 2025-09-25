package Graphs;

import java.util.List;
import java.util.*;

public class PrimsAlgo {
    static void main() {
        int v=9;
        List<List<Edge>>graph=new ArrayList<>();
        for (int i = 0; i <v ; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(new Edge(1, 4));
        graph.get(1).add(new Edge(0, 4));

        graph.get(0).add(new Edge(7, 8));
        graph.get(7).add(new Edge(0, 8));

        graph.get(1).add(new Edge(2, 8));
        graph.get(2).add(new Edge(1, 8));

        graph.get(1).add(new Edge(7, 11));
        graph.get(7).add(new Edge(1, 11));

        graph.get(2).add(new Edge(3, 7));
        graph.get(3).add(new Edge(2, 7));

        graph.get(2).add(new Edge(8, 2));
        graph.get(8).add(new Edge(2, 2));

        graph.get(3).add(new Edge(4, 9));
        graph.get(4).add(new Edge(3, 9));

        graph.get(3).add(new Edge(5, 14));
        graph.get(5).add(new Edge(3, 14));

        graph.get(4).add(new Edge(5, 10));
        graph.get(5).add(new Edge(4, 10));

        graph.get(5).add(new Edge(6, 2));
        graph.get(6).add(new Edge(5, 2));

        graph.get(6).add(new Edge(7, 1));
        graph.get(7).add(new Edge(6, 1));

        graph.get(6).add(new Edge(8, 6));
        graph.get(8).add(new Edge(6, 6));

        graph.get(7).add(new Edge(8, 7));
        graph.get(8).add(new Edge(7, 7));
        prims(graph,v);
    }
    static class Pair{
        int node,weight,parent;
        Pair(int node,int weight,int parent){
            this.node=node;
            this.weight=weight;
            this.parent=parent;
        }
    }
    static class Edge{
        int v,weight;
        Edge(int v,int weight){
            this.v=v;
            this.weight=weight;
        }
    }
    static void prims(List<List<Edge>>graph,int v){
        boolean[]isMst = new boolean[v];
        int[]parent=new int[v];
        int[]cost=new int[v];
        Arrays.fill(cost,Integer.MAX_VALUE);

        PriorityQueue<Pair>pq=new PriorityQueue<>(Comparator.comparingInt(a->a.weight));
        cost[0]=0;

        pq.add(new Pair(0,0,-1));

        while (!pq.isEmpty()){
            Pair curr=pq.poll();
            int u=curr.node;

            if (isMst[u])continue;

            isMst[u]=true;

            for (Edge e : graph.get(u)) {
                if (!isMst[e.v]&& e.weight < cost[e.v]){
                    cost[e.v]=e.weight;
                    parent[e.v] = u;
                    pq.add(new Pair(e.v,cost[e.v],u));
                }
            }
        }
        printMst(parent,cost,v);
    }
    static void printMst(int[]parent,int[]cost,int v){
        int total=0;
        for (int i = 1; i <v ; i++) {
            System.out.println(parent[i]+"-"+i+"\t"+cost[i]);
            total+=cost[i];
        }
        System.out.println("overall cost : "+total);
    }

}
