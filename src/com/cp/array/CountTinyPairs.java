package com.cp.array;

public class CountTinyPairs {
    public static void main(String[] args){
        int[] a= {1,2,3};
        int[] b= {1,2,3};
        System.out.println(new CountTinyPairs().countTinyPairs(a, b, 31));
    }

    int countTinyPairs(int[] a, int[] b, int k) {
        int result = 0, n = a.length, j =n-1;
        for(int i=0; i<n ;i++, j--){
            if(Integer.parseInt(a[i]+""+b[j]) < k) result++;
        }
        return result;
    }
}
