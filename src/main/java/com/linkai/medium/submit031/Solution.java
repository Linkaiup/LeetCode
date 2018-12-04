package com.linkai.medium.submit031;

/**
 * @ClassName: Solution
 * @Description: TODO
 * @Author: K LIn
 * @Date: 18-12-4 下午8:19
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length<=1){
            return;
        }

        int i= nums.length-1;

        for(;i>=1;i--){

            if(nums[i]>nums[i-1]){ //从后往前找，找到第一个小于其右相邻的数的数字
                break;
            }
        }

        if(i!=0){
            swap(nums,i-1); //将找到的数字和其右边的（从右往左数）第一个比它大的数字交换
        }

        reverse(nums,i);
    }

    private void swap(int[] a,int i){
        for(int j = a.length-1;j>i;j--){
            if(a[j]>a[i]){
                int t = a[j];
                a[j] = a[i];
                a[i] = t;
                break;
            }
        }
    }

    private void reverse(int[] a,int i){//将找到的数字的那一位之后（右边）的数字翻转
        int first = i;
        int last = a.length-1;
        while(first<last){
            int t = a[first];
            a[first] = a[last];
            a[last] = t;
            first ++;
            last --;
        }
    }
}
