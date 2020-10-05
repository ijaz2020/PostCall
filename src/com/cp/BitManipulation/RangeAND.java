package com.cp.BitManipulation;

public class RangeAND {
  public static void main(String[] args) {
    System.out.println(new RangeAND().rangeBitwiseAnd(13, 15));
  }

  public int rangeBitwiseAnd(int m, int n) {
    if(m == 0){
      return 0;
    }
    int moveFactor = 0;
    while(m != n){
      m >>= 1;
      n >>= 1;
      moveFactor++;
    }
    return m << moveFactor;
  }
}
