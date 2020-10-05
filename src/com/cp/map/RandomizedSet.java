package com.hotel.map;
import java.util.ArrayList;
import java.util.HashMap;

public class RandomizedSet {
    public static void main(String[] args){
        // Init an empty set.
        RandomizedSet randomSet = new RandomizedSet();

// Inserts 1 to the set. Returns true as 1 was inserted successfully.
        randomSet.insert(16);

// Returns false as 2 does not exist in the set.
        randomSet.remove(23);

// Inserts 2 to the set, returns true. Set now contains [1,2].
        randomSet.insert(23);

// getRandom should return either 1 or 2 randomly.
        System.out.println(randomSet.getRandom());

// Removes 1 from the set, returns true. Set now contains [2].

// 2 was already in the set, so return false.
        randomSet.insert(23);
        randomSet.insert(49);
        randomSet.insert(64);
        randomSet.insert(78);

        randomSet.remove(49);

// Since 2 is the only number in the set, getRandom always return 2.
        System.out.println(randomSet.getRandom());

    }
    ArrayList<Integer> nums;
    HashMap<Integer, Integer> locs;
    java.util.Random rand = new java.util.Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        nums = new ArrayList<Integer>();
        locs = new HashMap<Integer, Integer>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contain = locs.containsKey(val);
        if ( contain ) return false;
        locs.put( val, nums.size());
        nums.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        boolean contain = locs.containsKey(val);
        if ( ! contain ) return false;
        int loc = locs.get(val);
        if (loc < nums.size() - 1 ) { // not the last one than swap the last one with this val
            int lastone = nums.get(nums.size() - 1 );
            nums.set( loc , lastone );
            locs.put(lastone, loc);
        }
        locs.remove(val);
        nums.remove(nums.size() - 1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get( rand.nextInt(nums.size()) );
    }
}
