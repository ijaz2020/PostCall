package com.cp.greedy.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeleteSubFolder {
    public static void main(String[] args){
        String[] s = {"/a","/a/b","/c/d","/c/d/e","/c/f"};
        System.out.println(new DeleteSubFolder().removeSubfolders(s));
    }
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> ans=new ArrayList<>();
        ans.add(folder[0]);
        for(int i=1;i<folder.length;i++){
            String last=ans.get(ans.size()-1);
            String cur=folder[i];
            if(!cur.startsWith(last+"/")){
                ans.add(cur);
            }
        }
        return ans;
    }
}
