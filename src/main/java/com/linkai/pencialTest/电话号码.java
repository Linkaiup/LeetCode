package com.linkai.pencialTest;

import java.util.Scanner;

/**
 * @ClassName: 电话号码
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-9-20 下午8:04
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class 电话号码 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();
        int nInt = Integer.parseInt(n);
        for (int i=0;i<nInt;i++){
            String length = scanner.nextLine();
            int lengthInt = Integer.parseInt(length);
            String phone = scanner.nextLine();
            if (lengthInt<11)
                System.out.println("NO");
            else if (lengthInt==11){
                System.out.println(phone.indexOf("8"));
                if (phone.charAt(0)!='8'){
                    System.out.println("NO");
                }else {
                    System.out.println("YES");
                }
            }else{
                if (phone.contains("8")){
                    int index = phone.indexOf("8")+1;
                    int trueLength = lengthInt-index;
                    if (trueLength>=10){
                        System.out.println("YES");
                    }else {
                        System.out.println("NO");
                    }
                }else{
                    System.out.println("NO");
                }
            }
        }
    }
}
