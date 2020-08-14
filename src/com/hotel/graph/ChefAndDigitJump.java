package com.hotel.graph;


import java.io.*;
import java.util.*;
import java.math.*;

public class ChefAndDigitJump {

  public static void main(String[] args) throws java.lang.Exception {
    Scanner pm = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    String s = "012134444444443";
    int n = s.length();
    if(n == 0){
      System.out.println(0);
      return;
    }
    Queue<Integer>[] list=new ArrayDeque[10];

    for(int i=0;i<10;i++)
      list[i]=new ArrayDeque<>();
    for(int i=s.length()-1;i>=0;i--)
      list[s.charAt(i)-'0'].add(i);


    LinkedList<Integer> q = new LinkedList<>();
    int[] steps=new int[s.length()];
    Arrays.fill(steps,-1);
    q.add(0);
    steps[0] = 0;
    while(q.size()!= 0){
      int curr=q.poll();
      Queue<Integer> q1=list[s.charAt(curr)-'0'];
      while(!q1.isEmpty()){
        int c = q1.poll();
        if(steps[c]==-1){
          q.add(c);
          steps[c]=steps[curr]+1;
        }
      }
      if(curr+1<s.length() && steps[curr+1]==-1){
        steps[curr+1]=steps[curr]+1;
        q.add(curr+1);
      }
      if(curr-1>=0 && steps[curr-1]==-1){
        steps[curr-1]=steps[curr]+1;
        q.add(curr-1);
      }
      if(steps[s.length()-1]!=-1){
        System.out.println(steps[s.length()-1]);
        break;
      }
    }
  }

  static class Reader {
    final private int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    public Reader()
    {
      din = new DataInputStream(System.in);
      buffer = new byte[BUFFER_SIZE];
      bufferPointer = bytesRead = 0;
    }

    public Reader(String file_name) throws IOException
    {
      din = new DataInputStream(new FileInputStream(file_name));
      buffer = new byte[BUFFER_SIZE];
      bufferPointer = bytesRead = 0;
    }

    public String readLine() throws IOException
    {
      byte[] buf = new byte[64]; // line length
      int cnt = 0, c;
      while ((c = read()) != -1)
      {
        if (c == '\n')
          break;
        buf[cnt++] = (byte) c;
      }
      return new String(buf, 0, cnt);
    }

    public int nextInt() throws IOException
    {
      int ret = 0;
      byte c = read();
      while (c <= ' ')
        c = read();
      boolean neg = (c == '-');
      if (neg)
        c = read();
      do
      {
        ret = ret * 10 + c - '0';
      }  while ((c = read()) >= '0' && c <= '9');

      if (neg)
        return -ret;
      return ret;
    }

    public long nextLong() throws IOException
    {
      long ret = 0;
      byte c = read();
      while (c <= ' ')
        c = read();
      boolean neg = (c == '-');
      if (neg)
        c = read();
      do {
        ret = ret * 10 + c - '0';
      }
      while ((c = read()) >= '0' && c <= '9');
      if (neg)
        return -ret;
      return ret;
    }

    public double nextDouble() throws IOException
    {
      double ret = 0, div = 1;
      byte c = read();
      while (c <= ' ')
        c = read();
      boolean neg = (c == '-');
      if (neg)
        c = read();

      do {
        ret = ret * 10 + c - '0';
      }
      while ((c = read()) >= '0' && c <= '9');

      if (c == '.')
      {
        while ((c = read()) >= '0' && c <= '9')
        {
          ret += (c - '0') / (div *= 10);
        }
      }

      if (neg)
        return -ret;
      return ret;
    }

    private void fillBuffer() throws IOException
    {
      bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
      if (bytesRead == -1)
        buffer[0] = -1;
    }

    private byte read() throws IOException
    {
      if (bufferPointer == bytesRead)
        fillBuffer();
      return buffer[bufferPointer++];
    }

    public void close() throws IOException
    {
      if (din == null)
        return;
      din.close();
    }
  }
}
