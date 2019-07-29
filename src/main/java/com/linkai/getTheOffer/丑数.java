package com.linkai.getTheOffer;

/**
 * @ClassName: 丑数
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-7-29 下午8:03
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class 丑数 {
    public int GetUglyNumber_Solution(int index) {
        if (index<7)return index;
        int[] arr = {1};
        int p2=0,p3=0,p5=0;
        int numGet = 1;
        for (int i=1;i<index;i++){
            numGet = Math.min(Math.min(arr[p3]*3,arr[p5]*5),arr[p2]*2);
            if (numGet==arr[p2]*2)p2++;
            if (numGet==arr[p3]*3)p3++;
            if (numGet==arr[p5]*5)p5++;
            arr[i]=numGet;
        }
        return arr[arr.length-1];
    }
}
