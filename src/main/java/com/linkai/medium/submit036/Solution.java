package com.linkai.medium.submit036;

import java.util.HashMap;

/**
 * @ClassName: Solution
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-1-14 上午11:48
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // 由于 HashMap 具有一一映射功能，所以挑选 HashMap 作为数据结构
        // 初始化 HashMap 数组
        HashMap<Integer, Integer> [] rows = new HashMap[9];
        HashMap<Integer, Integer> [] columns = new HashMap[9];
        HashMap<Integer, Integer> [] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap(1);
            columns[i] = new HashMap(1);
            boxes[i] = new HashMap(1);
        }

        // 进行一次迭代检查
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int)num;
                    int box_index = (i / 3 ) * 3 + j / 3;

                    // keep the current cell value
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                    boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);

                    // check if this value has been already seen before
                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1)
                        return false;
                }
            }
        }
        return true;
    }
}
