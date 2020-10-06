package com.cp.LinkedList;

public class RemoveSortedListII {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
        System.out.println(new RemoveSortedListII().deleteDuplicates(head));
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode fake = new ListNode(0);
        fake.next = head;
        while(fake.next != null && fake.next.next != null){
            ListNode slow = fake.next, fast = fake.next.next;
            if(slow.val != fast.val){
                fake =fake.next;
            }
            else{
                while(fast != null && slow.val == fast.val){
                    slow = slow.next;
                    fast = fast.next;
                }
                fake.next = fast;
            }

        }
        return fake;
    }
}
