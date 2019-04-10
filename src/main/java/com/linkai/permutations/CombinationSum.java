package com.linkai.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: CombinationSum
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-3-11 下午8:42
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> listAll=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        //排序
        Arrays.sort(candidates);
        find(listAll,list,candidates,target,0);
        return listAll;
    }
    public static void find(List<List<Integer>> listAll,List<Integer> tmp,int[] candidates, int target,int num){
        if (target==0){
            listAll.add(tmp);
            return;
        }
        if (target<candidates[0])return;
        for (int i = num;i<candidates.length&&candidates[i]<=target;i++){
            List<Integer> list=new ArrayList<>(tmp);
            list.add(candidates[i]);
            find(listAll,list,candidates,target-candidates[i],i);
        }
    }

    public static void main(String[] args) {
        int[] nums={2,3,6,7};
        List<List<Integer>> listAll = combinationSum(nums,7);
        System.out.println(listAll);
    }
}
