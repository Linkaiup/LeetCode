package com.linkai.getTheOffer.数学;

/**
 * @ClassName: 判断一个数是否是2的n次幂
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-9-27 下午1:17
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class 判断一个数是否是2的n次幂 {
    public static void main(String[] args) {
        int n =2048;
        boolean isTrue = n>0&&Integer.bitCount(n)==1;
        System.out.println(isTrue);
    }
}
