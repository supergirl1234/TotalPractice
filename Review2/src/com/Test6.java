package com;


/*
*
* 给定一个m*n的网格，网格用非负数填充，找到一条从左上角到右下角的最短路径。
注：每次只能向下或者向右移动。
* */
public class Test6 {

    public static  int test(int[][] array){

        /*特殊情况：第0行、第0列*/
        int m=array.length;
        int n=array[0].length;
        int[][] result=new int[m][n];
        result[0][0]=array[0][0];
        for(int i=1;i<m;i++){

            result[i][0]=result[i-1][0]+array[i][0];
        }
        for(int i=1;i<n;i++){

            result[0][i]=result[0][i-1]+array[0][i];
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                result[i][j]=Math.min(result[i][j-1],result[i-1][j])+array[i][j];

            }

        }

        return  result[m-1][n-1];
    }

    public static void main(String[] args) {

        int[][] array=new int[][]{

                {1,2,3,4},
                {3,4,2,6},
                {1,0,3,4}
        };

       int result= test(array);
        System.out.println(result);
    }
}
