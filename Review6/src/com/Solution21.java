package com;


/*
* 题目：
* 删除链表中重复的节点
* 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
*
* */
public class Solution21 {

    public ListNode deleteDuplication(ListNode pHead)

    {
          if(pHead==null){
              return pHead;

          }
          ListNode Node=new ListNode(0);
          Node.next=pHead;

          ListNode pior=Node;
           ListNode pre=pHead;
           ListNode post=pHead.next;

           while(post!=null) {
               if (pre.val != post.val) {
                   pior = pior.next;
                   pre = pre.next;
                   post = post.next;
               } else {

                   while (post!=null&&pre.val == post.val) {
                       post = post.next;

                   }
                   pior.next = post;
                   if(post!=null) {
                       pre = post;
                       post = post.next;
                   }
               }
           }

           return  Node.next;
    }

    public static void main(String[] args) {


    }
}
