package com;

public class Test {

    public static void main(String[] args) {
        MyClassLoader myClassLoader=new MyClassLoader("D:/ClassLoaderBySelf/");//传入的是文件路径
        try {
            Class classz=myClassLoader.loadClass("FileJava");
            System.out.println(classz);
            System.out.println(classz.getConstructor().newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
