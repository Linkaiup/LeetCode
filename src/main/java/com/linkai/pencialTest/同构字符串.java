package com.linkai.pencialTest;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @ClassName: 同构字符串
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-9-18 下午9:40
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class 同构字符串 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String[] twoStr = string.split(";");
        String first = twoStr[0];
        String second = twoStr[1];
        if (second.length()!=first.length())
            System.out.println("False");
        else {
            HashMap<Character, Integer> saveTimeFirstMap = new HashMap<Character, Integer>(first.length());
            StringBuilder firstFormat=new StringBuilder();
            for (int i =0;i<first.length();i++){
                char temp = first.charAt(i);
                if (saveTimeFirstMap.containsKey(temp)){
                    saveTimeFirstMap.put(temp,saveTimeFirstMap.get(temp)+1);
                    firstFormat.append(saveTimeFirstMap.get(temp));
                }else {
                    saveTimeFirstMap.put(temp,1);
                    firstFormat.append(1);
                }
            }
            HashMap<Character, Integer> saveTimeSecondMap = new HashMap<Character, Integer>(first.length());
            StringBuilder secondFormat=new StringBuilder();
            for (int i =0;i<second.length();i++){
                char temp = second.charAt(i);
                if (saveTimeSecondMap.containsKey(temp)){
                    saveTimeSecondMap.put(temp,saveTimeSecondMap.get(temp)+1);
                    secondFormat.append(saveTimeSecondMap.get(temp));
                }else {
                    saveTimeSecondMap.put(temp,1);
                    secondFormat.append(1);
                }
            }
            if (secondFormat.toString().equals(firstFormat.toString())){
                System.out.println("True");
            }else {
                System.out.println("False");
            }
        }
    }
}
