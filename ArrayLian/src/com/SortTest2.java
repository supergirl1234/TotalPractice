package com;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Author:Fanleilei
 * Created:2019/6/1 0001
 * 找出n个整数里最小的k个数，升序输出
 */
//用快排的partition思想
public class SortTest2 {

    public static int qSort(int[] num,int start,int end){

        int dig=num[start];
        while(start<end){
            while(start<end && num[end]>=dig){
                end--;
            }
            num[start]=num[end];

            while(start<end&&num[start]<dig){
                start++;

            }
            num[end]=num[start];




        }
        num[start]=dig;
        return start;

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String str=sc.nextLine();
            //先将输入的数字以字符串的方式接收，以确定数组的长度
            String[] s=str.split(" ");
            int[] num=new int[s.length-1];
            for(int i=0;i<s.length-1;i++){
                num[i]=Integer.parseInt(s[i]);

            }
            int k=Integer.parseInt(s[s.length-1]);
            int start=0;
            int end=num.length-1;
            int index=qSort(num,start,end);
            while (index!=k){
                if(index>k){
                    end=index-1;
                    index=qSort(num,start,end);

                }else{

                    start=index+1;
                    index=qSort(num,start,end);

                }
            }
            //将前k个数排序
            Arrays.sort(num,0,k);
            for(int i=0;i<k;i++){

                System.out.print(i==k-1?num[i]:num[i]+" ");
            }
        }

    }
}
