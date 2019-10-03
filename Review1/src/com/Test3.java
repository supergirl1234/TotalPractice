package com;


/*
 *
 * 正整数A和正整数B 的最小公倍数是指 能被A和B整除的最小的正整数值，设计一个算法，求输入A和B的最小公倍数。
 * */

import java.util.Scanner;

/*
 * 思路：两个数的乘积等于这两个数的最大公约数与最小公倍数的积
 * 求最大公约数：
 * 1. a/b，令r为所得余数（0≤r<b） 若r=0，算法结束，a即为答案
 * 2. 互换：置 a←b，b←r，并返回第一步
 * */
public class Test3 {

    /*求最小公倍数*/
    public static int test(int a, int b) {

        return (a * b) / Cal(a, b);

    }

    /*求最大公约数*/
    public static int Cal(int a, int b) {

        if ( b == 0) {

            return a;
        } else {

            return Cal(b, a % b);
        }

    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int result=test(a,b);
        System.out.println(result);
    }
}
