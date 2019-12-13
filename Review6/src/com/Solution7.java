package com;

/*
* 题目：
 *
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
*
* */
public class Solution7 {

    public boolean IsBalanced_Solution(TreeNode root) {

        if(root==null){
            return  true;
        }

        if(Math.abs(height(root.left)-height(root.right))>1){
            return  false;

        }
        return IsBalanced_Solution(root.left)&&IsBalanced_Solution(root.right);

    }

    /*计算树的高度*/
    public int height(TreeNode root){
        if(root==null){

            return  0;
        }
        int leftHeight=height(root.left);
        int rightHeight=height(root.right);
        return  (leftHeight>rightHeight?leftHeight:rightHeight)+1;
    }
}
