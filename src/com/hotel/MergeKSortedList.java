package com.hotel;

import java.util.*;

public class MergeKSortedList {

    public static void main(String arg[]){
        Integer[] a = new Integer[10];
        mergeKLists(new ListNode[10]);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        Comparator<ListNode> cmp;
        cmp = Comparator.comparingInt(o -> o.val);

        Queue<ListNode> q = new PriorityQueue<>(cmp);
        for(ListNode l : lists){
            if(l!=null){
                q.add(l);
            }
        }
        ListNode head = new ListNode(0);
        ListNode point = head;
        while(!q.isEmpty()){
            point.next = q.poll();
            point = point.next;
            ListNode next = point.next;
            if(next!=null){
                q.add(next);
            }
        }
        return head.next;
    }
}
