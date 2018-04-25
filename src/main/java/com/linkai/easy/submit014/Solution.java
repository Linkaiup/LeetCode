package com.linkai.easy.submit014;

import java.util.Arrays;

/**
 * Created by K Lin
 * Date: 2018/4/25.
 * Time: 09:16
 * Remember to sow in the spring.
 * Description : LeetCode
 */
public class Solution {
    public static String longestCommonPrefix(String[] strs) {
        // Argument checks
        if (strs == null || strs.length == 0){ return "";}
        if (strs.length == 1){ return strs[0];}

        StringBuilder sb = new StringBuilder();
        Arrays.sort(strs);
        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length - 1].toCharArray();
        for (int i = 0, j = 0; i < first.length && j < last.length; i++, j++) {
            if (first[i] != last[j]){break;}
            sb.append(first[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"dog","dance","dark"};
        String commonP = longestCommonPrefix(strs);
        System.out.println(commonP);
    }
}
