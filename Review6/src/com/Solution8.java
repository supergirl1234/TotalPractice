package com;


import java.util.Arrays;
import java.util.Stack;

import static jdk.nashorn.internal.objects.NativeArray.push;

/*
* 题目：
* 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
*num1,num2分别为长度为1的数组。传出参数
将num1[0],num2[0]设置为返回结果
* */
public class Solution8 {

    /*方法1，最简单通俗的方法,除了用蘸，还可以用hashMap的方法*/
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {

        Arrays.sort(array);/*排序*/
        Stack<Integer> stack=new Stack<>();

        for(int i=0;i<array.length;i++){

            if(stack.isEmpty()){
                stack.push(array[i]);

            }else{

                if(array[i]==stack.peek()){

                    stack.pop();
                }else{

                    stack.push(array[i]);
                }
            }

        }

        num1[0]=stack.pop();
        num2[0]=stack.pop();


    }

    /*方法2，剑指offer的方法*/
    public void FindNumsAppearOnc2(int [] array,int num1[] , int num2[]) {

        /*异或^ 是指相同为0，一个数和0异或还是它本身*/
        int num=0;
        for(int i=0;i<array.length;i++){


            num^=array[i];
        }

        /*在异或的结果中，二进制形式的情况下，哪一位为0，说明异或的那两个数的那一位相同；哪一位为1，说明异或的那两个数的那一位不同*/


        /*找出异或的结果中从右往左数第一个1*/

        int index=1;
        while((num & index)==0){

            index=index<<1;//index左移一位

        }
        int result1=0;
        int result2=0;

        /*分组标准是第index位是否为1*/
        for(int i=0;i<array.length;i++){

            if((array[i]&index)==0){

                result1^=array[i];
            }else{

                result2^=array[i];
            }
        }


        num1[0]=result1;
        num2[0]=result2;
    }
}
