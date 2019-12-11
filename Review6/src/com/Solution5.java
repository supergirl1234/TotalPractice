package com;

import java.util.Arrays;

/*
* 题目：
* 统计一个数字在排序数组中出现的次数。
*
* */
public class Solution5 {

    int count=0;
    public int GetNumberOfK(int [] array , int k) {

        return getNumber(array,0,array.length-1,k);


    }

    public int getNumber(int[] array,int left,int right,int k){


        int medium=(right+left)/2;

        if(k<array[medium]){

            getNumber(array,0,medium,k);
        }else if(k>array[medium]){

            getNumber(array,medium+1,right,k);
        }else{

            count++;
            for(int i=medium+1;i<right;i++){

                if(array[i]==k){
                    count++;
                }else{
                    break;
                }
            }
            for(int i=medium-1;i>=left;i--){

                if(array[i]==k){
                    count++;
                }else{
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] array=new int[]{1,2,3,4,5,6,7,8,8,8,9,10};
        Solution5 solution5=new Solution5();
        int result=solution5.GetNumberOfK(array,8);
        System.out.println(result);


    }
}
