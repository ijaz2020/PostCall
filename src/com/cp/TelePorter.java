package com.hotel;

import java.util.*;

public class TelePorter {

    public static void main(String[] arg){
        int[][] arr = {{1,2},{1,3},{ 2 ,5}, {4,3},{3,4},{5,6},{4,6}};
        System.out.println(Arrays.toString(findOrder(arr, 6)));
    }

    private static int[] findOrder(int[][] arr, int n){
        int[] order = new int[n];
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        for (int i=1;i<=n;i++)
            inDegree.put(i, 0);
        for (int i=0;i<n;i++)
            inDegree.put(arr[i][1], inDegree.getOrDefault(arr[i][1], 0) +1);
        Queue<Integer> queue = new LinkedList<>();int index=0;
        for(Map.Entry<Integer, Integer> entry : inDegree.entrySet()){
            if(entry.getValue() == 0) {
                order[index++] = entry.getKey();
                queue.offer(entry.getKey());
            }
        }

        while ( !queue.isEmpty()){
            int sortedEdge = queue.poll();
            for(int i=0;i<arr.length;i++){
                if(arr[i][0] == sortedEdge){
                    inDegree.put(arr[i][1], inDegree.get(arr[i][1]) -1);
                    if(inDegree.get(arr[i][1]) == 0){
                        order[index++] = arr[i][1];
                        queue.offer(arr[i][1]);
                    }
                }
            }
        }
        return index == n ? order : new int[]{};
    }
}
