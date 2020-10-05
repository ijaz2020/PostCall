package com.cp.BitManipulation;

import com.cp.Utils.PrintUtils;

import java.util.HashSet;
import java.util.Set;

public class MagicSquare {
    public static void main(String args[]){
        int[][] square = new int[3][3];
        new MagicSquare().fillMagicSquare(square);
        PrintUtils.printMatrix(square);
    }

    void fillMagicSquare(int[][] square){
        Set<Integer> addedNumbers = new HashSet<>();
        doSolve(square, 0, 0, addedNumbers);
    }

    boolean doSolve(int[][] square, int row, int col, Set<Integer> addedNumbers){
        for(int i=row; i<square.length;i++, col=0){
            for(int j=col; j < square.length;j++){
                for(int k=1; k<=9;k++){
                    if(addedNumbers.add(k)){
                        square[i][j] = k;
                        if(doSolve(square, i, j+1, addedNumbers)) return true;
                        square[i][j] =0;
                        addedNumbers.remove(k);
                    }
                }
                return false;
            }
        }
        return true;
    }
}
