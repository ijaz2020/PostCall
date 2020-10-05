package com.cp;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RemoveParantheses {

    public static void main(String arg[]){
        RemoveParantheses removeParantheses = new RemoveParantheses();
//        System.out.println(removeParantheses.removeOuterParentheses("(()())(())(()(()))"));
        System.out.println(removeParantheses.selfDividingNumbers(70, 708));
    }
    public String removeOuterParentheses(String S) {
        String result="";
        Stack<Character> stack = new Stack<>();

        for(int i=0; i < S.length(); i++){
            if(stack.size() == 0 && S.charAt(i) == '('){
                stack.push(S.charAt(i));
            }

            else if(stack.size() == 1 && S.charAt(i) == ')'){
                stack.pop();
            }
            else{
                if(S.charAt(i) == ')'){
                    stack.pop();
                }
                else{
                    stack.push(S.charAt(i));
                }
                result += S.charAt(i);
            }
        }

        List<Integer> list = new ArrayList<>();

        return result;
    }

    public List<Integer> selfDividingNumbers(int left, int right) {

        List<Integer> list = new ArrayList<>();
        for(int i=left; i<=right;i++){
            list.add(i);
        }

        for(int i=left; i<=right;i++){

            int count = i;
            /*if(count%10 ==0){
                list.remove((Integer)i);
                continue;
            }*/
            System.out.println(i);
            while( count>0  ){
                int remainder = count%10;
                if(remainder ==0 || i %remainder !=0){
                    list.remove((Integer)i);
                    break;
                }
                count = count/10;
            }
        }

        return list;
    }
}
