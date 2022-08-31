package algo.sorting.heapsort;

import org.junit.Test;

import java.util.Arrays;

public class Heapify {
    /*
    With array representation of an n-element heap A, given any index i, the following three procedures
    easily compute the parent, left child, and right child
    PARENT(i)
        return i // 2
    LEFT(i)
        return i * 2
    RIGHT(i)
        return i * 2 + 1
     */

    /**
     * Calling the Max-Heapify procedure maintains the max-heap property.
     * It assumes the binary trees rooted at LEFT(i) and RIGHT(i) are max-heaps
     *
     * Max-Heapify(A,i)
     * largest = 0
     * l = LEFT(i)
     * r = RIGHT(i)
     * if l <= A.heap-size and A[l] > A[i]
     *     largest = l
     * else largest = i
     * if r <= A.heap-size and A[r] > A[largest]
     *     largest = r
     * if largest != i
     *     exchange A[i] with A[largest]
     *     Max-Heapify(A,largest)
     *
     * @param arr
     */
    public static void maxHeapify(int[] arr, int i){
        if(arr == null || arr.length == 0)
            return;
        int l = i<<1;
        int r = (i<<1) + 1;
        int heapSize = arr[0];
        int largest = i;
        if (l <= heapSize && arr[l] > arr[i]){
            largest = l;
        }
        if (r <= heapSize && arr[r] > arr[largest]){
            largest = r;
        }
        if(largest != i){
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
            maxHeapify(arr, largest);
        }
    }

    @Test
    public void testMaxHeapify(){
        int[] arr = new int[]{0,27,17,3,16,13,10,1,5,7,12,4,8,9,0};
        arr[0] = arr.length - 1;
        System.out.println("before: " + Arrays.toString(arr));
        maxHeapify(arr, 3);
        System.out.println("after: " + Arrays.toString(arr));
    }

    //before: [15, 27, 17, 3, 16, 13, 10, 1, 5, 7, 12, 4, 8, 9, 0]
    //after: [15, 27, 17, 10, 16, 13, 9, 1, 5, 7, 12, 4, 8, 3, 0]

    public static void maxHeapifyIterative(int[] arr, int i){
        if(arr == null || arr.length == 0)
            return;
        // i: current tree node
        // l: left child of i
        // r: right child of i
        // loop condition: current i <= heapSize
        int heapSize = arr[0];
        int l,r,largest;
        while(i <= heapSize / 2){
            l = i << 1;
            r = (i << 1) + 1;
            if(l <= heapSize && arr[l] > arr[i]){
                largest = l;
            }else{
                largest = i;
            }
            if(r <= heapSize && arr[r] > arr[largest]){
                largest = r;
            }
            if(largest != i){
                int temp = arr[i];
                arr[i] = arr[largest];
                arr[largest] = temp;
                i = largest;
            }else{
                break;
            }
        }
    }

    @Test
    public void testMaxHeapifyIterative(){
        int[] arr = new int[]{0,23,17,14,6,13,10,1,5,7,12};
        arr[0] = arr.length - 1;
        System.out.println("before: " + Arrays.toString(arr));
        maxHeapifyIterative(arr, 5);
        System.out.println("after: " + Arrays.toString(arr));
    }
}
