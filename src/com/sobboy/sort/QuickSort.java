package com.sobboy.sort;

import java.util.Arrays;

public class QuickSort {


    /**
     * 如何做到大于基准的放右边，小于基准的放左边？从左找到大于基准的数，从右找到小于基准的数，两个数交换
     * 注意：如果基准选左边，那就要从右边开始对比
     *
     * @param args
     */
    //为什么不能交换  交换的话会跑到大的数后面去了
    public static void main(String[] args) {

        int[] arr = {7, 3, 13, 65, 1, 21, 45, 5, 72, 33};
        sort(arr, 0, arr.length - 1);
    }

    //注意特殊情况 只有一个比基准大  或者  只有一个比基准小
    static void sort(int[] arr, int i, int j) {
        if (i > j) {
            return;
        }
        //基点和最后一个i交换 就能保证在中间位置
        int middle = arr[i];

        int left = i;
        int right = j;
        while (right > left) {
            //从右找小于基准的数
            while (arr[right] >= middle && left < right) {
                right--;
            }
            //从左找大于基准的数，加入等号排除基准
             while (arr[left] <= middle && left < right) {
                left++;
            }
            //如果只有小于数没有大于数  就不交换  等后面
            if (arr[right] < arr[left]) {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
            //此时有可能
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
