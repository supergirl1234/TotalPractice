package com;

/*
* 题目：
* 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
* 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
*
* */

import java.util.ArrayList;
import java.util.Stack;

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
public class Solution19 {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {

        TreeLinkNode Root=pNode;


        /*先找到整棵树的根节点*/
         while(Root.next!=null){

             Root=Root.next;

         }
         /*中序遍历*/
           ArrayList<TreeLinkNode> list=new ArrayList<>();
          TreeLinkNode cur=Root;
          Stack<TreeLinkNode>  stack=new Stack<>();
          while(!stack.isEmpty()|| cur!=null){
              while(cur!=null){
                  stack.push(cur);
                  cur=cur.left;
              }
              TreeLinkNode node=stack.pop();
              list.add(node);
              cur=node.right;
          }
          for(int i=0;i<list.size();i++){
              if(list.get(i)==pNode){
                  return i == list.size()-1?null:list.get(i+1);
              }
          }
          return null;
    }

    public TreeLinkNode GetNext2(TreeLinkNode pNode){


        /*如果该节点的右子树不为空，则该节点中序遍历的下一个节点为右子树的最左边的节点*/
       if(pNode.right!=null){
         TreeLinkNode node=  pNode.right;
         while(node.left!=null){

             node=node.left;
         }
         return  node;

       }

       /*如果该节点的右子树为空，且他是在某个节点的左子树上，则他的中序遍历的下一个节点为他的父节点*/
       if(pNode.next!=null && pNode.next.left==pNode){


               return pNode.next;

       }
        /*如果该节点的右子树为空，且他是在某个节点的右子树上，则他的中序遍历的下一个节点为：从该节点一直往上走的最后的那个父节点的父节点*/
       if(pNode.next!=null && pNode.next.right==pNode){

           TreeLinkNode node=pNode.next;
           while(node.next!=null && node.next.right==node){

               node=node.next;
           }

           return node.next;
       }

        return null;


    }

    public static void main(String[] args) {

        Solution19 solution19=new Solution19();
        TreeLinkNode a=new TreeLinkNode(1);
        TreeLinkNode b=new TreeLinkNode(2);
        TreeLinkNode c=new TreeLinkNode(3);
        TreeLinkNode d=new TreeLinkNode(4);
        TreeLinkNode e=new TreeLinkNode(5);
        TreeLinkNode f=new TreeLinkNode(6);
        a.left=b;
        a.right=c;
        b.next=a;
        c.next=a;
        b.left=d;
        b.right=e;
        d.next=b;
        e.next=b;
        c.right=f;
        f.next=c;

       TreeLinkNode node=solution19. GetNext(b);
        System.out.println(node.val);


    }
}
