package comm;


/*
* 以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
* */

class PNode{

    int value;
    PNode next;

    public PNode(int value) {
        this.value = value;
    }
}
public class Test21 {

    public static  PNode test(PNode root,int k){

        PNode small=null;
        PNode smallLast= null;
        PNode big=null;
        PNode bigLast= null;
        PNode cur=root;
        while(cur!=null){

            if(cur.value<k){

              if(smallLast==null){

                  small=new PNode(cur.value);
              }else{

                  smallLast.next=new PNode(cur.value);
              }
              smallLast=new PNode(cur.value);
            }
            if(cur.value>=k){

                if(bigLast==null){

                    big=new PNode(cur.value);
                }else{

                    bigLast.next=new PNode(cur.value);
                }
                bigLast=new PNode(cur.value);
            }
            cur=cur.next;
        }
        if(smallLast!=null){

            smallLast.next=big;
            return  small;
        }else{
            return  big;

        }



    }
    public static void main(String[] args) {



    }
}
