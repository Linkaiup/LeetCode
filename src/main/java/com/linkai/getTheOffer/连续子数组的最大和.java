package com.linkai.getTheOffer;

/**
 * @author K Lin
 * Date: 2019/7/25.
 * Time: 20:11
 * Remember to sow in the spring.
 * Description :
 */
public class 连续子数组的最大和 {
    public int FindGreatestSumOfSubArray(int[] array) {
        int left=0;
        int right=0;
        int sum = Integer.MIN_VALUE;
        int temp =0;
        int size = array.length;
        for (int i=0;i<size;i++){
            temp = 0;
            for (int j=i;j<size;j++){
                temp += array[j];
                if (temp>sum){
                    sum = temp;
                    left = i;
                    right = j;
                }
            }
        }
        return sum;
    }
}
