package com.cp.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class StoneGame {
  public static void main(String[] args){
    System.out.println();
  }

  public boolean stoneGame(int[] piles) {
    int alex = 0, lee = 0;
    Deque<Integer> deque = new ArrayDeque<>();
    for(int i : piles) deque.offer(i);
    for(int i=0; i<piles.length; i++){
      int score = 0;
      if(deque.size() < 3){
        if(deque.getFirst() > deque.getLast()){
          score += deque.removeFirst();
        }
        else{
          score += deque.removeLast();
        }
      }
      if(i % 2  ==0){

      }
    }
    return false;
  }
}
