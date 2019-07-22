package com.linkai.getTheOffer;

/**
 * @author K Lin
 * Date: 2019/7/22.
 * Time: 20:09
 * Remember to sow in the spring.
 * Description :
 */
public class MinNumberInRotateArray {
    public static void main(String[] args) {
        int[] array = new int[]{3,4,5,1,2};
        int result = minNumberInRotateArray(array);
        System.out.println(result);
    }

    public static int minNumberInRotateArray(int[] array) {
        int left = 0;
        int right = array.length - 1;
        int mid;
        if(array == null || array.length == 0) return 0;
        while (left < right) {
            if (array[left]<array[right])return array[left];
            mid = (left + right) / 2;
            if (array[left] < array[mid]) {
                left = mid;
            } else if (array[left] > array[mid]) {
                right = mid;
            }else {
                left++;
            }
        }
        return Math.min(array[left],array[right]);
    }
}
