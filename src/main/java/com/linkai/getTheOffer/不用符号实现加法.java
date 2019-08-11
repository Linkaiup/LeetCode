package com.linkai.getTheOffer;

/**
 * @author: lk
 * @date: 2019/8/7 17:21
 */
public class 不用符号实现加法 {
    public int Add(int num1,int num2) {
        return ((num1&num2)<<1)|num1|num2;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
