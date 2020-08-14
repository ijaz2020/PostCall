package com.hotel.dp;

public class NthUglyNumber {
    public static void main(String[] args) {
        System.out.println(new NthUglyNumber().nthUglyNumber(6));
        System.out.println(new NthUglyNumber().nthUglyNumber1(6));
    }

    public int nthUglyNumber(int n) { // n = 10
        int i2 = 1, i3 = 1, i5 = 1;
        int res = 1;
        for (int i=1; i<=n;i++){
            int f2 = i2 * 2, f3 = i3 * 3, f5 = i5 * 5;
            res = Math.min(Math.min(f2, f3), f5);
            if(res == f2) i2++;
            if(res == f3) i3++;
            if(res == f5) i5++;
        }
        return res;
    }

    public int nthUglyNumber1(int n) {
        int i2 = 0, i3 = 0, i5 = 0;
        int u2 = 1, u3 = 1, u5 = 1;
        int res =1 ;
        for (int i = 1; i <= n; i++) {
            res = Math.min(u2, Math.min(u3, u5));
            if (res == u2)
                u2 = ++i2 * 2;
            if (res == u3)
                u3 = ++i3 * 3;
            if (res == u5)
                u5 = ++i5 * 5;
        }
        return res;
    }
}
