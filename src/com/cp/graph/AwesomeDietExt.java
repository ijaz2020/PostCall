package com.cp.graph;

import java.util.*;

public class AwesomeDietExt {
    public static void main(String[] args){
        List<String> dietList = new ArrayList<>();
        dietList.add("abcd");
        dietList.add("de");
        dietList.add("ef");
        dietList.add("ghijk");
        System.out.println(Arrays.toString(new AwesomeDietExt().findConnectedDiet(dietList, 11)));
    }

    void appendParent(Map<Character, Character> parentMap, Character parent, char[] chars){
        for (int i=1; i<chars.length;i++) parentMap.put(chars[i], parent);
    }
    String[] findConnectedDiet(List<String> dietList, int n){
        Map<Character, Character> parentMap = new HashMap<>();
        for (char c= 'a'; c<'a'+n;c++) parentMap.put(c, c);
        for (String s : dietList){
            char[] chars = s.toCharArray();
            char parent = findParent(parentMap, chars[0]);
            appendParent(parentMap, parent, chars);
        }
        return makeResultString(parentMap, n);
    }
    Character findParent(Map<Character, Character> parentMap, Character c){
        if(parentMap.get(c) == c ) return c;
        parentMap.put(c, parentMap.get(c));
        return parentMap.get(c);
    }


    String[] makeResultString(Map<Character, Character> parentMap, int n){
        String[] result = new String[n];
        for(Character c: parentMap.keySet()){
            if(c == parentMap.get(c))
                result[c -'a'] =  String.valueOf(c);
            else result[parentMap.get(c) -'a'] +=  String.valueOf(c);
        }
        int index=0;
        for (String s: result)
            if(s !=null)result[index++] = s;
        return Arrays.copyOf(result,  index);
    }
}
