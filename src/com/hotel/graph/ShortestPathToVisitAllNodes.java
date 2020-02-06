package com.hotel.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ShortestPathToVisitAllNodes {
    public static void main(String args[]) {
        ShortestPathToVisitAllNodes s = new ShortestPathToVisitAllNodes();
        int[][] a = {{1}, {0, 2, 4}, {1, 3, 4}, {2}, {1, 2}};
//        System.out.println(s.shortestPathLength1(a));
        System.out.println(s.shortestPathLength(a));
    }
    public int shortestPathLength(int[][] graph) {
        int N = graph.length, mask = 1, count = 0;
        Set<String> set = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            mask |= (1 << i);
            int[] make = new int[] {(1<<i),i};
            set.add(make[0] + "+" + make[1]);
            q.offer(make);
        }
        while (true) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int[] curr = q.poll();
                if (curr[0] == mask)
                    return count;
                for (int next : graph[curr[1]]) {
                    int nextPath = curr[0] | (1 << next);
                    if (!set.add(nextPath + "+" + next)) continue;
                    q.offer(new int[]{nextPath,next});
                }
            }
            count++;
        }
    }

    class Node {
        int id;
        int mask;

        Node(int id, int mask){
            this.id = id; this.mask = mask;
        }

        public String toString() {
            return id + " " + mask;
        }
    }

    public int shortestPathLength1(int[][] graph) {
        Queue<int[]> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        int N = graph.length;

        for(int i = 0; i < N; i++){
            int tmp = (1 << i);
            set.add(tmp + ":" + i);
            queue.add(new int[]{tmp, i, 1});
        }

        while(!queue.isEmpty()){
            int[] curr = queue.remove();

            if(curr[0] == (1 << N) - 1){
                return curr[2] - 1;
            } else {
                int[] neighbors = graph[curr[1]];

                for(int v : neighbors){
                    int bitMask = curr[0];
                    bitMask = bitMask | (1 << v);
                    if(!set.add(bitMask + ":" +  v)) continue;
                    queue.add(new int[]{bitMask, v, curr[2] + 1});
                }
            }
        }
        return -1;
    }

}
