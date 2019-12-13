package com;


import java.util.ArrayList;

/*
* 题目：
* 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
* 如果有多对数字的和等于S，输出两个数的乘积最小的。
* 对应每个测试案例，输出两个数，小的先输出。
*
* */
public class Solution10 {

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {

        ArrayList<Integer> list=new ArrayList<>();
        int left=0;
        int right=array.length-1;

        while(left<right){

            if(array[left]+array[right]>sum){
                right--;

            }else if(array[left]+array[right]<sum){
                left++;

            }else{

                list.add(array[left]);
                list.add(array[right]);
            }

        }
        return  list;

    }
}
