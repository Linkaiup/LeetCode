package com.linkai.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Subsets
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-3-11 下午8:26
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class Subsets {
    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(results,new ArrayList<>(),nums,0);
        return results;
    }
    public void backtrack(List<List<Integer>> results,List<Integer> list,int[] num,int start){
        results.add(new ArrayList<>(list));
        for (int i = start;i<num.length;i++){
            list.add(num[i]);
            backtrack(results,list,num,i+1);
            list.remove(list.size()-1);
        }
    }
}
