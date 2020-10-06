package com.cp.stack;

public class BackSpaceCompare {
  public static void main(String[] args) {
    System.out.println(new BackSpaceCompare().backspaceCompare("a##c", "#a#c"));
  }

  public boolean backspaceCompare(String S, String T) {
    int i = S.length() - 1, j = T.length() - 1;
    while (true) {
      for (int back = 0; i >= 0 && (back > 0 || S.charAt(i) == '#'); --i)
        back += S.charAt(i) == '#' ? 1 : -1;
      for (int back = 0; j >= 0 && (back > 0 || T.charAt(j) == '#'); --j)
        back += T.charAt(j) == '#' ? 1 : -1;
      if (i >= 0 && j >= 0 && S.charAt(i) == T.charAt(j)) {
        i--; j--;
      } else
        return i == -1 && j == -1;
    }
  }
}
