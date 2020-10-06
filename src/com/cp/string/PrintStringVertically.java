package com.cp.string;

import java.util.ArrayList;
import java.util.List;

public class PrintStringVertically {
    public static void main(String[] args){
        System.out.println(new PrintStringVertically().printVertically("TO BE OR NOT TO BE"));
    }

    public List<String> printVertically(String s) {
        String[] splitString = s.split(" ");
        int max = 0;
        for(String str : splitString) max = Math.max(max ,str.length());
        List<String> result = new ArrayList<>();
        for(int i=0; i< max;i++){
            StringBuilder current = new StringBuilder();
            for(String str: splitString){
                current.append(i > str.length() -1 ? " " : str.charAt(i));
            }
            result.add(current.toString().stripTrailing());
        }
        return result;
    }
}
