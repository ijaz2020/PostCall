package com.hotel.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ShortestPathToVisitAllNodes {
    public static void main(String args[]) {
        ShortestPathToVisitAllNodes s = new ShortestPathToVisitAllNodes();
        int[][] a = {{1}, {0, 2, 4}, {1, 3, 4}, {2}, {1, 2}};
        System.out.println(s.shortestPathLength(a));
    }

    public int shortestPathLength(int[][] graph) {
        int N = graph.length;

        Queue<Tuple> queue = new LinkedList<>();
        Set<Tuple> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            int tmp = (1 << i);
            set.add(new Tuple(tmp, i, 0));
            queue.add(new Tuple(tmp, i, 1));
        }

        while (!queue.isEmpty()) {
            Tuple curr = queue.remove();

            if (curr.bitMask == (1 << N) - 1) {
                return curr.cost - 1;
            } else {
                int[] neighbors = graph[curr.curr];

                for (int v : neighbors) {
                    int bitMask = curr.bitMask;
                    bitMask = bitMask | (1 << v);

                    Tuple t = new Tuple(bitMask, v, 0);
                    if (!set.contains(t)) {
                        queue.add(new Tuple(bitMask, v, curr.cost + 1));
                        set.add(t);
                    }
                }
            }
        }
        return -1;
    }

    class Tuple {
        int bitMask;
        int curr;
        int cost;

        public Tuple(int bit, int n, int c) {
            bitMask = bit;
            curr = n;
            cost = c;
        }

        public boolean equals(Object o) {
            Tuple p = (Tuple) o;
            return bitMask == p.bitMask && curr == p.curr && cost == p.cost;
        }

        public int hashCode() {
            return 1331 * bitMask + 7193 * curr + 727 * cost;
        }
    }
}
