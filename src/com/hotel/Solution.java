package com.hotel;


import java.util.LinkedList;
import java.util.List;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
public class Solution {

    public static void main(String arg[]){
        List<ListNode> listNodesA = new LinkedList<>();


    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int i=0, j=0;
        ListNode longerNode = headB, shorterNode = headA;
        while(headA.next !=null){
            headA = headA.next;
            i++;

        }
        while(headB.next !=null){
            headB = headB.next;
            j++;
        }


        if(i>j){
            ListNode temp = longerNode;
            longerNode = shorterNode;
            shorterNode =temp;
        }

        int d;
        if(longerNode  == headA){
            d = i-j;
        }else{
            d = j-i;
        }

        while(longerNode.next !=null){
            if(d !=0){
                longerNode = longerNode.next;
                d--;
            }
            else{
                if(longerNode.val == shorterNode.val){
                    return longerNode;
                }
                longerNode = longerNode.next;
                shorterNode =shorterNode.next;
            }
        }
        return null;
    }
}