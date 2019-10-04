package comm;


/*
* 操作给定的二叉树，将其变换为源二叉树的镜像。
* */

class  Node{

    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }
}
public class Test20 {


    public  static  void test(Node root){

        if(root==null){

            return;
        }
        /*如果左子树和右子树都为null，则也结束了*/
        if(root.left==null&&root.right==null){

            return;
        }
        /*将左子树与右子树互换*/
        Node temp=root.left;
        root.left=root.right;
        root.right=temp;

       test(root.left);
       test(root.right);
    }
    public static void main(String[] args) {

         Node head=new Node(1);
         Node p1=new Node(2);
         Node p2=new Node(3);
         Node p3=new Node(4);
         Node p4=new Node(5);
         Node p5=new Node(6);
         Node p6=new Node(7);

         head.left=p1;
         head.right=p2;
         p1.left=p3;
         p1.right=p4;
         p2.left=p5;
         p5.right=p6;
        test(head);


    }
}
