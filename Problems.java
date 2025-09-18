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
 // method 2 without visited array
    // instead of taking boolean visited array and marking true we just replace by marking 1 at current position .
    public static int shortestPathBinaryMatrix2(int[][] grid) {
        int n=grid.length;
        if (grid[0][0]==1 || grid[n-1][n-1]==1){
            return -1;
        }
        Queue<int[]>queue=new LinkedList<>();
        queue.offer(new int[]{0,0,1});
        grid[0][0]=1; // marking starting path as 1 same like visited array
        while(!queue.isEmpty()){
          int[]curr=queue.poll();
          int x=curr[0];
          int y=curr[1];
          int step=curr[2];

          if (x==n-1 && y==n-1){
              return step;
          }
          for(int[]dir:directions){
              int newX=dir[0];
              int newY=dir[1];
              if (newX>=0 && newY>=0 && newX<n &&newY<n && grid[newX][newY]==0) {
                  queue.offer(new int[]{newX, newY, step + 1});
                  grid[newX][newY] = 1;// marking current path 1 same like visited
              }
          }
        }

        return -1;
    }
     // knight walk gfg
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N) {
        int[][]Knightdirections= {{-2, -1}, {-2, 1},
                {-1, -2}, {-1, 2},
                {1, -2},  {1, 2},
                {2, -1},  {2, 1}};

        int startX=KnightPos[0]-1;
        int startY=KnightPos[1]-1;
        int targetX=TargetPos[0]-1;
        int targetY=TargetPos[1]-1;

        boolean[][]visited=new boolean[N][N];
        visited[startX][startY]=true;
        Queue<int[]>queue=new LinkedList<>();
        queue.add(new int[]{startX,startY,0});
        while(!queue.isEmpty()){
            int[]curr=queue.poll();
            int x=curr[0];
            int y=curr[1];
            int steps=curr[2];
            if (x==targetX && y==targetY){
                return steps;
            }
            for(int[]dir:Knightdirections){
                int newX=x+dir[0];
                int newY=y+dir[1];

                if (newX>=0 && newY>=0 && newX < N && newY<N && !visited[newX][newY] ){
                    visited[newX][newY]=true;
                    queue.offer(new int[]{newX,newY,steps+1});
                }
            }

        }
        return -1;
    }
      // leetcode 1197 minimum knight moves
     public int minKnightMoves(int x, int y) {
        // converting all negative coordinates to only one positive quadrant 1
        x=Math.abs(x);
        y=Math.abs(y);
        int[][]Knightdirections= {{-2, -1}, {-2, 1},
                {-1, -2}, {-1, 2},
                {1, -2},  {1, 2},
                {2, -1},  {2, 1}};
        Queue<int[]>queue=new LinkedList<>();
        queue.offer(new int[]{0,0,0});

        // taking set since they have not given array size we are adding in set and avoiding revisiting position again
        Set<String>visited=new HashSet<>();
        visited.add("0,0");
        while(!queue.isEmpty()){
            int[]curr=queue.poll();
            int cx=curr[0];
            int cy=curr[1];
            int steps=curr[2];

            if (cx==x && cy==y){
                return steps;

            }
            for(int[]dir:Knightdirections){
                int newX=cx+dir[0];
                int newY=cy+dir[1];

                if (newX>=-1 && newY>=-1){// here we are only considering quadrant 1 but sometimes the knight move are l shape so maybe it can go into q2
                    String key=newX+","+newY;
                    if (!visited.contains(key)){
                        visited.add(key);
                        queue.offer(new int[]{newX,newY,steps+1});
                    }
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
