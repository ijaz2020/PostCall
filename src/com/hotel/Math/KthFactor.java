package com.hotel.Math;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class KthFactor {
  public static void main(String[] args) {
//    System.out.println(new KthFactor().kthFactor(24, 6));
    Object[] obs = new Object[0];
    System.out.println(londonCityHacker(obs));
  }

  public static String londonCityHacker(Object[] journey) {
    //code me up baby!
    BigDecimal total = new BigDecimal("0"), tube = new BigDecimal("2.40"),
      bus = new BigDecimal("1.50"), last = new BigDecimal("0");
    total = total.setScale(2, BigDecimal.ROUND_HALF_EVEN);
    for(Object obj : journey){
      if(obj instanceof String ){
        total = total.add(tube);
        last = tube;
      }
      else{
        if(!last.equals(bus)){
          total = total.add(bus);
          last = bus;
        }
        else{
          last = new BigDecimal("0");
        }
      }
    }
    return "£"+(total);
  }

  public int kthFactor(int n, int k) {
    int cnt = 0;
    List<Integer> l = new ArrayList<>();
    for(int i = 1; i * i <= n; i++) {
      if (n % i == 0) {
        if (i * i != n)
          l.add(n / i);
        if (++cnt == k)
          return i;
      }
    }
    if (l.size() + cnt < k)
      return -1;
    return l.get(l.size() - (k - cnt));
  }
}
