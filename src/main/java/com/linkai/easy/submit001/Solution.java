package com.linkai.easy.submit001;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by K Lin
 * Date: 2018/4/22.
 * Time: 10:30
 * Remember to sow in the spring.
 * Description : LeetCode
 */
public class Solution {
    public int[] twoSumA(int[] nums, int target) {
        int length = nums.length;
        for(int i = 0;i < length; i++){
            for (int j = i+1; j < length;j++){
                if (nums[i] + nums[j] == target){
                    return new int[] {i,j};
                }
            }
        }
        return null;
    }

    //借鉴大佬的方法
    public int[] twoSumB(int[] nums, int target) {
        int length = nums.length;
        Map<Integer,Integer> map = new HashMap<>(length);
        for (int i = 0;i < length;i++){
            map.put(nums[i],i);
        }
        for (int i = 0;i < length;i++){
            int temp = target - nums[i];
            if (map.containsKey(temp)){
                return new int[] {i,map.get(temp)};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {6, 8, 18};
        int target = 24;
        // 答案为[0, 2]
        System.out.println(Arrays.toString(solution.twoSumA(nums, target)));
        System.out.println(Arrays.toString(solution.twoSumB(nums, target)));
    }

}
