package com;

public class String2 {

    public  static void test(String x,String y){

        x=x+"A";
        y=y+"A";
        System.out.println("x:"+x);//CA
        System.out.println("y:"+y);//DA
    }
    public static void main(String[] args) {
        String a="C";
        String b="D";
        test(a,b);
        System.out.println(a);//C
        System.out.println(b);//D
    }
}
