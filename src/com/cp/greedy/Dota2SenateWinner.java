package com.cp.greedy;

import java.util.LinkedList;
import java.util.Queue;

public class Dota2SenateWinner {
    public static void main(String[] args){
//        System.out.println(new Dota2SenateWinner().predictPartyVictory("DRRDRDRDRDDRDRDR"));
        System.out.println(new Dota2SenateWinner().predictPartyVictoryLi("DDR"));
    }
    public String predictPartyVictory(String senate) {
        Queue<Integer> q1 = new LinkedList<>(), q2 = new LinkedList<>();
        int n = senate.length();
        for(int i = 0; i<n; i++){
            if(senate.charAt(i) == 'R')q1.add(i);
            else q2.add(i);
        }
        while(!q1.isEmpty() && !q2.isEmpty()){
            int r_index = q1.poll(), d_index = q2.poll();
            if(r_index < d_index)
                q1.add(r_index + n);
            else
                q2.add(d_index + n);
        }
        return (q1.size() > q2.size())? "Radiant" : "Dire";
    }
    public String predictPartyVictoryLi(String senate) {
        int r = 0, d = 0, start = 0;
        char[] arr = senate.toCharArray();
        for (char c : arr) {
            if (c == 'R') r++;
            else d++;
        }

        while (r > 0 && d > 0) {
            while (arr[start] != 'R' && arr[start] != 'D') {
                start = (start + 1) % arr.length;
            }

            char ban = 'R';
            if (arr[start] == 'R') {
                ban = 'D';
                d--;
            }
            else {
                r--;
            }
            int idx = (start + 1) % arr.length;
            while (arr[idx] != ban) {
                idx = (idx + 1) % arr.length;
            }

            arr[idx] = ' ';
            start = (start + 1) % arr.length;
        }

        return d == 0 ? "Radiant" : "Dire";
    }

}
