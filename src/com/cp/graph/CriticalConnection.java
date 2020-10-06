package com.cp.graph;

import java.util.*;

public class CriticalConnection {
    public static void main(String[] args){
//        int[][] g ={{0,1},{1,2},{2,0},{1,3}};
        List<List<Integer>> g = new ArrayList<>();
        g.add(Arrays.asList(0,1));
        g.add(Arrays.asList(1,2));
        g.add(Arrays.asList(2,0));
        g.add(Arrays.asList(1,3));
        System.out.println(new CriticalConnection().criticalConnections(4, g));
    }

    private int currentTime = 0;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        {
            int[] times = new int[n];
            int[] lowTimes = new int[n];
            boolean[] visitedNodes = new boolean[n];
            List<List<Integer>> ans = new ArrayList<>();

            ArrayList<Integer>[] graph = new ArrayList[n];
            for(int i = 0; i < graph.length; i++) {
                graph[i] = new ArrayList<>();
            }
            for(List<Integer> connection: connections) {
                graph[connection.get(0)].add(connection.get(1));
                graph[connection.get(1)].add(connection.get(0));
            }

            for(int i = 0; i < n; i++) {
                visitedNodes[i] = false;
            }

            dfs(graph, 0, -1, times, lowTimes, visitedNodes, ans);

            return ans;
        }
    }

    private void dfs(ArrayList<Integer>[] graph, int currentNode, int parentNode, int[] times, int[] lowTimes, boolean[] visitedNodes, List<List<Integer>> ans) {
        visitedNodes[currentNode] = true;
        times[currentNode] = lowTimes[currentNode] = currentTime++;

        for(int neighbourNode: graph[currentNode]) {
            if(neighbourNode == parentNode)
                continue;
            else if(!visitedNodes[neighbourNode]) {
                dfs(graph, neighbourNode, currentNode, times, lowTimes, visitedNodes, ans);
                lowTimes[currentNode] = Math.min(lowTimes[currentNode], lowTimes[neighbourNode]);
                if(times[currentNode] < lowTimes[neighbourNode]) {
                    ans.add(Arrays.asList(currentNode, neighbourNode));
                }
            } else {
                lowTimes[currentNode] = Math.min(lowTimes[currentNode], lowTimes[neighbourNode]);
            }
        }
    }

    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> criticalConnections1(int n, List<List<Integer>> connections) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (List<Integer> c : connections) {
            graph.computeIfAbsent(c.get(0), (k -> new ArrayList<>())).add(c.get(1));
            graph.computeIfAbsent(c.get(1), (k -> new ArrayList<>())).add(c.get(0));
        }
        int[] timestamps = new int[n];
        dfs(graph, 0, 0, 1, timestamps);
        return ans;
    }

    private int dfs(Map<Integer, List<Integer>> graph, int curr, int parent, int currTimestamp, int[] timestamps) {
        timestamps[curr] = currTimestamp;
        for (int nextNode : graph.getOrDefault(curr, new ArrayList<Integer>())) {
            if (nextNode == parent) continue;
            if (timestamps[nextNode] > 0)
                timestamps[curr] = Math.min(timestamps[curr], timestamps[nextNode]);
            else
                timestamps[curr] = Math.min(timestamps[curr], dfs(graph, nextNode, curr, currTimestamp + 1, timestamps));
            if (currTimestamp < timestamps[nextNode])
                ans.add(Arrays.asList(curr, nextNode));
        }
        return timestamps[curr];
    }
}
