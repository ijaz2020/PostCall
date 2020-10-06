package com.cp.graph;

public class FriendsCircle {
    public static void main(String[] args){
        int[][] nums ={
                {1,1,0},
                {1,1,0},
                {0,0,1}};
        System.out.println(new FriendsCircle().findCircleNum(nums));
    }

    public int findCircleNum(int[][] M) {
        int m = M.length, cnt = 0;
        int[] root = new int[m];
        for (int i = 0; i < m; i++)
            root[i] = i;
        for (int i = 0; i < m; i++)
            for (int j = i + 1; j < m; j++)
                if (M[i][j] == 1) unionFind(root, i, j);

        for (int i = 0; i < m; i++)
            if (i == root[i]) cnt++;
        return cnt;
    }

    void unionFind (int[] root, int v1, int v2) {
        while (root[v1] != v1)
            v1 = root[v1]; //find v1's root
        while (root[v2] != v2)
            v2 = root[v2]; //find v2's root
        if (root[v1] != root[v2])
            root[v2] = v1; //unite the 2 subtrees
    }

}
