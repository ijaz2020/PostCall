package com.cp.Utils;

import com.cp.LinkedList.ListNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintUtils {

    public static void printMatrix(char[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static <T> void printMatrix(T[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static <T> void printMatrix(List<T[]> matrix){
        for (int i = 0; i < matrix.size(); i++) {
            System.out.print(Arrays.deepToString(matrix.get(i)));
        }
        System.out.println();
    }
    public static <T> void printMatrix(Queue<T[]> matrix){
        Queue<T[]> clone = new LinkedList<>(matrix);
        for (int i = 0; i < clone.size(); i++) {
            System.out.print(Arrays.deepToString(clone.poll()));
        }
        System.out.println();
    }

    public static String get2DArrayPrint(char[][] matrix) {
        String output = new String();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                output = output + (matrix[i][j] + "\t");
            }
            output = output + "\n";
        }
        return output;
    }

    public static String get2DArrayPrint(String[][] matrix) {
        String output = new String();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                output = output + (matrix[i][j] + "\t");
            }
            output = output + "\n";
        }
        return output;
    }

    public static String get2DArrayPrint(int[][] matrix) {
        String output = new String();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                output = output + (matrix[i][j] + "\t");
            }
            output = output + "\n";
        }
        return output;
    }

    public static String get2DArrayPrint(boolean[][] matrix) {
        String output = new String();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                output = output + (matrix[i][j] + "\t");
            }
            output = output + "\n";
        }
        return output;
    }

    public static String get2DArrayPrint(int[] matrix) {
        String output = new String();
        for (int i = 0; i < matrix.length; i++) {
                output = output + (matrix[i] + " ");
            output = output + " ";
        }
        return output;
    }

    public static String getArrayPrint(char[] matrix) {
        String output = new String();
        for (int i = 0; i < matrix.length; i++) {
            output = output + (matrix[i] + " ");
            output = output + " ";
        }
        return output;
    }
    public static String getArrayPrint(boolean[] matrix) {
        String output = new String();
        for (int i = 0; i < matrix.length; i++) {
            output = output + (matrix[i] + " ");
            output = output + " ";
        }
        return output;
    }

    public static String getLinkedList(ListNode node){
        StringBuilder sb = new StringBuilder();
        while (node != null){
            sb.append(node.val).append("->");
            node = node.next;
        }
        return sb.toString();
    }

}
