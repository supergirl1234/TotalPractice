package comm;


/*
 * 题目：
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * */

import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Stack;
import java.util.concurrent.Callable;


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution3 {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ArrayList<Integer> list=new ArrayList<>();

        /*将链表反向*/
        ListNode head=null;

        ListNode cur=listNode;
        while(cur!=null){
            ListNode node=cur.next;
            /*头插*/
            cur.next=head;
            head=cur;

            cur=node;


        }

        ListNode p=head;
        while(p!=null){

            list.add(p.val);
            p=p.next;
        }
        return list;

    }

    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> list=new ArrayList<>();
        Stack<Integer> stack=new Stack<>();
        ListNode cur=listNode;
        while(cur!=null){

            stack.push(cur.val);
            cur=cur.next;
        }
        while (stack.isEmpty()){
            list.add(stack.pop());
        }
        return  list;

    }

    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        ArrayList<Integer> list=new ArrayList<>();

        while(listNode!=null){

            printListFromTailToHead(listNode.next);
            list.add(listNode.val);
        }
        return  list;


        }

    public static void main(String[] args) {


    }
}
