package com.hotel;

import java.util.Stack;

public class DecodeStrings {

    public static void main(String arg[]){
        DecodeStrings decodeStrings = new DecodeStrings();
       System.out.println( decodeStrings.decodeString("3[a]2[bc]"));
    }

    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == ']'){
                break;
            }
            else if(Character.isDigit(c)){
                sb.append(decodeString(s.substring(i+2)).repeat(c-'0'));
            }
            else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
        public String decodeString1(String s) {
            String res = "";
            Stack<Integer> countStack = new Stack<>();
            Stack<String> resStack = new Stack<>();
            int idx = 0;
            while (idx < s.length()) {
                if (Character.isDigit(s.charAt(idx))) {
                    int count = 0;
                    while (Character.isDigit(s.charAt(idx))) {
                        count = 10 * count + (s.charAt(idx) - '0');
                        idx++;
                    }
                    countStack.push(count);
                }
                else if (s.charAt(idx) == '[') {
                    resStack.push(res);
                    res = "";
                    idx++;
                }
                else if (s.charAt(idx) == ']') {
                    StringBuilder temp = new StringBuilder (resStack.pop());
                    int repeatTimes = countStack.pop();
                    for (int i = 0; i < repeatTimes; i++) {
                        temp.append(res);
                    }
                    res = temp.toString();
                    idx++;
                }
                else {
                    res += s.charAt(idx++);
                }
            }
            return res;
        }
    }