package com.linkai.getTheOffer;

/**
 * @author K Lin
 * Date: 2019/7/22.
 * Time: 21:29
 * Remember to sow in the spring.
 * Description :跳台阶升级版，阶数为1到n
 */
public class JumpFloorII {
    /**
     * 台阶可以选择跳或不跳，所以就是2的次方次次数
     * @param floor
     * @return
     */
    public static int JumpFloor(int floor) {
        int a = 1;
        return a<<(floor-1);
    }
}
