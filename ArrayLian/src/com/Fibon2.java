package com;

import java.awt.datatransfer.SystemFlavorMap;
import java.util.Scanner;

/**
 * Author:Fanleilei
 * Created:2019/6/1 0001
 *
 * 将一个数变成Fibonacci数，最少需要多少步，每一步可以将当前数字减1或加1
 */
public class Fibon2 {

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int n=0;
        int a=0,b=1,c=1;
        if(scanner.hasNext()){
            n=scanner.nextInt();
        }
        //找出n在哪两个Fibonacci数中间 b n c
        while(c<n){
            a=b;
            b=c;
            c=a+b;//计算新的Fibonacci数值


        }
        int dis1=n-b;
        int dis2=c-n;
        //找出两者中最小的
        System.out.println(dis1<dis2?dis1:dis2);


    }
}
