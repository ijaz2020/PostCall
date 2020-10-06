package com.cp.string;

import java.util.IntSummaryStatistics;
import java.util.StringTokenizer;

public class ReverseWords {
  public static void main(String[] args) {
    IntSummaryStatistics intSummaryStatistics = new IntSummaryStatistics();
    intSummaryStatistics.accept(1);
    intSummaryStatistics.accept(2);
    intSummaryStatistics.accept(3);
    System.out.println(intSummaryStatistics.getMin());
    System.out.println(intSummaryStatistics.getSum());
    System.out.println(new ReverseWords().reverseWords("  hello    world!  "));
  }

  public String reverseWords(String s) {
    StringTokenizer st = new StringTokenizer(s, " ");
    StringBuilder sb = new StringBuilder();
    while (st.hasMoreTokens()){
      sb.insert(0, st.nextToken()+" ");
    }
    return sb.toString().trim();
  }

}
