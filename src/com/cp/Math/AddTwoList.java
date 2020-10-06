package com.cp.Math;

import com.cp.LinkedList.ListNode;

import java.util.LinkedList;

public class AddTwoList {
    public static void main(String[] args){
        LinkedList<Integer> result = new LinkedList<>();
    }
    //2 -> 4 -> 3
    //5 -> 6 -> 4
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry =0; ListNode result = new ListNode(-1);
        ListNode dummy = result;
        for(ListNode i = l1, j=l2; i !=null || j !=null || carry == 1; i= i==null ? i : i.next, j = j== null? j : j.next ){
            int x = i == null ? 0 : i.val;
            int y = j == null ? 0 : j.val;
            int sum = x+y;
            carry = sum %10;
            dummy.next = new ListNode(sum/10);
            dummy =dummy.next;
        }
        return result.next;
    }
}
