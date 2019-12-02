package commm;


/*
* 问题：
* 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
*
* */
public class Solution16 {
    public ListNode Merge(ListNode list1,ListNode list2) {


        ListNode result=null;
        ListNode last=null;
        ListNode cur1=list1;
        ListNode cur2=list2;
        while(cur1!=null&&cur2!=null){


            if(cur1.val<=cur2.val){

                if(result==null){
                    result=cur1;
                }else{

                    last.next=cur1;

                }
                last=cur1;

                cur1=cur1.next;

            }else{
                if(result==null){
                    result=cur2;
                }else{

                    last.next=cur2;

                }
                last=cur2;

                cur2=cur2.next;

            }



        }

        while(cur1!=null){
            ListNode node=cur1.next;
            if(result==null){
                result=cur1;
            }else{

                last.next=cur1;

            }
            last=cur1;

            cur1=node;

        }
        while(cur2!=null){
            ListNode node=cur2.next;
            if(result==null){
                result=cur2;
            }else{

                last.next=cur2;

            }
            last=cur2;

            cur2=node;

        }

        return  result;
    }
}