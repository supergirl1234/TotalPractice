package comm;


/*
 * 题目：
 * 在O(n log n)的时间内使用常数级空间复杂度对链表进行排序
 *
 *
 * 思路：
 * 使用归并排序
 * */

public class Solution13 {
    public ListNode sortList(ListNode head) {

        if (head == null) {

            return null;
        }
        if (head.next == null) {

            return head;
        }

        /*使用快慢指针找出中间结点*/
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null &&fast.next .next!= null) {  //fast.next .next!= null这一条件是为了针对两个数不能平分的情况

            fast = fast.next.next;
            slow = slow.next;

        }

        ListNode head2 = slow.next;
        slow.next = null;
        ListNode result1=sortList(head);
        ListNode result2=sortList(head2);
        return merge(result1, result2);//合并两个有序链表



    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode result = null;
        ListNode last = null;



        ListNode cur1 = head1;
        ListNode cur2 = head2;
        while (cur1 != null && cur2 != null) {
            ListNode node1 = cur1.next;
            ListNode node2 = cur2.next;
            if (cur1.val <= cur2.val) {
                if (last == null) {
                    result = cur1;
                } else {
                    last.next = cur1;
                }
                last = cur1;
                cur1 = node1;
            } else {
                if (last == null) {
                    result = cur2;
                } else {
                    last.next = cur2;
                }
                last = cur2;
                cur2 = node2;
            }
        }

        while (cur1 != null) {

            if(last==null) {
               result=cur1;

            }else {
                last.next = cur1;

            }
            last = cur1;
            cur1=cur1.next;
        }
        while (cur2 != null) {

            if(last==null) {
                result=cur2;

            }else {
                last.next = cur2;

            }
            last = cur2;
            cur2=cur2.next;
        }


     return  result;
    }

    public static void main(String[] args) {

        Solution13 solution13=new Solution13();
        ListNode head=new ListNode(3);
        ListNode a=new ListNode(2);
        ListNode b=new ListNode(4);
       /* ListNode c=new ListNode(7);
        ListNode d=new ListNode(1);
        ListNode e=new ListNode(11);
        ListNode f=new ListNode(10);*/
        head.next=a;
        a.next=b;
       /* b.next=c;
        c.next=d;
        d.next=e;
        e.next=f;*/
        ListNode result=solution13.sortList(head);

        ListNode cur=result;
        while(cur!=null){

            System.out.println(cur.val+" ");
            cur=cur.next;

        }

    }
}
