import java.util.Arrays;

public class ProductElem {
    public static void main(String arg[]){
        int[] a ={2,3,4,5};
        System.out.println(Arrays.toString(new ProductElem().productExceptSelf1(a)));
    }
    private int[] productExceptSelf(int[] nums) {

            // The length of the input array
            int length = nums.length;

            // The left and right arrays as described in the algorithm
            int[] L = new int[length];
            int[] R = new int[length];

            // Final answer array to be returned
            int[] answer = new int[length];

            // L[i] contains the product of all the elements to the left
            // Note: for the element at index '0', there are no elements to the left,
            // so L[0] would be 1
            L[0] = 1;
            for (int i = 1; i < length; i++) {

                // L[i - 1] already contains the product of elements to the left of 'i - 1'
                // Simply multiplying it with nums[i - 1] would give the product of all
                // elements to the left of index 'i'
                L[i] = nums[i - 1] * L[i - 1];
            }

            // R[i] contains the product of all the elements to the right
            // Note: for the element at index 'length - 1', there are no elements to the right,
            // so the R[length - 1] would be 1
            R[length - 1] = 1;
            for (int i = length - 2; i >= 0; i--) {

                // R[i + 1] already contains the product of elements to the right of 'i + 1'
                // Simply multiplying it with nums[i + 1] would give the product of all
                // elements to the right of index 'i'
                R[i] = nums[i + 1] * R[i + 1];
            }

            // Constructing the answer array
            for (int i = 0; i < length; i++) {
                // For the first element, R[i] would be product except self
                // For the last element of the array, product except self would be L[i]
                // Else, multiple product of all elements to the left and to the right
                answer[i] = L[i] * R[i];
            }

            return answer;
        }

    public int[] productExceptSelf1(int[] nums) {
        int n = nums.length;
        int[] left = new int[n], right = new int[n], res = new int[n];
        left[0] = nums[0]; right[n-1] =nums[n-1];
        for(int i=1; i<n; i++)
            left[i] = left[i-1] * nums[i];
        for(int i=n-2; i>=0; i--)
            right[i] = right[i+1] * nums[i];
        res[0] = right[1]; res[n-1] = left[n-2];
        for(int i=1; i<n-1; i++)
            res[i] = left[i-1] * right[i+1];
        return res;
    }
}
