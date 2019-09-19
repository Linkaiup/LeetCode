package com.linkai.pencialTest;

import java.util.Scanner;

/**
 * @ClassName: 求询问次数
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-9-19 下午5:35
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class 求询问次数 {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        long num = scanner.nextInt();
        long result=1;
        long modNum = 1000003;
        while (num>=1){
            result*=num;
            result=result%modNum;
            num--;
        }
        System.out.println(result);
    }
}
