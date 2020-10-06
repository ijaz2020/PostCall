package com.cp.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MagicNumbersCodeForces {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            String s1 = "414";
    String s1 = br.readLine();

    int num = Integer.parseInt(s1);

    while(String.valueOf(num).length() != 1) {
      if (num % 1000 == 144) {
        num = num / 100;
      } else if (num % 100 == 14) {
        num = num / 100;
      } else if (num % 10 == 1) {
        num = num / 10;
      }
      else{
        System.out.println("NO");
        return;
      }
    }
    if(num > 1 && num <11){
      System.out.println("NO");
      return;
    }
    System.out.println("YES");
  }

}
