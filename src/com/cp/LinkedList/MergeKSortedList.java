package com.cp.LinkedList;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedList {
    /*      [
            1->4->5,
            1->3->4,
            2->6
            ]*/
    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(5);
        l1.next.next = new ListNode(6);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);
        ListNode[] list = {l1, l2, l3};
        System.out.println(new MergeKSortedList().mergeKLists(list));
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1), result;
        result=dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i.val));
        for(ListNode i : lists)
            if(i!=null) pq.offer(i);
        while(!pq.isEmpty()){
            ListNode current = pq.poll();
            result.next = current;
            result = result.next;
            if(current.next != null)
                pq.offer(current.next);
        }
        return dummy.next;
    }
}
