package com;


import java.util.*;

/*
 * 题目：
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行
 *
 * */
public class Solution24 {

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> FinalList = new ArrayList<>();

        Map<TreeNode, Integer> map = new HashMap<>();//用来保存每个节点的层次

        Queue<TreeNode> queue = new LinkedList<>();
        if (pRoot != null) {
            queue.add(pRoot);
            map.put(pRoot,0);

        } else {

            return null;
        }

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
               int depth= map.get(node);
               if(FinalList.size()>depth){

                   ArrayList<Integer> list=FinalList.get(depth);
                   list.add(node.val);

               }else{
                   ArrayList<Integer> list=new ArrayList<>();
                   list.add(node.val);
                   FinalList.add(list);
               }
                if (node.left != null) {
                    queue.add(node.left);
                    map.put(node.left,depth+1);

                }
                if (node.right != null) {
                    queue.add(node.right);
                    map.put(node.right,depth+1);
                }
            }


        }
        return  FinalList;

    }
}
