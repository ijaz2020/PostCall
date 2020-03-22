package com.hotel.backtracking.bfs;

import java.util.*;

public class OpenLock {
    public static void main(String[] args){
        String[] dead = {"8888"/*"0201","0101","0102","1212","2002"*/};
        System.out.println(new OpenLock().openLock(dead, "0009"));
    }

    public int openLock1(String[] deadends, String target) {
        Queue<String> q = new LinkedList<>();
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        q.offer("0000");
        visited.add("0000");
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                String s = q.poll();
                if(deads.contains(s)) {
                    size --;
                    continue;
                }
                if(s.equals(target)) return level;
                StringBuilder sb = new StringBuilder(s);
                for(int i = 0; i < 4; i ++) {
                    char c = sb.charAt(i);
                    String s1 = sb.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + sb.substring(i + 1);
                    String s2 = sb.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + sb.substring(i + 1);
                    if(!visited.contains(s1) && !deads.contains(s1)) {
                        q.offer(s1);
                        visited.add(s1);
                    }
                    if(!visited.contains(s2) && !deads.contains(s2)) {
                        q.offer(s2);
                        visited.add(s2);
                    }
                }
                size --;
            }
            level ++;
        }
        return -1;
    }
    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        int result = 0; String start= "0000";
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                String current = queue.poll();
                if(current.equals(target)) return result;
                if(!visited.add(current)) continue;
                char[] chars = current.toCharArray();
                for(int i=0; i< 4; i++){
                    char temp = chars[i];
                    chars[i] = (char) (chars[i] == '9'? '0' : chars[i]+1);;
                    queue.offer(String.valueOf(chars));
                    chars[i]= temp;
                    chars[i] = (char) (chars[i] == '0'? '9' : chars[i]-1);
                    queue.offer(String.valueOf(chars));
                    chars[i]= temp;
                }
            }
            result++;
        }
        return -1;
    }
}
