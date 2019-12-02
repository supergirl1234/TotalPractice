package commm;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

/*
* 问题：输入一个链表，输出该链表中倒数第k个结点。
*
* 思路：使用快慢指针的思想，快指针比慢指针快k个节点
* */
public class Solution14 {
    public ListNode FindKthToTail(ListNode head,int k) {


       ListNode pre=head;
       ListNode post=head;
       while(k>=0 && pre!=null){

           pre=pre.next;

       }
        if(pre==null&&k>0){
            return null;
        }
       while(pre!=null){

           pre=pre.next;
           post=post.next;

       }
        return  post;
    }
}