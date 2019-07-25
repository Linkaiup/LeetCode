package com.linkai.getTheOffer;

/**
 * @author K Lin
 * Date: 2019/7/25.
 * Time: 19:07
 * Remember to sow in the spring.
 * Description :
 */
public class 数组中出现次数超过一半的数字 {
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array.length == 0) return 0;
        int target = array[0];
        int size = 0;
        for (int i = 0; i < array.length; i++) {
            if (target == array[i]) {
                size++;
            } else if (target != array[i]) {
                if (size == 0) {
                    target = array[i];
                } else {
                    size--;
                }
            }
        }
        if (size > 0)
            return target;
        else
            return 0;
    }
}
