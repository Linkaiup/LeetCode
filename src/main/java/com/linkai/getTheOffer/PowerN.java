package com.linkai.getTheOffer;

/**
 * @author: lk
 * @date: 2019/7/23 10:03
 */
public class PowerN {
    /**
     * 快速幂，计算过的不重复计算
     * @param base
     * @param n
     * @return
     */
    public static double PowerN(int base,int n){
        int realN = Math.abs(n);
        double result = 1.0;
        while (realN!=0){
            if ((realN&1)!=0)result*=base;
            //base升级
            base*=base;
            realN>>=1;
        }
        return n<0?1/result:result;
    }
}
