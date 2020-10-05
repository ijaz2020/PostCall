package com.cp.backtracking;

import com.cp.Utils.PrintUtils;

import java.lang.reflect.Array;
import java.util.*;

public class ConstructWordUsingDice {

    public static void main(String[] args) {
        ConstructWordUsingDice c = new ConstructWordUsingDice();
        char[][] grid = {
                {'a', 'l', 'c', 'd', 'e', 'f'},
                {'a', 'b', 'c', 'd', 'e', 'f'},
                {'a', 'b', 'c', 'h', 'e', 'f'},
                {'a', 'b', 'c', 'd', 'o', 'f'},
                {'a', 'b', 'c', 'l', 'e', 'f'},};
        char[] pattern = {'h', 'e', 'l', 'l', 'o'};
        Stack<Integer[]> result = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        c.search(grid, pattern, result, visited, 0);
        PrintUtils.printMatrix(result);
    }


    boolean search(char[][] grid, char[] pattern, Stack<Integer[]> result, Set<Integer> visited, int current){
        if(current == pattern.length) return Boolean.TRUE;
        for(int i=0; i<grid.length;i++){
            for(int j=0; j < grid[0].length;j++){
                if(grid[i][j] == pattern[current] && visited.add(i)){
                    result.add(new Integer[]{i,j});
                    if(search(grid, pattern, result, visited, current+1))
                        return Boolean.TRUE;
                    visited.remove(i);
                    result.pop();
                }
            }
        }
        return Boolean.FALSE;
    }

}
