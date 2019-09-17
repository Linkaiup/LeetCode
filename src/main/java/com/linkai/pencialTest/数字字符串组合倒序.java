package com.linkai.pencialTest;

import java.util.Scanner;
import java.util.Stack;

/**
 * @ClassName: 数字字符串组合倒序
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-9-11 下午7:09
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class 数字字符串组合倒序 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        System.out.println(getReserver(string));
    }
    public static String getReserver(String str){
        for (int i=0;i<str.length();i++){
            if (!((str.charAt(i)>='a'&&str.charAt(i)<='z')||(str.charAt(i)>='A'&&str.charAt(i)<='Z')||(str.charAt(i)>='0'&&str.charAt(i)<='9')||str.charAt(i)=='-'||str.charAt(i)==' ')){
                str = str.replace(str.charAt(i),' ');
            }
        }
        String[] strings = str.split(" ");
        Stack<String> stringReserve = new Stack<>();
        for (int i=0;i<strings.length;i++){
            if (strings[i].contains("-")){
                if (strings[i].contains("--")){
                    String[] minStrs = strings[i].split("--");
                    for (int j=0;j<minStrs.length;j++){
                        stringReserve.push(minStrs[j]);
                    }
                }else if (strings[i].indexOf("-")==0){
                    strings[i] = strings[i].substring(1,strings[i].length());
                    if (strings[i].indexOf("-")==(strings[i].length()-1)){
                        stringReserve.push(strings[i].substring(0,strings[i].length()-1));
                    }else{
                        stringReserve.push(strings[i]);
                    }
                }else{
                    stringReserve.push(strings[i]);
                }
            }else {
                stringReserve.push(strings[i]);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        String temp;
        int size = stringReserve.size();
        for (int j=0;j<size;j++){
            temp = stringReserve.pop();
            if (!"".equals(temp)) {
                stringBuilder.append(temp + " ");
            }
        }
        return stringBuilder.toString();
    }
}
