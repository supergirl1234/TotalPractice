package comm;


/*
* 题目：
* 将给定的单链表L： L 0→L 1→…→L n-1→L n,
重新排序为： L 0→L n →L 1→L n-1→L 2→L n-2→…
要求使用原地算法，并且不改变节点的值
*
* */
public class Solution11 {

    public void reorderList(ListNode head) {

        if(head==null){

            return;
        }

        /*1、先快慢指针找到链表的中间结点*/
         ListNode fast=head;
         ListNode slow=head;
         while(fast!=null&& fast.next!=null){

             fast=fast.next.next;
             slow=slow.next;

         }  //然后slow就处于链表的中间结点除了，fast处于链表的末尾

        /*2、将整个链表拆分为两部分*/

         ListNode twoListNode=slow.next;/*第二个链表*/
         slow.next=null;


        /*3、并且经后半部分链表反转*/
        /*即将head2链表反转,即将每个结点头插到另个链表上*/
         ListNode head2=null;

        ListNode cur=twoListNode;
        while(cur!=null){
            ListNode node=cur.next;

            cur.next=head2;
            head2=cur;

            cur=node;

        }/*最终第二个链表为head2*/

        /*4、将两个链表交叉排序*/

        ListNode cur1=head;
        ListNode cur2=head2;

        while (cur1!=null&&cur2!=null){

              ListNode node1=cur1.next;
              ListNode node2=cur2.next;

              cur2.next=cur1.next;
              cur1.next=cur2;

              cur1=node1;
              cur2=node2;
        }

    }
}


