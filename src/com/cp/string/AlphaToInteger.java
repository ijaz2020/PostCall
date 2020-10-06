package com.cp.string;

public class AlphaToInteger {
    public static void main(String[] args){
        System.out.println(freqAlphabets("10#11#12"));
    }
    public static String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        int size = s.length();
        for(int i=0; i< size;i++){
            if(i+2 < size && s.charAt(i+2) == '#'){
                sb.append((char) ((Integer.parseInt(s.substring(i, i+2)) - 1)+ 'a') );
                i=i+2;
            }
            else{
                sb.append( (char) ( (Integer.parseInt(String.valueOf(s.charAt(i))) - 1) + 'a') );
            }
        }
        return sb.toString();
    }
}
