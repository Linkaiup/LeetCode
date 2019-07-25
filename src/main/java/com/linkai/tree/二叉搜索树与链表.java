package com.linkai.tree;

/**
 * @author: lk
 * @date: 2019/7/25 11:28
 */
public class 二叉搜索树与链表 {
    TreeNode head = null;
    TreeNode cur = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        ConvertCore(pRootOfTree);
        return head;
    }
    public void ConvertCore(TreeNode pRootOfTree){
        if (pRootOfTree==null)return;
        ConvertCore(pRootOfTree.left);
        if (cur==null){
            head = pRootOfTree;
        }else {
            cur.right = pRootOfTree;
            pRootOfTree.left = cur;
        }
        //更新
        cur=pRootOfTree;
        ConvertCore(pRootOfTree.right);
    }
}
