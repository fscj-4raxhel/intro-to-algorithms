package algo.sorting.heapsort;

import sun.security.pkcs11.wrapper.CK_ECDH1_DERIVE_PARAMS;

/**
 * We can use a max-heap structure to implement a priority queue which supports the following four basic operations:
 * 1)INSERT(S,x): inserts the element x into the set S.
 * 2)MAXIMUM(S): Returns the element of S with the largest key.
 * 3)EXTRACT-MAX(S): Removes and returns the element of S with the largest key.
 * 4)INCREASE-KEY(S,x,k): Increases the value of element x's key to the new value k, where k >= x
 *
 */
public class PriorityQueue {


    /**
     * HEAP-MAXIMUM(A)
     * return A[1]
     *
     * HEAP-MAXIMUM(A) implements the MAXIMUM(S) operation
     * @param heap is an int array with the max-heap property
     * @return The element of S with the largest key.
     */
    public int heapMaximum(int [] heap) throws Exception {
        if(heap == null || heap.length == 0)
            throw new Exception("heap underflow");
        return heap[1];
    }

    /**
     * HEAP-EXTRACT-MAX(A)
     * if A.heap-size <1
     *     error "heap underflow"
     * max = A[1]
     * A[1] = A[A.heap-size]
     * A.heap-size = A.heap-size - 1
     * MAX-HEAPIFY(A,1)
     * return max
     *
     * @param heap is an int array with the max-heap property
     * @return The element of S with the largest key.
     */
    public int heapExtractMax(int [] heap) throws Exception {
        if(heap == null || heap.length == 0 || heap[0] < 1)
            throw new Exception("heap underflow");
        int max = heap[1];
        heap[1] = heap[heap[0]--];
        Heapify.maxHeapify(heap,1);
        return max;
    }

    /**
     * HEAP-INCREASE-KEY(A,i,k)
     * if key < A[i]
     *     error "new key is smaller than current key"
     * A[i] = key
     * while i > 1 and A[PARENT(i)] < A[i]
     *     exchange A[i] with A[PARENT(i)]
     *     i = PARENT(i)
     *
     * loop invariant: At the start of each iteration of the while loop in line 54 -- 56,
     * A[PARENT(i)] >= A[LEFT(i)] and A[RIGHT(i)], if these nodes exists, and the subarray
     * A[1,...,A.heap-size] satisfies the max-heap property, except that there may be one
     * violation: A[i] may be larger than A[PARENT(i)]
     *
     * Initialization: Prior to the first iteration of the while loop, A[1,...,A.heap-size]
     * satisfies the max-heap property, except that there may be one
     * violation: A[i]==key may be larger than A[PARENT(i)]. Denote the original value of A[i]
     * by old. Then A[PARENT(i)] >= old >= A[LEFT(i)] and A[RIGHT(i)]
     * comes from the fact that A[j] is A[PARENT(LEFT(j))] hence A[j] >= A[LEFT(j)]
     *
     * Maintenance: Denote A[PARENT(i)] before exchange by parent, and A[i] = key, so we have
     * parent < key. After the before updating i, we have A[PARENT(i)] = key > A[i] = parent
     * which satisfies the heap property. We are off from the loop invariant by the location
     * where the violation may occur - now PARENT(i) instead of i. Updating i in line 56 reestablishes
     * the loop variant.
     *
     * Termination: The loop terminates when i = 1 or A[PARENT(i)] >= A[i] for some i > 1. In the first
     * case, A[1,...,A.heap-size] satisfies the max-heap property without violation because PARENT(1)
     * does not exist. In the second case, A[1,...,A.heap-size] satisfies the max-heap property so no
     * violation as well.
     *
     */
    public void heapIncreaseKey(int[] heap, int i, int key) throws Exception{
        if(heap == null || heap.length <= 1 || key < heap[i])
            throw new Exception("new key is smaller than current key");
        heap[i] = key;
        int temp;
        while(i > 1 && heap[i/2] < heap[i]){
            temp = heap[i];
            heap[i] = heap[i/2];
            heap[i/2] = temp;
            i /= 2;
        }
    }

    /**
     * MAX-HEAP-INSERT(A,key)
     * A.heap-size = A.heap-size + 1
     * A[heap-size] = -infy
     * HEAP-INCREASE-KEY(A,A.heap-size,key)
     *
     */
    public void maxHeapInsert(int[] heap, int key){
        if(heap == null || heap.length <= 1)
            return;
        int heapSize = heap[0];
        int[] arr = new int[heapSize++];
        for(int i = 1; i <= heap[0]; i++){
            arr[i-1] = heap[i];
        }
        arr[0] = heapSize;
        arr[heapSize] = Integer.MIN_VALUE;
        heap = arr;
        try {
            heapIncreaseKey(heap,heapSize,key);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
