package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
    public static void main(String[] args) {
        int numCourses2 = 4;
        int[][] prerequisites2 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(canFinish(numCourses2, prerequisites2));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // finding Indegrees
        int size = numCourses;
        int[] Indegrees = new int[size];

        for (int[] pre : prerequisites) {
            Indegrees[pre[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            if (Indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        ArrayList<Integer> topo = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topo.add(node);
            for (int[] neighbour : prerequisites) {
                if (neighbour[1] == node) {
                    Indegrees[neighbour[0]]--;
                    if (Indegrees[neighbour[0]] == 0) {
                        queue.offer(neighbour[0]);
                    }
                }
            }
        }
        return topo.size() == size;
    }

    // method 2 more optimized
    public static boolean canFinish2(int numCourses, int[][] prerequisites) {
        // finding Indegrees
        int size = numCourses;
        int[] Indegrees = new int[size];

        for (int[] pre : prerequisites) {
            Indegrees[pre[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            if (Indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            count++;
            for (int[] neighbour : prerequisites) {
                if (neighbour[1] == node) {
                    Indegrees[neighbour[0]]--;
                    if (Indegrees[neighbour[0]] == 0) {
                        queue.offer(neighbour[0]);
                    }
                }
            }
        }
        return count == size;
    }

}