package com.cp.string;

public class StepsStringToOne {
  public static void main(String[] args) {
    System.out.println(new StepsStringToOne().numSteps("1101"));
  }

  public int numSteps(String s) {
    int res = 0;
    while(!s.equals("1")){
      int n = s.length() -1;
      if(s.charAt(n) == '1') s = add1(s);
      else s = divide2(s);
      res++;
    }
    return res;
  }

  private String add1(String s){
    StringBuilder res = new StringBuilder();
    int carry =0; String o = "1";
    for(int i=s.length()-1, j = 0; i>=0 || j >= 0 || carry == 1; i--, j--){
      int a = (i >=0 && s.charAt(i) == '1') ? 1 : 0;
      int b = (j >=0 && o.charAt(j) == '1') ? 1 : 0;
      int sum = a+b+carry;
      res.append(sum%2);
      carry = sum/2;
    }
    return res.reverse().toString();
  }

  private String divide2(String s){
    return s.substring(0, s.length()-1);
  }
}
