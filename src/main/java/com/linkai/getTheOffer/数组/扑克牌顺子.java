package com.linkai.getTheOffer.数组;

import java.util.Arrays;

/**
 * @author: lk
 * @date: 2019/8/7 16:12
 */
public class 扑克牌顺子 {
    public boolean isContinuous(int[] numbers) {
        if (numbers==null||numbers.length==0)
            return false;
        Arrays.sort(numbers);
        int numOf0 = 0;
        for (int i=0;i<numbers.length;i++){
            if (numbers[i]==0)
                numOf0++;
            else
                break;
        }
        int temp = 0;
        for (int i=numOf0;i<numbers.length;i++){
            if (((i+1)<numbers.length)){
                temp+=(numbers[i+1]-numbers[i]-1);
            }
        }
        if (temp<0||numOf0<temp)
            return false;
        else
            return true;
    }
}
