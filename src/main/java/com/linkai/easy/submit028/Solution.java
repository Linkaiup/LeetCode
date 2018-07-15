package com.linkai.easy.submit028;

/**
 * @author K Lin
 * Date: 2018/7/11.
 * Time: 08:47
 * Remember to sow in the spring.
 * Description :
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        if("".equals(needle)){
            return 0;
        }
        return haystack.indexOf(needle);
    }
}
