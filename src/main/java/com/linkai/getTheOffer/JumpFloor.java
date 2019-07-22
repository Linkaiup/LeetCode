package com.linkai.getTheOffer;

/**
 * @author K Lin
 * Date: 2019/7/22.
 * Time: 21:09
 * Remember to sow in the spring.
 * Description :
 */
public class JumpFloor {
    /**
     * 600ms+
     * @param target
     * @return
     */
    public int JumpFloorByDiGui(int target) {
        if(target<0)
            return 0;
        if(target==1)
            return 1;
        if(target==2)
            return 2;
        return JumpFloor(target-1)+JumpFloor(target-2);
    }

    /**
     * 13ms
     * @param target
     * @return
     */
    public int JumpFloor(int target) {
        if(target <= 2) {
            return target;
        }
        int first = 1, second = 2, third = 0;
        for (int i = 3; i <= target; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }
}
