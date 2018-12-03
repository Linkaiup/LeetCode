package com.linkai.easy.submit026;

/**
 * @ClassName: Solution
 * @Description: TODO
 * @Author: K LIn
 * @Date: 18-12-3 下午8:24
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class Solution {
    public static int removeDuplicates(int[] A) {
        if (A.length==0) return 0;
        int j=0;
        for (int i=0; i<A.length; i++)
            if (A[i]!=A[j]) A[++j]=A[i];
        return ++j;
    }

    public static void main(String[] args) {
        int[] a = {1,1,2,3,4,4,5,5,6,6,6,6};
        int length = removeDuplicates(a);
        for (int i=0;i<length;i++){
            System.out.println(a[i]);
        }
    }
}
