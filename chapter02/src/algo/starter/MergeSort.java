package algo.starter;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {

    /**
     * This method merges the sorted subarray A[p,...,q] and A[q+1,...,r],
     * assuming that p<= q < r and both subarray are sorted.
     * Pseudocode:
     * MERGE(A,p,q,r):
     * n1 = q - p + 1
     * n2 = r - q
     * Let L[p,...,n1+1] and R[q+1,...,n2+1] be new arrays
     * for i = 1 to n1:
     *     L[i] = A[p+i-1]
     * for j = 1 to n2;
     *     R[j] = [q + j]
     * L[n1+1] = infy
     * R[n2+1] = infy
     * i = 1
     * j = 1
     * for k = p to r
     *     if L[i] <= R[j]
     *          A[k] = L[i]
     *          i = i + 1
     *     else
     *          A[k] = R[j]
     *          j = j + 1
     *
     * Loop invariant: At the start of each iteration of the for loop of line2 21 -- 27, the subarray
     * A[p,...,k-1] contains the k - p smallest elements of L[1,...,n1+1] and R[1,...,n2+1], in sorted
     * order. Moreover, L[i] and R[j] are the smallest elements of their arrays that have not been copied
     * back into A.
     *
     */
    private void mergeWithSentinel(int[] arr, int p, int q, int r){
        if(arr == null || arr.length == 0)
            return;
        if(p > q || r <= q)
            return;
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] left = new int[n1 + 1];
        int[] right = new int[n2 + 1];
        for (int i = 0; i < n1; i++) {
            left[i] = arr[p + i];
        }
        for (int j = 0 ; j < n2 ; j++) {
            right[j] = arr[q + j + 1];
        }
        left[n1] = Integer.MAX_VALUE;
        right[n2] = Integer.MAX_VALUE;
        int i,j;
        i = j = 0;
        for (int k = p; k < r + 1; k++) {
            if(left[i] <= right[j]){
                arr[k] = left[i++];
            }
            else{
                arr[k] = right[j++];
            }
        }
    }

    public void mergeSortWithSentinel(int[] arr, int p, int r){
        if(p<r){
            int q = p + (r - p) / 2;
            mergeSortWithSentinel(arr,p,q);
            mergeSortWithSentinel(arr,q + 1,r);
            mergeWithSentinel(arr,p,q,r);
        }
    }

    @Test
    public void testMergeSortWithSentinel(){
        int n = (int) (Math.random() * (31) + 21);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Random().nextInt(100);
        }
        System.out.println(Arrays.toString(arr));
        mergeSortWithSentinel(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * This method checks does not employee a sentinel element but checks if one of the array is empty.
     * Pseudocode:
     *MERGE(A,p,q,r):
     * n1 = q - p + 1
     * n2 = r - q
     * Let L[p,...,n1] and R[q+1,...,n2] be new arrays
     * for i = 1 to n1:
     *     L[i] = A[p+i-1]
     * for j = 1 to n2;
     *     R[j] = [q + j]
     * i = 1
     * j = 1
     * for k = p to r
     *     if L[i] <= R[j]
     *          A[k] = L[i]
     *          i = i + 1
     *     else
     *          A[k] = R[j]
     *          j = j + 1
     *
     * Loop invariant: At the start of each iteration of the for loop of line2 21 -- 27, the subarray
     * A[p,...,k-1] contains the k - p smallest elements of L[1,...,n1+1] and R[1,...,n2+1], in sorted
     * order. Moreover, L[i] and R[j] are the smallest elements of their arrays that have not been copied
     * back into A.
     */

    private void mergeWithoutSentinel(int[] arr, int p, int q, int r){
        if(arr == null || arr.length == 0)
            return;
        if(p > q || r <= q)
            return;
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] left = new int[n1 + 1];
        int[] right = new int[n2 + 1];
        for (int i = 0; i < n1; i++) {
            left[i] = arr[p + i];
        }
        for (int j = 0 ; j < n2 ; j++) {
            right[j] = arr[q + j + 1];
        }
        left[n1] = Integer.MAX_VALUE;
        right[n2] = Integer.MAX_VALUE;
        int i,j;
        i = j = 0;
        for (int k = p; k < r + 1; k++) {
            if(i >= n1){//left is empty; copy right back to arr
                while(j < n2){
                    arr[k++] = right[j++];
                }
                break;
            }
            if(j >= n2){//right is empty, copy left back to arr
                while(i < n1){
                    arr[k++] = left[i++];
                }
                break;
            }
            if(left[i] <= right[j]){
                arr[k] = left[i++];
            }
            else{
                arr[k] = right[j++];
            }
        }
    }

    public void mergeSortWithoutSentinel(int[] arr, int p, int r){
        if(p<r){
            int q = p + (r - p) / 2;
            mergeSortWithoutSentinel(arr,p,q);
            mergeSortWithoutSentinel(arr,q + 1,r);
            mergeWithoutSentinel(arr,p,q,r);
        }
    }

    @Test
    public void testMergeSortWithoutSentinel(){
        int n = (int) (Math.random() * (33) + 21);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Random().nextInt(100);
        }
        System.out.println(Arrays.toString(arr));
        mergeSortWithoutSentinel(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
}
