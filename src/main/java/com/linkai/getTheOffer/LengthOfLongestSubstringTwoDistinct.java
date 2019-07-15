package com.linkai.getTheOffer;

import java.util.ArrayList;

/**
 * @ClassName: LengthOfLongestSubstringTwoDistinct
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-7-14 下午4:41
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class LengthOfLongestSubstringTwoDistinct {
    public static String findSubs(String str){
        ArrayList arrayList = new ArrayList<>(2);
        int left = 0;
        int right = 1;
        char c1 = str.charAt(left);
        int maxLength = 0;
        int maxLengthLeft = 0;
        arrayList.add(c1);
        for (;right<str.length();right++){
            if (arrayList.contains(str.charAt(right))){
                System.out.println(str.charAt(right));
            }else{
                if (arrayList.size()>=2){
                    if ((right-left)>maxLength){
                        maxLength = right-left;
                        maxLengthLeft = left;
                    }
                    char remove = (char)arrayList.get(0);
                    int sizeToRemove = 0;
                    for (int index=maxLengthLeft;index<right;index++){
                        if (str.charAt(index)==remove)
                            sizeToRemove++;
                    }
                    arrayList.remove(0);
                    arrayList.add(str.charAt(right));
                    left +=sizeToRemove;
                }else {
                    arrayList.add(str.charAt(right));
                }
            }
        }
        if ((right-left)>maxLength){
            maxLength = right-left;
            maxLengthLeft = left;
        }
        return str.substring(maxLengthLeft,maxLengthLeft+maxLength);
    }

    public static void main(String[] args) {
        String result = findSubs("ccaabbb");
        System.out.println(result);
    }
}
