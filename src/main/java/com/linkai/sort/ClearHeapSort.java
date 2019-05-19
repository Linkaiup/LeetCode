package com.linkai.sort;

/**
 * @ClassName: ClearHeapSort
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-5-16 下午8:59
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class ClearHeapSort {
    public static void topK(int[] arrays,int k){
        int[] top = new int[k];
        for (int i = 0;i<k;i++){
            top[i] = arrays[i];
        }
        //建堆
        buildHead(top);
        //遍历，将比堆顶数小的数字替换进堆当中
        for (int j = k;j<arrays.length;j++){
            int topNum = top[0];
            if (arrays[j]<topNum)
                setTop(top,arrays[j]);
        }
    }
    public static void buildHead(int[] arrays){
        int length = arrays.length;
        for (int i = length/2-1;i>=0;i--){
            headify(arrays,i,length);
        }
    }
    public static void headify(int[] array,int index,int length){
        int left = index*2+1;
        int right = index*2+2;
        int larget = index;
        if (left<length&&array[left]>array[index])
            larget=left;
        if (right<length&&array[right]>array[larget])
            larget=right;
        if (larget!=index){
            swap(array,larget,index);
            headify(array,larget,length);
        }
    }
    public static void swap(int[] array,int a,int b){
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
    public static void setTop(int[] arrays,int tmp){
        arrays[0] = tmp;
        //修改之后还要再调整堆
        headify(arrays,0,arrays.length);
    }
    public static void main(String[] args) {

    }
}
