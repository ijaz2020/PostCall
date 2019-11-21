package com.hotel;

import java.util.*;

public class TopologicalSort {

    public static void main(String arg[]){
        TopologicalSort t = new TopologicalSort();
        int[][] top = { {1,0}, {2,0}, {4,1}, {3,2}, {5,4}, {5,3}};
        System.out.println(Arrays.toString(t.findOrder(6, top)));
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return null;
        // Convert graph presentation from edges to indegree of adjacent list.
        int[] indegree = new int[numCourses];
        int[] order = new int[numCourses];
        int index = 0;
        for (int i = 0; i < prerequisites.length; i++) // Indegree - how many prerequisites are needed.
            indegree[prerequisites[i][0]]++;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
            if (indegree[i] == 0) {
                // Add the course to the order because it has no prerequisites.
                order[index++] = i;
                queue.offer(i);
            }

        Queue<Integer> queue1 = new LinkedList<>();
            Stack<Integer> s1 = new Stack<>();

        // How many courses don't need prerequisites.
        while (!queue.isEmpty()) {
            int prerequisite = queue.poll(); // Already finished this prerequisite course.
            for (int i = 0; i < prerequisites.length; i++)  {
                if (prerequisites[i][1] == prerequisite) {
                    indegree[prerequisites[i][0]]--;
                    if (indegree[prerequisites[i][0]] == 0) {
                        // If indegree is zero, then add the course to the order.
                        order[index++] = prerequisites[i][0];
                        queue.offer(prerequisites[i][0]);
                    }
                }
            }
        }

        return (index == numCourses) ? order : new int[0];
    }
}
