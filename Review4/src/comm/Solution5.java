package comm;

import java.util.Stack;

/*
* 题目：
* 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
* */
public class Solution5 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
       stack1.push(node);

    }

    public int pop() {
        int result;
        if(!stack2.isEmpty()){
           result= stack2.pop();

        }else {
            if(stack1.isEmpty()){
              return -1;

            }else {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
                result = stack2.pop();
            }
        }
        return  result;

    }

    public static void main(String[] args) {

        Solution5 solution5=new Solution5();
        solution5.push(1);
        solution5.push(3);
        solution5.push(4);
        solution5.push(5);
        System.out.println(solution5.pop());
        System.out.println(solution5.pop());
        System.out.println(solution5.pop());
        System.out.println(solution5.pop());
    }
}
