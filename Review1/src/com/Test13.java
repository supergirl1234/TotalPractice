package com;

import java.util.Scanner;

/*
 * 给定数字0-9各若干个。你可以以任意顺序排列这些数字，但必须全部使用。目标是使得最后得到的数尽可能小（注意0不能做首位）。
 * 例如：给定两个0，两个1，三个5，一个8，我们得到的最小的数就是10015558。
 * 现给定数字，请编写程序输出能够组成的最小的数。
 * 该题目的输入数据是由 10 个数字组成，表示 0 -9 出现的次数，
 * */
public class Test13 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] num = new int[10];
        for (int i = 0; i < 10; i++) {
            num[i] = scanner.nextInt();

        }
        /*先输出1-9中最小的数一个，然后如果有0，则把0全部输出，然后再把剩下的数依次输出*/
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 10; i++) {

            if (num[i] != 0) {
                sb.append(i);
                num[i]--;
                break;
            }
        }
        while (num[0] != 0) {
            sb.append(0);
            num[0]--;
        }

        for(int i=0;i<10;i++){

            while (num[i] != 0) {
                sb.append(i);
                num[i]--;

            }
        }


        System.out.println(sb.toString());
    }
}
