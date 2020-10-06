package com.cp;


public class RemoveNthNodeFromEnd {
    public static void main(String[] args){
        ListNode l = new ListNode(0);
        l.next = new ListNode(1);
        l.next.next = new ListNode(2);
        l.next.next.next = new ListNode(3);
        l.next.next.next.next = new ListNode(4);
        l.next.next.next.next.next = new ListNode(5);
        l.next.next.next.next.next.next = new ListNode(6);
        l.next.next.next.next.next.next.next = new ListNode(7);
        l.next.next.next.next.next.next.next.next = new ListNode(8);
        l.next.next.next.next.next.next.next.next.next = new ListNode(9);
        l.next.next.next.next.next.next.next.next.next.next = new ListNode(10);
        l.next.next.next.next.next.next.next.next.next.next.next = new ListNode(11);
        l.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(12);
        l.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(13);
        RemoveNthNodeFromEnd r = new RemoveNthNodeFromEnd();
        ListNode node = r.removeNthFromEnd(l.next, 3);
        r.printNode(node);
    }

    private ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;

        //Move fast in front so that the gap between slow and fast becomes n
        for(int i=1; i<=n+1; i++)   {
            fast = fast.next;
        }
        //Move fast to the end, maintaining the gap
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Skip the desired node
        slow.next = slow.next.next;
        return start.next;
    }

    private void printNode(ListNode node){
        while (node!=null){
            System.out.print(node.val +"->");
            node = node.next;
        }
        System.out.println();
    }
}
