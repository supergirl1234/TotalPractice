package com;


import java.util.Arrays;

/*
* 给定一个三角矩阵，找出自顶向下的最短路径和，每一步可以移动到下一行的相邻数字。
比如给定下面一个三角矩阵，自顶向下的最短路径和为11。
* */
public class Test4 {


    /*从上往下算*/
    public static  int test1(int[][] array){


        int[][] result = Arrays.copyOf(array,array.length);


        for(int i=1;i<array.length;i++){

            for(int j=0;j<array[i].length;j++){

                if(j==0){

                    result[i][j]=result[i-1][j]+array[i][j];
                }else if(j==i){
                    result[i][j]=result[i-1][j-1]+array[i][j];

                }else{

                    result[i][j]=Math.min(result[i-1][j-1],result[i-1][j])+array[i][j];
                }


            }

        }

        int min=result[result.length-1][0];

        for(int i=1;i<result[result.length-1].length;i++){
            if(result[result.length-1][i]<min){
                min=result[result.length-1][i];

            }

        }

        return  min;

    }

    /*从下往上算*/
    public static  int test2(int[][] array){

        int[][] result = Arrays.copyOf(array,array.length);
        for(int i=result.length-2;i>=0;i--){

            for(int j=0;j<result[i].length;j++){

                result[i][j]=Math.min(result[i+1][j],result[i+1][j+1])+array[i][j];

            }
        }

        return result[0][0];

    }
    public static void main(String[] args) {

        int[][] array=new int[][]{

                {1},
                {2,3},
                {5,4,1},
                {4,6,7,2}
        };

        int result=test1(array);
        System.out.println(result);
        int result2=test2(array);
        System.out.println(result);

    }
}
