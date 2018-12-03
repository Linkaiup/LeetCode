package com.linkai.medium.submit018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Solution
 * @Description: TODO
 * @Author: K LIn
 * @Date: 18-11-25 下午9:24
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class Solution {
    //类比3Sum的写法
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
        if(len < 4 || nums[0] + nums[1] + nums[2] + nums[3] > target
                || nums[len - 1] + nums[len - 2] + nums[len - 3] + nums[len - 4] < target)
            return result;
        for( int i = 0;i < len - 3 &&
                nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] <= target ;i++)
            //类似3SUm，只是多加了个数，同样地使用循环遍历
            for(int j = i + 1; j < len - 2 &&
                    nums[i] + nums[j] + nums[j + 1] + nums[j + 2] <= target;j++) {
                int k = j + 1,t = len - 1,temp = target - nums[i] - nums[j];
                while(k < t )
                    if(nums[k] + nums[t] == temp) {
                        List res = Arrays.asList(nums[i] ,nums[j],nums[k],nums[t]);
                        if(!result.contains(res))
                            result.add(res);
                        k++; t--;
                    }
                    else if(nums[k] + nums[t] < temp) k++;
                    else t--;
            }
        return result;
    }
}
