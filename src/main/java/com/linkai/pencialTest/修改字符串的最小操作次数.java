package com.linkai.pencialTest;

import java.util.Scanner;

/**
 * @ClassName: 修改字符串的最小操作次数
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-9-10 下午7:43
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class 修改字符串的最小操作次数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();
        int len = a.length();
        int preA = len-1;
        int pointA = len-1;
        int preB = len-1;
        int pointB = len-1;
        int count = 0;
        while (preA>=0){
            if (a.charAt(pointA)==b.charAt(pointB)){
                count+=preA-pointA-(preB-pointB);
                preA = pointA;
                preB = pointB;
                pointA--;
                pointB--;
            }else {
                pointA--;
            }
        }
        System.out.println(preA+count);
    }
}
