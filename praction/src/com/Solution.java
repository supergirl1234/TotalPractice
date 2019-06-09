package com;



/**
 * Author:Fanleilei
 * Created:2019/6/9 0009
 *
 * 二叉树的镜像
 */

class TreeNode {
    int val;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
public class Solution {
    public void Mirror(TreeNode root) {
        if(root==null){

            return;
        }

        if(root.left==null&&root.right==null){

            return;
        }

            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            if(root.left!=null) {
                Mirror(root.left);
            }
            if(root.right!=null) {
                Mirror(root.right);
            }


    }
    public static void main(String[] args) {
        Solution p=new Solution();
      TreeNode root=new TreeNode(1);
      TreeNode p1=new TreeNode(2);
      TreeNode p2=new TreeNode(3);
      TreeNode p3=new TreeNode(4);
      TreeNode p4=new TreeNode(5);
      TreeNode p5=new TreeNode(6);
      TreeNode p6=new TreeNode(7);
      root.left=p1;
      root.right=p2;
      p1.left=p3;
      p1.right=p4;
      p2.left=p5;
      p2.right=p6;
      p.Mirror(root);


    }
}
