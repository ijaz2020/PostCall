package com.hotel.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class GenerateParanthesisScore {
    public static void main(String[] args){
        Map<Integer, Integer> map = new HashMap<>();
        map.replace(1, 2);
        System.out.println(scoreOfParentheses("(()(()))"));
    }

    public static int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<>();
        int cur = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push(cur);
                cur = 0;
            } else {
                cur = stack.pop() + Math.max(cur * 2, 1);
            }
        }
        return cur;
    }

}
