package com.hotel;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class MyCalendar {

//    public static void main(String[] args){
//        MyCalendar myCalendar = new MyCalendar();
//        System.out.println(myCalendar.book(10, 20)); // returns true
//        System.out.println(myCalendar.book(15, 25)); // returns false
//        System.out.println(myCalendar.book(20, 30)); // returns true
//        System.out.println(myCalendar.book(8, 9)); // returns true
//        HashMap map = new HashMap();
//        map.put("a", "b");
//        System.out.println(map.put("a", "c"));
//    }

    TreeMap<Integer, Integer> calendar;

    private MyCalendar() {
        calendar = new TreeMap<>();
    }

    private boolean book(int start, int end) {
        Integer floorKey = calendar.floorKey(start);
        if (floorKey != null && calendar.get(floorKey) > start) return false;
        Integer ceilingKey = calendar.ceilingKey(start);
        if (ceilingKey != null && ceilingKey < end) return false;

        calendar.put(start, end);
        return true;
    }
}