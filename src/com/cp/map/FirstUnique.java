package com.cp.map;

import java.util.HashMap;
import java.util.Map;

class FirstUnique {
  public static void main(String[] args) {
    int[] nums = {2,3,5};
    FirstUnique firstUnique = new FirstUnique(nums);
    System.out.println(firstUnique.showFirstUnique()); // return 2
    firstUnique.add(5);            // the queue is now [2,3,5,5]
    System.out.println(firstUnique.showFirstUnique()); // return 2
    firstUnique.add(2);            // the queue is now [2,3,5,5,2]
    System.out.println(firstUnique.showFirstUnique()); // return 3
    firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
    System.out.println(firstUnique.showFirstUnique()); // return -1
    System.out.println();
  }


  Map<Integer, Node> map;
  Node head, tail;
  public FirstUnique(int[] nums) {
    map = new HashMap<>();
    head = new Node(-1, -1);
    tail = new Node(-1, -1);
    head.post = tail;
    tail.pre = head;
    process(nums);
  }

  public int showFirstUnique() {
    Node node = head.post;
    if(node.count !=1) return -1;
    return node.val;
  }

  public void add(int i) {
    addTo(i);
  }

  private void addTo(int i) {
    map.compute(i, (k, v) ->{
      if(v == null){
        Node node = new Node(i, 1);
        moveLast(node);
        return node;
      }
      deleteNode(v);
      v.setCount(v.getCount() +1);
      return v;
    });
  }

  private void process(int[] nums){
    for(int i: nums){
      addTo(i);
    }
  }

  private void deleteNode(Node node){
    Node pre = node.pre;
    Node post = node.post;
    pre.post = post;
    post.pre = pre;
  }

  private void moveLast(Node node){
    Node pre = tail.pre;
    pre.post = node;
    tail.pre = node;
    node.pre = pre;
    node.post = tail;
  }

  class Node{
    Node pre;
    Node post;
    int val;
    int count;
    Node(int val, int count){
      this.val = val;
      this.count = count;
    }

    public void setCount(int count){
      this.count = count;
    }

    public int getCount(){
      return this.count;
    }
  }
}
