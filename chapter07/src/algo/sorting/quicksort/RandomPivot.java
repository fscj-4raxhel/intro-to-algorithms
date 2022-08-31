package algo.sorting.quicksort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static algo.sorting.quicksort.NaivePivot.partition;

public class RandomPivot {

    public void randomizedQuicksort(int[] arr, int p, int r){
        if(p<r){
            int q = randomizedPartition(arr,p,r);
            randomizedQuicksort(arr,p,q-1);
            randomizedQuicksort(arr,q+1,r);
        }
    }

    public int randomizedPartition(int[] arr, int p, int r){
        if(arr == null || arr.length == 0){
            return -1;
        }
        Random rand = new Random();
        int pivot = p + rand.nextInt(r-p+1);
        int temp;
        temp = arr[r];
        arr[r] = arr[pivot];
        arr[pivot] = temp;
        return partition(arr,p,r);
    }

    @Test
    public void testPartition(){
        int[] arr = new int[]{2,8,7,1,3,5,6,4};
        System.out.println("before: " + Arrays.toString(arr));
        randomizedQuicksort(arr, 0,arr.length-1);
        System.out.println("after: " + Arrays.toString(arr));
        arr = new int[]{13,19,9,5,12,8,7,4,21,2,6,11};
        System.out.println("before: " + Arrays.toString(arr));
        randomizedQuicksort(arr, 0,arr.length-1);
        System.out.println("after: " + Arrays.toString(arr));
        arr = new int[]{13,13,13,13,13,13,13,13,13};
        int q = randomizedPartition(arr, 0,arr.length-1);
        System.out.println("r: " + (arr.length - 1));
        System.out.println("q: " + q);
    }
}
