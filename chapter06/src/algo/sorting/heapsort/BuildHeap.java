package algo.sorting.heapsort;


import org.junit.Test;

import java.util.Arrays;

public class BuildHeap {

    /**
     * BUILD-MAX-HEAP(A)
     * A.heap-size = A.length
     * for i = A.length // 2 downto 1
     *     MAX-HEAPIFY(A,i)
     *
     * Loop invariant: At the start of each iteration of the for loop of lines 10--11, each node i + 1,
     * i + 2, ..., n is the root of a max-heap
     *
     * Initialization: Prior to the first iteration fo the loop, i = n // 2. Each node n // 2 + 1,
     * n // 2 + 2, ..., n is a leaf and is thus the root of a trivial max-heap
     *
     * Maintenance: The children of node i are indexed higher than i. Hence, by the loop invariant, they
     * are the root of max-heaps which meets the condition to call MAX-HEAPIFY. MAX-HEAPIFY preserves the
     * property that nodes i+1, i+2, ..., n are all roots of max-heaps. Decrementing i in the for loop
     * update reestablishes the loop invariant for the next iteration.
     *
     * Termination: At termination, i = 0. By the loop invariant, each node 1,2,...,n is the root of a max-heap.
     * In particular 1 is.
     */
    public static int[] buildMaxHeap(int[] arr){
        if(arr == null || arr.length == 0){
            return null;
        }
        int n = arr.length;
        int[] heap = new int[n+1];
        heap[0] = n; // store heap-size to the element indexed at 0.
        for(int i = 1; i <=n; i++){
            heap[i] = arr[i-1];
        }
        for(int i = n / 2; i >= 1; i--){
            Heapify.maxHeapifyIterative(heap,i);
        }
        return heap;
    }

    @Test
    public void testBuildMaxHeap(){
        int[] arr = new int[]{5,3,17,10,84,19,6,22,9};
        System.out.println("before: " + Arrays.toString(arr));
        int[] heap = buildMaxHeap(arr);
        System.out.println("after: " + Arrays.toString(heap));
    }
}
