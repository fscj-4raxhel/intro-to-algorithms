package algo.practice;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class SortingAlgos {
    public void insertionSort(int[] arr){
        if(arr == null || arr.length == 0)
            return;
        int key,j;
        for (int i = 1; i < arr.length; i++) {
            key = arr[i];
            j = i - 1;
            while(j >=0 && arr[j] > key){// search left if arr[j] > key and j >=0
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }

    public void selectionSort(int[] arr){
        if(arr == null || arr.length == 0)
            return;
        int min,temp;
        for (int i = 0; i < arr.length - 1; i++) {
            min = i;
            for (int j = i; j < arr.length; j++) {
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    private int[] generateRandomIntegers(){
        int n = (int) (Math.random() * (33) + 21);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Random().nextInt(100);
        }
        return arr;
    }

    @Test
    public void testSelectionSort(){
        int[] arr = generateRandomIntegers();
        System.out.println(Arrays.toString(arr));
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void testInsertionSort(){
        int[] arr = generateRandomIntegers();
        System.out.println(Arrays.toString(arr));
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
