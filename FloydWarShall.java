package Graphs;

public class FloydWarShall {

    static  final int max=1000000000;

  static void FloydWarshall(int[][]graph,int V){
      int[][]dist=new int[V][V];
      for (int i = 0; i <V ; i++) {
          for (int j = 0; j <V ; j++) {
           dist[i][j]=graph[i][j];
          }
      }

      for(int k=0;k<V;k++){
          for (int i = 0; i <V; i++) {
              for (int j = 0; j <V ; j++) {
               if (dist[i][k]!=max && dist[k][j]!=max && dist[i][k]+dist[k][j]<dist[i][j]){
                   dist[i][j]=dist[i][k]+dist[k][j];
               }
              }
          }
      }
      print(dist,V);
  }
  static void print(int[][]dist,int V){
      System.out.println("all pairs shortest path matrix");
      for (int i = 0; i <V ; i++) {
          for (int j = 0; j <V ; j++) {
              if (dist[i][j]==max){
                  System.out.print("∞ ");
              }
              else {
                  System.out.print(dist[i][j]+" ");
              }
          }
          System.out.println();
      }
  }
}
