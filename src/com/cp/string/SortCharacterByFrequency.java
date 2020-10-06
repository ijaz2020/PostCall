package com.cp.string;

import java.util.ArrayList;
import java.util.List;

public class SortCharacterByFrequency {
    public static void main(String[] args){
        System.out.println(frequencySort("2a554442f544asfasssffffasss"));
    }
    public static String frequencySort(String s) {
        int[] charMap = new int[256];
        for(int i=0; i< s.length(); i++)
            charMap[s.charAt(i) -' ']++;
        List<StringBuilder> bucket= new ArrayList<>(s.length()+1);
        for(int i=0; i<= s.length(); i++) bucket.add(i,  new StringBuilder() );
        for(int i=0; i< charMap.length;i++){
            int frequency = charMap[i];
            if(frequency > 0){
                bucket.get(frequency).append((char) (i+' '));
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=bucket.size() -1; i>=0; i--){
            if(bucket.get(i).length() >0 ){
                StringBuilder current = bucket.get(i);
                for(int j=0; j <current.length();j++){
                    int freq = i;
                    while(freq-- >0) sb.append(current.charAt(j));
                }
            }
        }
        return sb.toString();
    }
}
