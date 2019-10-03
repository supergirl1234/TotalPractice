package com;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
* 在一组数的编码中，若任意两个相邻的代码只有一位二进制数不同， 则称这种编码为格雷码(Gray Code)，
* 请编写一个函数，使用递归的方法生成N位的格雷码。
给定一个整数n，请返回n位的格雷码，顺序为从0开始。
* */
public class Test12 {

    public static List test(int n){
        List<String> list=new ArrayList<>();
        if(n==1){
            list.add("0");
            list.add("1");
        }else{

            List<String> Rlist=test(n-1);
            for(int i=0;i<Rlist.size();i++){

                list.add("0"+Rlist.get(i));
                list.add("1"+Rlist.get(i));

            }
        }

        return  list;
    }

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();

        List<String> result=test(n);
        System.out.println(result);

    }
}
