package com.hotel.BitManipulation;

public class HasAllCodes {
  public static void main(String[] args) {
    //s = "00110110", k = 2
    System.out.println(new HasAllCodes().hasAllCodes( "0000000001011100", 4));
  }

  public boolean hasAllCodes(String s, int k) {
    for(int i=0; i<= (2 *k) -1; i++){
      String  c = Integer.toBinaryString(i);
      String res = "0".repeat(k - c.length()) + c;
      if(!s.contains(res)) return false;
    }
    return true;
  }
}
