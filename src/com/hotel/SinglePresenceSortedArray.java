package com.hotel;

public class SinglePresenceSortedArray {
        // A Binary Search based method to find the element
        // that appears only once
        private static int singleNonDuplicate(int[] nums) {
            if(nums.length != 0){
                int left = 0, right = nums.length -1;
                while(left <= right){

                    if(left == right ){
                        return nums[left];
                    }
                    int mid = left + (right - left) / 2;

                    if(mid % 2 ==0){
                        if(nums[mid] == nums[mid +1]){
                            left =mid +2;
                        }else{
                            right = mid;
                        }
                    }
                    else{
                        if(nums[mid] == nums[mid-1]){
                            left = mid +1;
                        }
                        else{
                            right = mid -1;
                        }
                    }
                }
            }
            return -1;
        }

        public static void main(String[] args)
        {
            int[] arr = {1, 1, 3, 3, 5, 5, 4, 7, 7, 8, 8};
            System.out.println(singleNonDuplicate(arr));
        }
    }


