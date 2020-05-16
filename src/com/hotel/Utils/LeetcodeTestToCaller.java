package com.hotel.Utils;

import java.util.Arrays;

public class LeetcodeTestToCaller {
  //[false,false,false,false,false,false,false,true,true,false,false,true,false,false,false,true,true,true]
  //[false,true,false,false,false,false,false,true,true,false,true,true,false,false,false,true,true,true]
  public static void main(String[] args) {
   String[] method = {"Trie","insert","insert","insert","insert","insert","insert","search","search","search","search","search","search","search","search","search","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith"};
   String[][] params = {{},{"app"},{"apple"},{"beer"},{"add"},{"jam"},{"rental"},{"apps"},{"app"},{"ad"},{"applepie"},{"rest"},{"jan"},{"rent"},{"beer"},{"jam"},{"apps"},{"app"},{"ad"},{"applepie"},{"rest"},{"jan"},{"rent"},{"beer"},{"jam"}};
   for(int i=1; i < method.length; i++){
      StringBuilder sb = new StringBuilder();
      sb.append("m.").append(method[i]).append("(").append(getString(params[i][0])).append(")").append(';');
     System.out.println(sb.toString().replace('[', ' ').replace(']', ' '));
   }
  }

  static String getString(String s){
    return ("\"" +
      s + "\"").strip();
  }
}
