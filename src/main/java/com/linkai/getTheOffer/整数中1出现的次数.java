package com.linkai.getTheOffer;

/**
 * @author: lk
 * @date: 2019/7/26 16:52
 */
public class 整数中1出现的次数 {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        long i = 1;
        for (i=1;1<=n;i*=10){
            count += (((n/i+8)/10*i));
            //TODO
        }
        return count;
    }
}
