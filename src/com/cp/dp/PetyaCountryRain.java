package com.hotel.dp;

import com.hotel.Utils.PrintUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PetyaCountryRain {
  public static void main(String[] args) throws IOException {
//    new PetyaCountryRain().main1(999);
    int[] nums = {2,1,4,7,3,2,5};
    System.out.println(new PetyaCountryRain().longestMountain(nums));
  }

  public int longestMountain(int[] A) {
    int res = 0, up = 0, down = 0;
    for (int i = 1; i < A.length; ++i) {
      if (down > 0 && A[i - 1] < A[i] || A[i - 1] == A[i])
        up = down = 0;
      if (A[i - 1] < A[i])
        up++;
      if (A[i - 1] > A[i])
        down++;
      if (up > 0 && down > 0 && up + down + 1 > res)
        res = up + down + 1;
    }
    return res;
  }

  public void main1(int n) throws IOException {
    while(n > 0){
      n -= 1000;
    }
    System.out.println(-n);;
  }

  //4 2 3 3 2
  private int findMaximalSpace(int n, int[] nums) {
    int dpL[] = new int[n], dpR[] = new int[n], res =1;
    Arrays.fill(dpL, 1);
    Arrays.fill(dpR, 1);
    for(int i=1; i<n; i++){
     if(nums[i] >= nums[i-1]){
       dpL[i] = dpL[i-1]+1;
     }
    }
    for(int i=n-1; i >=0; i--){
      if(i+1 < n && nums[i] >= nums[i+1]){
        dpR[i] = dpR[i+1]+1;
      }
      res = Math.max(dpL[i] +dpR[i] -1, res);
    }
    return res;
  }
}
