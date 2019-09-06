package com.linkai.sort;

import java.util.Arrays;

/**
 * @ClassName: HeapSort
 * @Description: 堆排序
 * @Author: K LIn
 * @Date: 18-10-11 下午10:32
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class HeapSort {
    static int[] array = {3,5,3,0,8,6,1,5,8,6,2,4,9,4,7,0,1,8,9,7,3,1,2,5,9,7,4,0,2,6};

    /**
     * 排序，分两步
     */
    public void sort(){
        /**
         * 第一步：将数组堆化
         * beginIndex = 从下往上第一个非叶子节点
         */
        int len = array.length-1;
        int beginIndex = (len-1)>>1;
        for (int i = beginIndex;i>=0;i--){
            maxHeapify(i,len);
        }
        //此时是大根堆

        /**
         * 第二步：对已经堆化好的数组进行排序
         */
        for (int i = len;i>0;i--){
            //第一步：将值最大的根节点和最后一个叶子节点交换位置
            swap(0,i);
            //第二步：再将新的根树以下的堆整理完毕
            maxHeapify(0,i-1);
        }
        //重复以上操作，即可将整个数组转化成降序数组【可看作渐渐地将堆转化成小根堆】
    }

    private void swap(int a,int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    /**
     * 调整索引为 index 处的数据，使其符合堆的特性
     * @param index 需要堆化处理的数据的索引
     * @param len 未排序数组的长度
     */
    private void maxHeapify(int index,int len){
        int li = (index<<1)+1;
        int ri = li+1;
        //子节点值最大索引，默认左子节点
        int cMax = li;

        //如果大于数组长度范围，则返回
        if (li>len)return;
        //选出最大索引
        if (ri<=len && array[ri]>array[li])
            cMax = ri;
        //从下往上整理成最大堆
        if (array[cMax]>array[index]){
            swap(cMax,index);
            //继续递归下去
            maxHeapify(cMax,len);
        }
    }
    public static void main(String[] args) {
        new HeapSort().sort();
        System.out.println(Arrays.toString(array));
    }
}
