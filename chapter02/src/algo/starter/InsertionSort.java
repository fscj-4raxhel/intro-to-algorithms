package algo.starter;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class InsertionSort {
    public static void insertionSortAsc(int[] arr){
        if(arr == null || arr.length == 0)
            return;
        int key;
        //if arr.length == 1, loop is not entered.
        for(int i = 1; i < arr.length; i++){
            key = arr[i];
            int j = i - 1;
            //the condition to continue search left:
            while(j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }
            //So when falling off this loop there will be two cases:
            //1. It reaches to the left end of the array, j = -1 for this case
            //2. arr[j] <= key. Hence, should insert key to position j+1
            arr[j+1] = key;
        }
    }

    public static void insertionSortDesc(int[] arr){
        if(arr == null || arr.length == 0)
            return;
        int key;
        //if arr.length == 1, loop is not entered.
        for(int i = 1; i < arr.length; i++){
            key = arr[i];
            int j = i - 1;
            //the condition to continue search left:
            while(j >= 0 && arr[j] < key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }



    @Test
    public void testInsertionSortAsc(){
        int n = (int) (Math.random() * (32) + 21);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Random().nextInt(100);
        }

        System.out.println(Arrays.toString(arr));

        insertionSortAsc(arr);

        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void testInsertionSortDesc(){
        int[] case1 = new int[]{21,41,59,26,41,58};
        int[] case2 = new int[]{5,2,4,6,1,3};

        System.out.println(Arrays.toString(case1));
        System.out.println(Arrays.toString(case2));

        insertionSortDesc(case1);
        insertionSortDesc(case2);

        System.out.println(Arrays.toString(case1));
        System.out.println(Arrays.toString(case2));
    }
}
