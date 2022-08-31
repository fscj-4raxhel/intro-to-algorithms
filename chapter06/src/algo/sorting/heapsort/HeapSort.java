package algo.sorting.heapsort;

import org.junit.Test;

import java.util.Arrays;

public class HeapSort {
    /**
     * HEAPSORT(A)
     * BUILD-MAX-HEAP(1)
     * for i = A.length downto 2
     *     exchange A[1] with A[i]
     *     A.heap-size A.heap-size - 1
     *     MAX-HEAPIFY(A,1)
     *
     * loop invariant: At the start of each iteration of the for loop of lines 6--9, the subarray
     * A[1,...,i] is a max-heap containing the i smallest elements of A[1,...,n] and the subarray
     * A[i,+1,...,n] contains the n - i largest elements of A[1,..,n], sorted.
     *
     * Initialization: Prior to the first iteration i = n. Hence, A[1,...,n] is a max-heap containing
     * the n elements of A[1,...,n], and the subarray A[i+1,...,n] is empty.
     *
     * Maintenance: Before the start of the iteration characterized by loop index i, by the loop invariant
     * and max-heap property, the maximum of A[1,...,i] is stored at A[1]. Exchanging it with A[i] in line 7
     * makes A[i,...,n] contains the n-i+1 largest elements of A[1,..,n], sorted. And calling MAX-HEAPIFY(A,1)
     * reestablishes the heap property of A[1,...,i-1].
     *
     * Termination: At termination, i = 1. By the loop invariant, A[1] contains the smallest element of A[1,...,n]
     * and A[2,...,n] contains the n - 1 largest elements of A[1,..,n], sorted. Hence A[1,..,n] is now sorted.
     */

    public void heapSort(int[] arr){
        if(arr == null || arr.length == 0){
            return;
        }
        int n = arr.length;
        int[] heap = BuildHeap.buildMaxHeap(arr);
        int temp;

        for(int i = n; i >= 2; i--){
            temp = heap[i];
            heap[i] = heap[1];
            heap[1] = temp;
            heap[0]--;
            Heapify.maxHeapify(heap,1);
        }

        for(int i = 1; i <=n; i++){
            arr[i-1] = heap[i];
        }
    }

    @Test
    public void testHeapSort(){
        int[] arr = new int[]{5,13,2,25,7,17,20,8,4};
        System.out.println("before: " + Arrays.toString(arr));
        heapSort(arr);
        System.out.println("after: " + Arrays.toString(arr));
    }
}
