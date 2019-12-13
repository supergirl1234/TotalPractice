package com;


import java.util.Arrays;

/*
* 题目：
* 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
* 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
* 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
*
* */
public class Solution11 {

    /*使用内置函数*/
    public String LeftRotateString(String str,int n) {

        if(n>str.length()){
            return  "";

        }
        StringBuffer sb=new StringBuffer();
        return sb.append(str.substring(n)).append(str.substring(0,n)).toString();

    }

    /*不使用内置函数*/
    public String LeftRotateString2(String str,int n) {
        if(n>str.length()){
            return  "";

        }

        char[] chars=str.toCharArray();

        n=n%str.length();

        for(int i=0,j=n-1;i<j;i++,j--){

            swap(chars,i,j);
        }
        for(int i=n,j=str.length()-1;i<j;i++,j--){

            swap(chars,i,j);
        }
        for(int i=0,j=str.length()-1;i<j;i++,j--){
            swap(chars,i,j);

        }

        return new String(chars);
    }

    public void swap(char[] chars,int i,int j){

          char temp= chars[i];
          chars[i]=chars[j];
          chars[j]=temp;

    }

    public static void main(String[] args) {


    }

}
