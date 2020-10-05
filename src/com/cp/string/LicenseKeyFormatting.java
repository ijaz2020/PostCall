package com.hotel.string;

import java.util.LinkedList;

public class LicenseKeyFormatting {
  public static void main(String[] args) {
    System.out.println(new LicenseKeyFormatting().licenseKeyFormatting("2-5g-3-J", 2));
  }

  public String licenseKeyFormatting(String S, int K) {
    char[] chars = S.toCharArray();
    int t = K;
    LinkedList<Character> res = new LinkedList<>();
    for(int i = chars.length-1; i >= 0; i--){
      while(K-- >0){
        if(chars[i] != '-'){
          res.addFirst(Character.toUpperCase(chars[i]));
        }
      }
      res.addFirst('-');
      K=t;
    }
    return res.toString();
  }
}
