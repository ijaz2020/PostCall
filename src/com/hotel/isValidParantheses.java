package com.hotel;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static com.hotel.Trie.c;

public class isValidParantheses {

    class Solution {
        public boolean isValid(String s) {
            Map<Character, Character> map = new HashMap<Character, Character>() {{
                put(']', '[');
                put(')', '(');
                put('}', '{');
            }};

            Stack<Character> stack = new Stack<>();
            for(char c : s.toCharArray()){
                if(!map.containsKey(c)){
                    stack.push(c);
                }
                else{
                    if(! (map.get(c) == stack.peek()))
                        return false;
                    stack.pop();
                }
            }
            return true;
        }
    }
}
