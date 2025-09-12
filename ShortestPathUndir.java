package Graphs;

import java.util.*;

public class ShortestPathUndir {
    // when destination is given
    public static int[] bfs(int src, int dest, int n,List<List<Integer>>adj) {
        boolean[]visited=new boolean[n];
        int[]distance=new int[n];
        Arrays.fill(distance,-1);
        Queue<Integer>queue=new LinkedList<>();
        queue.offer(src);
        visited[src]=true;
        distance[src]=0;
        while (!queue.isEmpty()){
            int node=queue.poll();
            if (node==dest)break;
            for(int neighbour:adj.get(node)){
               if(!visited[neighbour]){
                   visited[neighbour]=true;
                   distance[neighbour]=distance[node]+1;
                   queue.offer(neighbour);
               }

            }
        }
return distance;
    }
}
