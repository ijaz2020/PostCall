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

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){return l2;}if(l2 == null){return l1;}
        ListNode result = new ListNode(0);
        ListNode dummy = result;
        while(l1 != null && l2 != null ){
            if(l1.val < l2.val){
                dummy.next = l1;
                l1 = l1.next;
            }
            else{
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }

        dummy.next = l1 == null? l2:l1;

        return result.next;
    }
}
