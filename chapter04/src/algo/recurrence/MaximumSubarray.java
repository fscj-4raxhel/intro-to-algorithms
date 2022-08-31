package algo.recurrence;

import org.junit.Test;

import java.util.Arrays;

/**
 * maximum subarray: nonempty, contiguous subarray of A whose values have the largest sum.
 * Suppose we want to find the maximum subarray of A[low,...,high]. We find the middle point mid.
 * Then any contiguous subarray A[i,j] of A[low,...,high] must lie in exactly one of the following
 * places:
 * 1) entirely in the subarray A[low,...,mid]
 * 2) entirely in the subarray A[mid+1,...,high]
 * 3) crossing the midpoint, so that low<= i mid < j <= high
 *
 * case 1) and 2) are solved recursively, case 3) is solved in linear time of n = high - low + 1
 */
public class MaximumSubarray {

    /**
     * FIND-MAX-CROSSING-SUBARRAY(A,low,mid,high)
     * left-sum = -infy
     * sum = 0
     * for i = mid downto low
     *     sum = sum + A[i]
     *     if sum > left-sum
     *         left-sum = sum
     *         max-left = i
     * right-sum = -infy
     * sum = 0
     * for j = mid + 1 to high
     *     sum = sum + A[j]
     *     if sum > right-sum
     *         right-sum = sum
     *         max-right = j
     * return (max-left, max-right, left-sum + right-sum)
     */

    private int[] findMaxCrossingSubarray(int[] arr, int low, int mid, int high){
        if(arr == null || arr.length == 0)
            return null;
        if(low > mid || mid >= high)
            return null;
        // temp[0] -> left-sum,  temp[1] -> left-index,
        // temp[2] -> right-sum, temp[3] -> right-index
        int[] temp = new int[]{Integer.MIN_VALUE,0,Integer.MIN_VALUE,0};
        int sum = 0;
        for (int i = mid; i >= low; i--) {
            sum += arr[i];
            if(sum > temp[0]){
                temp[0] = sum;
                temp[1] = i;
            }
        }
        sum = 0;
        for (int i = mid + 1; i <= high; i++) {
            sum += arr[i];
            if(sum > temp[2]){
                temp[2] = sum;
                temp[3] = i;
            }
        }
        return new int[]{temp[1],temp[3],temp[0] + temp[2]};
    }

    /**
     * FIND-MAXIMUM-SUBARRAY(A,low,high)
     * if low == high
     *     return (low,high,A[low])
     * else mid = low + (high - low) // 2
     *     (left-low,left-high,left-sum) = FIND-MAXIMUM-SUBARRAY(A,low,mid)
     *     (right-low,right-high,right-sum) = FIND-MAXIMUM-SUBARRAY(A,mid+1,high)
     *     (cross-low,cross-high,cross-sum) = FIND-MAX-CROSSING-SUBARRAY(A,low,mid,high)
     *     if left-sum >= right-sum and left-sum >= cross-sum
     *         return (left-low,left-high,left-sum)
     *     elseif right-sum >= left-sum and right-sum >= cross-sum
     *         return (right-low,right-high,right-sum)
     *     else
     *         return (cross-low,cross-high,cross-sum)
     *
     */

    public int[] findMaximumSubarray(int[] arr, int low, int high){
        if(arr == null || arr.length == 0 || low > high){
            return null;
        }
        if(low == high){
            return new int[]{low,high,arr[low]};
        }
        int mid = low + (high - low) / 2;
        int[] left,right,cross;
        left = findMaximumSubarray(arr,low,mid);
        right = findMaximumSubarray(arr,mid + 1,high);
        cross = findMaxCrossingSubarray(arr,low,mid,high);
        if (left[2] >= right[2] && left[2] >= cross[2]){
            return left;
        }else if(right[2] >= left[2] && right[2] >= cross[2]){
            return right;
        }else{
            return cross;
        }
    }

