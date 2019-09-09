package com.linkai.getTheOffer.数学;

/**
 * @ClassName: 两个数的最大公约数
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-9-9 下午3:21
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class 两个数的最大公约数 {
    public static int gcdFunc(int m,int n){
        if (m<n){
            int t = m;
            m = n;
            n = t;
        }
        if (m%n!=0){
            int temp = m%n;
            return gcdFunc(n,temp);
        }else {
            return n;
        }
    }
}
