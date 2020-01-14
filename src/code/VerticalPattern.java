package code;

public class VerticalPattern implements Pattern {
    public final int type = 2;
    @Override
    public void put(char[][] bar, int i, int j, boolean isSweetFirst) {
        if(isSweetFirst) {
            bar[i][j] = 'S';
            bar[i+1][j] = 'B';
        }
        else {
            bar[i][j] = 'B';
            bar[i+1][j] = 'S';
        }
    }

    @Override
    public void revert(char[][] bar, int i, int j) {
        bar[i][j] = 'E';
        bar[i+1][j] = 'E';
    }

    public boolean isPossible(char[][] bar, int i, int j, int m, int n) {
         if(i >= m-1 || j>=n || bar[i][j] != 'E' || bar[i+1][j] != 'E') {
             return false;
         }
        return true;
    }

    @Override
    public int getType() {
        return 2;
    }


}
