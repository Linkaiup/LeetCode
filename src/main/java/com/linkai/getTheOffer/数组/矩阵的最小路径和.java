package com.linkai.getTheOffer.数组;

/**
 * @ClassName: 矩阵的最小路径和
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-9-6 下午9:27
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class 矩阵的最小路径和 {
    public int minPathSum(int[][] grid) {
        if (grid.length==0||grid[0].length==0)
            return 0;
        int m = grid.length,n=grid[0].length;
        int[] dp = new int[n];
        for (int i =0;i<m;i++){
            for (int j=0;j<n;j++){
                if (j==0)
                    dp[j]=dp[j];
                else if (i==0)
                    dp[j]=dp[j-1];
                else {
                    dp[j]=Math.min(dp[j],dp[j-1]);
                }
            dp[j]+=grid[i][j];
            }
        }
        return dp[n-1];
    }
}
