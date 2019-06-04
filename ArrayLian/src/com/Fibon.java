package com;

import java.util.Scanner;

/**
 * Author:Fanleilei
 * Created:2019/6/1 0001
 *
 * 将一个数变成Fibonacci数，最少需要多少步，每一步可以将当前数字减1或加1
 */
public class Fibon {

    public static int Num(int n){
        //先判断n是否为Fibon数
        int[] F=new int[1000];
        F[0]=1;
        F[1]=1;
        int i=0;

       while(F[i]<n){


           i++;
           if(i>=2) {
               F[i] = F[i - 1] + F[i - 2];
           }

       }
       if(F[i]==n){
           return 0;
       }
       if(F[i]-n<=n-F[i-1]){

           return  F[i]-n;

       }else{
          return  n-F[i-1];

       }

    }

    public static void main(String[] args) {

        System.out.println("请输入一个正整数：");
        Scanner in=new Scanner(System.in);
        int N=in.nextInt();
        int result=Num(N);
        System.out.println(result);
    }
}
