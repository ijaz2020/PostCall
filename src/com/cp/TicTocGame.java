package com.cp;

public class TicTocGame {
    public static void main(String[] args){
        int[][] A = {{0,0},{1,1},{0,1},{0,2},{1,0},{2,0}};
        System.out.println(tictactoe(A));

    }

    public static String tictactoe1(int[][] moves) {
        int[] aRow = new int[3], aCol = new int[3], bRow = new int[3], bCol = new int[3];
        int  aD1 = 0, aD2 = 0, bD1 = 0, bD2 = 0;
        for (int i = 0; i < moves.length; ++i) {
            int r = moves[i][0], c = moves[i][1];
            if (i % 2 == 1) {
                if (++bRow[r] == 3 || ++bCol[c] == 3 || r == c && ++bD1 == 3 || r + c == 2 && ++bD2 == 3) return "B";
            }else {
                if (++aRow[r] == 3 || ++aCol[c] == 3 || r == c && ++aD1 == 3 || r + c == 2 && ++aD2 == 3) return "A";
            }
        }
        return moves.length == 9 ? "Draw" : "Pending";
    }

    public static String tictactoe(int[][] moves) {
        int n= 3; //Game grid size
        int[] rowSum = new int[n];
        int[] colSum  = new int[n];
        int diagonalSum =0, revDiagonalSum=0;
        for(int i =0; i < moves.length;i++){
            int row = moves[i][0], col=moves[i][1];
            String player; int playerScore;
            if(i%2 ==0){
                player ="A";
                playerScore =1;
            }
            else{
                player = "B";
                playerScore =-1;
            }
            rowSum[row] += playerScore; colSum[col] +=playerScore;
            if(row == col){
                diagonalSum += playerScore;
            }
            if(row+col == n-1){
                revDiagonalSum += playerScore;
            }
            if( Math.abs(rowSum[row]) == 3 || Math.abs(colSum[col]) == 3 || Math.abs(diagonalSum) == 3 || Math.abs(revDiagonalSum) ==3) return player;
        }
        return moves.length == 9 ? "Draw" : "Pending";
    }
}
