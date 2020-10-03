package com.hotel.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class WordLadder {
  public static void main(String[] args) {
    String[] n ={"hot","dot","dog","lot","log","cog"};
//    System.out.println(new WordLadder().ladderLength("hit","cog", new HashSet<>(Arrays.asList(n))));
    System.out.println(new WordLadder().ladderLength("hit","cog", (Arrays.asList(n))));
  }

  class Node{
    int dist;
    String word;
    Node(int dist, String word){
      this.dist = dist;
      this.word = word;
    }
    public String toString(){
      return "dist: "+ dist + "->word: "+word;
    }
  }
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.dist));
    Map<String, List<String>> paths = new HashMap<>();
    Map<String, Node> index = new HashMap<>();
    for(int i = 0; i < wordList.size(); i ++){
      List<String> neibors = paths.computeIfAbsent(wordList.get(i), k->new ArrayList<String>());
      for(int j = i+1; j < wordList.size(); j ++){
        if(isNear(wordList.get(i), wordList.get(j))){
          neibors.add(wordList.get(j));
          paths.computeIfAbsent(wordList.get(j),k->new ArrayList<>()).add(wordList.get(i));
        }
      }
    }

    //System.out.println(paths);
    if(!paths.containsKey(endWord)) return 0;
    if(!paths.containsKey(beginWord)){
      List<String> neibors = paths.computeIfAbsent(beginWord, k->new ArrayList<String>());
      for(String word : wordList){
        if(isNear(beginWord, word)){
          neibors.add(word);
        }
      }
    }

    queue.offer(new Node(0, beginWord));
    //System.out.println(queue);
    //System.out.println(index);
    while(!queue.isEmpty()){
      Node node = queue.poll();
      if(node.word.equals(endWord)) return node.dist+1;
      //System.out.println(node.word);
      for(String neigbor : paths.get(node.word)){
        if(index.containsKey(neigbor)){
          if(index.get(neigbor).dist > node.dist+1){
            index.get(neigbor).dist = node.dist+1;
            queue.remove(index.get(neigbor));
            queue.offer(index.get(neigbor));
          }
        }else{
          index.put(neigbor, new Node(node.dist+1, neigbor));
          queue.offer(index.get(neigbor));
        }
      }
    }
    return 0;
  }

  boolean isNear(String a, String b){
    int count = 0;
    for(int i = 0; i < a.length(); i ++){
      if(a.charAt(i) != b.charAt(i)){
        if(count == 1) return false;
        count = 1;
      }
    }
    return true;
  }


  public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
    Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>();

    int len = 1;
    HashSet<String> visited = new HashSet<>();

    beginSet.add(beginWord);
    endSet.add(endWord);
    while (!beginSet.isEmpty() && !endSet.isEmpty()) {
      if (beginSet.size() > endSet.size()) {
        Set<String> set = beginSet;
        beginSet = endSet;
        endSet = set;
      }

      Set<String> temp = new HashSet<String>();
      for (String word : beginSet) {
        char[] chs = word.toCharArray();

        for (int i = 0; i < chs.length; i++) {
          for (char c = 'a'; c <= 'z'; c++) {
            char old = chs[i];
            chs[i] = c;
            String target = String.valueOf(chs);

            if (endSet.contains(target)) {
              return len + 1;
            }

            if (!visited.contains(target) && wordList.contains(target)) {
              temp.add(target);
              visited.add(target);
            }
            chs[i] = old;
          }
        }
      }

      beginSet = temp;
      len++;
    }

    return 0;
  }
}
