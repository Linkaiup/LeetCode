package com.linkai.easy.submit013;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by K Lin
 * Date: 2018/4/25.
 * Time: 08:58
 * Remember to sow in the spring.
 * Description : LeetCode
 */
public class Solution {
    public static int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        HashMap<Character, Integer> map = new HashMap<>(s.length());
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int len = s.length(), result = map.get(s.charAt(len - 1));
        //从后遍历，从低位加起
        for (int i = len - 2; i >= 0; i--) {
            if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1))){
                result += map.get(s.charAt(i));
            }
            else{
                //骚操作
                result -= map.get(s.charAt(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String roman = "XXVII";
        System.out.println(romanToInt(roman));
        List Listlist1 = new ArrayList();
        Listlist1.add(0);
        List Listlist2 = Listlist1;
        System.out.println(Listlist1.get(0) instanceof Integer);
        System.out.println(Listlist2.get(0) instanceof Integer);
    }
}
