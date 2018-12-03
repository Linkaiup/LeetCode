package com.linkai.medium.submit029;

/**
 * @ClassName: Solution
 * @Description: TODO
 * @Author: K LIn
 * @Date: 18-12-3 下午8:51
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class Solution {
    public int divide(int dividend, int divisor) {
        int sign=1;
        int res=-1;
        if(dividend>0&&divisor<0||dividend<0&&divisor>0){
            sign=-1;
        }
        dividend=dividend>0?(0-dividend):dividend;
        divisor=divisor>0?(0-divisor):divisor;
        int orign_dividend=dividend;
        int orign_divisor=divisor;
        if(dividend>divisor)
            return 0;
        dividend-=divisor;
        while(dividend<=divisor){
            res+=res;
            divisor+=divisor;
            dividend-=divisor;
        }
        //两个负数计算结果一定为正，而用的是负数保存，所以取相反数
        res=res+0-divide(orign_dividend-divisor,orign_divisor);
        if(res==Integer.MIN_VALUE){
            if(sign==1) return Integer.MAX_VALUE;
            else return Integer.MIN_VALUE;
        }
        return sign>0?(0-res):res;
    }
}
