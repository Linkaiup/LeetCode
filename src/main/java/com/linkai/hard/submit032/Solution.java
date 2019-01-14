package com.linkai.hard.submit032;

/**
 * @ClassName: Solution
 * @Description: TODO
 * @Author: K LIn
 * @Date: 18-12-4 下午9:27
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class Solution {
    public static int longestValidParentheses(String s) {
        if (s == null||s.length()==1){
            return 0;
        }
        int length = s.length();
        int sum = 0;
        int left = 0;
        int sum2 = 0;
        int i;
        String string1;
        for (i=0;i < length-1;){
            string1 = s.substring(i,i+1);
            if (("(").equals(string1)){
                if (("()").equals(s.substring(i,i+2))){
                   sum++;
                   i+=2;
                }else {
                    left++;
                    i++;
                }
            }else if ((")").equals(string1)&&left!=0){
                left--;
                sum2++;
                i++;
            }else {
                i++;
            }
        }
        string1 = s.substring(i);
        if ((")").equals(string1)&&left==1){
            sum2++;
        }
        if (left!=0){
            sum--;
        }
        Integer integer = 1;
        Integer integer1 = Integer.valueOf(i);
        return (sum+sum2)*2;
    }

    public static void main(String[] args) {
        String s1 = "()(())";
        int sums = longestValidParentheses(s1);
        System.out.println(sums);
    }
}
