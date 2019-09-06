package com.linkai.getTheOffer.数组;

import java.util.Arrays;

/**
 * @ClassName: 矩阵的总路径数
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-9-6 下午9:35
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class 矩阵的总路径数 {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for (int i =0;i<m;i++){
            for (int j=0;j<n;j++){
                dp[j] = dp[j]+dp[j-1];
            }
        }
        return dp[n-1];
    }
}
