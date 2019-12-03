package com.lei.com;


/*
* 题目：
* 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
* 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
*
* */
public class Solution27 {

    /*
    * 思路：
    * 数量超过数组长度一半的数字排序后必定占据中间位置
    * */
    public int MoreThanHalfNum_Solution(int [] array) {
        int length=array.length;
        int medium=length/2;
        int count=0;
        for(int i=0;i<length;i++){
            if(array[i]==array[medium]){
                count++;

            }
        }
        if(count>medium){

            return array[medium];
        }
        return 0;

    }
}
