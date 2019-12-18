package comm;


import java.util.ArrayList;
import java.util.Stack;

/*
 * 题目：
 * 前序遍历，非递归方式
 *
 * */
public class Solution9 {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return list;

        }

        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                list.add(cur.val);
                cur = cur.left;

            }

            TreeNode node = stack.pop();
            cur = node.right;


        }

        return list;

    }
}
