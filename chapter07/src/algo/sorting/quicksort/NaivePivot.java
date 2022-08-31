package algo.sorting.quicksort;

import org.junit.Test;

import java.util.Arrays;

/**
 * This class describes the naive pivot point being the last element of A.
 */
public class NaivePivot {
    /**
     * The idea of quick sort is as follows:
     * Divide: Partition array A[p,...,r] into two possibly empty subarray using pivot A[q]
     * such that elements in A[p,...,q-1] <= A[q] <= elements in A[q+1,...,r].
     *
     * Conquer: Sort the two subarrays A[p,...,q-1] and A[q+1,...,r] by recursive calls to
     * quicksort.
     *
     * Combine: Become the subarrays are already sorted, no work is needed to combine them: the entire array A[p,..,r]
     * is now sorted.
     *
     * QUICKSORT(A,p,r)
     * if p<r
     *     q = PARTITION(A,p,r)
     *     QUICKSORT(A,p,q-1)
     *     QUICKSORT(A,p+1,r)
     */

    public void quicksort(int[] arr, int p, int r){
         if(p<r){
             int q = partition(arr,p,r);
             quicksort(arr,p,q-1);
             quicksort(arr,q+1,r);
         }
    }


    /**
     *
     * PARTITION(A,p,r)
     * x = A[r]
     * i = p-1;
     * for j = p to r-1
     *     if A[j] <= x
     *         i = i + 1
     *         exchange A[i] with A[j]
     * exchange A[i+1] with A[r]
     * return i + 1
     *
     * loop invariant: At the beginning of each iteration of the loop of lines 43--46,
     * for any array index k,
     * 1) if p<=k<=i, then A[k] <= x
     * 2) if i+1<=k<=j-1, then A[k] > x
     * 3) if k=r, then A[k]=x
     *
     * Initialization: Prior to the first iteration of the loop, i = p-1 and j =p.
     * Because no values lie between p and i and no values lies between i+1 and j -1
     * the first two conditions of the loop invariant are trivially satisfied.
     * The assignment in line 41 satisfies the third condition
     *
     * Maintenance: There are two cases depending on the test in line 44.
     * When A[j] > x, incrementing j reestablish condition 2 holding other entries unchanged.
     * When A[j] <= x, the loop increments i, swaps A[i] and A[j], and then increments j.
     * Because of the swap, we now have that A[i] <= x, and condition 1 is satisfied. Similarly,
     * we also have that A[j-1] >x, since the item that was swapped into A[j-1] is, by the loop
     * invariant.
     *
     * Termination: At termination, j = r. Therefore, every entry in the array is one of the three sets
     * described by the invariant, and we have partitioned the values in the array into three sets: those
     * less than or equal to x, those greater than x, and a singleton set containing x.
     */
    public static int partition(int[] arr, int p, int r){
        if(arr == null || arr.length == 0){
            return -1;
        }
        //should also check p and r are in reasonable range to avoid
        //ArrayIndexOutOfBound exception
        int pivot = arr[r];
        int i = p - 1;
        int temp;
        for(int j = p; j < r; j++){
            if(arr[j] <= pivot){
                temp = arr[++i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        temp = arr[i+1];
        arr[i+1] = arr[r];
        arr[r] = temp;
        return i + 1;
    }

    @Test
    public void testPartition(){
        int[] arr = new int[]{2,8,7,1,3,5,6,4};
        System.out.println("before: " + Arrays.toString(arr));
        quicksort(arr, 0,arr.length-1);
        System.out.println("after: " + Arrays.toString(arr));
        arr = new int[]{13,19,9,5,12,8,7,4,21,2,6,11};
        System.out.println("before: " + Arrays.toString(arr));
        quicksort(arr, 0,arr.length-1);
        System.out.println("after: " + Arrays.toString(arr));
        arr = new int[]{13,13,13,13,13,13,13,13,13};
        int q = partition(arr, 0,arr.length-1);
        System.out.println("r: " + (arr.length - 1));
        System.out.println("q: " + q);
    }
}
