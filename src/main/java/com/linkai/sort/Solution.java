package com.linkai.sort;

import java.util.Arrays;

/**
 * @ClassName: Solution
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-6-6 上午10:40
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class Solution {
    public static void main(String[] args) {
        int[] arr = new int[]{3,3,7,9,1,10};
        int result = solution(arr,7);
        System.out.println(result);
    }
    public static int solution(int[] array,int length){
        int[] array2 =  Arrays.copyOf(array,length);
        Arrays.sort(array);
        int realLength=2;
        int partition = 2;
        int result = 0;
        int num = 0;
        for (;partition<array[length-1];partition++){
            num=0;
            realLength=0;
            for (int i=0;i<length;i++){

                if (realLength<length)
                    realLength++;
            for (int j=i;j<realLength;j++){
                if (array2[j]%partition==0){
                    num++;
                }
            }
            }
            if (num>=(realLength/2)){
                result = Math.max(result,realLength);
            }
        }
        return result;
    }
}
