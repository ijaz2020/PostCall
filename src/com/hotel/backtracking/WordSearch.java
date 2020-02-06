package com.hotel.backtracking;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordSearch {
    public static void main(String[] args){
        char[][] board ={
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

        System.out.println(new WordSearch().exist(board, "ABCCEDAS"));
    }

    public boolean exist(char[][] board, String word) {
        int m= board.length, n = board[0].length, seqCount =0;
        if(word.length() == 0) return Boolean.FALSE;
        for(int i=0; i<m;i++){
            for(int j=0; j<n;j++){
                if(board[i][j] == word.charAt(seqCount)){
                    if(checkNeighbours(board, i, j, seqCount, word))
                        return Boolean.TRUE;
                }
            }
        }
        return Boolean.FALSE;
    }

    boolean checkNeighbours(char[][] board, int i, int j, int seqCount, String word){
        if(seqCount == word.length()) return true;
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || word.charAt(seqCount) != board[i][j]) return false;

        int[][] dirs  = {{0,1} , {1,0}, {-1,0}, {0, -1}};
        ++seqCount;
        board[i][j] ^= 256;
        for(int[] dir: dirs){
            if(checkNeighbours(board, dir[0] + i, dir[1] + j, seqCount, word))
                return true;
        }
        board[i][j] ^= 256;
        return false;
    }
}
