package com.hotel.array;

import java.lang.reflect.Array;
import java.util.*;

public class TopKFrequent {
    public static void main(String[] args){
        TopKFrequent k = new TopKFrequent();
        int[] ints = {5,4,2,5,4,3,2,5,4,5};
//
        List<String> comp = new ArrayList();
        comp.add("anacel");
        comp.add("betacell");
        comp.add("centra");
        comp.add("delta");
        comp.add("euro");
        List<String> review = new ArrayList<>();
        review.add("anacel");
        review.add("anacel");
        review.add("betacell");
        System.out.println(new TopKFrequent().topNCompetitors(5, 2 , comp, 3, review ));
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }

        // corner case: if there is only one number in nums, we need the bucket has index 1.
        List<Integer>[] bucket = new List[nums.length+1];
        for(int n:map.keySet()){
            int freq = map.get(n);
            if(bucket[freq]==null)
                bucket[freq] = new LinkedList<>();
            bucket[freq].add(n);
        }

        List<Integer> res = new LinkedList<>();
        for(int i=bucket.length-1; i>0 && k>0; --i){
            if(bucket[i]!=null){
                List<Integer> list = bucket[i];
                res.addAll(list);
                k-= list.size();
            }
        }

        return res;
    }

    public ArrayList<String> topNCompetitors(int n,
                                             int top,
                                             List<String> comp,
                                             int numReviews,
                                             List<String> reviews)
    {
        List<String> res = new LinkedList<>();
        if(reviews == null || reviews.size() == 0 || comp == null ||
                comp.size() == 0) return new ArrayList<>(res);
        HashMap<String, Integer> freqMap = new HashMap<>();
        for(int i=0; i<comp.size();i++){
            freqMap.put(comp.get(i), 0);
        }
        for(String c : comp) {
            for (String review : reviews) {
                if(review.contains(c))
                    freqMap.put(c, freqMap.get(c)+1);
            }
        }

        List<String>[] bucket = new List[n+1];
        for(String i :freqMap.keySet()){
            int freq = freqMap.get(i);
            if(bucket[freq]==null)
                bucket[freq] = new LinkedList<>();
            bucket[freq].add(i);
        }

        for(int i=bucket.length-1; i>0 && top>0; --i){
            if(bucket[i]!=null){
                List<String> list = bucket[i];
                Collections.sort(list);
                res.addAll(list);
                top-= list.size();
            }
        }

        return new ArrayList<>(res);

    }
}
