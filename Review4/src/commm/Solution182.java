package commm;

/*
 * 题目：
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * */

public class Solution182 {

    public boolean HasSubtree2(TreeNode root1, TreeNode root2) {


        /*约定空树不是任意一个树的子结构*/
        if (root2 == null) {

            return false;
        }

        /*如果root1是空的，root2非空，则也是false*/
        if (root1 == null) {
            return false;

        }
        boolean result=false;
        /*
         * 从第一个根结点开始判断
         * */

        /*如果两棵树的根结点相等*/
        if (root1.val == root2.val) {


            /*则下面开始判断root1的左子树与root2的左子树是否相等，root1的右子树与root2的右子树是否相等*/

             result= isZiShu(root1.left, root2.left) && isZiShu(root1.right, root2.right);

        }
        if(!result) {


            /*如果两棵树的根结点不相等，则判断root1的左子树包不包含root2，或者root1的右子树包不包含root2*/
            result= HasSubtree2(root1.left, root2) || HasSubtree2(root1.right, root2);
        }
        return  result;

    }

    public static boolean isZiShu(TreeNode root1, TreeNode root2) {
        if (root2 == null) {

            return true;
        }


        if (root1 == null) {
            return false;

        }
        if (root1.val == root2.val) {

            return isZiShu(root1.left, root2.left) && isZiShu(root1.right, root2.right);

        }
        return false;
    }
}
