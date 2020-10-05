package com.cp.priorityQueue;

import java.util.*;

public class RankTeamByVotes {
    public static void main(String[] args){
        Integer b = null;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.nullsFirst(Comparator.comparingInt(a->a)));
        pq.offer(1);
        pq.offer(4);
        pq.offer(2);
        pq.offer(3);
        pq.offer(-1);
        System.out.println();
    }

    public String rankTeams(String[] votes) {
        if(votes.length <= 1) return votes[0];
        PriorityQueue[] queueList = new PriorityQueue[votes[0].length()];
        Set<Character> visited = new HashSet<>();
        StringBuffer sb = new StringBuffer();
        for(String s : votes){
            for(int i=1 ; i <= s.length(); i++){
                if(queueList[i] == null) {
                    queueList[i] = new PriorityQueue<Map.Entry<Integer, Integer>>();
                }

            }
        }
        return sb.toString();
    }
}
