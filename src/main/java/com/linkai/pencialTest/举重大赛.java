package com.linkai.pencialTest;

import java.util.Arrays;

/**
 * @ClassName: 举重大赛
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-8-10 下午7:29
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class 举重大赛 {
    public static void main(String[] args) {
        int[] arr = {60,80,90,70,90,80,70,100};
        Arrays.sort(arr);
        double[] arrNity = new double[arr.length];
        for (int i =0;i<arr.length;i++){
            arrNity[i] = arr[i]*0.9;
        }
        int count = 0;
        double temp;
        for (int i=arr.length-1;i>=0;i--){
            temp = arrNity[i];
            for (int j=i-1;j>=0;j--){
                if (arr[j]>=temp)
                    count++;
                else
                    break;
            }
        }
        System.out.println(count);
    }
}
