package com.linkai.tree;

/**
 * @author: lk
 * @date: 2019/7/25 9:23
 */
public class 判断是否为二叉树的后序遍历序列 {
    /**
     * 递归解法
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length==0)return false;
        return VerifySquenceCore(sequence,0,sequence.length-1);
    }
    public boolean VerifySquenceCore(int[] sequence,int start,int end){
        if (start>=end)
            return true;
        int i = start;
        for (;i<end;i++){
            if (sequence[i]>sequence[end])break;
        }
        for (int j =i;j<end;j++){
            if (sequence[j]<sequence[end])return false;
        }
        return VerifySquenceCore(sequence,start,i-1) && VerifySquenceCore(sequence,i,end-1);
    }

    /**
     * 非递归解法
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBSTII(int [] sequence) {
        if (sequence.length==0)return false;
        int size = sequence.length;
        int i =0;
        while ((--size)!=0){
            while (sequence[i++]<sequence[size]);
            while (i<size&&sequence[i++]>sequence[size]);
            if (i<size)
                return false;
            i=0;
        }
        return true;
    }
}
