package com.linkai.getTheOffer;

/**
 * @author: lk
 * @date: 2019/7/23 10:53
 */
public class ReOrderArray {
    public static void ReOrderArray(int[] array){
        for (int i =0;i<array.length;i++){
            for (int j=array.length-1;j>i;j--){
                if (array[j]%2==1&&array[j-1]%2==0){
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
    }
}
