package commm;


/*
* 题目：
* 给定一个仅包含数字0-9的二叉树，每一条从根节点到叶子节点的路径都可以用一个数字表示。
例如根节点到叶子节点的一条路径是1->2->3,那么这条路径就用123来代替。
找出根节点到叶子节点的所有路径表示的数字之和
*
*
* 思路：
* 先序遍历的思想(根左右)+数字求和(每一层都比上层和*10+当前根节点的值)
* */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution25 {
    public int sumNumbers(TreeNode root) {

        int sum = 0;
        if (root == null) {

            return sum;
        }

        return preSum(root, sum);
    }

    public int preSum(TreeNode head, int sum) {

        if (head == null) {
            return 0;

        }

        sum = sum * 10 + head.val;
        if (head.left == null && head.right == null) {
            return sum;
        }
        return preSum(head.left, sum) + preSum(head.right, sum);

    }


}