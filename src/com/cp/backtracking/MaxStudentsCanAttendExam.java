package com.hotel.backtracking;

public class MaxStudentsCanAttendExam {
    public static void main(String[] args){
/*                {
                 {'#','.','#','#','.','#'},
                 {'.','#','#','#','#','.'},
                 {'#','.','#','#','.','#'}};*/
                        /*
                        {{'.','#'},
                        {'#','#'},
                        {'#','.'},
                        {'#','#'},
                        {'.','#'}};*/
        char[][] seats =
                        {{'#','.','.','.','#'},
                        {'.','#','.','#','.'},
                        {'.','.','#','.','.'},
                        {'.','#','.','#','.'},
                        {'#','.','.','.','#'}};
        System.out.println(new MaxStudentsCanAttendExam().maxStudents(seats));
    }

    int result = 0;
    int lastI  = -1, lastJ = -1;
    public int maxStudents(char[][] seats) {
        for(int i=0; i< seats.length; i++){
            for(int j=0; j<seats[0].length; j++){
                if(seats[i][j] == '.') {
                    lastI = i; lastJ=j;
                }
            }
        }
        checkSeat(0, 0, seats, 0);
        return result;
    }

    boolean checkSeat(int row, int col, char[][] seats, int current){
        if(row ==seats.length && col == seats[0].length)
            result = Math.max(result, current);

        for(int i=row; i<seats.length;i++, col=0){
            for(int j=col; j< seats[0].length; j++){
                if(seats[i][j] == '#') continue;
                if(isValid(i, j, seats, current)){
                    seats[i][j] = '*';
                    if(i ==lastI && j== lastJ)
                        result = Math.max(result, current);
                    if(checkSeat(i, j+1, seats, current+1))
                        return true;
                    seats[i][j] = '.';
                }
            }
        }
        return true;
    }

    boolean isValid(int i, int j, char[][] seats, int current){
        int[][] dirs ={{0,1}, {0, -1}, {-1, -1}, {-1, 1}};
        for(int[] dir: dirs){
            int row = i + dir[0], col = j+ dir[1];
            if(row<0 || row >= seats.length || col >= seats[0].length || col <0) continue;

            if(seats[row][col] == '*')
                return false;
        }
        return true;
    }
}
