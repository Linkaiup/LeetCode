package com.linkai.pencialTest;

import java.util.Scanner;

/**
 * @ClassName: 汇量科技
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-9-26 下午12:28
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class 汇量科技 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String[] strings = string.split(" ");
        for (int i = strings.length - 1; i >= 0; i--) {
            System.out.print(strings[i] + " ");
        }
    }
//        Scanner scanner = new Scanner(System.in);
//        String string = scanner.nextLine();
//        System.out.println(getFirstChar(string));
//    }
//    public static int getFirstChar(String string){
//        char[] strToChars = string.toCharArray();
//        int[] countArray = new int[256];
//        for (int i=0;i<strToChars.length;i++){
//            countArray[strToChars[i]] +=1;
//        }
//        for (int i =0;i<strToChars.length;i++){
//            if (countArray[strToChars[i]]==1){
//                return i;
//            }
//        }
//        return -1;
//    }
}
