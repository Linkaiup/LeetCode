package com.linkai.getTheOffer.数组;

/**
 * @author: lk
 * @date: 2019/7/30 15:46
 */
public class 数字在数组中出现的次数 {
    public int GetNumberOfK(int [] array , int k) {
        if (array.length==1){
            if (array[0]==k)
                return 1;
            else
                return 0;
        }
        int start = 0;
        int end = array.length-1;
        int index = 0;
        int result = 0;
        while (start<end){
            if (array[(start+end)/2]>k){
                end = (start+end)/2-1;
            }else if (array[(start+end)/2]<k){
                start = (start+end)/2+1;
            }else {
                index = (start+end)/2;
                break;
            }
        }
        if (start>=end)
            return result;
        int indexTemp = index;
        while (indexTemp>=0&&array[indexTemp--]==k){
            result++;
        }
        while (index<array.length-1&&array[++index]==k){
            result++;
        }
        return result;
    }
}
