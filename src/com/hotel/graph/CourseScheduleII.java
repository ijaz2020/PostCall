package com.hotel.graph;

import java.util.*;

public class CourseScheduleII {
    public static void main(String[] args){
        CourseScheduleII c = new CourseScheduleII();
        int[][] course = {{1,0}, {2,0}, {3,1}, {3,2}};
        System.out.println(Arrays.toString(c.findOrder(4, course)));
    }
    // 0,1,2,3
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int resultIndex = 0; int[] result = new int[numCourses];
        Map<Integer, Integer> inDegree = new HashMap<>();
        for (int i=0; i<numCourses;i++) inDegree.put(i, 0);
        for (int[] prerequisite : prerequisites)
            inDegree.put(prerequisite[0], inDegree.getOrDefault(prerequisite[0], 0) + 1);
        Queue<Integer> processedVertex = new LinkedList<>();
        for(Integer key: inDegree.keySet())
            if(inDegree.get(key) == 0) {
                processedVertex.offer(key);
                result[resultIndex++] = key;
            }
        while ( !processedVertex.isEmpty() ){
            Integer vertex = processedVertex.poll();
            for(int[] prerequisite : prerequisites){
                if(vertex == prerequisite[1]){
                    inDegree.put(prerequisite[0], inDegree.get(prerequisite[0]) -1);
                    if(inDegree.get(prerequisite[0]) == 0){
                        processedVertex.offer(prerequisite[0]);
                        result[resultIndex++] = prerequisite[0];
                    }
                }
            }
        }
        return result;
    }
}
