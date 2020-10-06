package com.cp.string;

import java.util.*;

public class WeakestRow {

    public static void main(String[] args){
        int[][] mat =
                {
                        {1,1,1,0,0,0,0},
                        {1,1,1,1,1,1,0},
                        {0,0,0,0,0,0,0},
                        {1,1,1,0,0,0,0},
                        {1,1,1,1,1,1,1}};
        System.out.println(Arrays.toString(new WeakestRow().kWeakestRows(mat, 4)));
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        Map<Integer, Integer> weakMap = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue().equals(b.getValue()) ? a.getKey() - (b.getKey()) : a.getValue() - b.getValue() );

        for(int i=0; i<mat.length; i++){
            int count =0;
            for(int j=0; j<mat[0].length;j++){
                if(mat[i][j] == 1) count++;
            }
            weakMap.put(i, count);
        }
        for(Map.Entry<Integer, Integer> entry : weakMap.entrySet()) pq.offer(entry);

        int[] out = new int[k];
        for(int i=0; i< k;i++) {
            Map.Entry<Integer, Integer> entry = pq.poll();
            out[i] =entry.getKey();
        }
        return out;
    }

    public int[] sortByBits(int[] arr) {
        List<int[]> pq = new ArrayList<>();
        Collections.sort(pq, (a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0]- b[0]);
        for(int i=0; i<arr.length; i++){
            int count = calcualte1Bit(arr[i]);
            pq.add(new int[]{count, arr[i], i});
        }
        int[] result = new int[arr.length]; int index = 0;
        for (int[] i : pq)
            result[index++] = i[1];

        return result;
    }

    private int calcualte1Bit(int n){
        int count = 0;
        while(n != 0){
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}
