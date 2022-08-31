package algo.starter;
/*
Input: Two sequences of n binary digits in array A = {a1,a2,...,an}
       and  A = {b1,b2,...,bn}
Output: Array C of length n + 1 which stores the sum the binary integer A and B

Pseudocode:
Add-Binary(A,B)
carry = 0;
for i = A.length downto 1
    c_i = (A[i] + B[i] + carry) % 2
    carry = (A[i] + B[i] + carry) / 2
    C[i+1] = c_1
C[0] = carry
return C

Loop Invariant:
At the start of each iteration of the for loop of line 7 -- 15,
the sum of the subarray A[i + 1,...,n] and subarray B[i + 1,...,n]
are store in subarray C[i+2,...,n+1] with carry stored in c_i

Initialization: When i = n, A[n + 1,...,n] and B[n + 1,...,n] are empty.
                Hence, loop invariant holds
Maintenance: In the loop body, carry from the lower bits are stored
             in carry. By adding digits at A[i] and B[i] and carry,
             we can then compute the digits of position C[i] and carry
             from summation of A[i,...,n] and B[i,...,n] and store it
             int variable carry.

Termination: The loop terminates when i equals 0 with C[2,...,n+1]
             contains the sum of A[1,...,n] and B[1,...,n]
             and carry holds the carry
 */

import org.junit.Test;

import java.util.Arrays;

public class AddBinaryString {

    public int[] addBinary(int[] arr_1, int[] arr_2){
        if(arr_1 == null || arr_1.length == 0)
            return null;
        if(arr_2 == null || arr_2.length ==0)
        if(arr_1.length != arr_2.length)
            return null;
        int n = arr_1.length;
        int[] res = new int[n + 1];
        int carry = 0;
        for(int i = n-1; i > -1 ; i--){
            res[i+1] = (arr_1[i] + arr_2[i] + carry) % 2;
            carry = (arr_1[i] + arr_2[i] + carry) / 2;
        }
        res[0] = carry;
        return res;
    }

    @Test
    public void testAddBinary(){
        int[] arr_1 = new int[]{0,0,1,1,1};
        int[] arr_2 = new int[]{0,0,1,1,0};
        int[] res = addBinary(arr_1,arr_2);
        System.out.println(Arrays.toString(res));
    }

}