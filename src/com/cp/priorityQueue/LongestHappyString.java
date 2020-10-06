package com.cp.priorityQueue;

import java.util.PriorityQueue;

public class LongestHappyString {
  public static void main(String[] args) {
//    System.out.println(new LongestHappyString().longestDiverseString(1, 1, 7));
//    System.out.println(new LongestHappyString().strWithout3a3b(8, 11));
    System.out.println(new LongestHappyString().thousandSeparator(123456789));
    System.out.println(new LongestHappyString().thousandSeparator(1234));
    System.out.println(new LongestHappyString().thousandSeparator(987));
  }

  public String thousandSeparator(int n) {
    String s = new StringBuilder( String.valueOf(n)).reverse().toString();
    StringBuilder sb= new StringBuilder();
    for(String t :s.split("(?<=\\G...)")){
      sb.append(t).append(".");
    }
    return sb.reverse().substring(1, sb.length());
  }

//"bbabbababababababab"
  public String strWithout3a3b(int A, int B) {
    StringBuilder res = new StringBuilder(A + B);
    char a = 'a', b = 'b';
    int i = A, j = B;
    if (B > A) {
      a = 'b'; b = 'a'; i = B; j = A;
    }
    while (i-- > 0) {
      res.append(a);
      if (i > j) {
        res.append(a);
        --i;
      }
      if (j-- > 0)
        res.append(b);
    }
    return res.toString();
  }

  String generate(int a, int b, int c, String aa, String bb, String cc) {
    if (a < b)
      return generate(b, a, c, bb, aa, cc);
    if (b < c)
      return generate(a, c, b, aa, cc, bb);
    if (b == 0)
      return aa.repeat(Math.min(2, a));
    int use_a = Math.min(2, a), use_b = a - use_a >= b ? 1 : 0;
    return aa.repeat(use_a) + bb.repeat(use_b) +
      generate(a - use_a, b - use_b, c, aa, bb, cc);
  }
  public String longestDiverseString(int a, int b, int c) {
    return generate(a, b, c, "a", "b", "c");
  }
}
