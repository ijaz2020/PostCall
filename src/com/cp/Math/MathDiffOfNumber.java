package com.hotel.Math;

public class MathDiffOfNumber {
  public static void main(String[] args) {
    /*Input:
    1101057
    Output:
    8808000
    Expected:
    8808050*/
    System.out.println(new MathDiffOfNumber().maxDiff(1101057 ));
  }

  int maxDiff(int nums){
    String n = String.valueOf(nums);
    String max = n, min = n;

    for ( char c: n.toCharArray()){
      if(c != '9'){
        max = n.replaceAll(c+"", "9");
        break;
      }
    }

    if(n.charAt(0) != '1'){
      min = n.replaceAll(n.charAt(0)+"", "1");
    }
    else{
      for(char c : n.toCharArray()){
        if(c != '1' && c != '0'){
          min = n.replaceAll(c+"", "0");
          break;
        }
      }
    }
    return Integer.parseInt(max) - Integer.parseInt(min);
  }
}
