package com.linkai.tree;

import java.util.List;

/**
 * @ClassName: TreeNode
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-5-16 上午9:32
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public List<TreeNode> children;
    public TreeNode(int x) { val = x; }
}
