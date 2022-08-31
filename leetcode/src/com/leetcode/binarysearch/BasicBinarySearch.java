package com.leetcode.binarysearch;

import org.junit.Test;

public class BasicBinarySearch {

    public int search(int[] nums, int target) {
        int l,h,mid;
        l = 0;
        h = nums.length - 1;
        while(l <= h){
            mid = l + (h - l) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(target < nums[mid]){
                h = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return -1;
    }

    @Test
    public void testSearch(){
        int[] arr = new int[]{-1,0,3,5,9,12};
        System.out.println(search(arr,2));
    }
}
