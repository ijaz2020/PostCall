package com.hotel.backtracking;

import javax.ws.rs.core.Link;
import java.util.*;

public class GridIlumination {
    public static void main(String args[]) {
        int n = 5;
        int[][] lamps = {{0, 0}, {0,1},{0, 4}};
        int[][] queries = {{0,0}, {0, 1}, {1,2}};
        GridIlumination g = new GridIlumination();
        System.out.println(Arrays.toString(g.gridIllumination(n, lamps, queries)));
    }

    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        String[][] illuminationGrid = new String[n][n];
        for(String[] i: illuminationGrid)
            Arrays.fill(i, "");

        Set<String> lampSet = new HashSet<>();
        for (int[] lamp : lamps) {
            lampSet.add(lamp[0] + "" +lamp[1]);
            turnOnLamp(illuminationGrid, lamp[0],lamp[1], n, true);
        }
        int[] result = new int[queries.length];
        int index = 0;
        for (int[] query : queries) {
            result[index++] = illuminationGrid[query[0]][query[1]].equals("") ? 0 : 1;
            turnOffLamp(illuminationGrid, query, n, lampSet);
        }
        return result;
    }

    void turnOnLamp(String[][] illuminationGrid, int row, int col, int n, boolean switch1) {
        int diag1 =row+col, diag2 = row-col;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i == row || j ==col || i+j == diag1 || i-j == diag2){
                    if(switch1)
                        illuminationGrid[i][j] = illuminationGrid[i][j].equals("") ? "1" : illuminationGrid[i][j]+"1";
                    else
                        illuminationGrid[i][j] = !illuminationGrid[i][j].equals("") ?
                                illuminationGrid[i][j].substring(0, illuminationGrid[i][j].length()-1) : "";
                }
            }
        }
    }

    void turnOffLamp(String[][] illuminationGrid, int[] query, int n, Set<String> lampSet) {
        int[][] dirs = {{0,0},{1, -1}, {-1, 1}, {1, 1}, {-1, -1}, {0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int row = query[0], col = query[1];
        for (int[] dir : dirs) {
            int row1 = row + dir[0], col1 = col + dir[1];
            if (row1 >= 0 && col1 >= 0 && row1 < n && col1 < n){
                if(lampSet.contains(row1+""+col1)){
                    turnOnLamp(illuminationGrid, row1, col1, n, false);
                }
                /*else{
                    illuminationGrid[row1][col1] = !illuminationGrid[row1][col1].equals("") ?
                            illuminationGrid[row1][col1].substring(0, illuminationGrid[row1][col1].length()-1) : "";
                }*/
            }
        }
    }
}
