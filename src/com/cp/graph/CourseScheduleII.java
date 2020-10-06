package com.cp.graph;

import java.util.*;

public class CourseScheduleII {
    public static void main(String[] args){
        CourseScheduleII c = new CourseScheduleII();
        int[][] course = {{1,0}, {2,0}, {3,1}, {3,2}};
        System.out.println(Arrays.toString(c.findOrder1(4, course)));
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
    //Input: 4, [[1,0],[2,0],[3,1],[3,2]]
    //Output: [0,1,2,3] or [0,2,1,3]
    public int[] findOrder1(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        LinkedList<Integer> res = new LinkedList<>();
        boolean[] visited = new boolean[numCourses];
        for(int[] inDegree : prerequisites){
            graph.computeIfAbsent(inDegree[1], k -> new ArrayList<>()).add(inDegree[0]);                    // 0 1,2
        }                                                                                                   // 1 3
                                                                                                            // 2 3
        for(int i=0; i<numCourses; i++){                                                                    // 3 1
            Set<Integer> path = new HashSet<>();
            path.add(i);
            if(!dfs(i, graph, res, visited, path)){
                res.clear();
                break;
            }
        }

        return res.stream().mapToInt(i->i).toArray();
    }

    private boolean dfs(int i, Map<Integer, List<Integer>> graph, LinkedList<Integer> res, boolean[] visited, Set<Integer> path) {
        boolean noCycle = true;
        for(int j : graph.getOrDefault(i, new ArrayList<>())){
            if(!visited[j]){
                if(!path.add(j)){
                    noCycle = false;
                    break;
                }
                noCycle = noCycle && dfs(j, graph, res, visited, path);
            }
        }
        if(!visited[i]) {
            visited[i] = true;
            res.addFirst(i);
        }
        return noCycle;
    }
}
