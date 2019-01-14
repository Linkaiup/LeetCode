package com.linkai.medium.lagelangri;

import java.util.Scanner;

/**
 * @ClassName: Solution
 * @Description: 四平方和定理（拉格朗日定理）算法
 * @Author: K LIn
 * @Date: 18-12-8 下午2:37
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class Solution {
    public int[] a = new int[5000010];
    public int n;

    public void init() {
        for (int i = 0; i * i <= n; i++) {
            for (int j = 0; j * j <= n; j++) {
                if (i * i + j * j <= n) {
                    a[i * i + j * j] = 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Solution Solution = new Solution();
        boolean flag = false;
        Solution.n = n;
        Solution.init();
        for (int i = 0; i * i <= n; i++) {
            for (int j = 0; j * j <= n; j++) {
                if (Solution.a[n - i * i - j * j] == 0) {
                    continue;	// 如果剩下的差用两个完全平方数不能组合出来就不继续
                }
                for (int k = 0; k * k <= n; k++) {
                    int temp = n - i * i - j * j - k * k;
                    double l = Math.sqrt((double) (temp));
                    if (l == (int) l) {
                        System.out.println(i + " " + j + " " + k + " " + (int) l);
                        flag = true;
                        break;
                    }
                }
                if (flag)
                    break;
            }
            if (flag)
                break;
        }
    }
}
