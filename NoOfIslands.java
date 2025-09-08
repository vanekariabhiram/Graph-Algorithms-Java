package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class NoOfIslands {
    static class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    // method 1
    public static int numIslands(char[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        Queue<Pair>queue=new LinkedList<>();
        boolean[][]visited=new boolean[rows][cols];
        int[][]directions={{1,0},{-1,0},{0,1},{0,-1}};
        int TotalIsland=0;
       for (int r=0;r<rows;r++){
           for (int c = 0; c <cols; c++) {
               if (grid[r][c]=='1' && !visited[r][c]){ // here it is going to traverse entire 2d matrix and searches whatever are remaining 1's which can form a island
                   TotalIsland++;
                   bfs(grid,r,c,visited,directions);
               }
           }
       }
        return TotalIsland;

    }

    private static void bfs(char[][] grid, int r, int c, boolean[][] visited, int[][] directions) {
        Queue<int[]>queue=new LinkedList<>();
        queue.offer(new int[]{r,c});
        visited[r][c]=true;
        while(!queue.isEmpty()){
            int[]cell=queue.poll();
            int currentRow=cell[0];
            int currentcol=cell[1];
            for(int[]dir:directions){
                int newRow=currentRow+dir[0];
                int newCol=currentcol+dir[1];

                if (newRow>=0 && newRow<grid.length && newCol>=0 && newCol<grid[0].length && grid[newRow][newCol] =='1' && !visited[newRow][newCol]){
                    queue.add(new int[]{newRow,newCol});
                    visited[newRow][newCol]=true;
                }

            }
        }
    }



    private void bfsPair(char[][] grid, int r, int c, boolean[][] visited, int[][] directions) {
        Queue<Pair>queue=new LinkedList<>();
        queue.offer(new Pair(r,c));
        visited[r][c]=true;
        while(!queue.isEmpty()){
          Pair p=queue.poll();
            int currentRow=p.row;
            int currentcol=p.col;
            for(int[]dir:directions){
                int newRow=currentRow+dir[0];
                int newCol=currentcol+dir[1];

                if (newRow>=0 && newRow<grid.length && newCol>=0 && newCol<grid[0].length && grid[newRow][newCol] =='1' && !visited[newRow][newCol]){
                    queue.add(new Pair(newRow,newCol));
                    visited[newRow][newCol]=true;
                }

            }
        }
    }
    // method 2 without using the visited array
    static int numIslandss(char[][]grid){
        int rows=grid.length;
        int cols=grid[0].length;
        int[][]directions={{1,0},{-1,0},{0,1},{0,-1}};
        int totalIslands=0;
        for (int r = 0; r <rows; r++) {
            for (int c=0;c<cols;c++){
                if (grid[r][c]=='1'){
                    totalIslands++;
                    bfs2(grid,r,c,directions);
                }
            }

        }
        return totalIslands;
    }
    
    static void bfs2(char[][]grid,int r,int c,int[][]directions){
        Queue<int[]> queue=new LinkedList<>();
       queue.offer(new int[]{r,c});
       grid[r][c]=0;
       while(!queue.isEmpty()){
           int[]cell=queue.poll();
           int currentRow=cell[0];
           int currentCol=cell[1];
           for(int[]direc:directions){
               int NewRow=currentRow+direc[0];
               int NewCol=currentCol+direc[1];
               if (NewRow>=0&&NewRow<grid.length&&NewCol>=0&&NewCol<grid[0].length&&grid[NewRow][NewCol]=='1'){
                   queue.add(new int[]{NewRow,NewCol});
                   grid[NewRow][NewCol]='0';
               }
           }
       }


    }

    public static void main(String[] args) {
        // Sample 4x5 grid
        char[][] grid = {
                {'1','1','1','0','1','1'},
                {'0','1','1','0','0','1'},
                {'1','0','0','0','0','0'},
                {'1','0','1','0','1','1'},
                {'1','1','0','0','1','1'}
        };
        
        int islands =numIslands(grid);
        System.out.println("Number of islands = " + islands);

    }
}
