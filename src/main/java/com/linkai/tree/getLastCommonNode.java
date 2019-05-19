package com.linkai.tree;

import java.util.ArrayList;

/**
 * @ClassName: getLastCommonNode
 * @Description: TODO
 * @Author: K LIn
 * @Date: 19-5-16 上午10:01
 * @Version: 1.0
 * Remember to sow in the spring.
 **/
public class getLastCommonNode {
    public static void getNodePath(TreeNode root, TreeNode pNode, ArrayList<TreeNode> tmpList,ArrayList<TreeNode> path){
        if (root==pNode||root==null){
            return;
        }
        tmpList.add(root);
        ArrayList<TreeNode> children = root.children();
        for (TreeNode child:children){
            if (child==pNode){
                path.addAll(tmpList);
                break;
            }
            getNodePath(child,pNode,tmpList,path);
        }
        tmpList.remove(tmpList.size()-1);
    }
    private static TreeNode getLastCommonParent(ArrayList<TreeNode> path1,ArrayList<TreeNode> path2){
        TreeNode resultNode = null;
        for (int i=0;i<path1.size();i++){
            if (path1.get(i)!=path2.get(i))
                break;
            resultNode = path1.get(i);
        }
        return resultNode;
    }

    public static void main(String[] args) {
        String a = "12345";
        int level=1;
        int result=0;
        for (int i = a.length()-1;i>=0;i--){
            char tmp = a.charAt(i);
            result+=(tmp-'0')*level;
            level*=10;
        }
        System.out.println(result);
    }
}
