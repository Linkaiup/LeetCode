package com.linkai.pencialTest;

import java.util.Arrays;

/**
 * @ClassName: 制造出递增或递减数组最小的增加和
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-8-10 下午8:17
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class 制造出递增或递减数组最小的增加和 {
    public static void main(String[] args) {
        long[] arr = {60,80,90,70,90,80,70,100};
        int lenght = arr.length;
        long sum = minIncreament(arr,lenght);
        System.out.println(sum);
    }

    private static long minIncreament(long[] arr,int length){
        if (length==1)
            return 0;
        if (length==2&&arr[0]==arr[1])
            return 1;
        if (length==2&&arr[0]!=arr[1])
            return 0;
        long[] temp = Arrays.copyOf(arr,length);

        int i=0;
        while (i<length-1&&arr[i]<arr[i+1])
            i++;
        int j=length-1;
        while (j>0&&arr[j-1]>arr[j])
            j--;

        while (i<j){
            if (arr[i]<arr[j]){
                if (arr[i+1]<arr[i]+1)
                    arr[i+1]=arr[i]+1;
                i++;
            }else {
                if (arr[j-1]<arr[j]+1)
                    arr[j-1]=arr[j]+1;
                j--;
            }
        }
        return Arrays.stream(arr).sum()-Arrays.stream(temp).sum();
    }
}
