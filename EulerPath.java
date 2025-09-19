package Graphs;

import java.util.List;
import java.util.*;

public class EulerPath {
    // every edge must be visited only once
    public int isEulerCircuit(int V, List<Integer>[]adj) {
        int ans=0;
        if (!isConnected(V,adj)){
            return 0;
        }
        int odd=0;
        for (int i = 0; i <V ; i++) {
            if (adj[i].size()%2!=0){
                odd++;
            }

        }
    if (odd==0) return 2; // return 2 if it is euler circuit
    if (odd==2)return 1; // return 1 if it is euler path

        return ans;
    }
    static boolean isConnected(int V,List<Integer>[]adj){
        boolean[]visited=new boolean[V];
        int start=-1;
        for (int i = 0; i <V ; i++) {
            if (adj[i].size()>0){
                start=i;
                break;
            }
        }
        if (start==-1){
            return true;
        }
        dfs(start,adj,visited);
        for (int i = 0; i <V ; i++) {
            if (!visited[i]&& adj[i].size()>0){
                return false;
            }
        }
        return true;
    }
    static void dfs(int u,List<Integer>[]adj,boolean[]visited){
        visited[u]=true;
        for(int neighbour:adj[u]){
            if(!visited[neighbour]){
                dfs(neighbour,adj,visited);
            }
        }
    }

    // method 2 instead of dfs we are using bfs
    public int isEulerCircuit2(int V, List<Integer>[]adj) {
        int ans=0;
        if (!isConnected(V,adj)){
            return 0;
        }
        int odd=0;
        for (int i = 0; i <V ; i++) {
            if (adj[i].size()%2!=0){
                odd++;
            }
        }
        if (odd==0) return 2; // return 2 if it is euler circuit
        if (odd==2)return 1; // return 1 if it is euler path

        return ans;
    }
    static boolean isConnected2(int V,List<Integer>[]adj){
        boolean[]visited=new boolean[V];
        int start=-1;
        for (int i = 0; i <V ; i++) {
            if (adj[i].size()>0){
                start=i;
                break;
            }
        }
        if (start==-1){
            return true;
        }
     // here we are doing bfs traversal
        // instead of queue we are taking deque which improves performance same like queue only
        Deque<Integer>queue=new LinkedList<>();
        queue.offer(start);
        visited[start]=true;
        while (!queue.isEmpty()){
            int u=queue.poll();
            for(int neighbour:adj[u]){
                if (!visited[neighbour]){
                    visited[neighbour]=true;
                    queue.offer(neighbour);
                }
            }
        }

        for (int i = 0; i <V ; i++) {
            if (!visited[i]&& adj[i].size()>0){
                return false;
            }
        }
        return true;
    }
}
