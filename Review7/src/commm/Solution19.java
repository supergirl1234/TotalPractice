package commm;


import java.util.Scanner;

/*
 * 题目：
 * 给定一个 n * m 的矩阵 a，从左上角开始每次只能向右或者向下走，最后到达右下角的位置，
 * 路径上所有的数字累加起来就是路径和，输出所有的路径中最小的路径和
 *
 * 输入描述：
 * 第一行输入两个整数 n 和 m，表示矩阵的大小。
 * 接下来 n 行每行 m 个整数表示矩阵。
 *
 * 输出描述：
 * 输出一个整数表示答案。
 *
 * */

/*
* 思路：
*

1.生成大小和输入矩阵vec一样大小的矩阵dp，dp[i][j]表示从左上角（0，0）位置走到（i，j）位置的最小路径
2.第一行所有位置只能向右走，所以（0，0）位置到（0，j）位置的路径和就是vec[0][0...j]的值累加，同理，对于第一列的所有位置来说，只能向下走，为vec[0...i][0]的累加
3.除第一行和第一列其他位置都有左位置和上位置，选择值最小的位置加上当前值vec[i][j]就是就是当前路径最小值
*
*
* */
public class Solution19 {


    public static int getMin(int[][] array) {

        int [][] result=new int[array.length][array[0].length];
        result[0][0]=array[0][0];
        for(int i=1;i<result[0].length;i++){


            result[0][i]=result[0][i-1]+array[0][i];
        }
        for(int i=1;i<result.length;i++){

            result[i][0]=result[i-1][0]+array[i][0];
        }

        for(int i=1;i<result.length;i++){
            for(int j=1;j<result[0].length;j++){

                result[i][j]=array[i][j]+Math.min(result[i-1][j],result[i][j-1]);
            }

        }

        return  result[result.length-1][result[0].length-1];

    }



    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();

        int[][] array=new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                array[i][j]=scanner.nextInt();
            }

        }

        int result=getMin(array);
        System.out.println(result);
    }
}
