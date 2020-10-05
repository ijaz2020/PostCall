package com.cp.graph;


// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class LargestItemAssociation
{

  public static void main(String[] args) {
    LargestItemAssociation s = new LargestItemAssociation();
    /**
     * Example 1
     */
    List<PairString> input = Arrays.asList(
      new PairString[]{
        s.new PairString("item3", "item4"),
        s.new PairString("item1", "item2"),
      }
    );
    /**
     * Testing equal sized arraylist. 1->2->3->7 4->5->6->7
     */
    List<PairString> input2 =  Arrays.asList(
      new PairString[] {
        s.new PairString("item1","item2"),
        s.new PairString("item2","item3"),
        s.new PairString("item4","item5"),
        s.new PairString("item6","item7"),
        s.new PairString("item5","item6"),
        s.new PairString("item3","item7")
      }
    );
    List<String> lst = s.largestItemAssociation(input);
    for (String sa : lst) System.out.print(" " + sa);
    System.out.println();
    List<String> lst2 = s.largestItemAssociation(input2);
    for (String sa : lst2) System.out.print(" " + sa);
    System.out.println();
    /**
     * Testing duplicates: 1->2->3->7 , 5->6
     */
    List<PairString> input3 =  Arrays.asList(
      new PairString[] {
        s.new PairString("item1","item2"),
        s.new PairString("item1","item3"),
        s.new PairString("item2","item7"),
        s.new PairString("item3","item7"),
        s.new PairString("item5","item6"),
        s.new PairString("item3","item7")
      }
    );

  //  List<String> lst3 = s.largestItemAssociation(input3);
   // for (String sa : lst3) System.out.print(" " + sa);
  }

  // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
  // RETURN "null" IF NO ITEM ASSOCIATION IS GIVEN
  List<String> largestItemAssociation(List<PairString> itemAssociation)
  {
    // WRITE YOUR CODE HERE
    int maxLength = 0;
    Map<String, List<String>> graph = new HashMap<>();
    for (PairString s : itemAssociation){
      graph.computeIfAbsent(s.first, k -> new ArrayList<>()).add(s.second);
      graph.computeIfAbsent(s.second, k -> new ArrayList<>()).add(s.first);
    }
    Map<Integer, List<List<String>>> resultMap = new HashMap<>();
    for(String k : graph.keySet()){
      Queue<String> queue = new LinkedList<>();
      Set<String> curr = new TreeSet<>();
      Set<String> vis = new HashSet<>();
      queue.offer(k);
      while(!queue.isEmpty()){
        String top = queue.poll();
        curr.add(top);
        for(String neigh: graph.getOrDefault(top, new ArrayList<>())){
          if(vis.contains(neigh))continue;
          queue.offer(neigh);

        }
      }
      int s = curr.size();
      maxLength = Math.max(s, maxLength);
      resultMap.computeIfAbsent(s, y-> new ArrayList<>())
        .add(new ArrayList<>(curr));
    }
    List<List<String>> finalList = resultMap.get(maxLength);
    Collections.sort(finalList, (l1, l2)-> {
      int score = 0;
      for(int i=0; i<l1.size() && score ==0; i++){
        score = l1.get(i).compareTo(l2.get(i));
      }
      return score;
    });
    return finalList.get(0);
  }
  // METHOD SIGNATURE ENDS

  public class PairString {
    String first;
    String second;

    public PairString(String first, String second) {
      this.first = first;
      this.second = second;
    }
  }
}
