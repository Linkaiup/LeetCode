package com.linkai.sort;

/**
 * @ClassName: ShellSort
 * @Description: 希尔排序
 * @Author: K LIn
 * @Date: 18-10-11 下午7:07
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class ShellSort {
    public static void main(String[] args) {
        int[] array = {4,3,1,5,6,7,1,9};
        int number = array.length / 2;
        int i;
        int j;
        int temp;
        while(number >= 1){
            for (i = number;i < array.length; i++){
                //存着右边的未比较部分最左
                temp = array[i];
                //让 j 从每个步长距离的未比较的部分（最左）开始
                j = i-number;
                //降序排序
                while (j >= 0 && array[j] < temp){
                    //交换的第一步
                    array[j+number] = array[j];
                    j = j-number;
                }
                //交换第二步
                array[j+number] = temp;
            }
            //得出新步长
            number = number/2;
        }
        for (int x =0;x<array.length;x++) {
            System.out.println(array[x]);
        }
    }
}
