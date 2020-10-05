package com.hotel;

public class CheckBracesIsReduntant {

    public static void main(String[] a){
        System.out.println(braces("((a + b + c))"));
    }

    public static int braces(String A) {

        int a = 0, b = 0;
        for (int i = 0; i < A.length(); i++)
        {
            if (A.charAt(i) == '(' &&
                    A.charAt(i + 2) == ')')
                return 1;

            if (A.charAt(i) == '*' ||
                    A.charAt(i) == '+' ||
                    A.charAt(i) == '-' ||
                    A.charAt(i) == '/')
                a++;
            if (A.charAt(i) == '(')
                b++;
        }
        if (b > a)
            return 1;
        return 0;
    }
}
