package commm;



/*
* 题目：
*
* 给出两个二叉树，请写出一个判断两个二叉树是否相等的函数。
判断两个二叉树相等的条件是：两个二叉树的结构相同，并且相同的节点上具有相同的值
* */
public class Solution32 {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p==null&&q==null){
            return  true;

        }

        if(p!=null&&q!=null){

            if(p.val==q.val){
                return  isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);

            }

        }

        return  false;
    }
}
