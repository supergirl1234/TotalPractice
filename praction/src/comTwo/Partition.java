package comTwo;

/**
 * Author:Fanleilei
 * Created:2019/6/10 0010
 * 以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前。
 * 给定一个链表的头指针ListNode* pHead，请返回重新排列后的链表的头指针。
 * 且分割以后，保持原来的数据顺序不变
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Partition {

    private ListNode smallNode=null;
    private ListNode bigNode=null;
    private ListNode smalllast=null;
    private ListNode biglast=null;
    private ListNode partition(ListNode pHead, int x) {
         if(pHead==null || pHead.next==null){

             return null;
         }
         ListNode cur=pHead;
         while(cur!=null){

             if(cur.val<=x){



               inertSmallPost(smallNode,cur);
             }else{

                inertBigPost(bigNode,cur);

             }
             cur=cur.next;
         }

         //将smallNode和bigNode拼接在一起
        if(smallNode!=null) {

            smalllast.next = bigNode;
            return smallNode;
        }else {

             return bigNode;
        }


    }

    //smallNode尾插
    public  void inertSmallPost(ListNode smallNode,ListNode node){
        if(smallNode==null){

            smallNode=node;
        }else{

            smalllast.next=node;
        }
        smalllast=node;

    }
    //bigNode尾插
    public  void inertBigPost(ListNode bigNode,ListNode node){
        //尾插到bigNode

        if(bigNode==null){

            bigNode=node;
        }else{

            biglast.next=node;
        }
        biglast=node;
    }



    public static void main(String[] args) {

        ListNode head=new ListNode(1);
        ListNode p2=new ListNode(6);
        ListNode p3=new ListNode(8);
        ListNode p4=new ListNode(3);
        ListNode p5=new ListNode(11);
        ListNode p6=new ListNode(0);
        ListNode p7=new ListNode(16);
        head.next=p2;
        p2.next=p3;
        p3.next=p4;
        p4.next=p5;
        p5.next=p6;
        p6.next=p7;

        Partition test=new Partition();
        ListNode result=test.partition(head,5);

        ListNode cur=result;
        while(cur!=null){
            System.out.println(cur.val);
            cur=cur.next;

        }



    }
}
