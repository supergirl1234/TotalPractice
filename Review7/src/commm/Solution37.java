package commm;




import java.util.ArrayList;
import java.util.Stack;

/*
*
* 题目：
* 给出一棵二叉树，返回这棵树的中序遍历
例如：
给出的二叉树为{1,#,2,3},

   1↵    ↵     2↵    /↵   3↵
返回[1,3,2].
*
* */
public class Solution37 {

    public ArrayList<Integer> inorderTraversal(TreeNode root) {

        ArrayList<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        if(root==null){

            return  list;
        }

        TreeNode cur=root;
        while(!stack.isEmpty()|| cur!=null){

            while(cur!=null){

                stack.add(cur);
                cur=cur.left;

            }
            TreeNode node=stack.pop();
            list.add(node.val);
            TreeNode rightNode=node.right;
            if(rightNode!=null){

                cur=rightNode;
            }
        }

        return  list;


    }
}
