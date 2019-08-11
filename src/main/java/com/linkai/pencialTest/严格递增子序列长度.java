package com.linkai.pencialTest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName: 严格递增子序列长度
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-8-10 下午7:17
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class 严格递增子序列长度 {
    //动态规划
//    public static void main(String[] args) {
//        int[] arr = {5, 1, 6, 2, 7, 9, 91, 100,222};
//        int len=0;
//        if(arr==null||arr.length==0){
//            System.out.println(0);
//            return;
//        }
//        int dp[]=new int[arr.length];
//        dp[0]=1;
//        //dp[i] 表示到i为止是最长递增子序列的长度
//        for(int i=1;i<arr.length;i++)
//        {
//            dp[i]=1;
//            for(int j=0;j<i;j++)
//            {
//                if(arr[i]>arr[j])
//                {
//                    //求dp[i]时遍历，dp[0...i-1],找出arr[j]<arr[i]小且dp[j]是最大的
//                    //dp[i]=dp[j]+1;
//                    dp[i]=Math.max(dp[i],dp[j]+1);
//                }
//            }
//        }
//        for(int i=0;i<arr.length;i++)
//        {
//            len=Math.max(dp[i],len);
//        }
//        System.out.println(len);
//    }


    //序列长度
    private static int N;

    //二分查找
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        //正整数
        int[] val = new int[N];
        for (int i = 0; i < N; i++) {
            val[i] = sc.nextInt();
        }
        int max = 0;
        int[] dp = new int[N];
        for (int num : val) {
            //二分找位置
            int j = Arrays.binarySearch(dp, 0, max, num);
            //找不到新增
            j = j < 0 ? -(j + 1) : j;
            dp[j] = num;
            max = j == max ? (++max) : max;
        }
        System.out.println(max);
    }
}
