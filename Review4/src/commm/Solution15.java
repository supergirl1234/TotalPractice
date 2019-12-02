package commm;


/*
 * 题目：反转链表
 * 输入一个链表，反转链表后，输出新链表的表头。
 *
 * */
public class Solution15 {
    public ListNode ReverseList(ListNode head) {

        /*
         * 将原链表中的每一个结点头插到另一个链表中
         * */


        ListNode result = null;
        ListNode cur=head;
        while(cur!=null){

            ListNode node=cur.next;

            /*头插*/
            cur.next=result;
            result=cur;

            cur=node;

        }
        return result;
    }
}