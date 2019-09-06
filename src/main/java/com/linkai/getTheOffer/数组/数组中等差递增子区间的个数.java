package com.linkai.getTheOffer.数组;

/**
 * @ClassName: 数组中等差递增子区间的个数
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-9-6 下午9:47
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class 数组中等差递增子区间的个数 {
    public int numberOfArithmeticSlices(int[] A) {
        if (A==null||A.length==0)
            return 0;
        int[] dp = new int[A.length];
        for (int i=2;i<A.length;i++){
            if ((A[i]-A[i-1])==(A[i-1]-A[i-2]))
                dp[i]=dp[i-1]+1;
        }
        int sum=0;
        for (int num:dp)
            sum+=num;
        return sum;
    }
}
