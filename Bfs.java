package Graphs;

import java.util.*;

public class Bfs {
  public   static void main(String[]args) {
int V=9;
ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
      for (int i = 0; i <V ; i++) {
          adj.add(new ArrayList<>());
      }
      adj.get(0).add(1);
      adj.get(0).add(2);

      adj.get(1).add(0);
      adj.get(1).add(5);
      adj.get(1).add(7);

      adj.get(2).add(0);
      adj.get(2).add(3);
      adj.get(2).add(4);

      adj.get(3).add(2);

      adj.get(4).add(2);

      adj.get(5).add(1);
      adj.get(5).add(6);

      adj.get(6).add(5);
      adj.get(6).add(8);

      adj.get(7).add(1);
      adj.get(7).add(8);

      adj.get(8).add(6);
      adj.get(8).add(7);
bfs(adj,V,0);

    }
static void bfs(ArrayList<ArrayList<Integer>> adj,int Vertices,int start){
    ArrayList<Integer>ans=new ArrayList<>();
      boolean[]visited=new boolean[Vertices];
        visited[start]=true;

      Queue<Integer>queue=new LinkedList<>();
      queue.offer(0);
      while (!queue.isEmpty()){
        int node=queue.poll();
        ans.add(node);

      for(int neighbor:adj.get(node)){
             if (!visited[neighbor]){
                 visited[neighbor]=true;
                 queue.offer(neighbor);
             }
      }
      }
        System.out.println(ans);
}
}