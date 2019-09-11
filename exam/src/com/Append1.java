package com;

public class Append1 {

    public static  void test(StringBuilder x,StringBuilder y){
        x.append(y);
        y=x;
        System.out.println("x:"+x);//AB
        System.out.println("y:"+y);//AB
    }
    public static void main(String[] args) {
        StringBuilder a=new StringBuilder("A");
        StringBuilder b=new StringBuilder("B");
        test(a,b);
        System.out.println(a);//AB
        System.out.println(b);//B

    }
}
