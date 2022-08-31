package algo.practice;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class BinarySearch {

    /**
     * Pseudocode for iterative binary search
     *
     * BINARY-SEARCH(A,key):
     * p = 1, r = A.length
     * while p <= r
     *     q = p + (p - r) // 2
     *     if A[q] == key
     *         return q
     *     else-if A[q] < key
     *         p = q + 1;
     *     else
     *         r = q - 1;
     * return -1
     */
    /*
    Loop invariant: from the start of each iteration of the while loop in lin 8 -- 17, if key is contained in A[1,...,n]
    then key is also contained in A[p,...,r].
     */
    public int binarySearchIterative(int[] arr, int key){
        if(arr == null || arr.length == 0){
            return -1;
        }
        int l,r,mid;
        l = 0;
        r = arr.length - 1;
        while( l <= r){
            mid = l + (r - l) / 2;
            if(arr[mid] == key){
                return mid;
            }
            if(arr[mid] < key){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return -1;

    }
    @Test
    public void testBinarySearchIterative(){
        int[] arr = new int[]{1,2,3,4,21,5,6,7,8};
        System.out.println(Arrays.toString(arr));
        System.out.println(binarySearchIterative(arr,5));
        System.out.println(binarySearchIterative(arr,8));
        System.out.println(binarySearchIterative(arr,21));
        arr = generateRandomIntegers();
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(binarySearchIterative(arr,arr[0]));
        System.out.println(binarySearchIterative(arr,arr[1]));
        System.out.println(binarySearchIterative(arr,arr[2]));
        System.out.println(binarySearchIterative(arr,arr[3]));
        System.out.println(binarySearchIterative(arr,arr[4]));
        System.out.println(binarySearchIterative(arr,arr[5]));
        System.out.println(binarySearchIterative(arr,arr[6]));

    }

    private int[] generateRandomIntegers(){
        int n = (int) (Math.random() * (32) + 21);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Random().nextInt(100);
        }
        return arr;
    }

    /**
     * Pseudocode for recursive binary search
     *
     * BINARY-SEARCH(A,p,r,key):
     * if p < r
     *     return -1;
     * q = p + (r - p) // 2
     * if A[q] == key
     *     return q
     * if A[q] < key
     *     BINARY-SEARCH(A,q + 1,r,key)
     * else
     *     BINARY-SEARCH(A,p,q - 1,key)
     */
    public int binarySearchRecursive(int[] arr, int l, int r, int key){
        if(arr == null || arr.length ==0){
            return -1;
        }
        if(r < l){
            return -1;
        }
        int mid = l + (r - l) / 2;
        if(arr[mid] == key)
            return mid;
        if(arr[mid] < key){
            return binarySearchRecursive(arr, mid + 1, r, key);
        }
        else{
            return binarySearchRecursive(arr, l, mid - 1, key);
        }
    }
    @Test
    public void testBinarySearchRecursive(){
        int[] arr = new int[]{1,2,3,4,21,5,6,7,8};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(binarySearchRecursive(arr,0,arr.length-1,3));
        System.out.println(binarySearchRecursive(arr,0,arr.length-1,21));
        System.out.println(binarySearchRecursive(arr,0,arr.length-1,8));
        arr = generateRandomIntegers();
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(binarySearchRecursive(arr,0,arr.length-1,arr[3]));
        System.out.println(binarySearchRecursive(arr,0,arr.length-1,arr[4]));
        System.out.println(binarySearchRecursive(arr,0,arr.length-1,arr[5]));
        System.out.println(binarySearchRecursive(arr,0,arr.length-1,arr[6]));
        System.out.println(binarySearchRecursive(arr,0,arr.length-1,arr[7]));
        System.out.println(binarySearchRecursive(arr,0,arr.length-1,arr[8]));
        System.out.println(binarySearchRecursive(arr,0,arr.length-1,arr[9]));

    }
}
