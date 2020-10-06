package com.cp.array.sort;

public class MinimumCountToReoveToMakeArraySorted {
  public static void main(String[] args) {
    int[] nums = {1,2,3,10,4,2,3,5};
    System.out.println(new MinimumCountToReoveToMakeArraySorted().findLengthOfShortestSubarray(nums));
  }

  public int findLengthOfShortestSubarray(int[] arr) {
    int left = 0;
    while(left + 1 < arr.length && arr[left] <= arr[left+1])
      left++;
    if(left == arr.length - 1) return 0;

    int right = arr.length - 1;
    while(right > left && arr[right-1] <= arr[right])
      right--;
    int result = Math.min(arr.length - left - 1, right);

    int i = 0;
    int j = right;
    while(i <= left && j < arr.length) {
      if(arr[j] >= arr[i]) {
        result = Math.min(result, j - i - 1);
        i++;
      }else {
        j++;
      }
    }
    return result;
  }
}
