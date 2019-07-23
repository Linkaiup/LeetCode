package com.linkai.getTheOffer;

/**
 * @author: lk
 * @date: 2019/7/23 9:43
 */
public class NumberOf1 {
    /**
     * 时间复杂度二进制长度的解法
     * @param num
     * @return
     */
    public static int NumberOf1II(int num){
        int count=0;
        while (num!=0){
            if ((num&1)==1)
                count++;
            num = num>>>1;
        }
        return count;
    }
    /**
     * 常数时间复杂度的解法：利用公式num&(num-1)
     * @param num
     * @return
     */
    public static int NumberOf1(int num){
        int count=0;
        while (num!=0){
            num &= (num-1);
            count++;
        }
        return count;
    }
}
