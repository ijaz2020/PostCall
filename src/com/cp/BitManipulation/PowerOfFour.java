package com.cp.BitManipulation;

public class PowerOfFour {
  public static void main(String[] args) {
    System.out.println(new PowerOfFour().isPowerOfFour(-2147483648));
  }

  public boolean isPowerOfFour(int n) {
    int zero = 0, one = 0;
    while(n != 0){
      if( (n & 1) ==1){
        one++;
      }
      else zero++;
      n >>=1;
    }
    return one == 1 && (zero & 1) == 0;
  }
}
