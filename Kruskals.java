package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Kruskals {
    static void kruskals(List<int[]>edges,int n){
PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[2]-b[2]); // {u,v,weights} so we are taking least weight first

for(int[]edge:edges){
    pq.offer(edge);
}

    int[]parent=new int[n];
    int[]rank=new int[n];

        // initializing the parent array to itself index value
        for (int i = 0; i < n; i++) {
            parent[i]=i;
        }

        List<int[]>mst=new ArrayList<>();

        while(!pq.isEmpty()){
            int[]edge=pq.poll();
            int u=edge[0];
            int v=edge[1];
            if (findParent(u,parent) != findParent(v,parent)){
                mst.add(edge);
                unionFind(u,v,parent,rank);
            }
        }

        System.out.println("MST  is ");
        int[] overallcost=new int[1];
        for(int[]e:mst){
            System.out.println(e[0] + " -- "+e[1]+" (weight "+e[2]+")");
            System.out.println(overallcost[0]+=e[2]);
        }
    }
    static int findParent(int u,int[]adj){
       if (u==adj[u]){
           return u;
       }
       return adj[u]=findParent(adj[u],adj); // here path compression and also finding the ultimate parent
    }
    static void unionFind(int u,int v,int[]adj,int[]rank){
        int uP=findParent(u,adj);
        int vP=findParent(v,adj);

                if (uP==vP)return;

                if (rank[uP]>rank[vP]){
                    adj[vP]=uP;
                } else if (rank[uP]<rank[vP]) {
                    adj[uP]=vP;
                }
                else {
                    adj[vP]=uP;
                    rank[vP]++;
                }
    }
    static void unionFindSize(int u,int v,int[]adj,int[]size){
        int uP=findParent(u,adj);
        int vP=findParent(v,adj);

        if (uP==vP)return;

        if (size[uP]<size[vP]) {
            adj[uP] = vP;
            size[vP] += size[uP];
        }
        else {
            adj[vP]=uP;
            size[vP] += size[uP];
        }
    }
    static void main() {
        int V = 9;

        // Graph as edge list: {u, v, weight}
        List<int[]> edges = new ArrayList<>();
        edges.add(new int[]{0,1,4});
        edges.add(new int[]{0,7,8});
        edges.add(new int[]{1,2,8});
        edges.add(new int[]{1,7,11});
        edges.add(new int[]{2,3,7});
        edges.add(new int[]{2,8,2});
        edges.add(new int[]{8,6,6});
        edges.add(new int[]{8,7,7});
        edges.add(new int[]{3,4,9});
        edges.add(new int[]{4,5,10});
        edges.add(new int[]{5,6,2});
        edges.add(new int[]{6,7,1});

        kruskals(edges,V);

    }
}