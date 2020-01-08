package com;

/*
 * 动态规划：
 * 动态规划是分治思想的延伸通俗来讲就是：大事化小，小事化无的意思
 * 具有以下三个特点：
 * 1、把原来的问题分解为了几个相似的子问题
 * 2、所有的子问题只需要解决一次
 * 3、存储子问题的解
 *
 *
 * 动态规划问题一般从以下四个角度考虑：
 * 1、状态定义
 * 2、状态间的转移方程定义
 * 3、状态的初始化
 * 4、返回结果
 *
 * 状态定义的要求：定义的状态一定要形成递推关系
 * */

/*
* 给定一个三角矩阵，找出自顶向下的最短路径和，每一步可以移动到下一行的相邻数字。
* 比如，给定下面一个三角矩阵，自顶向下的最短路径和为11
* 2
* 3 4
* 6 5 7
* 4 1 8 3
*
* 从坐标（i，j）能走到（i+1，j）或者（i+1，j+1）
* */

/*
* 思路：定义状态：从（0，0）到某一点（i，j）的最短路径和的状态为F（i，j）
* F（i，j）=min（F（i-1，j-1），F（i-1，j））+a（i，j）
* 特殊：第0列，最后一列
* F（i，0）=F（i-1，0）+a（i，0）   第0列
* F（i，i）=F（i-1，i-1）+a（i，i） 最后一列
* F(0,0)=a(0,0)
*
* 返回的是最后一行的最小值
* */
public class ShortPath {


    public static  int minLength(int[][] array){

        int[][] result=new int[array.length][array.length];


        result[0][0]=array[0][0];
        for(int i=1;i<array.length;i++){

            result[i][0]=result[i-1][0]+array[i][0];
        }
        for(int i=1;i<array.length;i++){

            result[i][i]=result[i-1][i-1]+array[i][i];
        }

        for(int i=2;i<array.length;i++){
            for(int j=1;j<array[i].length;j++){

                result[i][j]=Math.min(result[i-1][j-1],result[i-1][j])+array[i][j];
            }
        }

        int min=result[array.length-1][0];
        for(int i=1;i<array.length;i++){

            if(result[array.length-1][i]<min){
                min=result[array.length-1][i];
            }
        }
        return  min;
    }
    public static void main(String[] args) {

    }
}

/*
* 最大连续子数组的和
* 状态F(i):以第i个元素结尾的连续最大和
*
* F(i)=Max(F(i-1)+a[i],a[i])
* */
