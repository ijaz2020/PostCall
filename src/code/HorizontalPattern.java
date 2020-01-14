package code;

public class HorizontalPattern implements Pattern {
    public final int type = 1;
    @Override
    public void put(char[][] bar, int i, int j, boolean isSweetFirst) {
        if(isSweetFirst) {
            bar[i][j] = 'S';
            bar[i][j+1] = 'B';
        }
        else {
            bar[i][j] = 'B';
            bar[i][j+1] = 'S';
        }
    }

    @Override
    public void revert(char[][] bar, int i, int j) {
        bar[i][j] = 'E';
        bar[i][j+1] = 'E';
    }

    @Override
    public boolean isPossible(char[][] bar, int i, int j, int m, int n) {
        if(j >= n-1 || i>= m || bar[i][j] != 'E' || bar[i][j+1] != 'E') {
            return false;
        }
        return true;
    }

    @Override
    public int getType() {
        return 1;
    }
}
