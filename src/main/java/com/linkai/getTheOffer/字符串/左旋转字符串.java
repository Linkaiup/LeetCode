package com.linkai.getTheOffer.字符串;

/**
 * @ClassName: 左旋转字符串
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-8-6 下午11:39
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class 左旋转字符串 {
    public String LeftRotateString(String str,int n) {
        if(str.length() == 0) return "";
        n = n%(str.length());
        StringBuilder sb = new StringBuilder();
        sb.append(str.substring(n,str.length()));
        sb.append(str.substring(0,n));
        return sb.toString();
    }
}
