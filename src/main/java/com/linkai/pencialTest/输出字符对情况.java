package com.linkai.pencialTest;

import java.util.Scanner;

/**
 * @ClassName: 输出字符对情况
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-9-10 下午7:57
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class 输出字符对情况 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();
        String str = in.nextLine();
        String[] strPairs = str.split(a);
        int count = strPairs.length;
        String[] result = new String[count*2];
        int index = 0;
        for (int i=0;i<count;i++){
            String[] pair = strPairs[i].split(b);
            result[index++] = pair[0];
            result[index++] = pair[1];
        }
        System.out.println(count);
        for (int i =0;i<count*2;i+=2){
            System.out.print(result[i]+' ');
            System.out.println(result[i+1]);
        }
    }
}
