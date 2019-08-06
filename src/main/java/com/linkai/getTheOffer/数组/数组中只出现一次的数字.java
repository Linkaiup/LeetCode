package com.linkai.getTheOffer.数组;

/**
 * @ClassName: 数组中只出现一次的数字
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-8-6 下午9:54
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class 数组中只出现一次的数字 {
    public static void main(String[] args) {

    }
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int first = array[0];
        //异或出bit结果
        for (int i=1;i<array.length;i++){
            first = first^array[i];
        }
        int index = findFirstOne(first);
        for (int i = 0;i<array.length;i++){
            //分组存放
            if (isBit1(array[i],index)){
                num1[0]^=array[i];
            }else {
                num2[0]^=array[i];
            }
        }
    }

    /**
     * 查找到从右边起第一个1所在的位置
     * @param bitResult
     * @return
     */
    public int findFirstOne(int bitResult){
        int index = 0;
        while (((bitResult&1)==0)&&index<32){
            bitResult>>=1;
            index++;
        }
        return index;
    }

    /**
     * 判断是否是第一个1所在的组
     * @param target
     * @param index
     * @return
     */
    public boolean isBit1(int target,int index){
        return ((target>>index)&1)==1;
    }
}
