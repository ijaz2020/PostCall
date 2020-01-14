package code;

public interface Pattern {

     public final int type = -1;

    public void put(char[][] a, int i, int j, boolean isSweetFirst);
    public void revert(char[][] a, int i, int j);
    public boolean isPossible(char[][] bar, int i, int j, int m, int n);
    public int getType();

}
