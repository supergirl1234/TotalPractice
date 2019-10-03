package com;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
* 给定一个k位整数N = dk-1*10k-1 + ... + d1*101 + d0 (0<=di<=9, i=0,...,k-1, dk-1>0)，
* 请编写程序统计每种不同的个位数字出现的次数。例如：给定N = 100311，则有2个0，3个1，和1个3。
* */
public class Test10 {

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        String s=scanner.next();
        char[] chars=s.toCharArray();
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<chars.length;i++){

            list.add(0);

        }
        for(int i=0;i<chars.length;i++){
            list.set(chars[i]-'0',list.get(chars[i]-'0')+1);

        }
        for(int i=0;i<list.size();i++){

            if(list.get(i)>0){

                System.out.println(i+":"+list.get(i));
            }

        }

    }
}
