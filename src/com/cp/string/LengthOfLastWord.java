package com.cp.string;

public class LengthOfLastWord {
    public static void main(String[] args) {
        System.out.printf(""+new LengthOfLastWord().lengthOfLastWord("Hello World"));
    }
    public int lengthOfLastWord(String s) {
        int res = 0;
        boolean noCharFound = true;
        for(int i=s.length()-1; i>=0 && (noCharFound || s.charAt(i) !=' '); i--, res++){
            if(s.charAt(i) != ' ' && noCharFound){
                noCharFound = false;
                res = 0;
            }
        }
        return res;
    }
}
