package com;


import java.util.*;

/*
 * 题目：
 * 请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，
 * 其他行以此类推
 *
 * */
public class Solution26 {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> FinalList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();    //使用队列

        HashMap<TreeNode, Integer> hashMap = new HashMap<>();
        if (pRoot != null) {
            queue.add(pRoot);
            hashMap.put(pRoot, 0);
        } else {
            return FinalList;
        }

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                int depth = hashMap.get(node);
                ArrayList<Integer> list = null;
                if (FinalList.size() > depth) {
                    list = FinalList.get(depth);
                } else {
                    list = new ArrayList<>();
                    FinalList.add(list);
                }
                if (depth % 2 != 0) {
                    list.add(0, node.val);

                } else {

                    list.add(node.val);
                }

                if (node.left != null) {
                    queue.add(node.left);
                    hashMap.put(node.left, depth + 1);
                }
                if (node.right != null) {
                    queue.add(node.right);
                    hashMap.put(node.right, depth + 1);
                }
            }
        }
        return FinalList;
    }


    /*使用栈*/
    public ArrayList<ArrayList<Integer>> Print2(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> FinalList = new ArrayList<>();

        Stack<TreeNode> jishuStack = new Stack<>();//存放奇数层的节点
        Stack<TreeNode> oushuStack = new Stack<>();//存放偶数层的节点

        if (pRoot != null) {
            jishuStack.push(pRoot);
        } else {

            return FinalList;
        }

        while (!jishuStack.isEmpty() || !oushuStack.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            if (!jishuStack.isEmpty()) {
                while (!jishuStack.isEmpty()) {

                    TreeNode node = jishuStack.pop();
                    if (node != null) {

                        list.add(node.val);

                        if(node.left!=null) {
                            oushuStack.push(node.left);
                        }
                        if(node.right!=null) {
                            oushuStack.push(node.right);
                        }
                    }

                }
                if (jishuStack.isEmpty()) {
                    FinalList.add(list);
                }
            }
            if (!oushuStack.isEmpty()) {
                list = new ArrayList<>();
                while (!oushuStack.isEmpty()) {

                    TreeNode node = oushuStack.pop();
                    if (node != null) {

                        list.add(node.val);
                        if(node.right!=null) {
                            jishuStack.push(node.right);
                        }
                        if(node.left!=null) {
                            jishuStack.push(node.left);
                        }
                    }
                }
                if (oushuStack.isEmpty()) {
                    FinalList.add(list);
                }
            }

        }

        return FinalList;

    }
}
