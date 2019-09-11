package com;

public class Test {


    public static void main(String[] args) {

        A p=new A();
        p.foo();


    }
}

class A{

    private int a = 0;


    public void foo() {

        new Thread(new Runnable() {

            public void run() {

                a = 1;

            }

        }).start();
        System.out.print(a);
    }

}
