package com.linkai.pencialTest;

import java.util.Scanner;

/**
 * @ClassName: 最小值
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-9-17 下午7:46
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class 最小值 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextInt();
        long m = scanner.nextInt();
        long k = scanner.nextInt();
        if (n*m<=k) {
            System.out.println(0);
            return;
        }
        long nCopy = n;
        while (nCopy*m>k){
            nCopy-=1;
        }
        long aMax = n-nCopy;
        long mCopy = m;
        while (n*mCopy>k){
            mCopy-=1;
        }
        long bMax = m-mCopy;
        long minSum = bMax>aMax?aMax:bMax;
        for (long i=aMax;i>=0;i--){
            for (long j=bMax;j>=0;j--){
                if ((n-i)*(m-j)<=k){
                    minSum = minSum>(i+j)?(i+j):minSum;
                }else{
                    break;
                }
            }
        }
        System.out.println(minSum);
    }
}
