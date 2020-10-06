package com.cp.map;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

class WatchedVideosFriends {

    public static void main(String[] args){
        WatchedVideosFriends w = new WatchedVideosFriends();
        List<List<String>> watchedVideos = Arrays.asList(Arrays.asList("A", "B"), Arrays.asList("C"), Arrays.asList("B","C"), Arrays.asList("D"));
        int[][] friends = { {1,2}, {0,3}, {0,3}, {1,2}};
        System.out.println(w.watchedVideosByFriends(watchedVideos, friends, 0, 2));
    }
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Map<Integer, List<Integer>> friendsMap = new HashMap<>();
        for(int i=0; i< friends.length; i++)
            friendsMap.put( i, Arrays.stream(friends[i]).boxed().collect(Collectors.toList()));
        List<Integer> visited = new ArrayList<>(); Set<Integer> nextLevel = new HashSet<>();
        nextLevel.add(id);
        while(level-- >0){
            visited.addAll(nextLevel);
            getFriendList(visited, friendsMap, nextLevel);
        }

        Map<String, Integer> videoFrequencyMap = new HashMap<>();
        int j=1;
        for(int i: nextLevel) {
            List<String> ithWatchedVideo = watchedVideos.get(i);
            for(String video : ithWatchedVideo) {
                videoFrequencyMap.put(video, videoFrequencyMap.getOrDefault(video, 0) +1);
                j++;
            }
        }

        List<String>[] bucket = new List[j];
        for(String video: videoFrequencyMap.keySet()){
            int frequency = videoFrequencyMap.get(video);
            if(bucket[frequency] == null){
                bucket[frequency] = new LinkedList<>();
            }
            bucket[frequency].add(video);
        }
        List<String> result = new ArrayList<>();
        for(int i=0; i < bucket.length; i++){
            if(bucket[i] !=null && !bucket[i].isEmpty()){
                Collections.sort(bucket[i]);
                result.addAll(bucket[i]);
            }
        }
        return result;
    }

    private void getFriendList(List<Integer> visited,
                                        Map<Integer, List<Integer>> friendsMap,
                                        Set<Integer> nextLevel){
        List<Integer> next = new ArrayList<>(nextLevel);
        nextLevel.clear();
        for(Integer i: next){
            List<Integer> current = friendsMap.get(i);
            current.removeAll(visited);
            nextLevel.addAll(current);
        }
    }
}
