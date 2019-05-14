package com.linkai.sort;

/**
 * @ClassName: TwoSearch
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-5-13 下午3:03
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class TwoSearch {
    public static int twoSearch(int[] arrays,int target){
        int start = 0;
        int end = arrays.length-1;
        int mid;
        while (start<=end){
            mid = (start+end)/2;
            if (target<arrays[mid])
                end = mid-1;
            else if (target>arrays[mid])
                start = mid+1;
            else
                return mid;
        }
        return -1;
    }
    public static int twoSearchLeft(int[] arrays,int target){
        if (arrays==null||arrays.length==0){
            return -1;
        }
        int start = 0;
        int end = arrays.length-1;
        while (start<end){
            int mid = (start+end)/2;
            if (arrays[mid]<target){
                start=mid+1;
            }else {
                end=mid-1;
            }
        }
        if (arrays[start]==target)
            return start;
        return -1;
    }
    public static int twoSearchRecursive(int[] arrays,int target,int start,int end){
        int mid = (start+end)/2;
        if (target==arrays[mid])
            return mid;
        if (start >= end) {
            return -1;
        }
        if(target<arrays[mid])
            return twoSearchRecursive(arrays,target,start,mid-1);
        else if (target>arrays[mid])
            return twoSearchRecursive(arrays,target,mid+1,end);
        return -1;
    }

    public static void main(String[] args) {
        int[] arrays = {0,1,2,3,4,5,6};
        int index = twoSearchRecursive(arrays,0,0,arrays.length-1);
        System.out.println(index);
    }
}
