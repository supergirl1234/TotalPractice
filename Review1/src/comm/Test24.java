package comm;

/*
* 实现一个函数，检查二叉树是否平衡，平衡的定义如下，对于树中的任意一个结点，其两颗子树的高度差不超过1。
* */

public class Test24 {

    public static  boolean isTest(Node root){

        if(root==null){

          return  true;
        }
        int LHeight=height(root.left);
        int RHeight=height(root.right);
        if(Math.abs(LHeight-RHeight)>1){

            return  false;
        }

        return  isTest(root.left)&&isTest(root.right);
    }

//    树的高度
    public static  int height(Node root){

        if(root==null){
            return  0;
        }
        int leftHeight=height(root.left);
        int rightHeight=height(root.right);

        return (leftHeight>rightHeight?leftHeight:rightHeight)+1;
    }
    public static void main(String[] args) {

    }
}
