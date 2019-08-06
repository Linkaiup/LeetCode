package com.linkai.pencialTest;

import java.util.Scanner;

/**
 * @ClassName: DrinkCoffee
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-8-6 下午8:47
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class DrinkCoffee {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int bugTime = 0;
        int[] result = new int[100];
        int index = 0;
        while (in.hasNext()) {
            int bugNum = in.nextInt();
            int beishu = in.nextInt();
            int coffNum = in.nextInt();
            int[] bugTimeArray = new int[bugNum];
            for (int i = 0; i < bugNum; i++) {
                bugTimeArray[i] = in.nextInt();
                bugTime += bugTimeArray[i];
            }
            result[index++] = (int) getFinalTime(beishu, coffNum, bugTime);
            bugTime = 0;
        }
        for (int i = 0; i < index; i++) {
            System.out.println(result[i]);
        }
    }

    public static double getFinalTime(int beishu, int coffNum, int bugTime) {
        int resultTime = beishu * coffNum * 60 + (8 - coffNum) * 60;
        if (resultTime < bugTime) {
            return 0;
        } else {
            int timeByCoff = beishu * coffNum * 60;
            if (timeByCoff >= bugTime) {
                return Math.ceil(bugTime / beishu);
            } else {
                return Math.ceil(coffNum + (bugTime - timeByCoff) / 60.0);
            }
        }
    }

}
