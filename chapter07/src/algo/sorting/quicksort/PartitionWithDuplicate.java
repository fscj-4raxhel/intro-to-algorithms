package algo.sorting.quicksort;

import org.junit.Test;

import java.util.Arrays;

public class PartitionWithDuplicate {
    private int[] partition(int[] arr, int p, int r){
        if(arr == null || arr.length == 0){
            return null;
        }
        //should also check p and r are in reasonable range to avoid
        //ArrayIndexOutOfBound exception
        int pivot = arr[r];
        int i,k;
        i = k = p - 1;
        int temp;
        for(int j = p; j < r; j++){
            if(arr[j] < pivot){
                if(i == k){//A[i+1,...,k] is empty, only need to swap A[i+1] and A[j]
                    temp = arr[++i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    k++;
                }else{
                    arr[++i] = arr[j];
                    arr[j] = arr[++k];
                    arr[k] = pivot;
                }

            }else if(arr[j] == pivot){// swap A[k+1] and A[j]
                temp = arr[++k];
                arr[k] = arr[j];
                arr[j] = temp;
            }
        }
        temp = arr[++k];
        arr[k] = arr[r];
        arr[r] = temp;
        return new int[] {i + 1, k};
    }

    @Test
    public void testPartitionWithDuplicate(){
        int[] arr = new int[]{3,2,8,7,1,3,4,4,5,6,3};
        System.out.println("before: " + Arrays.toString(arr));
        int[] res = partition(arr, 0,arr.length-1);
        System.out.println("after: " + Arrays.toString(arr));
        System.out.println("q: " + res[0]);
        System.out.println("t: " + res[1]);
    }
}
