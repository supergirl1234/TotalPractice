package com;
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

/*
* 题目：
*输入两个链表，找出它们的第一个公共结点
* */
public class Solution4 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {


        ListNode cur1=pHead1;
        int length1=0;
        ListNode cur2=pHead2;
        int length2=0;
        while(cur1!=null){

            length1++;
            cur1=cur1.next;
        }
        while(cur2!=null){

            length2++;
            cur2=cur2.next;
        }

       if(length1>length2){

            int sub=length1-length2;
            cur1=pHead1;
            while (sub>0){
                cur1=cur1.next;
                sub--;
            }
            cur2=pHead2;
            while(cur1!=cur2){
                cur1=cur1.next;
                cur2=cur2.next;

            }

       }else{

            int sub=length2-length1;
           cur2=pHead2;
           while (sub>0){
               cur2=cur2.next;
               sub--;
           }
           cur1=pHead1;
           while(cur1!=cur2){
               cur1=cur1.next;
               cur2=cur2.next;

           }
       }
        return  cur1;
    }
}