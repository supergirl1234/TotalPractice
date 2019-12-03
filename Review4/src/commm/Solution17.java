package commm;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

/*
 * 问题：
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 *
 * */
public class Solution17 {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {

        if (root2 == null) {
            return false;
        }
        if(root1==null){

            return  false;
        }
        boolean result=false;
        if (root1.val == root2.val) {

            /*比较root1的左子树和root2的左子树，比较root1的右子树和root2的右子树*/
            result= Subtree(root1,root2);
            if(result){
                return  result;
            }else {
                result= HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
            }
        }

      return  result;


    }
    public boolean Subtree(TreeNode root1, TreeNode root2) {
        if(root2==null)   {
            return  true;
        }
        if(root1==null){

            return  false;
        }
        if(root1.val==root2.val){
            return Subtree(root1.left,root2.left)&&Subtree(root1.right,root2.right);

        }
        return  false;

    }


}