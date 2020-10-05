package com.hotel.Utils;

import java.util.Arrays;

public class LeetcodeTestToCaller {
  //[false,false,false,false,false,false,false,true,true,false,false,true,false,false,false,true,true,true]
  //[false,true,false,false,false,false,false,true,true,false,true,true,false,false,false,true,true,true]
  public static void main(String[] args) {
   String[] method ={"ThroneInheritance", "birth", "birth", "birth", "birth", "birth", "birth", "getInheritanceOrder", "death", "getInheritanceOrder"};
   String[][] params = {{"king"}, {"king", "andy"}, {"king", "bob"}, {"king", "catherine"}, {"andy", "matthew"}, {"bob", "alex"}, {"bob", "asha"}, {null}, {"bob"}, {null}};
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
