package com.hotel.LinkedList;

public class OddEvenList {
  public static void main(String[] args) {
    ListNode head = new ListNode(5);
    head.next = new ListNode(7);
    System.out.println(new OddEvenList().oddEvenList(head));
  }

  public ListNode oddEvenList(ListNode head) {
    if(head == null) return head;
    ListNode odd = head, even = head.next; //odd  - 1  even - 2
    ListNode dummyOdd = odd, dummyEven = even;
    while(even != null){
      if(odd !=null) {
        odd.next = even.next;
        odd = odd.next; // 1- 3
      }
      if(odd != null){
        even.next = odd.next;
        even = even.next;
      }
    }
    odd.next = dummyEven;
    return dummyOdd;
  }
}
