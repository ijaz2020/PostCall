package com.hotel.graph;

import java.lang.reflect.Array;
import java.util.*;

public class TarjanAlgo {
    public static void main(String[] args){
        List<List<Integer>> in = new ArrayList<>();
//        {{0,1},{1,2},{2,0},{1,3}}
        in.add(Arrays.asList(0,1));
        in.add(Arrays.asList(1,2));
        in.add(Arrays.asList(2,0));
        in.add(Arrays.asList(1,3));
        System.out.println(new TarjanAlgo().criticalConnections(4, in));
    }
    private int time = 0; // current time of discovery

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        Map<Integer, List<Integer>> graph = new HashMap<>(); // node -> neighbors

        for (List<Integer> conn : connections) {
            int n1 = conn.get(0);
            int n2 = conn.get(1);
            graph.putIfAbsent(n1, new ArrayList<>());
            graph.putIfAbsent(n2, new ArrayList<>());
            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }

        int[] disc = new int[n]; // discovery time of each node
        int[] low = new int[n]; // earliest discovered node reachable from this node in DFS
        boolean[] visited = new boolean[n]; // whether this node has been visited in DFS
        List<List<Integer>> out = new ArrayList<>();

        dfs(0, -1, disc, low, visited, graph, out); // arbitrarily pick a node to start DFS

        return out;
    }

    // root = current node under consideration
    // parent = parent of current node
    private void dfs(int root, int parent, int[] disc, int[] low, boolean[] visited, Map<Integer, List<Integer>> graph, List<List<Integer>> out) {
        visited[root] = true;
        disc[root] = time++;
        low[root] = disc[root]; // we don't have to initialize low[] to inf because of this line

        List<Integer> neighbors = graph.get(root);
        if (neighbors == null) {
            return;
        }

        for (Integer nei : neighbors) {
            if (nei == parent) {
                continue;
            }

            if (!visited[nei]) {
                dfs(nei, root, disc, low, visited, graph, out);
                low[root] = Math.min(low[root], low[nei]);
                if (disc[root] < low[nei]) {
                    out.add(Arrays.asList(root, nei));
                }
            } else {
                low[root] = Math.min(low[root], disc[nei]);
            }
        }
    }
}
