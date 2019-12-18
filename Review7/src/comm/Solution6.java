package comm;


import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

/*
* 题目：
* 求给定二叉树的最小深度。最小深度是指树的根结点到最近叶子结点的最短路径上结点的数量。
*/
public class Solution6 {

// 方法一：思路：
//
//递归，若为空树返回0；
//若左子树为空，则返回右子树的最小深度+1；（加1是因为要加上根这一层，下同）
//若右子树为空，则返回左子树的最小深度+1；
//若左右子树均不为空，则取左、右子树最小深度的较小值，+1；
    public int run(TreeNode root) {

        if(root==null){

            return 0;
        }

        if( root.left==null){

            return 1+run(root.right);
        }

        if( root.right==null){

            return 1+run(root.left);
        }


        int leftHeight=run(root.left);
        int rightHeight=run(root.right);

        return (leftHeight<rightHeight?leftHeight:rightHeight)+1;
    }


    /*方法二：采用层序遍历,一旦找到一个节点为叶子节点，就不往下遍历了*/
    public int run2(TreeNode root) {

        Queue<TreeNode> queque=new LinkedList<>();
        if(root==null){

            return 0;
        }
        int height=0;
        queque.add(root);
        height=height+1;
        while(!queque.isEmpty()){
             int num=queque.size(); //得到的是某一层的节点个数
             for(int i=0;i<num;i++){  //将当前层的节点都出栈，将下一层的节点都入栈

                 TreeNode node=queque.poll();
                 if(node!=null) {
                     if (node.left == null && node.right == null) {

                         return height;
                     }
                     if(node.left!= null){
                         queque.add(node.left);

                     }
                     if(node.right!= null){
                         queque.add(node.right);

                     }
                 }

             }
             height++;


        }

        return height;

    }

}
