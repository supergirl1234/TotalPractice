package com;

/*
* 题目：
*
* 地上有一个m行和n列的方格。
* 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
* 但是不能进入行坐标和列坐标的数位之和大于k的格子。
* 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
* 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
*
* */
public class Solution1 {

    int count=0;
    public int movingCount(int threshold, int rows, int cols)
    {

         if(threshold<0){

             return 0;
         }

         int[][] num=new int[rows][cols];//用来标记每个位置是否判断过

         moving(threshold,0,0,num);

        return  count;
    }

    private void moving(int threshold, int startX, int startY, int[][] num) {


        boolean isCheck=check(startX,startY,threshold,num);
           if(isCheck && num[startX][startY]!=1){
               count++;
               num[startX][startY]=1;

               /*上下左右*/
               moving(threshold,startX-1,startY,num);
               moving(threshold,startX+1,startY,num);
               moving(threshold,startX,startY-1,num);
               moving(threshold,startX,startY+1,num);
           }

    }

    /*判断该点是否符合条件*/
    private boolean  check(int x,int y,int threshold,int[][] num){

        if(x<0||y<0){

            return  false;
        }
        if(x>=num.length ||y>=num[0].length){
            return  false;

        }

        /*计算横坐标和纵坐标的各位数的和*/
        int sum=0;
        while(x>0){
            sum+=x%10;
            x=x/10;

        }
        while(y>0){
            sum+=y%10;
            y=y/10;

        }
        return  sum<=threshold;

    }

}
