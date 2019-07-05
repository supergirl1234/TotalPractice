package com;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*对于给定的正整数，计算其十进制形式下所有位置数字之和，
并计算其平方的各位数字之和*/
public class MathCalculate {

    public static  int add(int a){

        int sum=0;
        for(;a!=0;){
            sum+=a%10;
            a=a/10;
        }
        return sum;
    }
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要计算的数:");
        int a = scanner.nextInt();
        int b = a * a;
        System.out.print(add(a));
        System.out.print(" "+add(b));


    }
}
