package com.linkai.sort;

import java.util.Arrays;

/**
 * @ClassName: QuickSort
 * @Description: 快速排序
 * @Author: K LIn
 * @Date: 18-10-12 下午8:24
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class QuickSort {
    public static void qSort(int[] array,int head,int tail){
        if (head >= tail||array == null||array.length<=1){
            return;
        }
        //选择中间数值作为基数进行排序
        int i = head,j = tail,pivot = array[(head + tail) / 2];
        while (i <= j){
            while (array[i]<pivot){
                ++i;
            }
            while (array[j]>pivot){
                --j;
            }
            if (i<j){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                ++i;
                --j;
            }else if (i==j){
                ++i;
            }
        }
        qSort(array,head,j);
        qSort(array,i,tail);
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 8, 2, 55, 3, 4, 8, 6, 4, 0, 11, 34, 90, 23, 54, 77, 9, 2, 9, 4, 10};
        qSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
