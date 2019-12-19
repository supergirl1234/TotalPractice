package comm;


/*
 * 题目：
 * 使用插入排序对链表进行排序
 *
 * 思路：新建一个链表,遍历原链表，将每个节点加入新链表正确的位置
 *
 * */


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution10 {
    public ListNode insertionSortList(ListNode head) {

        if (head == null) {

            return head;
        }

        ListNode dumny = new ListNode(0);//存放结果的链表

        ListNode cur = head;
        while (cur != null) {

            ListNode next = cur.next;//原链表的下一个节点

            ListNode pre = dumny;
            ListNode post = dumny.next;

            while (post != null && cur.val > post.val) {  //原链表中cur节点的值 与结果链表中的节点依次比较
                pre = pre.next;
                post = post.next;
            }
            cur.next = post;
            pre.next = cur;

            cur = next;
        }

        return dumny.next;
    }

    public static void main(String[] args) {

    }

}
