package com.lei.comm;

import java.util.ArrayList;
import java.util.Arrays;

/*
* 题目：
* 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
* */
public class Solution28 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {



        ArrayList<Integer> list=new ArrayList<>();
        if(k>input.length||k<0){
            return  list;

        }else if(k==input.length){
            for(int i=0;i<input.length;i++){

                list.add(input[i]);
            }
            return list;

        }
        int left=0;
        int right=input.length;
       int partion= QuickSort(input,left,right);//左闭右开
        while(partion+1!=k){

            if(partion+1>k){

                /*只排左半部分*/
                right=partion;
                partion=QuickSort(input,left,right);

            }else if(partion+1<k){

                /*只排右半部分*/
                left=partion+1;
                partion=QuickSort(input,left,right);
            }
        }
            for(int i=0;i<=partion;i++){
                list.add(input[i]);
            }
        return  list;

    }

    private int QuickSort(int[] input, int left, int right) {
        int part=input[right-1];
        int p=left;
        int q=right-1;
        while(p<q){

           while(p<q&&input[p]<part){
                p++;

            }
            while(p<q&&input[q]>=part){
                q--;

            }
            int temp=input[p];
            input[p]=input[q];
            input[q]=temp;

        }
        int temp=input[right-1];
        input[right-1]=input[p];
        input[p]=temp;

        return  p;

    }

    public static void main(String[] args) {
        int [] input=new int[]{4,5,1,6,2,7,3,8};
        int k=4;
        Solution28 solution28=new Solution28();
        ArrayList<Integer> list=solution28.GetLeastNumbers_Solution(input,k);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));

        }
    }
}
