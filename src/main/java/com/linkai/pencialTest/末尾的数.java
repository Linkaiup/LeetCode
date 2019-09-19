package com.linkai.pencialTest;

import java.util.Scanner;

/**
 * @ClassName: 末尾的数
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-9-19 下午4:45
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class 末尾的数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int result = 1;
        while (num > 0) {
            result *= num;
            while (result % 10 == 0) {
                result /= 10;
            }
            result = result % 10;
            num--;
        }
        System.out.println(result);
    }
}
