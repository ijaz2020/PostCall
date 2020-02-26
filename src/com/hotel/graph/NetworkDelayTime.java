package com.hotel.graph;

import java.util.*;

public class NetworkDelayTime {
    public static void main(String[] args) {
        int[][] nums = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        System.out.println(new NetworkDelayTime().networkDelayTime1(nums, 4, 2));
    }

    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] time : times) {
            map.putIfAbsent(time[0], new HashMap<>());
            map.get(time[0]).put(time[1], time[2]);
        }

        //distance, node into pq
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        pq.add(new int[]{0, K});

        boolean[] visited = new boolean[N + 1];
        int res = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.remove();
            int curNode = cur[1];
            int curDist = cur[0];
            if (visited[curNode]) continue;
            visited[curNode] = true;
            res = curDist;
            N--;
            if (map.containsKey(curNode)) {
                for (int next : map.get(curNode).keySet()) {
                    pq.add(new int[]{curDist + map.get(curNode).get(next), next});
                }
            }
        }
        return N == 0 ? res : -1;
    }

    public int networkDelayTime1(int[][] times, int N, int K) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        int score = 0;
        for (int[] time : times) {
            graph.putIfAbsent(time[0], new HashMap<>());
            graph.get(time[0]).put(time[1], time[2]);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        boolean[] visited = new boolean[N + 1];
        pq.offer(new int[]{0, K});
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            if (visited[node[1]]) continue;
            N--;
            score = node[0];
            if (N == 0) return score;
            visited[node[1]] = true;
            if(!graph.containsKey(node[1])) continue;
            for (Map.Entry<Integer, Integer> map : graph.get(node[1]).entrySet())
                pq.offer(new int[]{node[0] + map.getValue(), map.getKey()});
        }

        return N == 0 ? score : -1;
    }
}
