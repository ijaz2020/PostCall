package com.cp;

import java.util.Arrays;

public class SortedSquare {

    public static void main(String args[]) {
        SortedSquare s = new SortedSquare();
        int[][] A= {{1,1,0},{1,0,1},{0,0,0}};
//        System.out.println(Arrays.toString(s.sortedSquares(A)));
        System.out.println(Arrays.deepToString(s.flipAndInvertImage(A)));
    }

    public int[] sortedSquares(int[] A) {

        int i = 0, j = 0, t = 0;
        int N = A.length;
        int[] result = new int[N];


        while (j < N && A[j] < 0) {
            j++;
        }
        i = j - 1;

        while (i >= 0 && j < N) {
            if (A[i] * A[i] > A[j] * A[j]) {
                result[t++] = A[j] * A[j];
                j++;
            } else {
                result[t++] = A[i] * A[i];
                i--;
            }
        }

        while (i >= 0) {
            result[t++] = A[i] * A[i];
            i--;
        }


        while (j < N) {
            result[t++] = A[j] * A[j];
            j++;
        }

        return result;
    }

    public int[][] flipAndInvertImage(int[][] A) {

        for(int i=0; i<A.length;i++){
            int k=0,l=A[i].length-1;
            while(k<l){
                swap(k,l,A[i]);
                k++;l--;
            }
            if(k == l){
                A[i][k] = 1 - A[i][k];
            }
        }

        return A;
    }

    private void swap(int a,int b, int[] A){
        int temp=A[a];
        A[a] = A[b];
        A[b] = temp;

        A[a] = 1 - A[a];
        A[b] = 1 - A[b];
    }
}
