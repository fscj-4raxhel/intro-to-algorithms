package algo.starter;

import org.junit.Test;

/*
Input: A sequence of n numbers A[] = {a1, a2, ... , an} and value v;
Output: And index i such that A[i] = v or null if v does not appear in A;

Pseudocode:
Linear-Search(A,v)
for i = 1 to A.length
    if(A[i]==v)
        return i
    else
        i = i + 1
return null

Loop Invariant:
At the start of each iteration of the for loop of line 7 -- 12,
the subarray A[1...i - 1] does not contain value v;

Initialization: When i = 1, A[i - 1] is empty. Hence, loop invariant holds
Maintenance: In the loop body, it checks if the current position is the value of v.
It moves to the right position only if the current position is not equal to v.
So at the start of iteration i + 1, A[i] doesn't contain value v.
Termination: In case the loop terminates when i <= n, it finds v and returns
an index <= n. Otherwise, it ends with i = n + 1. Substituting to the loop
invariant yields A[n] does not contain value v

 */
public class LinearSearch {
    public int linearSearch(int[] arr, int value){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == value)
                return i;
        }
        return -1;
    }

    @Test
    public void testLinearSearch(){
        int[] arr = new int[]{1,2,3,4,21,5,6,7,8};
        System.out.println(linearSearch(arr,5) + 1);
        System.out.println(linearSearch(arr,8) + 1);
        System.out.println(linearSearch(arr,21) + 1);

    }
}
