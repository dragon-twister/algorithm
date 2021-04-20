package com.sobboy.sort;

import java.util.Arrays;

public class QuickSort {


    /**
     * 如何做到大于基准的放右边，小于基准的放左边？从左找到大于基准的数，从右找到小于基准的数，两个数交换
     * 注意：如果基准选左边，那就要从右边开始对比
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {7, 3, 13, 65, 1, 21, 45, 5, 72, 33};
        sort(arr, 0, arr.length - 1);
    }

    static void sort(int[] arr, int i, int j) {
        if (i > j) {
            return;
        }

        int middle = arr[i];
        int left = i;
        int right = j;

        while (right > left) {
            //从右找小于基准的数
            while (arr[right] >= middle && left < right) {
                right--;
            }
            //从左找大于基准的数
             while (arr[left] <= middle && left < right) {
                left++;
            }
            //如果只有小于数没有大于数就不交换
            if (arr[right] < arr[left]) {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
        }
        //跳出循环时left=right ,此致的位置为小于几点的数
        //交换i和基点，基点变成left
        arr[i] = arr[right];
        arr[right] = middle;

        System.out.println(Arrays.toString(arr));

        sort(arr, i, left - 1);
        sort(arr, left + 1, j);

    }

}
