package com.linkai.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Subsets2
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-3-11 下午8:33
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class Subsets2 {
    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(results,new ArrayList<>(),nums,0);
        return results;
    }
    public void backtrack(List<List<Integer>> results,List<Integer> list,int[] num,int start){
        results.add(new ArrayList<>(list));
        for (int i = start;i<num.length;i++){
            if (i > start && num[i] == num[i-1])continue;
            list.add(num[i]);
            backtrack(results,list,num,i+1);
            list.remove(list.size()-1);
        }
    }
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 100000000; i++) {
            for (int j = 0; j < 1000000; j++) {
                list.add(String.valueOf(i + j / 1000000).intern());
            }
        }
    }

}
