package com.linkai.medium.submit022;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: Solution
 * @Description: TODO
 * @Author: K LIn
 * @Date: 18-11-29 下午8:51
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class Solution {
    public List<String> generateParenthesis(int n) {
        List list = new LinkedList<>();
        if (n <= 1) {
            list.add("()");
        } else {
            for (String str : generateParenthesis(n - 1)) {
                list.add("(" + str + ")");
                list.add("()" + str);
            }
            for (int i = 1; i < n - 1; i++) {
                for (String str0 : generateParenthesis(n - i - 1)) {
                    for (String str1 : generateParenthesis(i)) {
                        list.add("(" + str0 + ")" + str1);
                    }
                }
            }
        }
        return list;
    }
}
