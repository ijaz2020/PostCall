package com.hotel.string;

public class BalancedStringSplit {

    public static void main(String arg[]){
        BalancedStringSplit b = new BalancedStringSplit();
        System.out.println(b.balancedStringSplit1("RLRRLLRLRL"));
    }
    public int balancedStringSplit(String s) {

        int count=1, out =0;
        char curr = s.charAt(0);
        for(int i=1; i<s.length();i++){

            if(s.charAt(i) == curr){
                count++;
            }else{
                count--;
            }
            if(count == 0){
                out++;
                i =i+1;
                if(i<s.length()){
                    count++;
                    curr = s.charAt(i);
                }
            }
        }
        return out;
    }
    public int balancedStringSplit1(String s) {
        int res = 0, cnt = 0;
        for (int i = 0; i < s.length(); ++i) {
            cnt += s.charAt(i) == 'L' ? 1 : -1;
            if (cnt == 0) ++res;
        }
        return res;
    }
}
