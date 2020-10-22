package com.cp.Utils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConversionUtil {
    public static void main(String[] args) {
        List<int[]> res = new ArrayList<>();
        System.out.println(Arrays.deepToString(res.toArray(new int[res.size()][2])));
        List<Integer> res1 = new ArrayList<>();
        System.out.println(Arrays.toString(res1.stream().mapToInt(i -> i).toArray()));
        String res2 = "4634354622669035435";
        // this works only for single digits ex(1,2,3,4,5) - Compound digit will fail( eg; 39,42,94) -> it splits like[3,9,4,2,9,4]
        System.out.println(Arrays.toString(res2.chars().mapToObj(i -> i-48).mapToInt(i->i).toArray()));

    }
}
