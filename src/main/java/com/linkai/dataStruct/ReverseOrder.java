package com.linkai.dataStruct;

/**
 * @ClassName: ReverseOrder
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-5-16 下午11:47
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class ReverseOrder {
    public static int reverseOrder(int[] array){
        if (array==null||array.length<2)
            return 0;
        int count = mergeSort(array,0,array.length-1);
    }
    private static int mergeSort(int[] array,int start,int end){
        if (start>=end)
            return 0;

        int mid = (start+end)/2;
        int left = mergeSort(array,start,mid);
        int right = mergeSort(array,mid+1,end);

        //要把数组拷贝一部分过来使用
        int[] copy = new int[array.length];
        System.arraycopy(array,start,copy,start,end-start+1);

        int i=mid;
        int j=end;
        int copyIndex=end;

        int count = 0;

        while (i>=start && j>=mid+1){
            if (array[i]>array[j]){
                copy[copyIndex--]=array[i--];
                count+=(j-mid);
            }else {
                copy[copyIndex--]=array[j--];
            }
        }

        //将数组中剩下的数写回
        while (i>=start){
            copy[copyIndex--]=array[i--];
        }
        while (j>=mid+1){
            copy[copyIndex--] = array[j--];
        }

        //写回原数组当中
        for (int k=start;k<=end;k++){
            array[k]=copy[k];
        }
        return left+count+right;
    }
}
