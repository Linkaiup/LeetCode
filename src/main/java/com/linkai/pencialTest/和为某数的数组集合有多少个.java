package com.linkai.pencialTest;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @ClassName: 和为某数的数组集合有多少个
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-8-11 下午7:18
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class 和为某数的数组集合有多少个 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int S = sc.nextInt();
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        boolean[] visisted = new boolean[S+1];
        backTrack(visisted,1,0,S,N,lists);
        System.out.println(lists.size());
    }
    public static void backTrack(boolean[] visit,int n,int sum,int S,int N,ArrayList<ArrayList<Integer>> lists){
        if (sum==S){
            ArrayList<Integer> list = new ArrayList<>();
            for (int i =1;i<=n;i++){
                if (visit[i])
                    list.add(i);
            }
            if (list.size()==N){
                lists.add(list);
            }
            return;
        }
        for (int i =n;i<S;i++){
            if (!visit[i]){
                sum+=i;
                visit[i]=true;
                if (i!=S-1){
                    backTrack(visit,i+1,sum,S,N,lists);
                }else {
                    backTrack(visit,i,sum,S,N,lists);
                }
                visit[i]=false;
                sum-=i;
            }
        }
    }
}
