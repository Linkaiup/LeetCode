package com.linkai.medium.submit048;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @ClassName: Solution
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-3-22 下午1:45
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class Solution {
    public void rotate(int[][] matrix){
        ArrayList list = new ArrayList();
        //先转置
        for (int i=0;i<matrix.length;i++){
            for (int j=i;j<matrix[0].length;j++){
                int temp=0;
                temp=matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        HashMap<Integer,Boolean> map = new HashMap<>();
        map.containsKey(1);

        //水平翻转
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix.length/2;j++){
                int temp=0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = temp;
            }
        }
    }
}
