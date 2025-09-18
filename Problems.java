package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class Problems {
    // https://leetcode.com/problems/shortest-path-in-binary-matrix/description/
    static final int[][]directions={
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1},
            {1, 1},
            {1, -1},
            {-1, 1},
            {-1, -1}
    };
    //
    public static int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        // when starting source is 1 you cannot go so return -1 same follows for destination also
        if (grid[0][0]==1||grid[n-1][n-1]==1){
            return -1;
        }
        boolean[][]visited=new boolean[n][n];
        Queue<int[]>queue=new LinkedList<>();
        queue.add(new int[]{0,0,1}); // adding initially row,col,and step number
        visited[0][0]=true;
        while (!queue.isEmpty()){
            int[]curr=queue.poll();
            int x=curr[0]; // getting row
            int y=curr[1];  // getting column
            int dist=curr[2];   // getting step count

            if (x==n-1 &&y==n-1){ // destination is reached
                return dist;

            }

            for(int[]dir:directions){ // checking for all 8 directions
                int newX=x+dir[0];
                int newY=y+dir[1];
                if (newX>=0 && newY >=0 && newX<n && newY <n && grid[newX][newY] ==0 && !visited[newX][newY]){
                    visited[newX][newY]=true;
                    queue.add(new int[]{newX,newY,dist+1});
                }
            }
        }

        return -1;
    }

    static void main() {
        int[][] grid = {
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 0}
        };
        System.out.println(shortestPathBinaryMatrix(grid));
    }
}
