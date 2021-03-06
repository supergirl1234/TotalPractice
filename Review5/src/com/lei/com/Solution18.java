package com.lei.com;


/*
* 题目：操作给定的二叉树，将其变换为源二叉树的镜像。
*
*思路：采用递归的思想
*
* */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Solution18 {
    public void Mirror(TreeNode root) {
        if(root==null){

            return;
        }
        TreeNode leftNode=root.left;
        TreeNode rightNode=root.right;
        root.left=rightNode;
        root.right=leftNode;
        Mirror(root.left);
        Mirror(root.right);

    }
}