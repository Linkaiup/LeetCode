package com.linkai.easy.submit011;

/**
 * @author K Lin
 * Date: 2018/7/15.
 * Time: 15:28
 * Remember to sow in the spring.
 * Description :
 */
public class Solution {
    public static int maxArea(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            }
            else {
                r--;
            }
        }
        return maxarea;
    }
    public static void main(String[] args) {
        int[] height = {2, 3, 10, 5, 7, 8, 9};
        int result = maxArea(height);
        System.out.println("the max Container is :" + result);
        double d1=-0.5;
        System.out.println("Ceil d1="+Math.ceil(d1));
        System.out.println("floor d1="+Math.floor(d1));
    }
}
