package com.hotel.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RevealDeck {
    public static void main(String[] args){
        RevealDeck r = new RevealDeck();
        int[] nums = {17,13,11,2,3,5,7};
        r.deckRevealedIncreasing(nums);
    }

    public int[] deckRevealedIncreasing(int[] deck) {
        int n= deck.length;
        Arrays.sort(deck);
        Queue<Integer> q= new LinkedList<>();
        for (int i=0; i<n; i++) q.add(i);
        int[] res= new int[n];
        for (int value : deck) {
            res[q.poll()] = value;
            q.add(q.poll());
        }
        return res;
    }

}
