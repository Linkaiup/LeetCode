package com.linkai.pencialTest;

import java.util.Scanner;

/**
 * @ClassName: 连续整数求和
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-9-10 下午8:10
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class 连续整数求和 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int count = 1;
        for (int n =2;2*num>n*(n-1);n++){
            if (2*num%n==0&&(2*num/n-n+1)%2==0){
                count++;
            }
        }
        System.out.println(count);
    }
}
