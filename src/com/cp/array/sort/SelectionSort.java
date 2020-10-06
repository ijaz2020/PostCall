package com.cp.array.sort;

import java.util.Arrays;

public class SelectionSort {
  public static void main(String[] args) {
    int[] nums= {0,6,2,7,5,9,0};
    new SelectionSort().selectionSort(nums);
    System.out.println(Arrays.toString(nums));
  }

  //Time Complexity  - O(n^2)
  //Space Complexity - O(1)
  void selectionSort(int[] nums){
    int n = nums.length;
    // 0,0,2,5,6,7,9;
    // 0 1 2 3 4 5 6
    for(int i=0; i<n; i++){
      int min = i;
      for(int j=i+1; j<n; j++){
        if(nums[j] < nums[min]){
          min = j;
        }
      }
      swap(i, min, nums);
    }
  }
  void swap(int i, int j, int[] nums){
    int t = nums[i];
    nums[i] = nums[j];
    nums[j] =t;
  }
}
