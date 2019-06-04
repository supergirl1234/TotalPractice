package com;

import java.sql.Statement;
import java.util.Scanner;

/**
 * Author:Fanleilei
 * Created:2019/6/1 0001
 *
 * 有一个XxY的网格，一个机器人只能走格点且只能向右或向下走，要从左上角走到右下角。请设计一个算法，计算机器人有多少种走法。
 *
 * 给定两个正整数int x,int y，请返回机器人的走法数目。保证x＋y小于等于12。
 */
//思路：采用递归
//机器人在X*Y的矩阵中走，每一步都有两种选择：要么向下、要么向右。 如果向下走，问题就变成：求(X-
//1)*Y矩阵中机器人的走法； 如果向右走，问题就变成：求X*(Y-1)矩阵中机器人的走法；
public class Test{

    public int countWays(int x,int y){
        if( x==1||y==1){
            return 1;

        }
        return countWays(x-1,y)+countWays(x,y-1);
    }

    public static void main(String[] args) {
        int x=0;
        int y=0;
        System.out.println("请输入x和y的值：");
        Scanner in=new Scanner(System.in);
        Test Robot=new Test();
        while(in.hasNext()){
            x=in.nextInt();
            y=in.nextInt();
            int result=Robot.countWays(x,y);
            System.out.println(result);
        }


    }
}
