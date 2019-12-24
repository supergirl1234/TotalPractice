package commm;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/*
* 题目：
* 给定一个二叉树，返回该二叉树的之字形层序遍历，（从左向右，下一层从右向左，一直这样交替）
例如：
给定的二叉树是{3,9,20,#,#,15,7},
    3↵   / ↵  9  20↵    /  ↵   15   7
该二叉树之字形层序遍历的结果是
[↵  [3],↵  [20,9],↵  [15,7]↵]
*
* */
public class Solution34 {

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        HashMap<TreeNode, Integer> map = new HashMap<>();/*用来记录每个结点的层次*/
        if (root == null) {

            return lists;
        }
        queue.add(root);
        map.put(root, 0);
        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();
            if (node != null) {
                int cengNum = map.get(node);
                if (cengNum >= lists.size()) {

                    if (cengNum % 2 == 0) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(node.val);
                        lists.add(list);

                    } else {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(0, node.val);
                        lists.add(list);


                    }

                } else {
                    ArrayList<Integer> list = lists.get(cengNum);
                    if(cengNum % 2 == 0) {

                        list.add(node.val);
                    }else{
                        list.add(0, node.val);

                    }
                }


                TreeNode leftNode = node.left;
                if (leftNode != null) {
                    queue.add(leftNode);
                    map.put(leftNode, cengNum + 1);

                }
                TreeNode rightNode = node.right;
                if (rightNode != null) {
                    queue.add(rightNode);
                    map.put(rightNode, cengNum + 1);
                }


            }

        }

        return lists;
    }
}
