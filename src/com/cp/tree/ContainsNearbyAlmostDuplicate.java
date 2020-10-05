package com.hotel.tree;

import java.util.HashMap;
import java.util.TreeSet;

public class ContainsNearbyAlmostDuplicate {
  public static void main(String[] args) {
    TreeSet<Integer> treeSet = new TreeSet<>();
    treeSet.add(2);
    treeSet.add(10);
    treeSet.add(100);
    treeSet.add(1000);
    int[] nums ={1,2,3,1};
    System.out.println(new ContainsNearbyAlmostDuplicate().containsNearbyAlmostDuplicate(nums, 3, 0));
  }

  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    if(nums == null || nums.length == 0 || k <= 0 || t < 0) return false; // k = 0 不可以，因为要保证distinct, t为0可以

    HashMap<Long, Long> m = new HashMap<>();
    long min = Integer.MAX_VALUE;
    for(int i: nums) min = Math.min(i, min);
    long diff = (long)t + 1; //case long 左右两边都得做，要在加减法进行之前做

    for(int i = 0; i < nums.length; i++){
      long cur = nums[i];
      long bucketNum = mapToBucket(cur, diff , min);

      //check left
      Long l = m.get(bucketNum - 1);
      if(l != null && Math.abs(l - cur) < diff) return true;

      //check right
      Long r = m.get(bucketNum + 1);
      if(r != null && Math.abs(r - cur) < diff) return true;

      //check my bucket
      Long mine = m.get(bucketNum);
      if(mine != null && Math.abs(mine - cur) < diff) return true;

      m.put(bucketNum, cur);

      //keep the sliding window, serve next rouond, which will add one more element
      if(i >= k) {
        m.remove(mapToBucket((long)(nums[i - k]), diff, min));
      }
    }

    return false;
  }

  public long mapToBucket(long val, long diff, long min){
    return (val - min) / diff;
  }

  public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
    int i=0, j=0, n = nums.length;
    TreeSet<Long> treeSet = new TreeSet<>();
    while (j < n){
      Long floor = treeSet.floor((long)nums[j]);
      if(floor != null && nums[j] - floor <= t){
        return  true;
      }
      Long ceil = treeSet.ceiling((long)nums[j]);
      if(ceil != null && ceil - nums[j] <= t){
        return  true;
      }
      treeSet.add((long)nums[j]);
      if(treeSet.size() > k){
        treeSet.remove((long)nums[i++]);
      }
      j++;
    }
    return false;
  }

}
