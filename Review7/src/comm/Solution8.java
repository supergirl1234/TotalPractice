package comm;

/*
* 题目：
* 求给定的二叉树的后序遍历，要求使用非递归的方式
*
* */


import java.util.ArrayList;
import java.util.Stack;

public class Solution8 {

    public ArrayList<Integer> postorderTraversal(TreeNode root) {

        Stack<TreeNode>  stack=new Stack<>();
        ArrayList<Integer> list=new ArrayList<>();
        if(root==null){

            return list;
        }

        TreeNode cur=root;
        TreeNode last=null;
        while(!stack.isEmpty() || cur!=null){

              while(cur!=null){

                  stack.push(cur);
                  cur=cur.left;
              }
              TreeNode peek=stack.peek();
              if(peek.right==null){

                  TreeNode node=stack.pop();
                  list.add(node.val);
                  last=node;


              }else if(peek.right==last){

                  TreeNode node=stack.pop();
                  list.add(node.val);
                  last=node;
              }else{

                  cur=peek.right;
              }


        }

        return  list;

    }
}
