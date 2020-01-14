package code;

public class EmptyPattern  implements Pattern {

    public final int type = 0;

    @Override
    public void put(char[][] bar, int i, int j, boolean isSweetFirst) {

        bar[i][j] = 'X';

    }

    @Override
    public void revert(char[][] bar, int i, int j) {
        bar[i][j] = 'E';

    }

    @Override
    public boolean isPossible(char[][] bar, int i, int j, int m, int n) {
       if(i>=m || j >= n || bar[i][j] != 'E')
        return false;
       return true;
    }

    @Override
    public int getType() {
        return 0;
    }
}
