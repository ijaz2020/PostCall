package com.cp.string.palindrome;

public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(new PalindromeNumber().isPalindrome(456654));
    }

    public boolean isPalindrome(int x) {
        if(x < 0 || ( x != 0 && x %10 == 0) ) return false;
        while(x > 9){
            int p = (int) Math.pow(10, (int)Math.log10(x));
            int f = x / p;;
            int l = x % 10;
            if(f != l){return false;}
            x = x % p;
            x = x /10;
        }
        return true;
    }

}
