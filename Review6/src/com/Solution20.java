package com;


import sun.reflect.generics.tree.Tree;

/*
* 题目：
* 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
*
* */
public class Solution20 {

    boolean isSymmetrical(TreeNode pRoot)
    {

        TreeNode copyTree=CreateMirrorTree(pRoot);

        /*比较两个二叉树*/
       return  isSame(pRoot,copyTree);

    }


    /*获取一个二叉树的镜像*/
    TreeNode CreateMirrorTree(TreeNode pRoot){
        if(pRoot==null){
            return null;
        }
        TreeNode head=new TreeNode(pRoot.val);
        head.left=CreateMirrorTree(pRoot.right);
        head.right=CreateMirrorTree(pRoot.left);
        return  head;
    }

    /*比较两个二叉树是否相同*/
    public boolean isSame(TreeNode head1,TreeNode head2){


        if(head1!=null &&  head2!=null &&head1.val==head2.val){

            return isSame(head1.left,head2.left)&&isSame(head1.right,head2.right);

        }else{

            return false;
        }


    }



    boolean isSymmetrical2(TreeNode pRoot){

        /*直接比较左子树和右子树是否相同*/


        return isSame(pRoot.left,pRoot.right);


    }

    public static void main(String[] args) {

        TreeNode head=new TreeNode(8);
        TreeNode a=new TreeNode(6);
        TreeNode b=new TreeNode(9);
        TreeNode c=new TreeNode(5);
        TreeNode d=new TreeNode(7);
        TreeNode e=new TreeNode(7);
        TreeNode f=new TreeNode(5);

        head.left=a;
        head.right=b;
        a.left=c;
        a.right=d;
        b.left=e;
        b.right=f;

        Solution20 solution20=new Solution20();
        System.out.println(solution20.isSymmetrical(head));
        System.out.println(solution20.isSymmetrical2(head));

    }
}
