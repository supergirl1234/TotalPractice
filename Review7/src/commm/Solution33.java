package commm;

/*
* 题目：
*
* 给定一个二叉树，返回该二叉树层序遍历的结果，（从左到右，一层一层地遍历）

例如：
给定的二叉树是{3,9,20,#,#,15,7},
    3↵   / ↵  9  20↵    /  ↵   15   7
该二叉树层序遍历的结果是
[↵  [3],↵  [9,20],↵  [15,7]↵]
*
* */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Solution33 {

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {

        ArrayList<ArrayList<Integer>> lists=new ArrayList<>();
        Queue<TreeNode>  queue=new LinkedList<>();
        HashMap<TreeNode,Integer> map=new HashMap<>();/*用来记录每个结点的层次*/
        if(root==null){

           return   lists;
        }
        queue.add(root);
        map.put(root,0);
        while(!queue.isEmpty()){

            TreeNode node=queue.poll();
            if(node!=null) {
                int cengNum = map.get(node);
                if (cengNum >= lists.size()) {

                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(node.val);
                    lists.add(list);
                }else{

                    ArrayList<Integer> list=lists.get(cengNum);
                    list.add(node.val);
                }


                TreeNode leftNode=node.left;
                if(leftNode!=null){
                    queue.add(leftNode);
                    map.put(leftNode,cengNum+1);

                }
                TreeNode rightNode=node.right;
                if(rightNode!=null){
                    queue.add(rightNode);
                    map.put(rightNode,cengNum+1);
                }
            }

        }

        return  lists;
    }
}
