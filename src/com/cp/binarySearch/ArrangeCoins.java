package com.hotel.binarySearch;

public class ArrangeCoins {
  public static void main(String[] args) {
    System.out.println(new ArrangeCoins().mySqrt(2147483647));
    //System.out.println(new ArrangeCoins().arrangeCoins(8));
  }

  public int mySqrt(int x) {
    long l=0, r = (long)x+1;
    while(l < r){
      long m = l + (r-l)/2;
      if(m *m > (long)x){
        r =m;
      }
      else{
        l = m +1;
      }
    }
    return (int)l-1;
  }
  public int arrangeCoins(int n) {
    int l = 1 , r = n, ans =1;
    while(l <= r){
      int m = l + (r-l)/2;
      long k = (m * (m +1))/2;
      if(k <= n){
        ans =m;
        l = m+1;
      }
      else r = m-1;
    }
    return ans;
  }
}
