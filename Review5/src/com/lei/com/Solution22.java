package com.lei.com;



import java.util.ArrayList;
import java.util.LinkedList;

import java.util.Queue;

/*
 * 题目：
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * */

/*
* 思路：利用队列
*
* 首先将根结点入队列
*
* 然后每出一个结点，就将该节点的左结点入队列，右结点入队列
*
* */
public class Solution22 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
       Queue<TreeNode> queue=  new LinkedList<>();
        ArrayList<Integer> list=new ArrayList<>();

        if(root==null){

            return list;
        }
       queue.add(root);
       while(!queue.isEmpty()){
           TreeNode node=queue.poll();
           list.add(node.val);
           if(node.left!=null) {
               queue.add(node.left);
           }
           if(node.right!=null) {
               queue.add(node.right);
           }



       }

        return list;
    }
}