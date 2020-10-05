package com.cp.string;

public class NumberOfWaysStringtoThreeSubString {
  public static void main(String[] args) {
    System.out.println(new NumberOfWaysStringtoThreeSubString().numWays("100100010100110"));
  }

  public int numWays(String s) {
    int count =0, n =s.length();
    long res=1l;
    for(int i=0; i<n; i++){
      if(s.charAt(i) == '1') count++;
    }
    if(count % 3 != 0) return 0;
    int div = count/3, p =-1, c = 0;
    for(int i=0; i<n; i++){
      if(s.charAt(i) == '1'){
        c++;
      }
      if(c % div ==0){
        p =i;
      }
      if(c % div ==1 && p!=-1){
        res *= i-p;
      }
    }

    return (int)(res % (int)1e9+7);
  }
}
