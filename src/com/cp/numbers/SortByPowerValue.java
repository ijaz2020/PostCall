package com.cp.numbers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortByPowerValue {
    public static void main(String[] args) {
        System.out.println(new SortByPowerValue().getKth(12, 15, 2));
    }

    public int getKth(int lo, int hi, int k) {
        Map<Integer, Integer> pow = new HashMap<>();
        List<int[]> res = new ArrayList<>();
        for(int i=12; i<=15; i++){
            int num = i, score =0;

            while (num !=1){
                if(num %2 == 0){
                    if(pow.get(num) !=null){
                        num = pow.get(num);
                    }
                    else {
                        num = num / 2;
                    }
                }
                else{
                    if(pow.get(num) !=null){
                        num = pow.get(num);
                    }
                    else {
                        num = 3 * num + 1;
                    }
                }
                score++;
            }
            res.add(new int[]{i, score});
        }
        Collections.sort(res, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1]-b[1]);

        return res.get(k-1)[0];
    }
}
