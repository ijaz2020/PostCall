package com.cp;
import java.util.Map;
import java.util.TreeMap;

class MyCalendarTwo {

        public static void main(String[] args){
 /*           MyCalendarTwo myCalendar = new MyCalendarTwo();
            System.out.println(myCalendar.book(10, 20)); // returns true
            System.out.println(myCalendar.book(50, 60)); // returns true
            System.out.println(myCalendar.book(10, 40)); // returns true
            System.out.println(myCalendar.book(5, 15)); // returns false
            System.out.println(myCalendar.book(5, 10)); // returns true
            System.out.println(myCalendar.book(25, 55)); // returns true*/

            MyCalendarThree myCalendar = new MyCalendarThree();
            System.out.println("out" +myCalendar.book(10, 20)); // returns 1
            System.out.println("out" +myCalendar.book(50, 60)); // returns 1
            System.out.println("out" +myCalendar.book(10, 40)); // returns 2
            System.out.println("out" +myCalendar.book(5, 15)); // returns 3
            System.out.println("out" +myCalendar.book(5, 10)); // returns 3
            System.out.println("out" +myCalendar.book(25, 55)); // returns 3
            System.out.println("out" +myCalendar.book(1, 2)); // returns 3



    }
    private TreeMap<Integer, Integer> calender; int K=0;

    public MyCalendarTwo() {
        calender = new TreeMap<>();
        K=2;
    }

  /*  public boolean book(int start, int end) {
        calender.put(start, map.getOrDefault(start, 0) + 1);
        calender.put(end, map.getOrDefault(end, 0) - 1);
        int count = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            count += entry.getValue();
            if(count > 2) {
                calender.put(start, calender.get(start) - 1);
                if(calender.get(start) == 0) {
                    calender.remove(start);
                }
                calender.put(end, map.get(end) + 1);
                if(calender.get(end) == 0) {
                    calender.remove(end);
                }
                return false;
            }
        }
        return true;
    }*/

    public boolean book(int start, int end) {
        calender.put(start, calender.getOrDefault(start, 0) +1);
        calender.put(end, calender.getOrDefault(end, 0) + 1);
        int count =0;
        for(Map.Entry<Integer, Integer> entry: calender.entrySet()){
            count += entry.getValue();
            if(count > K){
                calender.put(start, calender.get(start) -1);
                calender.put(end , calender.get(end) -1);
                return false;
            }
        }
        return true;
    }

    static class MyCalendarThree {

        Map<Integer, Integer> calender;
        MyCalendarThree() {
            calender = new TreeMap<>();
        }

        int book(int start, int end) {
            calender.put(start, calender.getOrDefault(start, 0) + 1);
            calender.put(end, calender.getOrDefault(end, 0) - 1);
            int count = 0, k = 0;
            for (int v : calender.values()) {
                count = count +  v;
                k = Math.max(k, count);
            }
            return k;
        }
    }
}