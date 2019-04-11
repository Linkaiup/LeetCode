package com.linkai.sort;

/**
 * @ClassName: SelectionSort
 * @Description: 选择排序,类似冒泡排序
 * @Author: K LIn
 * @Date: 18-10-11 下午8:47
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {3,2,1};
        int min,temp;
        for (int i = 0;i < array.length;i++){
            // 初始化未排序序列中最小数据数组下标
            min = i;
            //在未排序元素中继续寻找最小元素，并保存其下标
            for (int j = i;j < array.length;j++){
                if (array[j]<array[min]){
                    min = j;
                }
            }
            //将未排序列中最小元素放到已排序列末尾
            temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
        for (int x=0;x<array.length;x++) {
            System.out.println(array[x]);
        }
    }
}
