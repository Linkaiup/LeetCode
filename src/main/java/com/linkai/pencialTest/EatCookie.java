package com.linkai.pencialTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName: EatCookie
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-8-6 下午8:48
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class EatCookie {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int target = 0;
        while (in.hasNext()){
            int n = in.nextInt();
            int money = in.nextInt();
            ArrayList<Integer> manyiduArray = new ArrayList(n);
            int[] manyiduCopy = new int[n];
            int[] shuliangArray = new int[n];
            int[] jiageArray = new int[n];
            for (int i = 0; i < n; i++) {
                jiageArray[i] = in.nextInt();
                manyiduArray.add(in.nextInt());
                manyiduCopy[i] = manyiduArray.get(i);
                shuliangArray[i] = in.nextInt();
            }
            while (money>=0){
                Arrays.sort(manyiduCopy);
                int maxManyi = manyiduCopy[manyiduCopy.length-1];
                if (maxManyi==0)
                    break;
                int index = manyiduArray.indexOf(maxManyi);
                int jiage = jiageArray[index];
                int shuliang = shuliangArray[index];
                if (maxManyi!=0&&money>=jiage){
                    int buy = jiage*shuliang;
                    if (money>buy){
                        target+=(maxManyi*shuliang);
                        money -= jiage*shuliang;
                    }else {
                        target+=(maxManyi*(money/jiage));
                        money -= (money/jiage)*jiage;
                    }
                    manyiduCopy[manyiduCopy.length-1]=0;
                }
            }
            System.out.println(target);
            target=0;
        }
        in.close();
    }
}
