package com;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
*输入一个数n，然后输入n个数值各不相同，再输入一个值x，输出这个值在这个数组中的下标
* （从0开始，若不在数组中则输出-1）
* */
public class ArrayIndex {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
         String n=scanner.nextLine();//输入第一个数，表示数字个数n
         String[] num=scanner.nextLine().split(" ");//输入n个数字，空格分割
         String searchKey=scanner.nextLine();
        System.out.println(Arrays.asList(num).indexOf(searchKey));//利用Arrays的方法找出要找的数的下标


    }
}
