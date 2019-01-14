package com.linkai.medium.submit033;

/**
 * @ClassName: Solution
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-1-8 上午9:43
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class Solution {
    public static int search(int[] nums, int target) {
        int size = nums.length;
        if (size == 1){
            return nums[0]==target?0:-1;
        }else if (size==0){
            return -1;
        }
        int i = 0;
        for (; i < size; ) {
            int num = nums[i];
            if (target<num) {
                i = size-1;
                break;
            } else if(target>num){
                i++;
            }else {
                return i;
            }
        }
        if (i>=size){
            return -1;
        }
        for (;i>0;){
            int num = nums[i];
            if (target>num){
                return -1;
            }else if (target<num){
                i--;
            }else {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(search(nums, target));
    }
}
