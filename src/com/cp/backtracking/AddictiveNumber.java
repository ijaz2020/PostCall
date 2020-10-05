package com.cp.backtracking;

public class AddictiveNumber {
  public static void main(String[] args) {
    System.out.println(new AddictiveNumber().isAdditiveNumber("2314"));
  }

  String num = "";
  int n=0;
  public boolean isAdditiveNumber(String num1) {
    num = num1;
    n = num.length();
    if(n < 3) return false;
    for(int i=0; i<n-2; i++){
      for(int j=i+1; j<n-1; j++){
        String n1 = num.substring(0, i+1);
        String n2 = num.substring(i+1, j+1);
        if( (n1.length() == 1 || n1.charAt(0) != '0') && (n2.length() == 1 || n2.charAt(0) != '0')){
          boolean res = dfs(num.substring(0, i+1), num.substring(i+1, j+1), j+1);
          if(res) return res;
        }
      }
    }
    return false;
  }

  boolean dfs(String n1, String n2, int end){
    String n3 = String.valueOf(Integer.parseInt(n1) + Integer.parseInt(n2));
    return end == n || ( end+n3.length() <= n && n3.equals( num.substring(end, end+n3.length())) && dfs(n2, n3, end+n3.length()));
  }
}
