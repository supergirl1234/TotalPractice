package com;


/*
 * 题目：
 *
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 * */
public class Solution71 {
    public boolean IsBalanced_Solution71(TreeNode root) {

         return height71(root)!=-1;


    }


    /*在计算高度的过程中判断是否是平衡的*/
    public int height71(TreeNode root){

        if(root==null){

            return 0;
        }

        int leftHeight=height71(root.left);
        if(leftHeight==-1){  //如果左子树不平衡，就不往下计算了

            return  -1;
        }
        int rightHeight=height71(root.right);
        if(rightHeight==-1){//如果右子树不平衡，就不往下计算了
               return -1;

        }
        if(Math.abs(leftHeight-rightHeight)>1){
            return -1;

        }else{

            return  (leftHeight>rightHeight?leftHeight:rightHeight)+1;
        }


    }

}
