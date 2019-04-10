package com.linkai.permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Permutations1
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-3-11 下午5:49
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class Permutations1 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                // element already exists, skip
                if(tempList.contains(nums[i])) continue;
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
