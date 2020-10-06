package com.cp.graph;

import java.util.*;

public class NumberOfOperationToMakeNetworkConnected {
    public static void main(String[] args){
        int[][] nums = {{0,1},{0,2},{0,3},{1,2},{1,3}};int no = 6;
//        System.out.println(new NumberOfOperationToMakeNetworkConnected().makeConnected(no, nums));
//        System.out.println(new NumberOfOperationToMakeNetworkConnected().makeConnectedUF(no, nums));
    }


    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1) return -1;
        Map<Integer, List<Integer>> components = new HashMap<>();
        for(int[] connection : connections){
            connect(components, connection[0], connection[1]);
            connect(components, connection[1], connection[0]);
        }

        boolean[] visited = new boolean[n]; int component = 0;
        for(int v=0; v<n; v++){
            component += findComponents(v, visited, components);
        }
        return component - 1;
    }

    int findComponents(int v, boolean[] visited, Map<Integer, List<Integer>> components){
        if(visited[v]) return 0;
        Queue<Integer> adjacent = new LinkedList<>();
        visited[v] = true;
        adjacent.offer(v);
        while(!adjacent.isEmpty()){
            int size = adjacent.size();
            while(size-- > 0){
                Integer i = adjacent.poll();
                List<Integer> children = components.get(i);
                if(children == null) continue;
                for(int child : children){
                    if(!visited[child]){
                        visited[child] =true;
                        adjacent.offer(child);
                    }
                }
            }
        }
        return 1;
    }

    void connect(Map<Integer, List<Integer>> components, int i, int j){
        List<Integer> ithChild = components.getOrDefault(i, new ArrayList<>());
        ithChild.add(j);
        components.put(i, ithChild);
    }
    public int findParent(int[] par, int i) {
        if(par[i] == i) return i;
        return par[i] = findParent(par, par[i]);
    }
    public int makeConnectedUF(int n, int[][] connections) {
        int[] parent = new int[n];
        for(int i = 0; i < n; i++) parent[i] = i;
        int components = 0;
        int extraEdge = 0;
        for(int[] connection : connections) {
            int p1 = findParent(parent, connection[0]);
            int p2 = findParent(parent, connection[1]);
            if(p1 == p2)
                extraEdge++;
            else parent[p1] = p2;
        }
        for(int i = 0; i < n; i++) if(parent[i] == i) components++;
        return (extraEdge >= components - 1) ? components - 1 : -1;
    }
}


