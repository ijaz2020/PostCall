package code;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;

public class NewYearCandies {
    public static int[][] colWiseSum = {
            {1, -1, -1, 2, 1, -1}, //sweet
            {2, -1, -1, 2, -1, 3} //bitter
    };


    public static int[][] rowWiseSum = {
            {2, 3, -1, -1, -1}, //sweet
            {-1, -1, -1, 1, -1} //bitter
    };

    public static int m = 5;
    public static int n = 6;
    public static char[][] bar;
    public static ArrayList<Pattern> patterns;
    public static boolean[] sweetFirst = {true, false};

    public static void printMatrix(char[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {

        Pattern hoizontalPatter = new HorizontalPattern();
        Pattern verticalPattern = new VerticalPattern();
        Pattern emptyPattern = new EmptyPattern();
        patterns = new ArrayList<>();
        patterns.add(hoizontalPatter);
        patterns.add(verticalPattern);
        patterns.add(emptyPattern);
        bar = new char[m][n];

        for (char[] a : bar) {
            Arrays.fill(a, 'E');
        }
        fillCandy();
        printMatrix(bar);

    }

    public static void fillCandy() {
//         for(int i=0; i<m ;i++) {
//             for(int j=0;j<n;j++) {

        fillCandyUtil(0, 0);
//
//             }
//         }
    }

    public static void fillCandyUtil(int i, int j) {
        //System.out.println("NewYearCandies.fillCandyUtil "+ i+ " "+ j );
        printMatrix(bar);
        System.out.println("\n\n\n");


        Pair<Integer, Integer> next_coord = new Pair<>(0, 0);
        if (i < 0 && j < 0) {
            System.out.println("reached last");

            printMatrix(bar);
            System.exit(0);
            //  return;
        }


       /* if(isfeasible(i,j)) {
        next_coord = getNextEmptyCoordinate(i, j);
        fillCandyUtil(next_coord.getKey(), next_coord.getValue());
        }*/


        for (Pattern p : patterns) {
            if (p.isPossible(bar, i, j, m, n)) {
                for (boolean isSweetFirst : sweetFirst) {
                    p.put(bar, i, j, isSweetFirst);
                    if (!isfeasible(i, j, p.getType())) {
                        System.out.println("Not feasible");
                        p.revert(bar, i, j);
                        continue;
                    }

                    next_coord = getNextEmptyCoordinate(i, j);
                    System.out.println("next (" + i + " , " + j + ") => " + next_coord.getKey() + " " + next_coord.getValue());

                    if (next_coord.getKey() != -1 || next_coord.getValue() != -1) {
                        fillCandyUtil(next_coord.getKey(), next_coord.getValue());
                    }
                    else{
                        System.out.println("Final solution \n\n\n");
                        printMatrix(bar);
                        System.exit(0);
                    }
                    p.revert(bar, i, j);
                }
            }
        }
        return;
    }


    public static boolean isfeasible(int r, int c, int type) {
        int r1 = r, c1 = c;

        switch (type) {
            case 0:
                break;
            case 1:
                c1 += 1;
                break;
            case 2:
                r1 += 1;
                break;
            default:
                break;
        }


        if (type == 1) {
            return (isfeasibleRowwise(r, c) && isfeasibleRowwise(r, c1));

        } else if (type == 2) {
            return (isfeasibleRowwise(r, c) && isfeasibleRowwise(r1, c));
        } else {
            return isfeasibleRowwise(r, c);
        }
    }


    public static boolean isfeasibleRowwise(int r, int c) {

        //calc row wise sum of current row
        int s = 0;
        int b = 0;
        if (r >= m - 1 || r < 0) {
            r = m - 1;
        }

        if (c >= n - 1 || c < 0) {
            c = n - 1;
        }

        for (int j = 0; j <= c; j++) {
            if (bar[r][j] == 'S') {
                s++;
            } else if (bar[r][j] == 'B') {
                b++;
            }
        }
        if (c == n - 1) {
            if ((rowWiseSum[0][r] != -1 && s != rowWiseSum[0][r]) || (rowWiseSum[1][r] != -1 && b != rowWiseSum[1][r])) {
                return false;
            }
        } else {
            if ((rowWiseSum[0][r] != -1 && s > rowWiseSum[0][r]) || (rowWiseSum[1][r] != -1 && b > rowWiseSum[1][r])) {
                return false;
            }
        }
        //colwise integrity check
        s = 0;
        b = 0;

        for (int i = 0; i <= r; i++) {
            if (bar[i][c] == 'S') {
                s++;
            } else if (bar[i][c] == 'B') {
                b++;
            }
        }

        if (r == m - 1) {
            if ((colWiseSum[0][c] != -1 && s != colWiseSum[0][c]) || (colWiseSum[1][c] != -1 && b != colWiseSum[1][c])) {
                return false;
            }
        } else {
            if ((colWiseSum[0][c] != -1 && s > colWiseSum[0][c]) || (colWiseSum[1][c] != -1 && b > colWiseSum[1][c])) {
                return false;
            }
        }

        return true;

    }

    public static Pair<Integer, Integer> getNextCoordinate(int i, int j) {
        if (i == m - 1 && j == n - 1) {
            return new Pair<>(-1, -1);
        }
        if (j == n - 1) {

            return new Pair<>(i + 1, 0);
        }

        return new Pair<>(i, j + 1);

    }

    public static Pair<Integer, Integer> getNextEmptyCoordinate(int i, int j) {
        int i1 = i, j1 = j;
        if ((i == m - 1 && j == n - 1) || (i < 0 || j < 0)) {
            return new Pair<>(-1, -1);
        }
        Pair<Integer, Integer> nextempty;
        do {

            nextempty = getNextCoordinate(i1, j1);
            i1 = nextempty.getKey();
            j1 = nextempty.getValue();


        } while ((nextempty.getKey() >= 0 && nextempty.getValue() >= 0) && bar[nextempty.getKey()][nextempty.getValue()] != 'E');
        return nextempty;

    }
}
