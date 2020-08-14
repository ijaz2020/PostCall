package com.hotel.binarySearch;

public class KokoEatingBananas {
  public static void main(String[] args) {
/*
    [312884470]
    312884469
*/

    int[] piles = {312884470};
    System.out.println(new KokoEatingBananas().minEatingSpeed(piles, 312884469));
  }

  public int minEatingSpeed(int[] piles, int H) {
    int l = 1, r = piles[0];
    for(int i : piles){
      r = Math.max(r, i);
    }
    while( l < r){
      int m = l + (r-l)/2;
      if(isValid(piles, m, H)){
        r = m;
      }
      else{
        l = m+1;
      }
    }
    return l;
  }

  boolean isValid(int[] p, int m, int h){
    int count = 0, n =p.length;
    for(int i: p){
      count += i/m + (i%m >0 ? 1: 0);
    }
    return count <=h;
  }
}
