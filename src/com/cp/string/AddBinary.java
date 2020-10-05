package com.cp.string;

public class AddBinary {
  public static void main(String[] args) {
    System.out.println(new AddBinary().addBinary("11", "1"));
  }

  public String addBinary(String a, String b) {
    int m = a.length(), n = b.length(), carry =0;
    StringBuilder sb = new StringBuilder();
    for(int i=m-1, j=n-1; i>=0 || j >=0|| carry == 1; i--, j--){
      int x = i>=0 ? a.charAt(i) -'0' : 0;
      int y = j>=0 ? b.charAt(j) -'0' : 0;
      int sum = x + y + carry;
      sb.append(sum%2);
      carry = sum/2;
    }
    return sb.reverse().toString();
  }
}
