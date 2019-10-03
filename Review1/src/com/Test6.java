package com;


import java.util.Scanner;

/*
* 输入一个正整数n,求n!(即阶乘)末尾有多少个0？ 比如: n = 10; n! = 3628800,所以答案为2
*
* 那么我们在计算n的阶乘时，实际上就是把所有小于等于n的正整数分解成质因数，然后再将其乘到一起，那
么末尾0的个数实际上就是2*5的个数，而2的个数明显是很多很多的，所以问题就转化成了5的个数。
* 而只有5的倍数才有5这个因数，所以，问题就进一步简化为小于等于n的数中有多少个数是5的倍数
*
* */
public class Test6 {

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        int result=0;
        for(int i=num;i>=5;i--){//判断小于等于num，大于等于5的数里，每个数 分解成质因数 有多少个5
            int cou=i;
            while (cou%5==0){//判断一个数里有几个5

                result++;
                cou=cou/5;
            }
        }
        System.out.println(result);
    }

}
