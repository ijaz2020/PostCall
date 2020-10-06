package com.cp.binarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class AlertKeyCards {
    public static void main(String[] args) {
        String[] kn = {"daniel","daniel","daniel","luis","luis","luis","luis"},
        kt = {"10:00","10:40","11:00","09:00","11:00","13:00","15:00"};
        System.out.println(new AlertKeyCards().alertNames(kn, kt));
    }
    int HR = 60;
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        var empEntry = new HashMap<String, List<Integer>>();
        var res = new ArrayList<String>();
        int n = keyName.length;
        for(int i=0; i < n; i++){
            int t = Integer.parseInt( keyTime[i].split(":")[0]) * HR +  Integer.parseInt(keyTime[i].split(":")[1]);
            empEntry.computeIfAbsent(keyName[i], k -> new ArrayList<>()).add(t);
            int j = Collections.binarySearch( empEntry.get(keyName[i]), t-HR );
            j = j < 0 ? ~j : j;
            if(empEntry.get(keyName[i]).size() - j >= 3){
                res.add(keyName[i]);
            }
        }
        return res;
    }
}
