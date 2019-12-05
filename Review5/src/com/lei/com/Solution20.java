package com.lei.com;

import java.util.Stack;

/*
 * 题目：
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * */
public class Solution20 {


    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    int min=Integer.MAX_VALUE;

    public void push(int node) {
        stack.push(node);
        /*当node数值入栈时，当前时期，所有已经入栈的数的最小值存储在minStack中*/
        if (minStack.isEmpty()||node<min) {
            /*更新最小值，并将最小值入minStack*/
            min=node;
            minStack.push(node);
        }else{
             /*最小值没有变化，则将还将原来的那个最小值入栈minStack*/
            minStack.push(minStack.peek());  //要保证两个栈的元素个数相同
        }


    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }
    public int min() {

        return minStack.peek();

    }
}