    @Test
    public void testFindMaximumSubarray(){
        int[] arr1 = new int[]{13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
        System.out.println("arr1:" + Arrays.toString(arr1));
        System.out.println("Maximum subarray for arr1: " + Arrays.toString(findMaximumSubarray(arr1,0,arr1.length-1)));
        int[] arr2 = new int[]{1,-4,3,-4};
        System.out.println("arr2:" + Arrays.toString(arr2));
        System.out.println("Maximum subarray for arr2: " + Arrays.toString(findMaximumSubarray(arr2,0,arr2.length-1)));
        int[] arr3 = new int[]{-21,-1,-2,-3,6,-5};
        System.out.println("arr3:" + Arrays.toString(arr3));
        System.out.println("Maximum subarray for arr3: " + Arrays.toString(findMaximumSubarray(arr3,0,arr3.length-1)));
    }

    /**
     * Linear time non-recursive approach:
     *
     * 1)Maintain the maximum subarray of A[1,...,j] and the maximum subarray ending at index j
     * 2)The maximum subarray of A[1,...,j + 1] is either the the maximum subarray of A[1,...,j]
     *   or the maximum subarray ending at index j+1
     * 3)Determine the maximum subarray ending at index j+1 from the maximum subarray ending at index j
     *   in constant time:
     *   Compare the maximum subarray ending at index j + A[j+1] and A[j+1].
     * 4) Compare the two and update.
     *
     */
    private int[] findMaximumSubarrayLinear(int[] arr,int low, int high){
        if(arr == null || arr.length == 0){
            return null;
        }
        if(low < 0 || high > arr.length - 1 || low > high)
            return null;
        int[] max  = new int[]{0,0,arr[0]}; // Keep track of the maximum subarray of A[1,...,j]
        int[] maxJ = new int[]{0,0,arr[0]}; // Keep track of the maximum subarray ending with index j;
        for(int j = 1; j < arr.length; j++){
            //1. update maxJ buy comparing maxJ[2] + A[j] and A[j]
            if(maxJ[2] + arr[j] > arr[j]){ // simplifies to if maxJ[2] > 0
                maxJ[1] = j;
                maxJ[2] += arr[j];
            }else{
                maxJ[0] = maxJ [1] = j;
                maxJ[2] = arr[j];
            }
            //2. Compare max[2] and maxJ[2] then update max[2]
            if(maxJ[2] > max[2]){
                max[0] = maxJ[0];
                max[1] = maxJ[1];
                max[2] = maxJ[2];
            }
        }
        return max;
    }

    @Test
    public void testFindMaximumSubarrayLinear(){
        int[] arr1 = new int[]{13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
        System.out.println("arr1:" + Arrays.toString(arr1));
        System.out.println("Maximum subarray for arr1: " + Arrays.toString(findMaximumSubarrayLinear(arr1,0,arr1.length-1)));
        int[] arr2 = new int[]{1,-4,3,-4};
        System.out.println("arr2:" + Arrays.toString(arr2));
        System.out.println("Maximum subarray for arr2: " + Arrays.toString(findMaximumSubarrayLinear(arr2,0,arr2.length-1)));
        int[] arr3 = new int[]{-21,-1,-2,-3,6,-5};
        System.out.println("arr3:" + Arrays.toString(arr3));
        System.out.println("Maximum subarray for arr3: " + Arrays.toString(findMaximumSubarrayLinear(arr3,0,arr3.length-1)));
        int[] arr4 = new int[]{12,7,-1,18,4,-1,-2,-3,6,-5};
        System.out.println("arr3:" + Arrays.toString(arr4));
        System.out.println("Maximum subarray for arr3: " + Arrays.toString(findMaximumSubarrayLinear(arr4,0,arr4.length-1)));
    }
    private int[] findMaximumSubarrayLinearSimplify(int[] arr,int low, int high){
        if(arr == null || arr.length == 0){
            return null;
        }
        if(low < 0 || high > arr.length - 1 || low > high)
            return null;
        // Keep track of the maximum subarray of A[1,...,j]
        int left,right,max;
        left = right = 0;
        max = arr[0];

        //Keep track of the maximum subarray ending with index j;
        int jLeft, jRight, jMax;
        jLeft = jRight = 0;
        jMax = arr[0];
        for(int j = 1; j < arr.length; j++){
            jRight = j;
            //1. update maxJ buy comparing maxJ[2] + A[j] and A[j]
            if(jMax > 0){
                jMax += arr[j];
            }
            else{
                jLeft = j;
                jMax = arr[j];
            }
            //2. Compare max[2] and maxJ[2] then update max[2]
            if(jMax > max){
                left = jLeft;
                right = jRight;
                max = jMax;
            }
        }
        return new int[]{left,right,max};
    }

    @Test
    public void testFindMaximumSubarrayLinearSimplify(){
        int[] arr1 = new int[]{13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
        System.out.println("arr1:" + Arrays.toString(arr1));
        System.out.println("Maximum subarray for arr1: " + Arrays.toString(findMaximumSubarrayLinearSimplify(arr1,0,arr1.length-1)));
        int[] arr2 = new int[]{1,-4,3,-4};
        System.out.println("arr2:" + Arrays.toString(arr2));
        System.out.println("Maximum subarray for arr2: " + Arrays.toString(findMaximumSubarrayLinearSimplify(arr2,0,arr2.length-1)));
        int[] arr3 = new int[]{-21,-1,-2,-3,6,-5};
        System.out.println("arr3:" + Arrays.toString(arr3));
        System.out.println("Maximum subarray for arr3: " + Arrays.toString(findMaximumSubarrayLinearSimplify(arr3,0,arr3.length-1)));
        int[] arr4 = new int[]{12,7,-1,18,4,-1,-2,-3,6,-5};
        System.out.println("arr3:" + Arrays.toString(arr4));
        System.out.println("Maximum subarray for arr3: " + Arrays.toString(findMaximumSubarrayLinearSimplify(arr4,0,arr4.length-1)));
    }
}
