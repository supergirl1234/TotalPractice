package commm;


/*
* 题目：
* 判断给出的二叉树是否是一个二叉搜索树（BST）
二叉搜索树的定义如下
一个节点的左子树上节点的值都小于自身的节点值
一个节点的右子树上节点的值都小于自身的节点值
所有节点的左右子树都必须是二叉搜索树
如果你不清楚“{1,#,2,3}"的含义的话，请继续阅读
我们用如下方法将二叉树序列化：
二叉树的序列化遵循层序遍历的原则，”#“代表该位置是一条路径的终结，下面不再存在结点。
*
* */

/*
* 思路：
* 每次比较某节点时，更新当时的最小节点与最大节点
*
* */
public class Solution35 {
    public boolean isValidBST(TreeNode root) {

        if(root==null){

            return  true;
        }


        return  isValidBST(root.left,null,root)&&isValidBST(root.right,root,null);
    }

    public boolean isValidBST(TreeNode root,TreeNode min,TreeNode max) {
        if(root==null){
            return  true;
        }

        if(min!=null) {
            if (root.val <= min.val) {
                return false;

            }
        }
        if(max!=null) {
            if (root.val >= max.val) {
                return false;

            }
        }
        return  isValidBST(root.left,min,root)&&isValidBST(root.right,root,max);

    }

    public static void main(String[] args) {

        TreeNode root=new TreeNode(98);
        TreeNode a=new TreeNode(-57);
        TreeNode b=new TreeNode(58);
        TreeNode c=new TreeNode(31);

        root.left=a;
        a.right=b;
        b.left=c;


        Solution35 solution35=new Solution35();
        boolean result=solution35.isValidBST(root);
        System.out.println(result);

    }
}
