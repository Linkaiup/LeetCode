package com.linkai.pencialTest;

import java.util.Scanner;

/**
 * @ClassName: 事件推送
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-9-11 下午8:06
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class 事件推送 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        int index = 0;
        int firstLeft = string.indexOf("{");
        int firstRight = string.indexOf("}");
        String aNum = string.substring(firstLeft+1,firstRight);
        String[] aNums = aNum.split(",");
        int[] aNumArray = new int[aNums.length];
        for (int i=0;i<aNums.length;i++){
            aNumArray[i]=strToInt(aNums[i]);
        }
        string = string.substring(firstRight+1);
        int secondLeft = string.indexOf("{");
        int secondRight = string.indexOf("}");
        String bNum = string.substring(secondLeft+1,secondRight);
        String[] bNums = bNum.split(",");
        int[] bNumArray = new int[bNums.length];
        for (int i=0;i<bNums.length;i++){
            bNumArray[i]=strToInt(bNums[i]);
        }
        string = string.substring(secondRight+1);
        String[] strFin = string.split("=");
        int rNum = strToInt(strFin[1]);
        StringBuffer putOut=new StringBuffer();
        for (int i=0;i<aNumArray.length;i++){
            for (int j=0,count=0;j<bNumArray.length;j++){
                if (aNumArray[i]<bNumArray[j]){
                    if (bNumArray[j]<=aNumArray[i]+rNum){
                        putOut.append("(");
                        putOut.append(aNumArray[i]);
                        putOut.append(",");
                        putOut.append(bNumArray[j]);
                        putOut.append(")");
                        count+=1;
                    }else if (count==0){
                        putOut.append("(");
                        putOut.append(aNumArray[i]);
                        putOut.append(",");
                        putOut.append(bNumArray[j]);
                        putOut.append(")");
                        count+=1;
                        break;
                    }else {
                        break;
                    }
                }
            }
        }
        System.out.println(putOut.toString());
    }
    public static int strToInt(String string){
        int count = 1;
        int result = 0;
        for (int i=0;i<string.length();i++){
            result=result+count*(string.charAt(i)-'0');
            count*=10;
        }
        return result;
    }
}
