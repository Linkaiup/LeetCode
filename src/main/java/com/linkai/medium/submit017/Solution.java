package com.linkai.medium.submit017;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution
 * @Description: TODO
 * @Author: K LIn
 * @Date: 18-11-25 下午9:03
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class Solution {
    private String flatPad[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    //将字符串中的字符分开插入到列表当中
    private List<String> combine(String str, List<String> list) {
        List<String> res = new ArrayList<>();

        char[] chr = str.toCharArray();
        for (char c : chr) {
            for (String s : list) {
                res.add(s+c);
            }
        }
        return res;
    }

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) return ans;

        //先加入，防止遍历的时候产生空指针
        ans.add("");
        int size = digits.length();
        for (int i = 0; i < size; i++) {
            //技巧：利用字符减'0'得出实际数字
            ans = combine(flatPad[digits.charAt(i)-'0'], ans);
        }
        return ans;
    }
}
