package com.linkai.easy.submit009;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by K Lin
 * Date: 2018/4/22.
 * Time: 13:13
 * Remember to sow in the spring.
 * Description : LeetCode
 */
public class Solution {
    public static boolean isPalindrome(int x) {
        //使用 double 类型，因为int长度超过1000000000时就会溢出
        double temp;
        if (x < 0) {
            // 若给定整数是负数，返回 false
            return false;
        }
        List<Double> str = new ArrayList<>();
        for(double i=10;x > 0;i*=10){
            temp = x%i;
            //截取各个数字，添加入队列中
            str.add(temp/(i/10));
            //删除已存入队列中的数字
            x -= temp;
        }
        System.out.println(str);
        for(int j =0;j<str.size()/2;j++){
            if(!str.get(j).equals(str.get(str.size()-1 - j))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int test = 1000000000;
        System.out.println(isPalindrome(test));
    }
}
