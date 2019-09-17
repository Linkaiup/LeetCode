package com.linkai.pencialTest;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @ClassName: 机票改签
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-9-11 下午8:33
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class 机票改签 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] dataFly = new String[3];
        for (int i=0;i<n;i++){
            dataFly[i]=sc.nextLine();
        }
        int changeN = sc.nextInt();
        HashMap<String,String> map = new HashMap(changeN);
        String temp="";
        String[] strings=new String[4];
        for (int i =0;i<changeN;i++){
            temp=sc.nextLine();
            strings = temp.split(",");
            map.put(strings[0]+","+strings[1],strings[2]+","+strings[3]);
        }
        String change = map.get(strings[0]+","+strings[1]);
        int length = change.length();
        for (int i =0;i<dataFly.length;i++) {
            if (map.containsKey(dataFly[i].substring(0,length))) {
                dataFly[i] = dataFly[i].replace(dataFly[i].substring(0,length),map.get(dataFly[i].substring(0,length)));
            }
        }
        for (int i=0;i<dataFly.length;i++){
            System.out.println(dataFly[i]);
        }
    }
}
