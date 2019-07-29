package com.linkai.getTheOffer.字符串;

/**
 * @ClassName: 第一个只出现一次的字符
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-7-29 下午8:40
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class 第一个只出现一次的字符 {
    public int FirstNotRepeatingChar(String str) {
        int[] words = new int[58];
        for (int i = 0;i<str.length();i++){
            words[((int)str.charAt(i))-65]+=1;
        }
        for (int i=0;i<str.length();i++){
            if (words[((int)str.charAt(i))-65]==1)
                return i;
        }
        return -1;
    }
}
