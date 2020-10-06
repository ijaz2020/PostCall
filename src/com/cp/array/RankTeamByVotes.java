package com.cp.array;

import java.util.*;
import java.util.stream.Collectors;

public class RankTeamByVotes {
    public static void main(String[] args){
        String[] s = {"WXYZ","XYZW"};
        System.out.println(new RankTeamByVotes().rankTeams(s));
    }

    public String rankTeams1(String[] votes) {
        Map<Character, int[]> map = new HashMap<>();
        int l = votes[0].length();
        for(String vote : votes){
            for(int i = 0; i < l; i++){
                char c = vote.charAt(i);
                map.putIfAbsent(c, new int[l]);
                map.get(c)[i]++;
            }
        }

        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> {
            for(int i = 0; i < l; i++){
                if(map.get(a)[i] != map.get(b)[i]){
                    return map.get(b)[i] - map.get(a)[i];
                }
            }
            return a - b;
        });

        StringBuilder sb = new StringBuilder();
        for(char c : list){
            sb.append(c);
        }
        return sb.toString();
    }
    public String rankTeams(String[] votes) {
        Map<Character, int[]> rankMap = new HashMap<>();
        int rank = votes[0].length();

        for(String s : votes){
            for(int i =0; i < s.length(); i++){
                char c = s.charAt(i);
                rankMap.putIfAbsent(c , new int[rank]);
                rankMap.get(c)[i]++;
            }
        }

        List<Character> participantList = new ArrayList<>(rankMap.keySet());

        Collections.sort( participantList, (a , b) ->{
            for(int i=0; i< rank; i++){
                if(rankMap.get(a)[i] != rankMap.get(b)[i])
                    return rankMap.get(b)[i] - rankMap.get(a)[i] ;
            }
            return b-a;
        });
        return participantList.stream().map(String::valueOf).collect(Collectors.joining());
    }
    public int[] smallerNumbersThanCurrent_treeMap(int[] nums) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>(); //O(nlogn)
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int[] res = new int[nums.length];
        int rank = 0;
        for (Map.Entry<Integer, List<Integer>> ent : map.entrySet()) {
            List<Integer> cur = ent.getValue();
            for (int v : cur) {
                res[v] = rank;
            }
            rank += cur.size();
        }

        return res;
    }
}
