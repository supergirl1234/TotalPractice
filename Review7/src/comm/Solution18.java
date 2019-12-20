package comm;


import java.util.List;

/*
* 题目：
* 给定一个链表，删除链表的倒数第n个节点并返回链表的头指针
*
* */
public class Solution18 {

    public ListNode removeNthFromEnd(ListNode head, int n) {


        if(head==null){

            return  null;
        }

        ListNode dumy=new ListNode(1);
        dumy.next=head;

        ListNode fast=head;
        ListNode slow=head;

        ListNode pre=dumy;

       for(int i=0;i<n;i++){

          fast=fast.next;

        }

       while(fast!=null){

            fast=fast.next;
            slow=slow.next;
            pre=pre.next;

       }

       pre.next=slow.next;

        return  dumy.next;

    }

    public static void main(String[] args) {
        ListNode head=new ListNode(2);
        ListNode a=new ListNode(3);
        ListNode b=new ListNode(4);
        ListNode c=new ListNode(5);
        ListNode d=new ListNode(6);
        ListNode e=new ListNode(7);
        head.next=a;
        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;
        Solution18 solution18=new Solution18();
        ListNode result=solution18.removeNthFromEnd(head,6);

        ListNode cur=result;
        while(cur!=null){

            System.out.println(cur.val+" ");
            cur=cur.next;
        }


    }
}
