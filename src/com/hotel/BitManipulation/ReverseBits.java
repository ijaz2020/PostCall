package com.hotel.BitManipulation;

public class ReverseBits {
  public static void main(String[] args) {
    System.out.println(new ReverseBits().reverseBits(964176192));
  }
//   964176192 (00111001011110000010100101000000)
  public int reverseBits(int n) {
    int res = 0;
    for (int i = 0; i < 32; i++) {
      res <<= 1;
      res |= (n & 1);
      n >>= 1;
    }
    return res;
  }
}
