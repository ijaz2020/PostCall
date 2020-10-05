package com.cp;

public class LexographicallyNext {

    public static String getLexicographicallyGreaterString(String s) {
        char[] w = s.toCharArray();
        int n = w.length;
        int i, j;
        int index = -1, index2 = 0;
        char t;
        StringBuilder result = new StringBuilder();
        for (i = n - 2; i >= 0; i--) {
            if (w[i] < w[i + 1]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return "no answer";
        } else {
            for (j = n - 1; j > index; j--) {
                if (w[j] > w[index]) {
                    index2 = j;
                    break;
                }
            }
            t = w[index];
            w[index] = w[index2];
            w[index2] = t;
            for (i = 0; i <= index; i++) {
                result.append(w[i]);
            }
            StringBuilder x = new StringBuilder();
            for (i = index + 1; i < n; i++) {
                x.append(w[i]);
            }
            result.append(x.reverse().toString());
        }
        return result.toString();
    }

    public static String rearrangeWord(String word) {
        // Write your code here
        StringBuilder sBuilder = new StringBuilder();
        int n = word.length();
        char[] w = word.toCharArray();
        int index=-1;

        for(int i = n-2; i>=0; i++){
            if(w[i] < w[i-1]){
                index =i;
                break;
            }
        }
        if(index == -1){
            return sBuilder.append("no answer").toString();
        }

        return "";

    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        for(int i=1; i<=1; i++)
        {
            String input = "abczyxnm";
            System.out.println(getLexicographicallyGreaterString(input));
//            System.out.println(rearrangeWord(input));
        }
    }
}
