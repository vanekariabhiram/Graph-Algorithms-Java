package Graphs;

import java.util.Arrays;

public class DijkstraAlgo {
    static void main() {
        int V = 6;

        int[][] edges = {
                {0, 1, 6},
                {0, 2, 2},
                {1, 3, 7},
                {1, 2, 3},
                {2, 4, 4},
                {3, 5, 2},
                {3, 4, 5},
                {4, 5, 9}
        };

        int[][] graph = new int[V][V];

        // Fill adjacency matrix
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];
            graph[u][v] = w;
            graph[v][u] = w;
        }

        // Print adjacency matrix
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
        // to run second method
     List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            graph.get(u).add(new Pair(v, w));
            graph.get(v).add(new Pair(u, w));
        }
        // Run Dijkstra
        int src=0;
        int[] dist = dijkstra(V, edges, src);

        // Print shortest distances
        System.out.println("\nShortest distances from source " + src + ":");
        for (int i = 0; i < V; i++) {
            System.out.println(src + " -> " + i + " = " + dist[i]);
        }
    }
// these is brute force approach
    public static int[] dijkstra(int V, int[][] edges, int src) {
        // adjacency matrix initialized with INF
        int[][] graph = new int[V][V];
        for (int[] row : graph) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // Fill adjacency matrix from edges
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];
            graph[u][v] = w;
            graph[v][u] = w;
        }
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] visited = new boolean[V];
        dist[src] = 0;

        // Dijkstra brute force
        for (int i = 0; i < V - 1; i++) {
            int u = -1;
            int min = Integer.MAX_VALUE;

            // pick the minimum distance unvisited vertex
            for (int v = 0; v < V; v++) {
               if (!visited[v] && dist[v] < min) {
                    min = dist[v];
                    u = v;
               }
            }
            if (u == -1) break;
            visited[u] = true;
            // Relax neighbors
            for (int v = 0; v < V; v++) {
                if (graph[u][v] != Integer.MAX_VALUE && !visited[v]) {
                    dist[v] = Math.min(dist[v], dist[u] + graph[u][v]);
                }
            }
        }
        return dist;
    }
    // These method is optimized approach
   static class Pair{
        int node;
        int dist;
        Pair(int node,int dist){
            this.node=node;
            this.dist=dist;
        }
    }
    static int[]dijkstrasAlgo2(int V, List<List<Pair>>graph,int src){
        int[]dist=new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        PriorityQueue<Pair>pq=new PriorityQueue<>(Comparator.comparing(a->a.dist)); // based on the distance i.e least one would be my min heap it would be poll()
        pq.offer(new Pair(src,0));

        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int u=curr.node;
            int d=curr.dist;
            if (d>dist[u])continue; // skip multiple entries of same node with least one

            // relaxation of nodes
            for (Pair edge:graph.get(u)){
                int v=edge.node;
                int w=edge.dist;
                if ((dist[u]+w)<dist[v]){
                    dist[v]=dist[u]+w;
                    pq.add(new Pair(v,dist[v]));
                }
            }
        }
        return dist;
    }
    
}
