package com;

/*
* 题目:
* 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
*
*
* */
public class Solution5 {

    public int[] multiply(int[] A) {

        int[] B=new int[A.length];
        for(int i=0;i<B.length;i++){
            B[i]=1;

        }
        for(int i=0;i<B.length;i++){

            for(int j=0;j<i;j++){

                B[i]*=A[j];

            }
            for(int j=i+1;j<A.length;j++){

                B[i]*=A[j];
            }

        }
        return B;
    }


    /*另一种方法，剑指上的，使用下三角和上三角连乘*/
    public int[] multiply2(int[] A) {

        int[] B=new int[A.length];
        B[0]=1;
        for(int i=1;i<B.length;i++){

              B[i]=B[i-1]*A[i-1];       /*计算的是左下三角的值*/

        }

        int temp=1;
        for(int i=B.length-2;i>=0;i--){

            temp=temp*A[i+1];
            B[i]=B[i]*temp;  /*计算的是又乘以右上三角的值*/

        }

        return  B;
    }


}
