package com.hotel.graph;

import java.util.*;

public class CheapestFlight {
    public static void main(String[] args){
        int[][] flights = {{0,1,100},{1,2,100},{0,2,500}};

        System.out.println(new CheapestFlight().findCheapestPrice1(3, flights, 0, 2, 1));
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        for(int i=0; i<=K; i++){
            int[] temp = Arrays.copyOf(distance, n);
            for(int[] flight : flights){
                if(distance[flight[0]]==Integer.MAX_VALUE) continue;
                temp[flight[1]] = Math.min(distance[flight[0]] + flight[2], temp[flight[1]]);
            }
            distance =temp;
        }
        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }
    public int findCheapestPrice1(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for(int[] flight : flights){
            graph.putIfAbsent(flight[0], new HashMap<>());
            graph.get(flight[0]).put(flight[1], flight[2]);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, src, K});

        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int dist = current[0], node = current[1], stops = current[2];
            if(node == dst) return dist;
            if(stops >= 0){
                Map<Integer, Integer> adj = graph.get(node);
                for(Integer i : adj.keySet()){
                    pq.offer(new int[]{dist + adj.get(i), i, stops-1});
                }
            }
        }
        return -1;
    }
}
