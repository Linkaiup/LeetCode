package com.linkai.pencialTest;

import java.util.Scanner;

/**
 * @ClassName: 落单的数
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-9-18 下午9:14
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class 落单的数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i=0;i<n;i++){
            array[i] = scanner.nextInt();
        }
        int result = array[0];
        for (int i=1;i<n;i++){
            result^=array[i];
        }
        System.out.println(result);
    }
}
