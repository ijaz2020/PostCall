package com.hotel.combinatrics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutation {
  public static void main(String[] args) {
    List<String> res = new ArrayList<>();
    new Permutation().permutationString("HIK", "", 0, res);
    // HIK
    // IHK
    // KHI
    System.out.println(res);
  }
  
  void permutationString(String s, String curr, int i, List<String> res){
    if(curr.length() == s.length()){
      res.add(curr);
    }
    for(int j=i; j<s.length(); j++){
      permutationString(s, curr + s.charAt(j), j+1, res);
    }
  }
}
