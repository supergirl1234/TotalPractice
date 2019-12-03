package com.lei;

import java.util.ArrayList;
import java.util.List;

public class JVMTest2 {

    byte[] bytes=new byte[1024*100];
    public static void test() throws InterruptedException {

       Thread.sleep(5000);
        List list=new ArrayList();
        System.out.println("-----------------start");
        for(int i=0;i<2000;i++) {
            Thread.sleep(100);
            list.add(new JVMTest2());
        }
    }

    public static void main(String[] args) throws InterruptedException {

        System.out.println("---------------begin");
        test();

    }
}
