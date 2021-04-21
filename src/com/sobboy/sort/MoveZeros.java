package com.sobboy.sort;

import java.util.Arrays;

public class MoveZeros {
    /**
     * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     * <p>
     * Note that you must do this in-place without making a copy of the array.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [0,1,0,3,12]
     * Output: [1,3,12,0,0]
     * <p>
     * <p>
     * Example 2:
     * <p>
     * Input: nums = [0]
     * Output: [0]
     * <p>
     * <p>
     * Follow up: Could you minimize the total number of operations done?
     */


    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    //最快
    public static void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }

    //常规 最慢
    public static void moveZeroes1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[nums.length - 1] = 0;
            }
        }
    }
}
