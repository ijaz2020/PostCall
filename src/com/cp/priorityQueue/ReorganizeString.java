package com.hotel.priorityQueue;

import java.util.PriorityQueue;

public class ReorganizeString {
    public static void main(String[] args){
        System.out.println(new ReorganizeString().reorganizeString("aaaaaabbbbcccddeef"));
    }
    public String reorganizeString(String S) {
        int n = S.length();
        int[] charMap = new int[26];
        for(int i=0; i < n;i++){
            charMap[S.charAt(i) - 'a']++;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a , b) -> b[1] - a[1]);
        for(int i=0; i< 26;i++){
            pq.offer(new int[]{i, charMap[i]});
        }
        if( pq.peek()[1] > (n+1)/2 ) return "";

        StringBuilder sb = new StringBuilder();
        int[] prev = {0,0};
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            if(curr[1] == 0) break;
            sb.append( (char)(curr[0] + 'a'));
            pq.offer(prev);
            --curr[1];
            prev = curr;
        }

        return sb.toString();
    }
    public String reorganizeString1(String S) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        int[] m = new int[26];
        for(int i = 0; i < S.length(); i++)
            m[S.charAt(i) - 'a']++; // map of char counts

        for(int i = 0; i < 26; i++) {
            if(m[i] != 0) {
                q.offer(new int[] {i, m[i]}); // add char counts to priority queue
            }
        }

        int[] prev = new int[] {-1,0};
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if(prev[1] > 0)
                q.offer(prev); // add back last used character

            sb.append((char)(cur[0] + 'a')); // append current character
            cur[1]--; // decrease count of current char since it's used
            prev = cur; // set this character as previous used
            if(q.isEmpty() && prev[1] > 0)
                return ""; // if we left with anything return ""
        }
        return sb.toString();
    }
}
