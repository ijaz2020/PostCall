package com.hotel;

class RemoveDuplicates
{
    // Function to remove duplicate elements 
    // This function returns new size of modified 
    // array. 
     int removeDuplicates(int arr[], int n)
    {
        if (n == 0 || n == 1)
            return n;

        // To store index of next unique element 
        int j = 0;

        // Doing same as done in Method 1 
        // Just maintaining another updated index i.e. j 
        for (int i = 0; i < n-1; i++)
            if (arr[i] != arr[i+1])
                arr[j++] = arr[i];

        arr[j++] = arr[n-1];

        return j;
    }

    public int removeDuplicates2(int[] nums) {
        int n = nums.length;
        if(n < 3) return n;
        int j=0, count = 1;
        for(int i=0; i<n-1; i++){
            if(nums[i] == nums[i+1]) count++;
            else{
                nums[j++] = nums[i];
                if(count >=2)
                    nums[j++] = nums[i];
                count =1;
            }
        }

        if(count >= 1){
            nums[j++] = nums[n-1];
            if(count >=2)nums[j++] = nums[n-1];
        }
        return j;
    }

    public static void main (String[] args)
    {
        int arr[] = {0,0,1,1,1,1,2,3,3};
        int n = arr.length;

//        n = new RemoveDuplicates().removeDuplicates(arr, n);
        n = new RemoveDuplicates().removeDuplicates2(arr);

        // Print updated array 
        for (int i=0; i<n; i++)
            System.out.print(arr[i]+" ");
    }
} 
