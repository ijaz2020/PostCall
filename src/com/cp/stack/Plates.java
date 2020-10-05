package com.cp.stack;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/*public class Plates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int test = Integer.parseInt(scanner.nextLine());
        for (int i=1; i<=test;i++){
            int n = scanner.nextInt(), length = scanner.nextInt(), p = scanner.nextInt();
            List<List<Integer>> list = new ArrayList<>();
             for (int j=0; j<n;j++) {
                 List<Integer> current = new ArrayList<>();
                 for (int k = 0; k < length; k++){
                     current.add(scanner.nextInt());
                 }
                 list.add(current);
             }
            System.out.println("Case #" + i + ": " + process(list, p, length));
        }
    }



    private static int process(List<List<Integer>> list, int p, int n) {
        int[] dp = new int[n];
        List<int[]> prefixSum = new ArrayList<>();
        for(int i=0; i< list.size(); i++){
            List<Integer> current = list.get(i);
            int[] roll = new int[current.size()];
            roll[0] = current.get(0);
            for(int j=1; j<current.size();j++){
                roll[j] = roll[j-1] + current.get(j);
            }
            prefixSum.add(roll);
        }

        return 0;
    }
}*/
/*      2
        2 4 5
        10 10 100 30
        80 50 10 50
        3 2 3
        80 80
        15 50
        20 10*/

 public class Plates {
    public static class Task {

        public void solve(Scanner sc, PrintWriter pw) throws IOException {
            int T = sc.nextInt();
            int t = 0;
            while (T-- > 0) {
                t++;
                int n = sc.nextInt();
                int k = sc.nextInt();
                int p = sc.nextInt();
                int[][] dp = new int[n + 1][p + 1];
                for (int i = 0; i < n; i++) {
                    int[] a = new int[k];
                    for (int j = 0; j < k; j++) {
                        a[j] = sc.nextInt();
                    }
                    for (int j = 1; j < k; j++) {
                        a[j] += a[j - 1];
                    }
                    for (int j = 0; j <= k; j++) {
                        for (int l = 0; l <= p; l++) {
                            if (l + j <= p)
                                dp[i + 1][l + j] = Math.max(dp[i + 1][l + j], dp[i][l] + (j == 0 ? 0: a[j - 1]));
                        }
                    }
                }
                pw.println("Case #" + t + ": " + dp[n][p]);
            }

        }



    }

    static long TIME_START, TIME_END;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
//        Scanner sc = new Scanner(new FileInputStream("nondec.in"));
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
//        PrintWriter pw = new PrintWriter(new FileOutputStream("nondec.out"));

        Runtime runtime = Runtime.getRuntime();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
        TIME_START = System.currentTimeMillis();
        Task t = new Task();
        t.solve(sc, pw);
        TIME_END = System.currentTimeMillis();
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        pw.close();
        System.err.println("Memory increased: " + (usedMemoryAfter - usedMemoryBefore) / 1000000);
        System.err.println("Time used: " + (TIME_END - TIME_START) + ".");
    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public Scanner(FileReader s) throws FileNotFoundException {
            br = new BufferedReader(s);
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public boolean ready() throws IOException {
            return br.ready();
        }
    }
}
