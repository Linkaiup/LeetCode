package com.linkai.getTheOffer;

/**
 * @ClassName: ReserveFindNum
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-7-14 下午3:13
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class ReserveFindNum {
    public int search(int[] nums, int target) {
        int left = nums[0];
        int leftIndex = 0;
        int lenght = nums.length;
        int right = nums[lenght - 1];
        int rightIndex = lenght - 1;
        int index = lenght / 2;
        int mid = nums[index];
        //分情况进行调用serach()
        return 0;
    }

    public int find_point_index(int left,int right,int[] nums){
        if (nums[left]<nums[right])
            return 0;

        while (left<=right){
            int mid = (left+right)/2;
            if (nums[mid]>nums[mid+1])
                return mid+1;
            if (nums[mid]>nums[left])
                left=mid+1;
            else if (nums[mid]<nums[left])
                right=mid-1;
        }
        return 0;
    }

    public int search(int target,int left,int right,int[] nums){
        while (left<=right){
            int mid = (left+right)/2;
            if (nums[mid]==target)
                return mid;
            else {
                if (target<nums[mid])
                    right=mid-1;
                else
                    left=mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
