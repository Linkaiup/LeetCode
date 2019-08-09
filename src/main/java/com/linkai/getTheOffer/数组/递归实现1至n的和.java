package com.linkai.getTheOffer.数组;

/**
 * @author: lk
 * @date: 2019/8/7 17:12
 */
public class 递归实现1至n的和 {
    public int Sum_Solution(int n) {
        int result = n;
        boolean pass = (n>0)&&((result+=Sum_Solution(n-1))>0);
        return result;
    }
}
