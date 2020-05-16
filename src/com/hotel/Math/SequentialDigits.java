package com.hotel.Math;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {
  public static void main(String[] args){
    System.out.println(new SequentialDigits().sequentialDigits(1000,13000));
  }

  public List<Integer> sequentialDigits(int low, int high) {
    String l = String.valueOf(low);
    int first = Character.getNumericValue(l.charAt(0)), n = l.length();
    List<Integer> result = new ArrayList<>();
    int curr = low;
    StringBuilder s = new StringBuilder(first+"");
    while(curr <=  high){
      s.append(++first);
      if(s.length() >= n){
        curr = Integer.parseInt(s.toString());
        if(curr <= high)
         result.add(curr);
        s.deleteCharAt(0);
      }
    }

    return result;
  }
}
