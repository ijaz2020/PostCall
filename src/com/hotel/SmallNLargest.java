package com.hotel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class SmallNLargest {
    public static String getSmallestAndLargest(String s, int k) {
        String curr = "hello";
        System.out.println(curr.compareTo("java"));
        return "";
    }

    public static void main(String[] largest){
//        getSmallestAndLargest("welcometojava", 3);
        Pattern p = Pattern.compile("az");
        String str = "^((0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)\\.){3}(0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)$";
        System.out.println(p);

        List<BigDecimal> b = new ArrayList<>();
        BigDecimal n= new BigDecimal("");
    }

}
