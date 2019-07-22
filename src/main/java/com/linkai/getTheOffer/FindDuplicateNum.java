package com.linkai.getTheOffer;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName: FindDuplicateNum
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-7-8 上午4:55
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class FindDuplicateNum {
    public static void main(String[] args) {
        int[] array = new int[]{2,3,1,2,0,0,1,4};
        int size = array.length;
        int now=0,why=0,temp =0;
        ArrayList duplicate = new ArrayList();
        for (why = 0;why<size;why++){
            now = array[why];
            if (now!=why) {
                temp = array[now];
                if (temp==now){
                    duplicate.add(now);
                }else {
                    array[now] = now;
                    array[why] = temp;
                    why--;
                }
            }
        }
        System.out.println(duplicate.toString());
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
    }
}
