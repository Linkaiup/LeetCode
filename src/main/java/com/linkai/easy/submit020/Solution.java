package com.linkai.easy.submit020;

/**
 * Created by K Lin
 * Date: 2018/5/13.
 * Time: 17:55
 * Remember to sow in the spring.
 * Description : LeetCode
 */
public class Solution {
    public static boolean isValid(String s) {
        while ((s.contains("{}")) || (s.contains("()")) || (s.contains("[]"))){
            s = s.replaceAll("\\{\\}","");
            s = s.replaceAll("\\[\\]","");
            s = s.replaceAll("\\(\\)","");}
        return s.equals("");
    }

    public static void main(String[] args) {
        System.out.println(isValid("{}{[{[]}]}"));
    }
}
