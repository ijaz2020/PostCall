package com.hotel.atCoder;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    sc.next();
    String s = sc.next();
//    String s = "WRWWRWRR";
    char[] chars = s.toCharArray();
    char R ='R', W ='W';
    int i=0, j=chars.length-1, res = 0;
    while ( i <j){
      if(R == chars[j] && W == chars[i]){
        char tmp = chars[j];
        chars[j] = chars[i];
        chars[i] = tmp;
        i++;j--;res++;
      }
      else if(chars[i] == R)
        i++;
      else if(chars[j] == W)
        j--;
    }
//    System.out.println(new String(chars));
    System.out.println(res);
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
