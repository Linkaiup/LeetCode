package com.linkai.getTheOffer.数组;

/**
 * @ClassName: 构建乘积数组
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-8-7 下午8:41
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class 构建乘积数组 {
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        if (A.length!=0){
            B[0]=1;
            //上三角
            for (int i=1;i<A.length;i++){
                B[i] = B[i-1]*A[i-1];
            }
            //下三角
            int temp = 1;
            for (int j=A.length-2;j>=0;j--){
                temp *= A[j+1];
                B[j] *= temp;
            }
        }
        return B;
    }
}
