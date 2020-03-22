package com.hotel.priorityQueue;

import java.util.*;

public class TopKFrequentWords {
    public static void main(String[] args){
        TopKFrequentWords t = new TopKFrequentWords();
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(t.topKFrequent(words, 3));
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for(String word : words)
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        PriorityQueue<Map.Entry<String, Integer>> priorityQueue = new PriorityQueue<>((a,b) -> a.getValue().equals(b.getValue()) ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue());
//        PriorityQueue<String> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(frequencyMap::get));

        for(Map.Entry<String, Integer> entry: frequencyMap.entrySet()){
            priorityQueue.offer(entry);
            if(priorityQueue.size() > k) priorityQueue.poll();
        }
        LinkedList<String> result = new LinkedList<>();
        for (Map.Entry<String, Integer> entry : priorityQueue) result.offerFirst( entry.getKey());
        return result;
    }
}
