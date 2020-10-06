package com.cp.map;

import java.util.*;

public class RandomizedSetDuplicates {
    public static void main(String[] args) {
        /*["RandomizedCollection","insert","insert","insert","insert",
        "insert","insert","remove","remove","remove","insert","remove"]
[[],[9],[9],[1],[1],[2],[1],   [2],[1],[1],[9],[1]]*/
        RandomizedSetDuplicates r = new RandomizedSetDuplicates();
        r.insert(9);
        r.insert(9);
        r.insert(1);
        r.insert(1);
        r.insert(2);
        r.insert(1);

        r.remove(2);
        r.remove(1);
        r.remove(1);

        r.insert(9);

        r.remove(1);
        r.getRandom();
    }

    ArrayList<Integer> result;
    HashMap<Integer, LinkedHashSet<Integer>> map;

    public RandomizedSetDuplicates() {
        result = new ArrayList<Integer>();
        map = new HashMap<Integer, LinkedHashSet<Integer>>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        // Add item to map if it doesn't already exist.
        boolean alreadyExists = map.containsKey(val);
        if(!alreadyExists) {
            map.put(val, new LinkedHashSet<Integer>());
        }
        map.get(val).add(result.size());
        result.add(val);
        return !alreadyExists;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) {
            return false;
        }
        // Get arbitary index of the ArrayList that contains val
        LinkedHashSet<Integer> valSet = map.get(val);
        int indexToReplace = valSet.iterator().next();

        // Obtain the set of the number in the last place of the ArrayList
        int numAtLastPlace = result.get(result.size() - 1);
        LinkedHashSet<Integer> replaceWith = map.get(numAtLastPlace);

        // Replace val at arbitary index with very last number
        result.set(indexToReplace, numAtLastPlace);

        // Remove appropriate index
        valSet.remove(indexToReplace);

        // Don't change set if we were replacing the removed item with the same number
        if(indexToReplace != result.size() - 1) {
            replaceWith.remove(result.size() - 1);
            replaceWith.add(indexToReplace);
        }
        result.remove(result.size() - 1);

        // Remove map entry if set is now empty, then return
        if(valSet.isEmpty()) {
            map.remove(val);
        }
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        // Get linearly random item
        return result.get((int)(Math.random() * result.size()));
    }
}
