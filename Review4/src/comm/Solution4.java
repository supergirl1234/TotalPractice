package comm;



import java.util.Arrays;

/*
 * 题目：
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution4 {

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {


        if(pre.length == 0 || in.length == 0){
            return null;

        }
        TreeNode head = new TreeNode(pre[0]);//根结点
        int index = index(in, pre[0]);  //找出根结点在中序排列中的位置，将其分割成左右子树
        /*采用递归的方式*/
        /*然后采用递归的形式对左子树的前序遍历和中序遍历进行创建树*/
        head.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, index + 1), Arrays.copyOfRange(in, 0, index));
        /*采用递归的形式对右子树的前序遍历和中序遍历进行创建树*/
        head.right = reConstructBinaryTree(Arrays.copyOfRange(pre, index + 1, pre.length), Arrays.copyOfRange(in, index + 1, in.length));


        return head;
    }

    public static int index(int[] in, int num) {

        for (int i = 0; i < in.length; i++) {
            if (in[i] == num) {

                return i;
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        int[] pre = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] in={4,7,2,1,5,3,8,6};

        TreeNode head=reConstructBinaryTree(pre, in);

        System.out.println(head);
    }
}
