package commm;

/*
* 题目：
* 现在有一个这样的链表：链表的每一个节点都附加了一个随机指针，随机指针可能指向链表中的任意一个节点或者指向空。
请对这个链表进行深拷贝。
*
*
* */

class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
};

public class Solution24 {
    public RandomListNode copyRandomList(RandomListNode head) {


        /*复制链表*/
        RandomListNode cur=head;
        while(cur!=null){
            RandomListNode next=cur.next;

            RandomListNode node=new RandomListNode(cur.label);
            node.next=next;
            cur.next=node;

            cur=next;

        }


        /*复制random*/
        cur=head;
        while(cur!=null){

            RandomListNode next=cur.next.next;

            if(cur.random!=null){
                cur.next.random=cur.random.next;

            }else{

                cur.next.random=null;
            }


            cur=next;


        }

        /*开始拆分整个链表，拆分为连两个*/
        cur=head;
        RandomListNode result=null;
        if(cur!=null){

            result=cur.next;
        }

        while(cur!=null){

            RandomListNode nextNext=cur.next.next;

            if(nextNext!=null) {
                cur.next.next = nextNext.next;
            }
            cur.next=nextNext;


            cur=nextNext;

        }


        return  result;

    }
}