package com.linkai.pencialTest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName: 数组中方差最小的三个数字
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-8-11 下午7:16
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class 数组中方差最小的三个数字 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] array = new double[n];
        for(int i = 0;i<n;i++){
            array[i] = sc.nextInt();
        }
        Arrays.sort(array);
        double min = Integer.MAX_VALUE;
        for (int i=0;i<array.length-2;i++){
            double sum = array[i]+array[i+1]+array[i+2];
            double pinJun = sum/3;
            double sumFang = Math.pow((array[i]-pinJun),2)+Math.pow((array[i+1]-pinJun),2)+Math.pow((array[i+2]-pinJun),2);
            double fangCha = sumFang/3;
            min = min>fangCha?fangCha:min;
        }
        String result = String.format("%.2f",min);
        System.out.println(result);
    }
}
