package com.hotel.string;

import com.hotel.array.TopKFrequent;

import java.util.*;

public class TopKFrequentWords {
    public static void main(String[] args){
        TopKFrequentWords t = new TopKFrequentWords();
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(t.topKFrequent(words, 2));
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for(String word : words)
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        PriorityQueue<Map.Entry<String, Integer>> priorityQueue = new PriorityQueue<>((a,b) -> a.getValue().equals(b.getValue()) ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue());

        for(Map.Entry<String, Integer> entry: frequencyMap.entrySet()){
            priorityQueue.offer(entry);
            if(priorityQueue.size() > k) priorityQueue.poll();
        }
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : priorityQueue) result.add(0, entry.getKey());
        return result;
    }
}
