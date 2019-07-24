package com.linkai.tree;

/**
 * @author: lk
 * @date: 2019/7/23 14:50
 */
public class 树的子结构 {
    /**
     * 第一层递归是遍历树的节点
     *
     * @param root1
     * @param root2
     * @return
     */
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return false;
        //使用短路法：isSubtree首先判断，如果不是，则短路，进行下一个判断
        return isSubtree(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    /**
     * 第二层递归是判断对应根节点下的各个值是否相等
     *
     * @param root1
     * @param root2
     * @return
     */
    public boolean isSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null)
            return true;
        if (root1 == null)
            return false;
        if (root1.val == root2.val) {
            return isSubtree(root1.left, root2.left) && isSubtree(root1.right, root2.right);
        } else {
            return false;
        }
    }
}
