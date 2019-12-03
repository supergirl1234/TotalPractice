package com.lei.com;



import java.util.Stack;

/*
* 题目：
* 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
* 假设压入栈的所有数字均不相等。
* 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
* （注意：这两个序列的长度是相等的）
* */
public class Solution21 {


    /*
    * 第一种思想：
    * 创建一个栈
    * 先查看出栈数组popA中的元素，对于popA中的每一个元素a，如果此时，栈中是空的，则将pushA中的a这个元素之前的元素入栈；
    * 如果栈不空，且栈中的栈顶元素与a相等，则出栈，如果栈中的栈顶元素与a不相等，则将继续讲pushA中的栈顶元素之前的元素入栈；
    *
    * 如果最后，栈为空，则结果为true；
    * */
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack=new Stack<>();
        int j=0;
       for(int i=0;i<popA.length;i++){

           if(stack.isEmpty()){
               for(;j<pushA.length;j++){
                   if(pushA[j]!=popA[i]){

                       stack.push(pushA[j]);
                   }else{
                       j++;
                       break;
                   }

               }
           }else if(stack.peek()==popA[i]){
               stack.pop();

           }else {
               for(;j<pushA.length;j++){
                   if(pushA[j]!=popA[i]){

                       stack.push(pushA[j]);
                   }else{
                       j++;
                       break;
                   }

               }
           }
       }

       if(stack.isEmpty()){

           return  true;
       }

       return  false;
    }


    /*
    * 第二种思路：
    *
    * 将pushA中的元素依次入栈，如果栈顶元素与popA的元素相同，则出栈，当循环结束时，判断栈是否为空，若为空则返回true.
    * */
    public static boolean IsPopOrder2(int [] pushA,int [] popA) {
        Stack<Integer> stack=new Stack<>();
        int j=0;
        for(int i=0;i<pushA.length;i++){

            stack.push(pushA[i]);

            while (!stack.isEmpty()&&stack.peek()==popA[j]){

                stack.pop();
                j++;

            }

        }

        if(stack.isEmpty()){

            return  true;
        }
        return  false;
    }

    public static void main(String[] args) {
       int[] pushA=new int[]{1,2,3,4,5};
       int[] popA=new int[]{4,5,3,2,1};
        System.out.println( IsPopOrder(pushA,popA));
        System.out.println( IsPopOrder2(pushA,popA));
    }
}
