package commm;


/*
* 题目：
* 判断给定的二叉树是否是平衡的
在这个问题中，定义平衡二叉树为每个节点的左右两个子树高度差的绝对值不超过1的二叉树
*
* */
public class Solution30 {

    public boolean isBalanced(TreeNode root) {

        if(root==null){

            return  true;
        }

        int left=height(root.left);
        int right=height(root.right);
        if(Math.abs(left-right)>1){

            return  false;
        }

        return  isBalanced(root.left)&&isBalanced(root.right);

    }

    public int height(TreeNode root){


        if(root==null){

            return  0;
        }

        int left=height(root.left);
        int right=height(root.right);

        return  1+(left>right?left:right);

    }
}
