package com.linkai.pencialTest;

import java.util.Scanner;

/**
 * @ClassName: 最大连续子序列和
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-9-18 下午9:14
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class 最大连续子序列和 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        str = str.substring(1,str.length()-1);
        String[] nums = str.split(",");
        int[] array = new int[nums.length];
        for (int index = 0;index<nums.length;index++){
            array[index]=changeStrToInt(nums[index]);
        }
        int maxSum,temp;
        maxSum = temp = array[0];
        for (int i =1;i<array.length;i++){
            if (temp<=0){
                temp=array[i];
            }else {
                temp+=array[i];
            }
            if (temp>maxSum){
                maxSum=temp;
            }
        }
        System.out.println(maxSum);
    }
    public static int changeStrToInt(String string){
        int flag = 1;
        if (string.contains(" ")){
            string = string.substring(1,string.length());
        }
        if (string.contains("-")){
            string = string.substring(1,string.length());
            flag=-1;
        }
        int count = 1;
        int result = 0;
        for (int i = 0;i<string.length();i++){
            result=result*count+string.charAt(i)-'0';
            count*=10;
        }
        return result*flag;
    }
}
