package com.hotel.array;
import com.hotel.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
public class AngryNeighboursAmazon {
    public static void main(String args[]){
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque();

        int[] a = {1,0,0,0,0,1,1,0};
        System.out.println(cellCompete(a, 1));
    }            //  0 1 2 3 4 5 6 7
        // actual - [[0 1 0 0 1 1 1 1]]
       // expected - 0 1 0 0 1 0 1 0
        public static List<Integer> cellCompete(int[] states, int days)
        {
            while(days-- >0){
                int prev = -1, next = prev +2, n = states.length;
                int[] result = new int[n];
                for(int i = 0; i< states.length;i++){
                    if( (prev < 0 ? 0 : states[prev]) == (next > 7 ? 0 : states[next]) ) result[i]=0;
                    else result[i] =1;
                    prev++;next++;
                }
                states = result;
            }
            ArrayList<Integer> result = new ArrayList<>();
            for(int i: states) result.add(i);
            return result;
        }
}
