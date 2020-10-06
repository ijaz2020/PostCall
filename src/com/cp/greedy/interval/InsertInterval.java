package com.cp.greedy.interval;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
class Interval{
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
    @Override
    public String toString(){
        return this.start+" : "+this.end;
    }
}
public class InsertInterval {
    public static void main(String[] args){
        List<Interval> intervals = new ArrayList<>();
        //[[1,2],[3,5],[6,7],[8,10],[12,16]]
        intervals.add(new Interval(1,2));
        intervals.add(new Interval(3,5));
        intervals.add(new Interval(6,7));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(12,16));
        System.out.println(new InsertInterval().insert(intervals, new Interval(4, 8)));
    }

    public int[][] insert(int[][] iv, int[] newInt) {
        int i = 0, n = iv.length;
        LinkedList<int[]> res = new LinkedList<>();
        if (n == 0) res.add(newInt);
        else if (newInt.length == 0)
            return iv;
        else {
            while (i < n && iv[i][1] < newInt[0]) {
                res.offer(iv[i++]);
            }
            res.offer(newInt);
            for (int j = i; j < iv.length; j++) {
                int[] current = res.getLast();
                int[] next = iv[j];
                if (current[1] >= next[0]) {
                    res.remove(i);
                    res.add(new int[]{Math.min(current[0], next[0]), Math.max(current[1], next[1])});
                } else res.add(iv[j]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int i=0;
        while(i<intervals.size() && intervals.get(i).end<newInterval.start)
            i++;
        while(i<intervals.size() && intervals.get(i).start<=newInterval.end){
            newInterval = new Interval(Math.min(intervals.get(i).start, newInterval.start), Math.max(intervals.get(i).end, newInterval.end));
            intervals.remove(i);
        }
        intervals.add(i,newInterval);
        return intervals;
    }
}
