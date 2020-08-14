import java.util.*;

public class SortByFrequency {
    public static void main(String arg[]){
        int[] a= {2,2,3, 1,1,1}; int n=2;
        System.out.println(topKFrequent(a, n));
    }
    public static List<Integer> topKFrequent(int[] nums, int k) {

        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

        for (int n : nums) {
//            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
            frequencyMap.merge(n, 1, Integer::sum);
        }

        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        List<Integer> res = new ArrayList<>();

        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }
        return res;
    }
}
