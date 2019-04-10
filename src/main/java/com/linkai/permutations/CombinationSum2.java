package com.linkai.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: CombinationSum2
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-3-11 下午9:51
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class CombinationSum2 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> listAll=new ArrayList<List<Integer>>();
        List<Integer> list=new ArrayList<Integer>();
        //排序
        Arrays.sort(candidates);
        find(listAll,list,candidates,target,0);
        return listAll;
    }
    public static void find(List<List<Integer>> listAll,List<Integer> tmp,int[] candidates, int target,int start){
        if (target<0)return;
        if (target==0){
            listAll.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
            if(i>start && candidates[i]==candidates[i-1])continue;
            tmp.add(candidates[i]);
            find(listAll, tmp, candidates, target - candidates[i], i+1);
            tmp.remove(tmp.size()-1);
        }

    }

    public static void main(String[] args) {
        int[] nums={10,1,2,7,6,1,5};
        List<List<Integer>> listAll = combinationSum2(nums,8);
        System.out.println(listAll);
    }
}
