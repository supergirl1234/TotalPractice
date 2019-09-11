package com;

public class Append3 {


    public static  void test(StringBuilder x,StringBuilder y){
        StringBuilder temp=y;
        y=x;
        x=temp;
        System.out.println("x:"+x);//D
        System.out.println("y:"+y);//C
    }
    public static void main(String[] args) {

        StringBuilder a=new StringBuilder("C");
        StringBuilder b=new StringBuilder("D");
        test(a,b);
        System.out.println(a);//C
        System.out.println(b);//D
    }
}
