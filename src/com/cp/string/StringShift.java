package com.cp.string;

public class StringShift {
  public static void main(String[] args) {
    int[][] shift = {{0,1},{0,1},{1,2},{0,3}};

    System.out.println(new StringShift().stringShift("abcdefg", shift));
    /*
    defgabc
    */
  }

  public String stringShift(String s, int[][] shift) {
    int total =0, n =s.length(), N= shift.length;
    for(int[] i : shift)
      total += i[0] == 0 ? -1 * i[1] : i[1];
    int k = total % n;
    char[] chars = s.toCharArray();
    reverse(chars, 0, n-1);
    reverse(chars, 0, k<0 ? n+k-1 : k-1);
    reverse(chars, k<0 ? n+k : k, n-1);
    //reverse(chars, 0, n-k-1);
    //reverse(chars, n-k, n-1);
    return new String(chars);
  }

  private void reverse(char[] chars, int i, int j){
    while(i <j){
      char temp = chars[i];
      chars[i++] =chars[j];
      chars[j--] = temp;
    }
  }
}
