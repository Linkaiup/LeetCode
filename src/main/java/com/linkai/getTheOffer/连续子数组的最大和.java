package com.linkai.getTheOffer;

/**
 * @author K Lin
 * Date: 2019/7/25.
 * Time: 20:11
 * Remember to sow in the spring.
 * Description :
 */
public class 连续子数组的最大和 {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array.length==0 || array==null) {
            return 0;
        }
        int curSum=0;
        int greatestSum=Integer.MIN_VALUE;
        for (int i=0;i<array.length;i++){
            if (curSum<=0)
                curSum=array[i];
            else
                curSum+=array[i];
            if (curSum>greatestSum)
                greatestSum = curSum;
        }
        return greatestSum;
    }
}
