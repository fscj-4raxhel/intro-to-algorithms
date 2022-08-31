package algo.starter;

import org.junit.Test;

import java.util.Arrays;

public class SelectionSort {

/*
Input: A sequence of n numbers A[] = {a1, a2, ... , an}
Output: A permutation of the input sequence such that a1' <= a2' <= ... <= an'

Pseudocode:
Selection-Sort(A)
for i = 1 to A.length - 1
    min = j = i
    while(j <= A.length)
        if(A[j] < A[min])
            min = j
    j = A[i]
    A[i] = A[min]
    A[min] = A[i]

Loop Invariant:
At the start of each iteration of the for loop of line 10 -- 18,
the subarray A[1...i - 1] contains the smallest i - 1 elements
from A[] but in sorted order.

Initialization: When i = 1, A[i - 1] is empty. Hence, loop invariant holds
Maintenance: In the loop body, it swaps A[i] with the smallest
element A[min] for the subarray A[i,...,n]. So when at the start of the next iteration,
A[1,...,i] contains the smallest i elements of A[1,...,n] in order.
Termination: When the loop terminates at i = n, A[1,...,n-1]
contains the smallest n - 1 elements in order, leaving the nth
smallest element which is also the maximum element at A[n].
Hence, A[1,..,n] is sorted

 */


    /*
    Pseudocode:
    Selection-Sort(A)
    for i = 1 to A.length - 1
        min = j = i
        while(j <= A.length)
            if(A[j] < A[min])
                min = j
        j = A[i]
        A[i] = A[min]
        A[min] = A[i]
     */
    public void selectionSort(int[] arr){
        if(arr == null || arr.length == 0)
            return;
        for (int i = 0; i < arr.length - 1; i++) {
            int min,j;
            min = j = i;
            while( j < arr.length){
                if(arr[j] < arr[min]){
                    min = j;
                }
                j++;
            }
            j = arr[min];
            arr[min] = arr[i];
            arr[i] = j;
        }
    }

    @Test
    public void testSelectionSort(){
        int[] case1 = new int[]{21,41,59,26,41,58};
        int[] case2 = new int[]{-1,123,5,43,625,2,4,6,1,3};

        System.out.println(Arrays.toString(case1));
        System.out.println(Arrays.toString(case2));

        selectionSort(case1);
        selectionSort(case2);

        System.out.println(Arrays.toString(case1));
        System.out.println(Arrays.toString(case2));
    }
}
