package com;

/*
 * 题目：
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 *
 *
 * 思路：就是中序遍历
 * */



import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution18 {

    /*中序遍历*/
    TreeNode KthNode(TreeNode pRoot, int k) {


        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = pRoot;
        int index=0;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {

                stack.push(cur);
                cur = cur.left;

            }
            TreeNode node =stack.pop();
            index++;
            if(index==k){

                return  node;
            }
            cur=node.right;


        }


        return  null;

    }

    /*后序遍历*/
    List<TreeNode> hh(TreeNode pRoot, int k) {
        ArrayList<TreeNode> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode last = null;
        TreeNode cur = pRoot;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {

                stack.push(cur);
                cur=cur.left;

            }
            TreeNode node = stack.peek();

            if (node.right == null) {
                last = stack.pop();
                list.add(last);
            }  else if (node.right==last) {
                last = stack.pop();
                list.add(last);

            }else  {
                cur=node.right;

            }


        }


         return  list;
    }
}
