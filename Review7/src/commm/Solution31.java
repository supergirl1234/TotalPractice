package commm;


/*
* 题目：
* 给定一棵二叉树，判断琪是否是自身的镜像（即：是否对称）
例如：下面这棵二叉树是对称的
*
* */
public class Solution31 {

    public boolean isSymmetric(TreeNode root) {
        if(root==null){

            return  true;
        }


        if(root.left==null && root.right==null){
            return  true;

        }

        return  isMirror(root.left,root.right);



    }

    public boolean isMirror(TreeNode head1,TreeNode head2){


        if(head1==null&& head2==null){

            return  true;
        }
        if(head1!=null&& head2!=null) {
            if (head1.val == head2.val) {

                return isMirror(head1.left, head2.right) && isMirror(head1.right, head2.left);


            }
        }

        return  false;

    }
}
