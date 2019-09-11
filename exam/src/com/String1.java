package com;

public class String1 {


    public static  void test(String x,String y){//C  D
        String temp=y;
        y=x;
        x=temp;
        System.out.println("x:"+x);//D
        System.out.println("y:"+y);//C
    }
    public static void main(String[] args) {

        String a=new String("C");
        String b=new String("D");

        test(a,b);
        System.out.println(a);//C
        System.out.println(b);//D

        b=a;
        System.out.println("b:"+b);//C
        System.out.println(a==b);//true
    }
}
