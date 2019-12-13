package com;
/*
* 题目：
* 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号
*
* */
public class Solution16 {
    public int Add(int num1,int num2) {

        int sum=0;

         /*直到进位为0*/
        while(num2 != 0){  //先按位异或，在按位与运算，循环即可实现加和，直到num2(即进位)为0
            sum = num1 ^ num2; //按位异或运算（这个有自带的函数，直接用即可）  这一步相当于加法
            num2 = (num1 & num2) << 1; //按位与运算（这个函数直接即可）   这一步是获得进位
            num1 =sum;
        }
        return num1;


    }
}
