package com.linkai.medium.submit034;

/**
 * @ClassName: Solution
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-1-14 上午10:49
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        int hi = nums.length-1,lo=0;
        while (lo<hi){
            int mid = (lo+hi)/2;
            if (nums[mid]<target){
                lo = mid+1;
            }else {
                hi = mid;
            }
        }
        if (nums[lo]!=target){
            return result;
        }else {
            result[0] = lo;
        }

        hi = nums.length-1;
        while (lo<hi){
            int mid = (lo+hi)/2+1;
            if (nums[mid]>target){
                hi = mid-1;
            }else {
                hi = mid;
            }
        }
        result[1] = hi;
        return result;
    }
}
