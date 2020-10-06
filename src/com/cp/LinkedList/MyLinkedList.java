package com.cp.LinkedList;

public class MyLinkedList {

  public static void main(String[] args) {
    MyLinkedList m = new MyLinkedList();
    m.addAtHead( 84 );
    m.addAtTail( 2 );
    m.addAtTail( 39 );
    m.get( 3 );
    m.get( 1 );
    m.addAtTail( 42 );
    m.addAtIndex( 1, 80 );
    m.addAtHead( 14 );
    m.addAtHead( 1 );
    m.addAtTail( 53 );
    m.addAtTail( 98 );
    m.addAtTail( 19 );
    m.addAtTail( 12 );
    m.get( 2 );
    m.addAtHead( 16 );
    m.addAtHead( 33 );
    m.addAtIndex( 4, 17 );
    m.addAtIndex( 6, 8 );
    m.addAtHead( 37 );
    m.addAtTail( 43 );
    m.deleteAtIndex( 11 );
    m.addAtHead( 80 );
    m.addAtHead( 31 );
    m.addAtIndex( 13, 23 );
    m.addAtTail( 17 );
    m.get( 4 );
    m.addAtIndex( 10, 0 );
    m.addAtTail( 21 );
    m.addAtHead( 73 );
    m.addAtHead( 22 );
    m.addAtIndex( 24, 37 );
    m.addAtTail( 14 );
    m.addAtHead( 97 );
    m.addAtHead( 8 );
    m.get( 6 );
    m.deleteAtIndex( 17 );
    m.addAtTail( 50 );
    m.addAtTail( 28 );
    m.addAtHead( 76 );
    m.addAtTail( 79 );
    m.get( 18 );
    m.deleteAtIndex( 30 );
    m.addAtTail( 5 );
    m.addAtHead( 9 );
    m.addAtTail( 83 );
    m.deleteAtIndex( 3 );
    m.addAtTail( 40 );
    m.deleteAtIndex( 26 );
    m.addAtIndex( 20, 90 );
    m.deleteAtIndex( 30 );
    m.addAtTail( 40 );
    m.addAtHead( 56 );
    m.addAtIndex( 15, 23 );
    m.addAtHead( 51 );
    m.addAtHead( 21 );
    m.get( 26 );
    m.addAtHead( 83 );
    m.get( 30 );
    m.addAtHead( 12 );
    m.deleteAtIndex( 8 );
    m.get( 4 );
    m.addAtHead( 20 );
    m.addAtTail( 45 );
    m.get( 10 );
    m.addAtHead( 56 );
    m.get( 18 );
    m.addAtTail( 33 );
    m.get( 2 );
    m.addAtTail( 70 );
    m.addAtHead( 57 );
    m.addAtIndex( 31, 24 );
    m.addAtIndex( 16, 92 );
    m.addAtHead( 40 );
    m.addAtHead( 23 );
    m.deleteAtIndex( 26 );
    m.get( 1 );
    m.addAtHead( 92 );
    m.addAtIndex( 3, 78 );
    m.addAtTail( 42 );
    m.get( 18 );
    m.addAtIndex( 39, 9 );
    m.get( 13 );
    m.addAtIndex( 33, 17 );
    m.get( 51 );
    m.addAtIndex( 18, 95 );
    m.addAtIndex( 18, 33 );
    m.addAtHead( 80 );
    m.addAtHead( 21 );
    m.addAtTail( 7 );
    m.addAtIndex( 17, 46 );
    m.get( 33 );
    m.addAtHead( 60 );
    m.addAtTail( 26 );
    m.addAtTail( 4 );
    m.addAtHead( 9 );
    m.get( 45 );
    m.addAtTail( 38 );
    m.addAtHead( 95 );
    m.addAtTail( 78 );
    m.get( 54 );
    m.addAtIndex( 42, 86 );

    m.addAtIndex(3,0);
    m.deleteAtIndex(2);
    m.addAtTail(4);
    System.out.println(m.get(4));
  }


  ListNode head, last;
  int size = 0;
  /** Initialize your data structure here. */
  public MyLinkedList() {
    head = new ListNode(-1);
    last = head;
  }

  /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
  public int get(int index) {
    if(index >= size) return -1;
    ListNode curr = head;
    for(int i=0; i<index;i++){
      curr =curr.next;
    }
    return curr.next == null ? -1 : curr.next.val;
  }

  /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
  public void addAtHead(int val) {
    ListNode next = head.next;
    ListNode newNode = new ListNode(val);
    head.next = newNode;
    newNode.next = next;
    size++;
    if(size ==1)last = newNode;
  }

  /** Append a node of value val to the last element of the linked list. */
  public void addAtTail(int val) {
    ListNode newNode = new ListNode(val);
    last.next = newNode;
    last = newNode;
    size++;
  }

  /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
  public void addAtIndex(int index, int val) {
    if(index > size) return;
    if(index == size){
      addAtTail(val);
      return;
    }
    if(index == 0){
      addAtHead(val);
      return;
    }
    ListNode curr = head, newNode = new ListNode(val);
    for(int i=0; i<index;i++){
      curr =curr.next;
    }
    ListNode next = curr.next;
    curr.next = newNode;
    newNode.next = next;
    size++;
  }

  /** Delete the index-th node in the linked list, if the index is valid. */
  public void deleteAtIndex(int index) {
    if(index >= size) return;
    ListNode curr = head;
    for(int i=0; i<index; i++){
      curr = curr.next;
    }
    curr.next = curr.next.next;
    if(index == size-1)
      last = curr;
    size--;
  }
  
}
